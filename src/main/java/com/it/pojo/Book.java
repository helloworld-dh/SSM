package com.it.pojo;

public class Book {
    private long bookId;
    private String bookName;
    private int number;

    public Book() {
    }

    public Book(long bookId, String bookName, int number) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.number = number;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", number=" + number +
                '}';
    }
}
