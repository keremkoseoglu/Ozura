package data;

import java.util.ArrayList;
import model.Contract;
import search.SelectionScreen;

public interface DataSource {

	public ArrayList<Contract> getAllContracts(String[] ConnectionParam) throws Exception;
	public ArrayList<Contract> getFilteredContracts(String[] ConnectionParam, SelectionScreen SS) throws Exception;
	
}
