package tr.com.soagen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import tr.com.soagen.presentation.model.Book;

@Repository
@Qualifier(value="bookDao")
public class BookDaoImpl implements BookDao{

	@Autowired
	MongoTemplate mongoTemplate;
	
	final String COLLECTION = "books";
	
	@Override
	public void create(Book book) {
		mongoTemplate.insert(book);
	}

	@Override
	public void update(Book book) {
		mongoTemplate.save(book);
	}

	@Override
	public void delete(Book book) {
		mongoTemplate.remove(book);
	}

	@Override
	public Book getBookById(Book book) {
		Query query = new Query(Criteria.where("_id").is(book.getId()));
		return mongoTemplate.findOne(query, Book.class, COLLECTION);
	}

	@Override
	public List<Book> getAllBooks() {
		return mongoTemplate.findAll(Book.class);
	}
}
