package com.lm.spring6.di;

/**
 * @author ming
 * @date 2023.06.19
 * @about
 */
public class Book {
    private String name;
    private String author;

    public Book(){
        System.out.println("执行Book无参构造……");
    }

    public Book(String name, String author) {
        System.out.println("执行Book有参数构造……");
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        // 通过set方法
        book1.setName("book1");
        book1.setAuthor("ming");

        // 通过构造器
        Book book2 = new Book("book2","ming");

    }
}
