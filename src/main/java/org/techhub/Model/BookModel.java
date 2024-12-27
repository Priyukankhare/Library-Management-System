package org.techhub.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {

	
	private int Bid;
	private String Bname;
	private String Btype;
	private String Author;
	private int Edyear;
	private int Bprice;
	private int Cid;
	private int Qty;
	
	public BookModel(int Bid, String Bname,String Btype,int Edyear,int Bprice,String Author, int Qty)
	{
		this.Bid=Bid;
		this.Bname=Bname;
		this.Btype=Btype;
		this.Author=Author;
		this.Edyear=Edyear;
		this.Bprice=Bprice;
		this.Qty=Qty;
	}
}
