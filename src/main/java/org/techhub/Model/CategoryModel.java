package org.techhub.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
	private int cid;
	private String Cname;
	
}
	/*public String getCname() {
		return Cname;
	}
	public void setCid(int cid) 
	{
		this.cid=cid;
		
	}
	public void setCname(String Cname) 
	{
		this.Cname=Cname;
		
	}
	public int getCId()
	{
		return cid;
	}
	public CategoryModel() {
		
	}
	public CategoryModel(int int1, String string) {
		// TODO Auto-generated constructor stub
		cid=int1;
		Cname= string;
	}
	
	

}*/
