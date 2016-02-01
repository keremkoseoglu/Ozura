package search;

public class SelectOptionBool extends SelectOption<Boolean> {

	@Override
	public boolean matches(Boolean Value) {
		if (!option.equals(DDOPTION.EQ)) return false;
		return low.equals(Value);
	}

	@Override
	public void parseUserInput(String Input) {
		if (Input.equals("TRUE")) {
			option = DDOPTION.EQ;
			low = true;
			return;
		}
		
		if (Input.equals("FALSE")) {
			option = DDOPTION.EQ;
			low = false;
			return;
		}
	}

}
