package package_background;

public class Field {
	//Als Description vorerst Name (gleich wie xmlTag) 
	private int length; 
	private int decimal; 
	private boolean mandatory; 
	private String description; 
	private String xmlTag;
	Field f = new Field(length, decimal, mandatory, description, xmlTag);
	
	public Field (int length, int decimal, boolean mandatory, String description, String xmlTag) {
		this.length = length; 
		this.decimal = decimal; 
		this.mandatory = mandatory; 
		this.description = description; 
		this.xmlTag = xmlTag; 
	}
	
	
	
	private void setData(Field f) {
		
	}
}
