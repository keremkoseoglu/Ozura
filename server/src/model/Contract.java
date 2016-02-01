package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Contract {

	public int height, length, width;
	public String client, description, id, version;
	public boolean active, cool, economy, regain, warm;
	public Date date;
	public Space space;
	
	public Contract() {
		height = 0; 
		length = 0;
		width = 0;
		
		client = "";
		description = "";
		id = "";
		version = "";
		
		active = false;
		cool = false;
		economy = false;
		regain = false;
		warm = false;
		
		date = new Date();
		
		space = new Space(Space.SPACE_ID.INTERNAL);
	}
	
	public String getSizeString() {
		return String.valueOf(width) + " x " + String.valueOf(length) + " x " + String.valueOf(height);
	}
	
	public String getActiveString() { return getBoolString(active); }
	public String getCoolString() { return getBoolString(cool); }
	public String getEconomyString() { return getBoolString(economy); }
	public String getRegainString() { return getBoolString(regain); }
	public String getWarmString() { return getBoolString(warm); }
	
	public String getDateString() {
		DateFormat format = new SimpleDateFormat("dd.mm.yyyy", Locale.ENGLISH);
		return format.format(date);
	}
	
	private String getBoolString(boolean B) {
		if (B) return "Evet";
		return "Hayır";
	}
	
}
