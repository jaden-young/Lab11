package lab11;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



/**
 *
 * @author JORDAN
 */
public class ClassGrades {
    public static void main(String[] args) throws FileNotFoundException{
       int count = 0;
       File imputFile = new File("grades.txt");
       int number;
        Scanner z = new Scanner(imputFile);
        double av;
        int high = 0;
        int low = 0;
        int passA = 0;
        int passB = 0;
        int passC = 0;
        int passD = 0;
        int fail = 0;
        int pass = 0;
       int total = 0;
        while(z.hasNext()){
        number = z.nextInt();
        if(number >= 60){
            if(number >= 60 && number < 70){
            System.out.println("You passed with a D");
            passD ++;
            total += number;
        }
            else if(number>=70 && number <80){
               System.out.println("You passed with a C");
            passC ++; 
            total += number;
            }
            else if(number >= 80 && number < 90){
                System.out.println("You passed with a B");
            passB ++;
            total += number;
            }
            else if(number >= 90 && number <100){
            System.out.println("You passed with a A");
            passA ++;
            total += number;
        }
        }
        else if(number < 60){
            System.out.println("You failed");
            fail ++;
            total += number;
        }
        count ++;
        
    }
        av = (double)total/count;
        System.out.println("The total amount of students that took the test was" + count);
        System.out.println("the average of the class is " + av);
        System.out.println("The number of students that passed is " + pass);
        System.out.println("The number of students that passed with D's is " + passD);
        System.out.println("The number of students that passed with C's is " + passC);
        System.out.println("The number of students that passed with B's is " + passB);
        System.out.println("The number of students that passed with A's is " + passA);
        System.out.println("The number of students that failed is " + fail);
    }
}
