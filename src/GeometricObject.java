/********************************************** 
Workshop # 4
Course: JAC433
Last Name:Yang
First Name:Shuqi
ID:132162207
Section:NBB 
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature 
Date:2022-02-23
**********************************************/ 

public abstract class GeometricObject {
	private String color;
	private Boolean filled;
	//constants 
	final double defSize = 1.0, maxSize = 10.0;
	GeometricObject(){};
	protected GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return this.color;
	}
	public void setFilled(Boolean filled) {
		this.filled = filled;
	}
	public Boolean getFilled() {
		return this.filled;
	}
	//abstract methods for subclasses to overload
	abstract public double getArea();
	abstract public double getPerimeter();
	
}
