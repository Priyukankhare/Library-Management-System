package org.techhub.Service;

import java.util.List;

import org.techhub.Model.CategoryModel;
import org.techhub.Repository.CategoryRepository;
import org.techhub.Repository.CategoryRepositoryImpl;

public class CategoryServiceImpl implements CategoryService{

	CategoryRepository stmtRepo=new CategoryRepositoryImpl();
	
	public boolean isCategoryPresent(String catPresent) {
	
		return stmtRepo.isCategoryPresent(catPresent);
	}
	
	public boolean isAddNewCategory(CategoryModel model) {
		return stmtRepo.isAddNewCategory(model);
	}
	
	public List<CategoryModel> getAllCategory() {
		return stmtRepo.getAllCategory();
	}

	public int getCategoryIdByName(String Cname) {
		
		return stmtRepo.getCategoryIdByName(Cname);
	}

	public boolean deleteCategoryByName(String Cname) {
		return stmtRepo.deleteCategoryByName(Cname);
	}

	public boolean searchCategoryByName(String Cname) {
		
		return stmtRepo.searchCategoryByName(Cname);
	}

	public boolean updateCategoryByName(String Cname, String Uname) {
		return stmtRepo.updateCategoryByName(Cname,Uname);
	}	
	

}
