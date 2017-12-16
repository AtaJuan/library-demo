package tr.com.soagen.presentation.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tr.com.soagen.dao.AuthorDao;
import tr.com.soagen.presentation.model.Author;

@Scope("view")
@Controller("authorController")
public class AuthorController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired
    private transient AuthorDao authorDao;
    private Author author;
    private List<Author> authorList = new ArrayList<>();
    private List<String> genreList = new ArrayList<>();
    private List<String> nationalityList = new ArrayList<>();
    private boolean created;

    @PostConstruct
    public void init() {
        this.author = new Author();
        genreList.addAll(Arrays.asList("Short Novel", "Short Story", "Novel", "Story", "Poem", "Article"));
        nationalityList.addAll(Arrays.asList("Turkey", "Russia", "Spain", "Italy", "German", "England"));
        this.created = true;
    }

    public List<String> getNationalityList() {
        return nationalityList;
    }

    public void setNationalityList(List<String> nationalityList) {
        this.nationalityList = nationalityList;
    }

    public List<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        this.created = false;
    }

    public List<Author> getAllAuthors() {
        return authorDao.getAllAuthors();
    }

    public void deleteAuthor(Author author) {
        authorDao.delete(author);
    }

    public boolean isCreated() {
        return created;
    }
    
    public void cancel () {
        author.setId(null);
        author.setFirstName(null);
        author.setGenreList(null);
        author.setLastName(null);
        author.setNationality(null);
    }
    
    public void save() {
        if (created) {
            authorDao.create(author);
        } else {
            authorDao.update(author);
        }
        this.author = new Author();
        this.created = true;
    }
}
