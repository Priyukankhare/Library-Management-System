package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.CategoryModel;

public interface CategoryRepository 
{
	public boolean isCategoryPresent( String catPresent);

	public boolean isAddNewCategory(CategoryModel model);
	

	public List<CategoryModel> getAllCategory();
	
	public boolean deleteCategoryByName(String Cname);
	
	public int getCategoryIdByName(String Cname);
	
	public boolean searchCategoryByName(String searchCategory);
	
	public boolean updateCategoryByName(String Cname, String Uname);
 
	

}

