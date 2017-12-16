package tr.com.soagen.dao;

import java.util.List;

import tr.com.soagen.presentation.model.Author;

public interface AuthorDao {

	public void create (Author author);
	
	public void update (Author author);
	
	public void delete (Author author);
	
	public Author getAuthorById (Long id);
	
	public List<Author> getAllAuthors();
}
