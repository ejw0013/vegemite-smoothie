package com.veggie.src.java.entities.media;

public class MediaItem{
	private int id;
	private MediaTitle title;
	private int status;

	public static final int AVAILABLE = 0;
	public static final int UNAVAILABLE = 1;
	public static final int RESERVED = 2;

	public MediaItem(final int id, final MediaTitle title){
		this.id = id;
		this.title = title;
	}

	public MediaTitle getTitle(){
		return title;
	}

	public int getId(){
		return id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
