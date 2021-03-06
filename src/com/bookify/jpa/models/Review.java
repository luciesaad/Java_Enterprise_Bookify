package com.bookify.jpa.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "review")
@JsonPropertyOrder({"reviewId","reviewUserId","reviewbookId","reviewText","reviewDate"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="reviewId")
public class Review implements Serializable {

    public Review(Integer reviewUserId, Integer reviewbookId, String reviewText, Date reviewDate) {
        this.reviewUserId = reviewUserId;
        this.reviewbookId = reviewbookId;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
    }

    public Review(){}

    @Id
    @GeneratedValue
    @Column(name = "reviewId")
    private  Integer reviewId;

    @Column(name = "reviewUserId")
    private Integer reviewUserId;

    @Column(name = "reviewbookId")
    private Integer reviewbookId;

    @Column(name = "reviewText")
    private String reviewText;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reviewbookId", insertable=false, updatable=false)
    private Book book;

    @JsonIgnore
    public Book getBooks() {
        return book;
    }

    public void setBooks(Book books) {
        this.book = books;
    }


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "reviewDate")
    private Date reviewDate;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(Integer reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public Integer getReviewbookId() {
        return reviewbookId;
    }

    public void setReviewbookId(Integer reviewbookId) {
        this.reviewbookId = reviewbookId;
    }


    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

}