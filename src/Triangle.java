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

@SuppressWarnings("serial")
public class Triangle extends GeometricObject implements Resizable{
	double side1, side2, side3;
	
	public Triangle() {};
	public Triangle(double side1, double side2, double side3, String color, Boolean filled) throws InvalidGOSizeException  {
		super(color, filled);
		if(side1 < defSize || side1 >maxSize || side2 >maxSize || side2 < defSize || side3 < defSize || side3 > maxSize || side1 + side2 <= side3 || side2 + side3 <= side1 || side2 + side3 <= side1) {
			throw new InvalidGOSizeException("Invalid side(s) for a Triangle!(Range must be 1.0-10.0cm)");
		}else {
			setSide1(side1);
			setSide2(side2);
			setSide3(side3);  
		}
	}
	public void setSide1(double s1) {
		this.side1 = s1;
	}
	public void setSide2(double s2) {
		this.side2 = s2;
	}
	public void setSide3(double s3) {
		this.side3 = s3;
	}
	
	public double getSide1() {
		return this.side1;
	}
	public double getSide3() {
		return this.side3;
	}
	public double getSide2() {
		return this.side2;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double s = (side1+side2+side3)/2;
		return (double) (Math.round(Math.sqrt(s*(s-side1)*(s-side2)*(s-side3))*10.0)/10.0);
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (double) (Math.round((getSide1()+getSide2()+getSide3())*10.0)/10.0);
	}
	@Override
	public void incSize(int percentage) throws InvalidGOSizeException {
		// TODO Auto-generated method stub
		double new1 = this.side1 * (1+(double)percentage/100);
		double new2 = this.side2 * (1+(double)percentage/100);
		double new3 = this.side3 * (1+(double)percentage/100);
		if( new1 > maxSize ||  new2 > maxSize ||  new3 > maxSize) {
			throw new InvalidGOSizeException("Could Not UpSize Triangle Object's side(s) by " + percentage + "%!\n");
		}else {
			setSide1(new1);
			setSide2(new2);
			setSide3(new3);
		}
		
	}
	@Override
	public void decSize(int percentage) throws InvalidGOSizeException {
		// TODO Auto-generated method stub
		double new1 = this.side1 * (1-(double)percentage/100);
		double new2 = this.side2 * (1-(double)percentage/100);
		double new3 = this.side3 * (1-(double)percentage/100);
		if(new1 < defSize ||  new2 < defSize ||  new3 < defSize) {
			throw new InvalidGOSizeException("Could Not DownSize Triangle Object's Side(s) object by " + percentage + "%!\n");
		}else {
			setSide1(new1);
			setSide2(new2);
			setSide3(new3);
		}
		
	}
	public String toString() {
		return "\nSide1: " + this.side1 + "\nSide2: " + this.side2 +"\nSide3: " + this.side3 + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nColor: " + getColor() + "\nFilled: " + (getFilled()? "Yes": "No") + "\n";
	}
}
