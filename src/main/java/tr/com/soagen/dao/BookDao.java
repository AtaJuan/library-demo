package tr.com.soagen.dao;

import java.util.List;

import tr.com.soagen.presentation.model.Book;

public interface BookDao {

	public void create (Book book);
	
	public void update (Book book);
	
	public void delete (Book book);
	
	public Book getBookById (Book book);
	
	public List<Book> getAllBooks();
	
}
