package search;

public class SelectionScreen {

	public SelectOptionInt height, length, width;
	public SelectOptionString client, description, id, version;
	public SelectOptionBool active, cool, economy, regain, warm;
	public SelectOptionDate date;
	public SelectOptionSpace space;
	
	public static final int MAX_SELECT_OPTION_COUNT = 14;
	
	public SelectionScreen() {
		
	}
	
}
