package com.it.pojo;

public class Book {
    private long bookId;
    private String bookName;
    private int bookNumber;

    public Book() {
    }

    public Book(long bookId, String bookName, int bookNumber) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookNumber = bookNumber;
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

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookNumber=" + bookNumber +
                '}';
    }
}
