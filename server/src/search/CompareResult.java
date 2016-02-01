package search;

import model.Contract;
import java.util.ArrayList;

public class CompareResult implements Comparable<CompareResult>  {

	public ArrayList<CompareResultLine> fields;
	public int points;
	public Contract contract;
	
	public CompareResult() {
		fields = new ArrayList<CompareResultLine>();
		points = 0;
		contract = null;
	}

	@Override
	public int compareTo(CompareResult o) {
		
		try {
			return points - o.points;
			
		} catch(Exception ex) {
			
		}
		
		// TODO Auto-generated method stub
		return 0;
	}
	
}
