package com.banana.pojos.books;

public class Book {
    private int currentPage=1;
	public String getTitle(){
        return 'A Great Book';
    }

    public String getAuthor(){
        return 'John Doe';
    }

    public void turnPage(){
        this.currentPage++;
    }

    public String printCurrentPage(){
        System.print.line("Current page content")
    }
}

