package com.bookify.jpa.repositrories;

import com.bookify.jpa.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class bookRepository {

    @PersistenceContext(unitName = "BookifyPU")
    private EntityManager em;

    public List<Book> getAllBooks(){
        Query query = em.createQuery("SELECT book FROM Book book order by book.bookTitel");
        return query.getResultList();
    }
}