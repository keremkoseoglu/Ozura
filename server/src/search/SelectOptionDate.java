package search;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class SelectOptionDate extends SelectOption<Date> {

	@Override
	public boolean matches(Date Value) {
		if (option.equals(DDOPTION.BT)) return (Value.before(high) && Value.after(low));
		if (option.equals(DDOPTION.EQ)) return low.equals(Value);
		if (option.equals(DDOPTION.GT)) return Value.after(low);
		if (option.equals(DDOPTION.LT)) return Value.before(low);
		return false;
	}

	@Override
	public void parseUserInput(String Input) {
		
		try {
			
			String fi = Input.trim();
			int l = fi.length();
			if (l <= 0) return;
			
			DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
			
			if (fi.startsWith("<")) {
				low = df.parse(fi.substring(1, l).trim());
				option = DDOPTION.LT;
				return;
			}
			if (fi.startsWith(">")) {
				low = df.parse(fi.substring(1, l).trim());
				option = DDOPTION.GT;
				return;
			}
			
			int dp = fi.indexOf("-");
			if (dp >= 0) {
				low = df.parse(fi.substring(0, dp).trim());
				high = df.parse(fi.substring(dp + 1, l).trim());
				option = DDOPTION.BT;
				return;
			}
			
			low = df.parse(fi);
			option = DDOPTION.EQ;
			
		} catch (Exception ex) {
			return;
		}
	}

}
