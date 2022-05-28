import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Stream {
	private static String fileName = "GeometricObject.ser";
	private  ObjectOutputStream outputS;
	private  ObjectInputStream inputS;
	private static ArrayList<GeometricObject> objectsArr = new ArrayList<GeometricObject>();
	private static ArrayList<GeometricObject> triangleArr = new ArrayList<GeometricObject>();
	private static ArrayList<GeometricObject> circleArr = new ArrayList<GeometricObject>();
	
	
	public Stream() {
		openFile(fileName);
	};
	
	public  void openFile(String fileName) {
		try {
			outputS = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
			inputS = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
		}catch (IOException ioException) {
			System.err.println("Can not open file. Terminating....");
			System.exit(1);
		}
	}
	
	public  void closeFile() {
		try {
			if(outputS != null || inputS != null) {
				inputS.close();
				outputS.close();
			}
		}catch (IOException ioException) {
			System.err.println("Error Closing files.Terminating...");
			System.exit(1);
		}
	}
	
	public ArrayList<GeometricObject> getCircleArr(){
		return circleArr;
	}
	
	public ArrayList<GeometricObject> getTriangleArr(){
		return triangleArr;
	}
	
	public ArrayList<GeometricObject> getObjectsArr(){
		return objectsArr;
	}
	
	public void read() {
		
		Boolean reading = true;
		try {
			while(reading) {							
				GeometricObject GO = (GeometricObject) (inputS.readObject());
				if(GO != null) {
					objectsArr.add(GO);
				}
//					if(GO.getClass() == Triangle.class) {
//						triangleArr.add(GO);
//					}else {
//						circleArr.add(GO);
//					}
//				}
					
			//break;
				}
			}catch(EOFException EOFException) {
				//System.out.println("End of file, no more object");
				//reading = false;
				//break;
			}catch(ClassNotFoundException classNotFoundException) {
				System.err.println("Invalid object type. Terminating.");
			}catch(IOException ioException) {
				System.err.println("Error reading from file. Terminating.");
			}
			catch(Exception excp) {
				System.out.println("No object in the file...");
				//reading = false;
				//break;
			}
			
		//return GoArray;
	}
	//}
	
	
	public void write(GeometricObject GO) {
		//openFile(fileName);
		try {
			outputS.writeObject(GO);
		}catch(IOException err) {
			System.err.println("Error Writing to file. Terminating....");	
		}
	}
}
