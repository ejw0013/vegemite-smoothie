import java.util.List;
import java.util.ArrayList;

public class LibraryCatalog{
	private static List<MediaItem> items;
	private static List<MediaTitle> titles;
	private static LibraryCatalog instance = null;

	protected LibraryCatalog(final List<MediaItem> items, finalList<MediaTitle> titles){
		this.items = items;
		this.titles =titles;
	}
	public LibraryCatalog getInstance(final List<MediaItem> items, finalList<MediaTitle> titles){
		if(instance == null){
			instance = new LibraryCatalog(List<MediaItem> items, List<MediaTitle> titles);
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
