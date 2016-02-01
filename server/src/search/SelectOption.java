package search;

public abstract class SelectOption<T> {

	public enum DDOPTION {CP, EQ, LT, GT, BT};
	
	public DDOPTION option;
	public T low, high;
	
	public abstract void parseUserInput(String Input);
	public abstract boolean matches(T Value);
	
}
