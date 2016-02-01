package data;

public class XmlToolkit {

	public static XmlTag getTag(String Line) {
		
		XmlTag ret = new XmlTag();
		
		String line = Line.trim();
		if (line.length() <= 0) return new XmlTag(); 
		if (!line.substring(0, 1).equals("<")) return new XmlTag();
		if (line.substring(1, 2).equals("/")) ret.state = XmlTag.STATE.CLOSED; else ret.state = XmlTag.STATE.OPEN;
		ret.name = line.substring(1, line.indexOf(">")).replace("/", "");
		
		return ret;
		
	}
	
	public static String getTagValue(String Line) throws Exception {
		int p1 = Line.indexOf(">") + 1;
		int p2 = Line.lastIndexOf("<");
		return Line.substring(p1, p2);
	}
	
}
