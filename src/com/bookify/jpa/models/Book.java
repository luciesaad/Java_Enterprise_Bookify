package com.bookify.jpa.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
@JsonPropertyOrder({"bookId","bookTitel","bookAuthor","bookDate"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="bookId")

public class Book {

    @Id
    @GeneratedValue
    @Column(name = "bookId")
    private  Integer bookId;

    @Column(name = "bookTitel")
    private String bookTitel;

    @Column(name = "bookAuthor")
    private String bookAuthor;

    @Column(name = "bookDate")
    private Date bookDate;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitel() {
        return bookTitel;
    }

    public void setBookTitel(String bookTitel) {
        this.bookTitel = bookTitel;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }
}