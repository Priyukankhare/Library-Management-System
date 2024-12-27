package org.techhub.Service;

import java.util.List;

import org.techhub.Model.CategoryModel;

public interface CategoryService 
{
	public boolean isCategoryPresent(String catPresent);

	public boolean isAddNewCategory(CategoryModel model);
	public List<CategoryModel> getAllCategory();
	public int getCategoryIdByName(String Cname);
	public boolean deleteCategoryByName(String Cname);
	
	public boolean searchCategoryByName(String Cname);

	public boolean updateCategoryByName(String Cname, String Uname);
}
