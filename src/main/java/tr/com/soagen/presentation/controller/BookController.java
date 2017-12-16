package tr.com.soagen.presentation.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tr.com.soagen.dao.AuthorDao;
import tr.com.soagen.dao.BookDao;
import tr.com.soagen.presentation.model.Author;
import tr.com.soagen.presentation.model.Book;

@Scope("view")
@Controller("bookController")
public class BookController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private transient BookDao bookDao;
    @Autowired
    private transient AuthorDao authorDao;
    private Book book;
    private List <Author> authorList = new ArrayList<>();
    private boolean creating;

    @PostConstruct
    public void init() {
        this.authorList = authorDao.getAllAuthors();
        this.book = new Book();
        this.creating = true;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
        this.creating = false;
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
    
    public void deleteBook(Book book) {
        bookDao.delete(book);
    }
    

    public boolean isCreating() {
        return creating;
    }
    
    public void cancel () {
        book.setId(null);
        book.setIsbn(null);
        book.setName(null);
        book.setPublishDate(null);
        book.setAuthor(null);
    }
    
    public void save() {
        if (creating) {
            bookDao.create(book);
        } 
        else {
            bookDao.update(book);
        }
        this.book = new Book();
        this.creating = true;
    }
}
