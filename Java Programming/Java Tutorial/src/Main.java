import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.awt.*;
import java.text.NumberFormat;

public class Main {
    // public static void main(String[] args) {
    //     stringClasses() ;
    //     array();
    // }

    // public static void stringClasses(){
    //     String message = "  -Hello World-" + "!!";

    //     System.out.println(message.replace("H", "J"));
    //     System.out.println(message.endsWith("!!"));
    //     System.out.println(message.startsWith("!!"));
    //     System.out.println("length = " + message.length());
    //     System.out.println("Before Trimming:\n"+ message);
    //     System.out.println("After Trimming:\n"+ message.trim());
    // }

    // public static void array() {
    //     int[][] numbers = {{1,2,3},{4,5,6}};
    //     // numbers[0][0] = 1;
    //     System.out.println(Arrays.toString(numbers));

    //     //use this to print multidimensional array
    //     System.out.println(Arrays.deepToString(numbers)); 
        
    // }

    // * Calculate Mortgage
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interes Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayements = years * MONTHS_IN_YEAR;

        double mortgage = principal
                            * (monthlyInterest *Math.pow(1 + monthlyInterest, numberOfPayements))
                            / (Math.pow(1 + monthlyInterest, numberOfPayements)-1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);

    }
}
