package org.techhub.Service;

import java.util.List;

import org.techhub.Model.BookModel;
import org.techhub.Model.CategoryModel;
import org.techhub.Model.UserModel;

public interface UserService {
	public boolean isAddNewUser(UserModel Model1);
	public int getUserIdByName(String name);
	  boolean addBooksToUser(int userId, List<Integer> bookIds);
	    List<String> getBooksByUser(int userId);
	    
	    public boolean checkUserLogin(String username, String pass);
	    
	    public String getUnameByEmail(String email);
	    
		public List<UserModel> ViewAllUser();
		
		public List<UserModel>SearchUserByName(String Uname);
		
		public boolean deleteUserByName(String Uname);
		
		public boolean searchUserByEmail(String presentEmail);
		
		public int getUserIdByEmail(String presentEmail);
		
		public boolean updateEmail(String presentEmail, String newEmail);
		
		public boolean updateAddress(String presentEmail, String address);
		public boolean updatepassword(String presentEmail12,String password1);
		public boolean updatePhone(String presentEmail12,long phone);
		public void removeBooksFromUser(int userId, List<Integer> returnedBookIds);
}
