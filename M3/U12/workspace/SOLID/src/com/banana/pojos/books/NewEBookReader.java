package com.banana.pojos.books;

public class NewEBookReader {
	private EBook book;
	 
    public NewEBookReader(EBook book) {
        this.book = book;
    }
 
    public String read() {
        return this.book.read();
    }
}
