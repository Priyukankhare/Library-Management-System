package org.techhub.Repository;
import java.util.*;
import java.util.List;

import org.techhub.Model.CategoryModel;

public class CategoryRepositoryImpl extends DBConnection implements CategoryRepository
{
	List<CategoryModel> list=new ArrayList<CategoryModel>();
	public boolean isAddNewCategory(CategoryModel model) { 
	    try {
	        stmt = conn.prepareStatement("insert into Book_Category values(?, ?)");
	        
	        stmt.setInt(1, model.getCid()); 
	        stmt.setString(2, model.getCname());

	        int value = stmt.executeUpdate();
	        
	        
	        return value > 0;
	    } catch (Exception ex) {
	        System.out.println("Error is: " + ex);
	        return false;	
	    }
	}

	public boolean isCategoryPresent(String catPresent) 
	{
	    try
	    {
	        stmt = conn.prepareStatement("select * from Book_Category WHERE cname = ?");
	        stmt.setString(1, catPresent);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            return true;
	        }
	    }
	    catch (Exception ex)
	    {
	        // Handle the exception (optional: log it for debugging)
		    return false; 
	    }
		return false;
	}

	public List<CategoryModel> getAllCategory() 
	{
		List<CategoryModel> list=new ArrayList<CategoryModel>();
		try
		{
			stmt=conn.prepareStatement("Select*from Book_Category");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CategoryModel model=new CategoryModel(rs.getInt(1),rs.getString(2));
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
	public boolean deleteCategoryByName(String Category_Name) {
		
		try
		{
		    int cid=this.getCategoryIdByName(Category_Name);
		    if(cid!=0) {
		    	stmt=conn.prepareStatement("delete from Book_Category where cid=?");
		    	stmt.setInt(1, cid);
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
	public int getCategoryIdByName(String Cname) {
         try {
           	 stmt=conn.prepareStatement("select cid from Book_Category where Cname=? ");
        	 stmt.setString(1,Cname);
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
	public boolean searchCategoryByName(String searchCategory) {
         try {
        	 
        	 stmt=conn.prepareStatement("select cname from Book_Category where Cname=?");
        	 stmt.setString(1, searchCategory);
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
	public boolean updateCategoryByName(String Cname, String Uname) {
		try
		{
		    int cid=this.getCategoryIdByName(Cname);
		    if(cid!=0) {
		    	stmt=conn.prepareStatement("update Book_Category set cname=? where cid=?");
		    	stmt.setString(1, Uname);
		    	stmt.setInt(2, cid);
		    	
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

	
}
