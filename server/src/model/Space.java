package model;

public class Space {

	public enum SPACE_ID {INTERNAL, EXTERNAL};
	
	public SPACE_ID id;
	
	public Space(SPACE_ID SID) {
		id = SID;
	}
	
	public String toString() {
		if (id.equals(SPACE_ID.INTERNAL)) return "İç";
		return "Dış";
	}
	
}
