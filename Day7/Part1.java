package Day7;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part1 {
    static String filename = "Day6/testinput.txt";
    // static String filename = "Day6/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;




            System.out.printf("Part 1 Answer: %d\n", answer);
        } catch (Exception e) {
            System.out.println("try catch error");
            e.printStackTrace();
        }
    }
}
