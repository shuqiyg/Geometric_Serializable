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

import java.util.ArrayList;
import java.util.Scanner;
// test program
public class Test {
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String mainOption;
		int mainOpt;
		Boolean exit = false; 
		Triangle triangleSample = null;
		Circle circleSample = null;
		Stream goStream = new Stream();
		System.out.println("Welcome to GO testing program!");
		do {
			
			System.out.println("Please choose one of the following option ===> ");
			System.out.println("1. Create an Object\n2. Upsize an Object\n3. Downsize an Object\n4. Save\n5. Load\n6. Exit Program\n");
			try {
				mainOption = input.next();
				System.out.println();
				mainOpt  = Integer.parseInt(mainOption);
			}catch(Exception e) {
				System.out.println("Please enter an Integer ....\n");
				continue;
			}		
			switch(mainOpt) {
			case 1:
				Boolean exit1 = false;
				do {
					System.out.println("Please choose one of the Geometric Object ===> ");
					System.out.print("a. Triangle OR  b. Circle : ");
					String objOption = input.next();
					switch(objOption.toLowerCase()){
					case "a":
						System.out.print("Please enter the length for side1(cm): ");
						double s1 = input.nextDouble();
						System.out.print("Please enter the length for side2(cm): ");
						double s2 = input.nextDouble();
						System.out.print("Please enter the length for side3(cm): ");
						double s3 = input.nextDouble();
						System.out.print("Please enter the color: ");
						String color = input.next();
						System.out.print("Is the Triangle filled(Y/N): ");
						String filledStr = input.next();
						Boolean filled;
						filledStr = filledStr.toLowerCase();
						if(filledStr.equals("y") || filledStr.equals("yes")) {
							filled = true;
						}else if(filledStr.equals("n") || filledStr.equals("no")) {
							filled = false;
						}else {
							System.out.println("Invalid input, filled will be set to false by default\n");
							filled = false;
						}
						try {
							triangleSample = new Triangle(s1, s2, s3, color, filled);
						}catch (InvalidGOSizeException e) {
							System.out.println(e.getMessage());
							System.out.println("Fail to creat a Triangle Object, try again...\n");
							continue;
						}
						System.out.println("\nA new Triangle has been created successfully, here is the information: " + triangleSample + "\n");
						exit1 = true;
						break;
					case "b":
						System.out.println();
						System.out.print("Please enter the radius of the Circle(cm): ");
						double radius = input.nextDouble();
						System.out.print("Please enter the color: ");
						String colorCir = input.next();
						System.out.print("Is the Triangle filled(Y/N): ");
						String filledStrCir = input.next();
						Boolean filledCir;
						filledStrCir = filledStrCir.toLowerCase();
						if(filledStrCir.equals("y") || filledStrCir.equals("yes")) {
							filledCir = true;
						}else if(filledStrCir.equals("n") || filledStrCir.equals("no")) {
							filledCir = false;
						}else {
							System.out.println("Invalid input, filled will be set to false by default\n");
							filledCir = false;
						}
						try {
							circleSample = new Circle(radius, colorCir, filledCir);
						}catch (InvalidGOSizeException e) {
							System.out.println(e.getMessage());
							System.out.println("Fail to creat a Triangle Object, try again...\n");
							continue;
						}
						System.out.println("\nA new Circle has been created successfully, here is the information: " + circleSample + "\n");
						exit1 = true;
						break;
					default:
						System.out.println("Invalid Option, please try again....\n");
					}					
				}while(!exit1);
				break;
			case 2:
				Boolean exit2 = false;
				String shapeInput;
				int shapeInt;
				
				do {
					System.out.println("Which Shape you want to UPsize? (1.Triangle 2.Circle 3.Go back)\n");				
					try {
						shapeInput = input.next();
						System.out.println();
						shapeInt  = Integer.parseInt(shapeInput);
					}catch(Exception e) {
						System.out.println("Please enter an Integer ....\n");
						continue;
					}	
					switch(shapeInt) {
					case 1:
						if(triangleSample == null) {
							System.out.println("Please create a Geometric Object before Upsizing.....\n");
							continue;
						}
						System.out.println("What's the percentage amount you want to increase by(%): ");
						int incPctg = input.nextInt();
						System.out.println();
						//check for violation of oversize/undersize input
						try {
							triangleSample.incSize(incPctg);
						}catch(InvalidGOSizeException e) {
							System.out.println(e);
							continue;
						}
						System.out.println("After UpSizing ==> " + triangleSample);
						System.out.println();
						break;
					case 2:
						if(circleSample == null) {
							System.out.println("Please create a Geometric Object before Upsizing.....\n");
							continue;
						}
						System.out.println("What's the percentage amount you want to increase by(%): ");
						int incPctg1 = input.nextInt();
						System.out.println();
						try {
							circleSample.incSize(incPctg1);
						}catch(InvalidGOSizeException e) {
							System.out.println(e);
							continue;
						}
						System.out.println("After UpSizing ==> " + circleSample);
						System.out.println();
						break;
					case 3:
						exit2 = true;
						break;
					default:
						System.out.println("Invalid input, try again...\n");
					}
				}while(!exit2);
				break;
			case 3:
				Boolean exit3 = false;
				String shapeInput1;
				int shapeInt1;
				
				do {
					System.out.println("Which Shape you want to DownSize? (1.Triangle 2.Circle 3.Go back)\n");	
					
					try {
						shapeInput1 = input.next();
						System.out.println();
						shapeInt1  = Integer.parseInt(shapeInput1);
					}catch(Exception e) {
						System.out.println("Please enter an Integer ....\n");
						continue;
					}	
					switch(shapeInt1) {
					case 1:
						if(triangleSample == null) {
							System.out.println("Please create a Geometric Object before downsizing\n");
							continue;
						}
						System.out.println("What's the percentage amount you want to increase by(%): ");
						int incPctg = input.nextInt();
						System.out.println();
						try {
							triangleSample.decSize(incPctg);
						}catch(InvalidGOSizeException e) {
							System.out.println(e);
							System.out.println();
							continue;
						}
						System.out.println("After DownSizing ==> " + triangleSample);
						System.out.println();
						break;
					case 2:
						if(circleSample == null) {
							System.out.println("Please create a Geometric Object before downsizing\n");
							continue;
						}
						System.out.println("What's the percentage amount you want to decrease by(%): ");
						int incPctg1 = input.nextInt();
						System.out.println();
						try {
							circleSample.decSize(incPctg1);
						}catch(InvalidGOSizeException e) {
							System.out.println(e);
							System.out.println();
							continue;
						}
						System.out.println("After DownSizing ==> " + circleSample);
						System.out.println();
						break;
					case 3:
						exit3 = true;
						break;
					default:
						System.out.println("Invalid input, try again...\n");
					}
				}while(!exit3);
				break;
			case 4:
				Boolean exit4 = false;
				int saveOption;
				do {
					System.out.print("Which object you want to save? (1.Triangle 2.Circle 3.Exit)  ");
					saveOption = input.nextInt();
					System.out.println();
					switch(saveOption) {
					case 1:
						if(triangleSample != null) {
							goStream.write(triangleSample);
							System.out.println("A Triangle Object has been saved.\n");
							exit4 = true;
						}else {
							System.out.println("No Triangle Object to save....\n");
						}
						break;
					case 2:
						if(circleSample != null) {
							goStream.write(circleSample);
							System.out.println("A Circle Object has been saved.\n");
							exit4 = true;
						}else {
							System.out.println("No Circle Object to save....\n");
						}
						break;
					case 3:
						exit4 = true;
						break;
					default:
						System.out.println("Invalid save option input, try again...\n");
					}
				}while(!exit4);
				break;
			case 5:
				Boolean exit5 = false;
				//do {
					goStream.read();
					ArrayList<GeometricObject> GoArr = goStream.getObjectsArr();
					//ArrayList<GeometricObject> GoArr =new ArrayList<GeometricObject>();// goStream.getTriangleArr();
					//for(int i = 0; i < goStream.getCircleArr().size(); i++) {
						//GoArr.add(goStream.getCircleArr().get(i));
					//}
					//for(int i = 0; i < goStream.getTriangleArr().size(); i++) {
						//GoArr.add(goStream.getTriangleArr().get(i));
				//	}
					//GoArr.addAll(GoArr.size(), goStream.getCircleArr());
					//System.out.println(goStream.getTriangleArr().size() + "---" + goStream.getCircleArr().size());
					if(GoArr.size() == 0) {
						System.out.println("File is empty, no object to load...\n");
					}else {
						for(int i = 0; i < GoArr.size(); i++) {
							System.out.println("Object " + (i+1) +" ------> " + GoArr.get(i));	
						}
						System.out.println();
						do {
							System.out.print("Please choose one of these object to load (Type in number) ");
							int loadOption = input.nextInt() - 1;
							if(loadOption < 0 || loadOption > GoArr.size() -1 ) {
								System.out.println("Invalid option, please try again...\n");
							}else {
								
								//if(GoArr.get(loadOption).getClass());
								//System.out.println(GoArr.get(loadOption).getClass().equals(triangleSample));
								if(GoArr.get(loadOption).getClass() == Triangle.class) {
									Triangle temp = (Triangle)GoArr.get(loadOption);
									triangleSample = temp;
									//goStream.getTriangleArr().remove(loadOption);
									
								}else {
									Circle temp = (Circle)GoArr.get(loadOption);
									circleSample = temp;
									//goStream.getCircleArr().remove(loadOption + goStream.getTriangleArr().size());
									//goStream.getCircleArr().remove(GoArr.size() - loadOption -1);
								}
								goStream.getObjectsArr().remove(loadOption);
								System.out.println();
								exit5 = true;
							}
						}while(!exit5);
					}
				break;
			case 6:
				System.out.println("Goodbye!");
				exit = true;
				input.close();
				goStream.closeFile();
				break;
			default:
				System.out.println("Please enter a number between 1 to 6.....\n");
			}
		}while(!exit);
		
		
	}

}
