package com.bookify.jpa.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "wanttoread")
@JsonPropertyOrder({"id", "bookId", "userId"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="userId")
public class WantToRead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wantToReadId")
    private int id;

    @Column(name = "wantToReadBookId")
    private int bookdId;

    @Column(name = "wantToReadUserId")
    private int userId;

    public WantToRead() {
    }

    public WantToRead(int bookdId, int userId) {
        this.bookdId = bookdId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookdId() {
        return bookdId;
    }

    public void setBookdId(int bookdId) {
        this.bookdId = bookdId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}