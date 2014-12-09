package lab11;

import java.util.Random;
import java.io.*;
/**
 * Client program of the CarPlate class. The program generates 3 CarPlate 
 * objects with appropriate random values for the fields, and writes them to 
 * a text file using ObjectOutputStream. Then the file is read using 
 * ObjectInputStream, and the output of the toString method for each object is 
 * printed to both the console window and to another text file called 
 * "output.txt".
 * 
 * @author Jaden Young
 */
public class CarPlateTest {
    
    //random number generator for class
    private static final Random rand = new Random();
    
    /**
     * Generates a random license plate number in the format "000 000", where 
     * the two groups of characters are randomly generated as either integers
     * 1-9 or as letters 
     * @return Randomly generated license plate number as a string
     */
    private static String generatePlateNumber(){
        String plateNumber = "";
        for (int i = 0; i < 7; i++){
            
            if (i == 3) //generates space for middle character
                plateNumber += " ";
            
            else if (Math.random() > .5) // generates a letter
                plateNumber += (char)(rand.nextInt(26) + 'a');
            
            else //generates a number
                plateNumber += rand.nextInt(10);
        }
        return plateNumber.toUpperCase();
    }
    
    /**
     * Generates a random integer 1-50 representing the State of the license 
     * plate
     * @return Random integer 1-50
     */
    private static int generateState(){
        return rand.nextInt(50) + 1;
    }
    
    /**
     * Generates a random color from a predefined array of 10 color choices
     * @return String containing a color
     */
    private static String generateColor(){
        String[] colorList = new String[]{ "Red", "White", "Blue", "Black",
            "Green", "Orange", "Pink", "Yellow", "Purple", "Periwinkle"};
        return colorList[rand.nextInt(10)];
    }
    
    
    
    
    public static void main(String[] args) {
        
        //generate 3 random carPlates objects and write them to a txt file
        try {
            
            FileOutputStream fos = new FileOutputStream("carPlates.txt", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            try{
                //generate and write 3 objects to the file
                for (int i = 0; i < 3; i++){
                    CarPlate tmpCarPlate = new CarPlate(generatePlateNumber(),
                                                         generateState(), 
                                                         generateColor());
                    oos.writeObject(tmpCarPlate);
                }
            }
            finally{
                oos.close();
            }
        }
        
        catch(FileNotFoundException fnfe){
            System.out.println("Could not create/modify the file carPlates.txt "
                    + "\nThere is probably a problem with the permissions.");
            System.out.print("Message: ");
            System.out.println(fnfe.getMessage());
            System.out.print("toString: ");
            System.out.println(fnfe.toString());
            fnfe.printStackTrace(System.out);
        }
        
        catch(IOException ioe){
            System.out.print("There was a problem writing to the file: ");
            System.out.println(ioe.getMessage());
            System.out.print("toString: ");
            System.out.println(ioe.toString());
            ioe.printStackTrace(System.out);
        }
        
        
        
        //read objects from txt file, print toString for each object to the 
        //console window and write toString to new txt file output.
        try {
            
            FileInputStream fis = new FileInputStream("carPlates.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            FileOutputStream fos = new FileOutputStream("output.txt", false);
            PrintWriter pw = new PrintWriter(fos);
            
            try {
                while(true){
                    CarPlate tmp = (CarPlate)ois.readObject();
                    System.out.println(tmp.toString());
                    pw.println(tmp.toString());
                }
            }
            
            catch(EOFException eofe){
                System.out.println("\nEnd of file reached");
            }
            
            catch(ClassNotFoundException cnfe){
                System.out.println("A ClassNotFoundException was caught: " + 
                        cnfe.getMessage());
                System.out.println(cnfe.toString());
                cnfe.printStackTrace(System.out);
            }
            
            finally{
                System.out.println("Closing file");
                ois.close();
                pw.close();
            }
        }
        
        catch(FileNotFoundException fnfe){
            System.out.println("Couldn't find the file: " + 
                    fnfe.getMessage());
            System.out.print("toString: ");
            System.out.println(fnfe.toString());
            fnfe.printStackTrace(System.out);
        }
        
        catch(IOException ioe){
            System.out.print("There was a problem reading from the file: ");
            System.out.println(ioe.getMessage());
            System.out.print("toString: ");
            System.out.println(ioe.toString());
            ioe.printStackTrace(System.out);
        }
    }
}
