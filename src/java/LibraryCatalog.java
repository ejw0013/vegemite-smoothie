import java.util.List;
import java.util.ArrayList;

public class LibraryCatalog{
	private static List<MediaItem> items;
	private static List<MediaTitle> titles;
	private static LibraryCatalog instance = null;
	protected LibraryCatalog(){}
	public LibraryCatalog getInstance(){
		if(instance == null){
			instance = new LibraryCatalog();
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
