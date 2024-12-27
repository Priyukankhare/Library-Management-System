package org.techhub.Service;

import java.util.List;

import org.techhub.Model.BookModel;
import org.techhub.Model.CategoryModel;

public interface BookService {
	
	public boolean isAddNewBooks(BookModel Model1);
	
	public List<BookModel> getBookListByCategoryId(int cid);
    
	public List<BookModel> getAllBooks();
	
	public boolean updateBookByName(String OldBook, String Ubook, String type, int Edition, int price, String author, int qty);
	public boolean searchBookByName(String SearchBook);
	
	public boolean deleteBookByName(String deleteBook);
	
	public boolean deleteBorrowedBook(List<String> bookNames);

	public boolean decreaseBookQuantity(int bookId, int i);

	public boolean increaseBookQuantity(int bookId, int i);
	
}
