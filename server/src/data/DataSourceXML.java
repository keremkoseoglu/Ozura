package data;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.*;
import search.SelectionScreen;

public class DataSourceXML implements DataSource {

	@Override
	public ArrayList<Contract> getAllContracts(String[] ConnectionParam) throws Exception {

		ArrayList<Contract> ret = new ArrayList<Contract>();
		Contract contract = null;
		
		Scanner in = new Scanner(new FileReader(ConnectionParam[0]));
		
		while (in.hasNextLine()) {
			
			String line = in.nextLine().trim();
			XmlTag tag = getTag(line);
			
			if (tag.name.equals("contract")) {
				if (tag.state.equals(XmlTag.STATE.OPEN)) contract = new Contract(); else ret.add(contract);
			}
			
			if (tag.name.equals("height")) contract.height = getTagValueInt(line);
			if (tag.name.equals("width")) contract.width = getTagValueInt(line);
			if (tag.name.equals("length")) contract.length = getTagValueInt(line);
			
			if (tag.name.equals("id")) contract.id = getTagValue(line);
			if (tag.name.equals("version")) contract.version = getTagValue(line);
			if (tag.name.equals("client")) contract.client = getTagValue(line);
			if (tag.name.equals("description")) contract.description = getTagValue(line);
			
			if (tag.name.equals("active")) contract.active = getTagValueBool(line);
			if (tag.name.equals("warm")) contract.warm = getTagValueBool(line);
			if (tag.name.equals("cool")) contract.cool = getTagValueBool(line);
			if (tag.name.equals("economy")) contract.economy = getTagValueBool(line);
			if (tag.name.equals("regain")) contract.regain = getTagValueBool(line);
			
			if (tag.name.equals("date")) contract.date = getTagValueDate(line);
			
			if (tag.name.equals("space")) contract.space = getTagValueSpace(line);
			
		}
		
		in.close();
		
		return ret;
		
	}

	@Override
	public ArrayList<Contract> getFilteredContracts(String[] ConnectionParam, SelectionScreen SS) throws Exception {
		return getAllContracts(ConnectionParam);
	}

	private XmlTag getTag(String Line) { return XmlToolkit.getTag(Line); }
	
	private String getTagValue(String Line) throws Exception { return XmlToolkit.getTagValue(Line); }
	private boolean getTagValueBool(String Line) throws Exception { return getTagValue(Line).equals("TRUE"); }
	
	private Date getTagValueDate(String Line) throws Exception {
		String s = getTagValue(Line);
		DateFormat format = new SimpleDateFormat("dd.mm.yyyy", Locale.ENGLISH);
		return format.parse(s);
	}
	
	private int getTagValueInt(String Line) throws Exception {
		int ret = Integer.valueOf(getTagValue(Line));
		return ret;
	}
	
	private Space getTagValueSpace(String Line) throws Exception {
		Space.SPACE_ID sid = Space.SPACE_ID.INTERNAL;
		if (getTagValue(Line).equals("EXTERNAL")) sid = Space.SPACE_ID.EXTERNAL;
		return new Space(sid);
		
	}
	
}
