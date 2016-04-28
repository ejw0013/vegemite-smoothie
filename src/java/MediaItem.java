public class MediaItem{
	private int id;
	private MediaTitle title;

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
}
