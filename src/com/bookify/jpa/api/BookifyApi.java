package com.bookify.jpa.api;

import com.bookify.jpa.models.Book;
import com.bookify.jpa.models.User;
import com.bookify.jpa.repositrories.UserRepository;
import com.bookify.jpa.repositrories.bookRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;
import java.util.List;

@Path("/v1.0")
@ApplicationPath("/api")
public class BookifyApi extends Application{

    @Inject
    private UserRepository ur;

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserName(){
        return ur.getAllUsers();
    }

    //Post metod för att lägga till användare.
    @POST
    @Path("/users")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response postUser(User user){
        ur.create(user);
        return Response.ok(user.getUserName() + " added as user").build();

    }

    @Inject
    private bookRepository br;

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBookTitel(){
        return br.getAllBooks();
    }

    @POST
    @Path("/books")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public  Response postBook(Book book){
        br.create(book);
        return Response.ok(book.getBookTitel() + " " + book.getBookAuthor() + " book added to the database").build();
    }
    /**Recensions delen av API:et med CRUD metoder*/
    @Inject
    private ReviewRepository rr;

    @POST
    @Path("/review")
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postReview(Review review){
        rr.create(review);
        return Response.ok("En recension skriven för boken med id: " +review.getReviewbookId()).build();
    }

    @GET
    @Path("/review")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> getReview(){
        return rr.getAllReviews();
    }
}

