package org.techhub.Service;

import java.util.List;

import org.techhub.Model.UserModel;
import org.techhub.Repository.UserRepository;
import org.techhub.Repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
	UserRepository userRepo=new UserRepositoryImpl();
	
	public boolean isAddNewUser(UserModel Model1) {
		
		return userRepo.isAddNewUser(Model1);
	}

	public boolean addBooksToUser(int userId, List<Integer> bookIds) {
		return userRepo.addBooksToUser(userId, bookIds);
	}

	public List<String> getBooksByUser(int userId) {
		return userRepo.getBooksByUser(userId);
	}

	public int getUserIdByName(String name)
	{
		
		return userRepo.getUserIdByName(name);
	}

	public boolean checkUserLogin(String username, String pass) {
		
		return userRepo.checkUserLogin(username, pass);
	}

	public String getUnameByEmail(String email) {
		return userRepo.getUnameByEmail(email);
	}

	public List<UserModel> ViewAllUser() {
		return userRepo.ViewAllUser();
	}

	public List<UserModel> SearchUserByName(String Uname) {
		
		return userRepo.SearchUserByName(Uname);
	}

	public boolean deleteUserByName(String Uname) {
		
		return userRepo.deleteUserByName(Uname);
	}

	public boolean searchUserByEmail(String presentEmail) {
		return userRepo.searchUserByEmail(presentEmail);
	}

	public boolean updateEmail(String presentEmail,String newEmail) {
		
		return userRepo.updateEmail(presentEmail,newEmail);
	}

	public int getUserIdByEmail(String presentEmail) {
		return userRepo.getUserIdByEmail(presentEmail);
	}

	public boolean updateAddress(String presentEmail, String address) {
		return userRepo.updateAddress(presentEmail, address);
	}

	public boolean updatepassword(String presentEmail12, String password1) {
		
		return userRepo.updatepassword(presentEmail12, password1);
	}

	public boolean updatePhone(String presentEmail12, long phone) {
		// TODO Auto-generated method stub
		return userRepo.updatePhone(presentEmail12, phone);
	}

	@Override
	public void removeBooksFromUser(int userId, List<Integer> returnedBookIds) {
		// TODO Auto-generated method stub
		
	}

	
	
}
