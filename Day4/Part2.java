import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Part2 {
    // static String filename = "Day4/input.txt";
    static String filename = "Day4/testinput.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
