package org.techhub.Repository;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.techhub.Model.BookModel;
import org.techhub.Model.CategoryModel;
import org.techhub.Service.CategoryService;
import org.techhub.Service.CategoryServiceImpl;

import com.mysql.cj.xdevapi.Statement;

public class BookRepositoryImpl extends DBConnection implements BookRepository {

  List<BookModel> bookList=new ArrayList<BookModel>();
	CategoryService categoryservice=new CategoryServiceImpl();

  public boolean isAddNewBooks(BookModel Model1) {
	    try {
	    	
	        PreparedStatement stmt = conn.prepareStatement("INSERT INTO book (Bname, Btype, Edition_year, Bprice, Author,cid, quantity) VALUES (?, ?, ?, ?, ?,?,?)");
	        stmt.setString(1, Model1.getBname());
	        stmt.setString(2, Model1.getBtype());
	        stmt.setInt(3, Model1.getEdyear());
	        stmt.setInt(4, Model1.getBprice());
	        stmt.setString(5, Model1.getAuthor());
	        stmt.setInt(6, Model1.getCid());
	        stmt.setInt(7, Model1.getQty());

	        int value = stmt.executeUpdate();
	    
	        return value > 0;
	    } 
	    catch (Exception ex)
	    {
	           return false;
	    }
	}
  public List<BookModel> getBookListByCategoryId(int cid) {
	   
	    List<BookModel> books = new ArrayList<BookModel>();

	    try {
	        stmt = conn.prepareStatement("select c.cname, b.bid, b.bname, b.btype, b.author, b.edition_year, b.bprice, b.quantity from book_category c inner join book b on b.cid=c.cid where c.cid=?");
	        stmt.setInt(1, cid); 
	        rs = stmt.executeQuery();

	        // Process the result set
	        while (rs.next()) {
	        	     	
	   	            BookModel model = new BookModel(
	                rs.getInt("bid"),        
	                rs.getString("bname"), 
	                rs.getString("btype"),    
	                rs.getInt("edition_year"),
	                rs.getInt("bprice"),      
	                rs.getString("author"), 
	                rs.getInt("quantity")
	            );
	            books.add(model);  
	        }
	    } catch (Exception ex) {
	        System.out.println("Error occurred: " + ex.getMessage());
	    }

	    return books;  
	}
public List<BookModel> getAllBooks() 
 {
	List<BookModel> list=new ArrayList<BookModel>();
	try
	{
		stmt=conn.prepareStatement("Select * from Book");
		rs=stmt.executeQuery();
		while(rs.next())
		{
			BookModel model = new BookModel(
	                rs.getInt("bid"),        
	                rs.getString("bname"), 
	                rs.getString("btype"),    
	                rs.getInt("edition_year"),
	                rs.getInt("bprice"),      
	                rs.getString("author"),
	                rs.getInt("quantity")
	            );
			
			list.add(model);
		}
		return list;
	}
	catch(Exception ex)
	{
		System.out.println("Error is "+ex);
		return list;
	}
}

public int getBookIdByName(String Bname) {
    try {
      	 stmt=conn.prepareStatement("select bid from Book where bname=? ");
   	 stmt.setString(1,Bname);
   	 rs=stmt.executeQuery();
   	 
   	 if(rs.next()) {
   		 return rs.getInt(1);
   	 }
   	 else {
   	      return 0;
   	 }
    }
    catch(Exception ex) {
   	 System.out.println("Error is " +ex);
   	 return -1;
    }
}
public boolean updateBookByName(String OldBook, String Ubook, String type, int Edition, int price, String author, int qty) {
	try
	{
	    int Bid=this.getBookIdByName(OldBook);
	    if(Bid!=0) {
	    	String sql = "UPDATE Book SET Bname=?, Btype=?, Edition_year=?, Bprice=?, Author=?, quantity=? WHERE Bid=?";
            stmt = conn.prepareStatement(sql);
            
            // Set parameters
            stmt.setString(1, Ubook);
            stmt.setString(2, type);
            stmt.setInt(3, Edition);
            stmt.setInt(4, price);
            stmt.setString(5, author);
            stmt.setInt(6, Bid );
            stmt.setInt(7, qty );

	    	int value=stmt.executeUpdate();
	    	return value>0?true:false;
	    	
	    }
	    else {
          return false;
	    }
	}
	catch(Exception ex)
	{
		System.out.println("Error is "+ex);
		return false;	
	}	
	
}
public boolean searchBookByName(String SearchBook) {
	try {
   	 
   	 stmt=conn.prepareStatement("select Bname from Book where Bname=?");
   	 stmt.setString(1, SearchBook);
   	 rs=stmt.executeQuery();
   	 
   	 if(rs.next()) {
   		 return true;
   	 }
   	 else {
   		 return false;
   	 }
      } 
    catch(Exception ex) {
   	 System.out.println("Error is " +ex);
		return false;
    }
	
}
public boolean deleteBookByName(String deleteBook) {
	try
	{
	    int bid=this.getBookIdByName(deleteBook);
	    if(bid!=0) {
	    	stmt=conn.prepareStatement("delete from Book where bid=?");
	    	stmt.setInt(1, bid);
	    	int value=stmt.executeUpdate();
	    	return value>0?true:false;
	    }
	    else {
          return false;
	    }
	}
	catch(Exception ex)
	{
		System.out.println("Error is "+ex);
		return false;	
	}
	
}
public boolean deleteBooksByNames(List<String> bookNames) 
{
	List<BookModel> list=new ArrayList<BookModel>();
    System.out.println("Attempting to delete books: " + bookNames);

    try {
    	stmt = conn.prepareStatement("DELETE FROM book WHERE Bname = ?");
	        for (String bookName : bookNames) 
	        {
	            stmt.setString(1, bookName);
	            stmt.addBatch();
	        }

        int[] results = stmt.executeBatch();

        for (int result : results) {
            if (result < 0) 
            { 
                System.out.println("Deletion failed for some books.");
                return false;
            }
        }

        System.out.println("All books deleted successfully.");
        return true;
    	}
	catch (Exception e) 
	{
	        System.out.println("Unexpected error: " + e.getMessage());
	        return false;
	    }
  }
public boolean decreaseBookQuantity(int bookId, int count) {
    try {
    stmt = conn.prepareStatement("UPDATE Book SET quantity = quantity - ? WHERE Bid = ? AND quantity >= ?"); 
        stmt.setInt(1, count);
        stmt.setInt(2, bookId);
        stmt.setInt(3, count); // Ensure enough books are available
       // return ((PreparedStatement) rs).executeUpdate() > 0; // Returns true if rows were updated
        return stmt.executeUpdate()>0?true:false;
    } 
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return false;
}

// Service method to increase book quantity in the database
public boolean increaseBookQuantity(int bookId, int count) {
    try {
    	stmt = conn.prepareStatement("UPDATE Book SET quantity = quantity + ? WHERE Bid = ?"); 
        stmt.setInt(1, count);
        stmt.setInt(2, bookId);
        //return ((PreparedStatement) rs).executeUpdate() > 0; // Returns true if rows were updated
        return stmt.executeUpdate()>0?true:false;
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    return false;
}
}



 
