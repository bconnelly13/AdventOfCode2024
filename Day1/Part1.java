package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Part1 {

    static String filename = "Day1/input.txt";

    public static void main(String[] args) {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));

            int sum = 0;
            String line = bf.readLine();
            ArrayList<Integer> colOne = new ArrayList<>();
            ArrayList<Integer> colTwo = new ArrayList<>();
            while (line != null) {
                String[] lineArr = line.split(" ");
                colOne.add(Integer.parseInt(lineArr[0]));
                colTwo.add(Integer.parseInt(lineArr[lineArr.length - 1]));
                line = bf.readLine();
            }


            colOne.sort(Comparator.naturalOrder());
            colTwo.sort(Comparator.naturalOrder());

            for (int i = 0; i < colOne.size(); i++) {
                sum += Math.abs(colOne.get(i) - colTwo.get(i));
            }

            System.out.printf("Answer: %d\n", sum);

        } catch (IOException e) {
            System.err.println("Error reading file \"" + filename + "\":: " + e.getMessage());
            System.exit(1);
        }
    }

}