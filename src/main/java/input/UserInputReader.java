package input;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInputReader {
    private final Scanner scanner;

    public UserInputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }
    public int readInt(String prompt){
        while (true){
           try {
               System.out.println(prompt);
               return scanner.nextInt();
           } catch (Exception e){
               scanner.nextLine();// clear the invalid input
               System.out.println("Invalid input , please try again ");

           }
        }
    }

    public BigDecimal readBigDecimal(String prompt){
        while (true){
            try {
                System.out.println(prompt);
                return scanner.nextBigDecimal();
            } catch (Exception e){
                scanner.nextLine();// clear the invalid input
                System.out.println("Invalid decimal  , please try again ");

            }
        }
    }
}
