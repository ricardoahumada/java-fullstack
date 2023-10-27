package com.banana.pojos.books;

public class NewPDFBook implements EBook{
	public String read(){
		return "reading a pdf book.";
	}

	@Override
	public int genX() {
		// TODO Auto-generated method stub
		return 0;
	}
}
