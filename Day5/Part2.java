package Day5;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part2 {
    
    // public static String filename = "input.txt";
    public static String filename = "testinput.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));


        } catch (Exception e) {
            System.err.println("try catch error");
            e.printStackTrace();
        }
    }
    
}
