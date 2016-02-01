package search;

import model.Space;
import model.Space.SPACE_ID;

public class SelectOptionSpace extends SelectOption<Space> {

	@Override
	public boolean matches(Space Value) {
		if (!option.equals(DDOPTION.EQ)) return false;
		return low.id.equals(Value.id);
	}

	@Override
	public void parseUserInput(String Input) {
		if (Input.equals("I")) {
			option = DDOPTION.EQ;
			low = new Space(SPACE_ID.INTERNAL);
			return;
		}

		if (Input.equals("E")) {
			option = DDOPTION.EQ;
			low = new Space(SPACE_ID.EXTERNAL);
			return;
		}
		
	}

}
