package com.veggie.src.java.core.media;

import java.util.Map;
import java.util.HashMap;

public class MediaTitle{
	private int id;
	private String ISBN;
	private String title;
	private String author;
	private String description;

	private Map<String, String> fieldMap;

	public static final int NEW_TITLE = 0;
	public static final int EXISTING_TITLE = 1;
	public static final int INVALID_TITLE = 2;


	public MediaTitle(final int id, final String ISBN, final String title, final String author, final String description){
		this.id = id;
		this.ISBN = ISBN;
		this.author = author;
		this.description = description;
		fieldMap = new HashMap<>();
		fieldMap.put("ISBN", ISBN);
		fieldMap.put("title", title);
		fieldMap.put("id", id + "");
		fieldMap.put("author", author);
		fieldMap.put("description", description);
	}

	public int getId(){
		return id;
	}

	public String getISBN(){
		return ISBN;
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public String getDescription(){
		return description;
	}

	public boolean containsField(String field) {
		return fieldMap.containsKey(field);
	}

	public String getData(String field) {
		return fieldMap.get(field);
	}
}
