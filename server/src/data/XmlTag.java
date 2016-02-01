package data;

public class XmlTag {

	public enum STATE {OPEN, CLOSED};
	
	public STATE state;
	public String name;
	
	public XmlTag() {
		name = "";
		state = STATE.CLOSED;
	}
	
}
