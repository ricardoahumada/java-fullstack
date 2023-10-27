package com.banana.pojos.books;

public class NewPDFReader extends NewEBookReader2{
	public NewPDFReader(EBook book) {
		super(book);
	}

	public String read() {
        return this.book.read();
    }
}
