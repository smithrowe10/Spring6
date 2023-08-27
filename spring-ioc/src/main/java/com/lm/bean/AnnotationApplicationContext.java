package com.lm.bean;

import com.lm.annotation.Bean;
import com.lm.annotation.Di;
import lombok.val;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ming
 * @date 2023.06.21
 * @about
 */
public class AnnotationApplicationContext implements ApplicationContext {
    // 创建map集合，存放Bean对象
    private  Map<Class,Object> beanFactory = new HashMap<>();
    private  String rootPath;
    @Override
    public Object getBean(Class clazz) throws NoSuchMethodException {
        return beanFactory.get(clazz);
    }

    // 创建有参构造器，传递包路径，设置包扫描规则
    // 当前包及子包中，如果哪个类有@Bean注解，则通过反射将其实例化
    public  AnnotationApplicationContext(String basePackage){
        try {
            // 1. 将.替换为\
            String packagePath = basePackage.replaceAll("\\.","\\\\");
            // 2. 获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);

                // 截取前路径
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                // 包扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 属性注入
        loadDi();
    }

    // 包扫描过程，实例化
    public void loadBean(File file) throws Exception {
        // 判断当前内容是否是一个文件夹
        if(file.isDirectory()) {
            // 获取文件夹中的所有内容
            File[] subFiles = file.listFiles();
            // 判断文件夹是否为空
            if(subFiles==null||subFiles.length==0){
                return;
            }
            // 遍历文件夹所有内容
            for(File subfile:subFiles){
                // 递归遍历文件夹及子文件夹
                if(subfile.isDirectory()){
                    // 如果是文件夹，递归遍历
                    loadBean(subfile);
                }else{
                    // 得到包路径+类名
                    String pathWithClass = subfile.getAbsolutePath().substring(rootPath.length()-1);
                    // 判断当前文件类型是否为.class
                    if(pathWithClass.endsWith(".class")){
                        // 把\换成. 并去掉.class后缀
                        String allName = pathWithClass.replaceAll("\\\\",".").replace(".class","");
                        // 对有注解 @Bean的类进行实例化
                        Class<?> clazz = Class.forName(allName);
                        // 判断是否为接口
                        if(!clazz.isInterface()){
                            // 判断有无注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                // 实例化对象
                                Object instance = clazz.getConstructor().newInstance();
                                // 实例化后的对象放入到map集合中
                                // 如果有接口，接口作为key
                                if(clazz.getInterfaces().length>0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else{
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void loadDi(){
        // 遍历 map 集合
        for(Map.Entry<Class,Object> entry:beanFactory.entrySet()){
            Object obj = entry.getValue();
            Class<?> clazz = obj.getClass();
            // 获取每个对象的属性
            Field[] fields = clazz.getDeclaredFields();
            // 遍历得到对象的属性数组，得到每个属性
            for(Field field:fields){
                // 判断属性上是否有 @Di 注解，把对象进行注入
                Di annotation = field.getAnnotation(Di.class);
                if(annotation!=null){
                    field.setAccessible(true);
                    try {
                        field.set(obj,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        }

    }

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationApplicationContext("com.lm");
    }
}
