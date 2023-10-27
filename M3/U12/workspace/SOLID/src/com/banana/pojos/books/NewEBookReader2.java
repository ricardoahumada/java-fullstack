package com.banana.pojos.books;

public abstract class NewEBookReader2 {
	protected EBook book;
	 
    public NewEBookReader2(EBook book){
    	this.book = book;
    }
 
    public abstract String read();
}
