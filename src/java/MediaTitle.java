public class MediaTitle{
	private int id;
	private String ISBN;
	private String title;
	private String author;
	private String description;

	public MediaTitle(final int id, final String ISBN, final String author, final String description){
		this.id = id;
		this.ISBN = ISBN;
		this.author = author;
		this.description = description;
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
}
