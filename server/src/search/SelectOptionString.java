package search;

import java.util.regex.*;

public class SelectOptionString extends SelectOption<String> {

	@Override
	public boolean matches(String Value) {
		
		if (option.equals(DDOPTION.CP)) {
			
			String regex = "";
			for (int n = 0; n < low.length(); n++) {
				String c = low.substring(n, n + 1);
				if (c.equals("*")) regex += "(.*)"; else regex += c.toUpperCase();
			}
			
			Pattern r = Pattern.compile(regex);
			Matcher m = r.matcher(Value.toUpperCase());
			return (m.find());
		}
		
		if (option.equals(DDOPTION.EQ)) return low.equals(Value);
		return false;
	}

	@Override
	public void parseUserInput(String Input) {
		
		try {
			
			String fi = Input.trim();
			
			if (fi.indexOf("*") >= 0) {
				low = fi;
				option = DDOPTION.CP;
				return;
			}
			
			low = fi;
			option = DDOPTION.EQ;
			return;
			
		} catch (Exception ex) {
			return;
		}
		
	}

}
