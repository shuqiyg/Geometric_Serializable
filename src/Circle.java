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
public class Circle extends GeometricObject implements Resizable {
	double radius = 1.0;
	final double pi = 3.1416;
	
	public Circle(double radius, String color, Boolean filled) throws InvalidGOSizeException {
		super(color, filled);
		if(radius < defSize || radius > maxSize) {
			throw new InvalidGOSizeException("Invalid Radius for a Circle!(Range must be 1.0-10.0cm)");
		}else {
			setRadius(radius);
		}
	}
	public double getRadius() {
		return this.radius;
	}
	public void setRadius(double r) {
		this.radius = r;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (double) (Math.round(getRadius()*getRadius()*pi*10.0)/10.0);
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		
		return (double) (Math.round(pi*2*getRadius()*10.0)/10.0);
	}
	@Override
	public void incSize(int percentage) throws InvalidGOSizeException {
		// TODO Auto-generated method stub
		double newR = this.radius * (1 + (double)percentage/100);
		if(newR > maxSize) {
			throw new InvalidGOSizeException("Could Not UpSize Circle Object's radius by " + percentage + "%!\n");
		}else {
			setRadius(newR);
		}

	}
	@Override
	public void decSize(int percentage) throws InvalidGOSizeException {
		// TODO Auto-generated method stub
		double newR = this.radius * (1 - (double)percentage/100);
		if(newR < defSize) {
			throw new InvalidGOSizeException("Could Not Downsize Circle Object's radius by " + percentage + "%!\n");
		}else {
			setRadius(newR);
		}
		
	}
	public String toString() {
		return "\nArea: " + this.getArea() + "\nPerimeter: " + this.getPerimeter() + "\nColor: " + this.getColor() + "\nFilled: " + (this.getFilled()? "Yes": "No") + "\n";
	}
}
