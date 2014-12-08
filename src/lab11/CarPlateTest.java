package lab11;

import java.util.Random;
import java.io.*;
/**
 * 
 * @author jaden
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
            
            //generate and write 3 objects to the file
            for (int i = 0; i < 3; i++){
                CarPlate tmpCarPlate = new CarPlate(generatePlateNumber(),
                                                     generateState(), 
                                                     generateColor());
                oos.writeObject(tmpCarPlate);
            }
            fos.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println("Could not create/modify the file carPlates.txt "
                    + "- There is probably a problem with the permissions.");
            System.out.print("Message: ");
            System.out.println(fnfe.getMessage());
            System.out.print("toString: ");
            System.out.println(fnfe.toString());
            fnfe.printStackTrace(System.out);
        }
        catch(IOException ioe){
            System.out.print("An IOException was caught: ");
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
                System.out.println("End of file reached");
            }
            catch(ClassNotFoundException cnfe){
                System.out.println("A ClassNotFoundException was caught: " + 
                        cnfe.getMessage());
            }
            finally{
                System.out.println("Closing file");
                ois.close();
                pw.close();
            }
        }
        catch(FileNotFoundException fnfe){
            System.out.println("A FileNotFoundException was caught: " + 
                    fnfe.getMessage());
            System.out.print("toString: ");
            System.out.println(fnfe.toString());
            fnfe.printStackTrace(System.out);
        }
        catch(IOException ioe){
            System.out.print("An IOException was caught: ");
            System.out.println(ioe.getMessage());
            System.out.print("toString: ");
            System.out.println(ioe.toString());
            ioe.printStackTrace(System.out);
        }
        
        
    }
}
