package org.techhub.Service;

import java.util.List;

import org.techhub.Model.BookModel;
import org.techhub.Repository.BookRepository;
import org.techhub.Repository.BookRepositoryImpl;

public  class BookServiceImpl implements BookService{

	BookRepository bookRepo=new BookRepositoryImpl();

	public boolean isAddNewBooks(BookModel Model1)
	{
		return bookRepo.isAddNewBooks(Model1);
	}
	public List<BookModel> getBookListByCategoryId(int cid) {
		
		return bookRepo.getBookListByCategoryId(cid);
	}
	public List<BookModel> getAllBooks() {
		
		return bookRepo.getAllBooks();
	}
	public boolean updateBookByName(String OldBook, String Ubook, String type, int Edition, int price, String author, int qty) {
		return bookRepo.updateBookByName(OldBook, Ubook, type, Edition, price, author, qty);
	}
	public boolean searchBookByName(String SearchBook) {
		// TODO Auto-generated method stub
		return bookRepo.searchBookByName(SearchBook);
	}
	public boolean deleteBookByName(String deleteBook) {
		return bookRepo.deleteBookByName(deleteBook);
	}
	public boolean deleteBorrowedBook(List<String> bookNames) {
	
		return bookRepo.deleteBooksByNames(bookNames);
	}
	@Override
	public boolean decreaseBookQuantity(int bookId, int i) {
		return bookRepo.decreaseBookQuantity(bookId, i);
	}
	@Override
	public boolean increaseBookQuantity(int bookId, int i) {
		return bookRepo.increaseBookQuantity(bookId, i);
	}
}
