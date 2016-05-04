package com.veggie.src.java.core;

import com.veggie.src.java.core.media.MediaItem;
import com.veggie.src.java.core.media.MediaTitle;

import java.util.List;

public class LibraryCatalog{
	private static List<MediaItem> items;
	private static List<MediaTitle> titles;
	private static LibraryCatalog instance = null;

	protected LibraryCatalog(final List<MediaItem> items, final List<MediaTitle> titles){
		this.items = items;
		this.titles =titles;
	}
	public static LibraryCatalog getInstance(final List<MediaItem> items, final List<MediaTitle> titles){
		if(instance == null){
			instance = new LibraryCatalog(items, titles);
		}
		return instance;
	}
	public List<MediaItem> getItems(){
		return items;
	}

	public List<MediaTitle> getTitles(){
		return titles;
	}
}
