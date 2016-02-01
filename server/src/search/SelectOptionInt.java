package search;

public class SelectOptionInt extends SelectOption<Integer> {

	@Override
	public boolean matches(Integer Value) {
		
		if (option.equals(DDOPTION.BT)) return (Value >= low && Value <= high);
		if (option.equals(DDOPTION.EQ)) return (Value.equals(low));
		if (option.equals(DDOPTION.GT)) return (Value > low);
		if (option.equals(DDOPTION.LT)) return (Value < low);
		
		return false;
	}

	@Override
	public void parseUserInput(String Input) {
		
		try {
			String fi = Input.trim();
			int l = fi.length();
			
			if (l <= 0) return;
			
			if (fi.startsWith("<")) {
				low = Integer.valueOf(fi.substring(1, l).trim());
				option = DDOPTION.LT;
				return;
			}
			if (fi.startsWith(">")) {
				low = Integer.valueOf(fi.substring(1, l).trim());
				option = DDOPTION.GT;
				return;
			}
			
			int dp = fi.indexOf("-");
			if (dp >= 0) {
				low = Integer.valueOf(fi.substring(0, dp).trim());
				high = Integer.valueOf(fi.substring(dp + 1, l).trim());
				option = DDOPTION.BT;
				return;
			}
			
			low = Integer.valueOf(fi);
			option = DDOPTION.EQ;
			
		}
		catch (Exception ex) {
			return;
		}
		
	}

}
