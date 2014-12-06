package lab11;

/**
 *
 * @author jaden
 */
public class CarPlate {
    
    //instance variables
    private String plateNumber;
    private int state;
    private String color;
    
    
    
    /**
     * Default constructor
     * <p> 
     * Initializes plateNumber to 000 000, state to 1, and color to None
     */
    public CarPlate(){
        plateNumber = "000 000";
        state = 1;
        color = "None";
    }
    
    /**
     * Overloaded constructor
     * <p>
     * Initializes fields from arguments, checks arguments for validity
     * @param startPlateNumber
     * @param startState
     * @param startColor 
     */
    public CarPlate(String startPlateNumber, int startState, String startColor){
        setPlateNumber(startPlateNumber);
        setState(startState);
        setColor(startColor);
    }
    
    
    
    /**
     * Returns the plate number
     * @return Plate number
     */
    public String getPlateNumber(){
        return plateNumber;
    }
    
    /**
     * Returns the state
     * @return state
     */
    public int getState(){
        return state;
    }
    
    /**
     * Returns the color of the license plate
     * @return Color of the license plate
     */
    public String getColor(){
        return color;
    }
    
    
    
    /**
     * Sets the plate number of the license plate
     * @param xPlateNumber - New plate number for the license plate
     * @throws IllegalArgumentException - For arguments that are not 7 
     *  characters in length and for arguments that do not have a space at the 
     *  4th index position
     */
    public final void setPlateNumber(String xPlateNumber) throws 
            IllegalArgumentException{
        
        if (xPlateNumber.length() != 7)
            throw new IllegalArgumentException("License plate number must be "
                    + "7 characters long");
        if (xPlateNumber.charAt(4) != ' ')
            throw new IllegalArgumentException("Licese plate number must be two"
                    + " groups of 3 characters separated by a space at the 4th"
                    + " index position");
        plateNumber = xPlateNumber;
    }
    
    /**
     * Sets the State of the license plate
     * @param xState - New state for the license plate
     * @throws IllegalArgumentException - For arguments that are not integers 
     *  ranging 1-50
     */
    public final void setState(int xState) throws IllegalArgumentException{
        if (xState < 1 || xState > 50)
            throw new IllegalArgumentException("State must be a whole number "
                    + "1-50");
        state = xState;
    }
    
    /**
     * Sets the color for the license plate
     * <p>
     * The argument is simply assigned to the variable, any String input is 
     * considered valid.
     * @param xColor - New color for the license plate 
     */
    public final void setColor(String xColor){
        color = xColor;
    }
    
    
    
    /**
     * toString method, Returns a printable version of the data contained in
     * the object
     * @return Printable string of data contained in object
     */
    @Override
    public String toString(){
        String output = "Plate number: " + plateNumber;
        output += "\nState: " + state;
        output += "\nColor: " + color;
        return output;
    }
    
    
    
    /**
     * Equals method, compares two CarPlate objects for equality by comparing
     * fields
     * @return True if objects are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof CarPlate))
            return false;
        CarPlate other = (CarPlate)obj;
        if (!(plateNumber.equals(other.getPlateNumber())))
            return false;
        if (state != other.getState())
            return false;
        return color.equals(other.getColor());
    }
}
