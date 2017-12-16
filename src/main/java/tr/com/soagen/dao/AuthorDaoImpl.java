package tr.com.soagen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import tr.com.soagen.presentation.model.Author;

@Repository
@Qualifier(value = "authorDao")
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    MongoTemplate mongoTemplate;

    final String COLLECTION = "authors";

    @Override
    public void create(Author author) {
        mongoTemplate.insert(author);
    }

    @Override
    public void update(Author author) {
        mongoTemplate.save(author);
    }

    @Override
    public void delete(Author author) {
        mongoTemplate.remove(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Author.class, COLLECTION);
    }

    @Override
    public List<Author> getAllAuthors() {
        return mongoTemplate.findAll(Author.class);
    }
}
