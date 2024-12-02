package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Part2 {

    static String filename = "Day1/input.txt";

    public static void main(String[] args) {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));

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

            int colTwoIndex = 0;
            int answer = 0;

            for (int i = 0; i < colOne.size(); i++) {
                int count = 0;
                int target = colOne.get(i);
                while (target > colTwo.get(colTwoIndex)) {
                    colTwoIndex++;
                    if (colTwoIndex == colTwo.size()) {
                        System.out.printf("Answer: %d\n", answer);
                        return;
                    }
                }
                while (target == colTwo.get(colTwoIndex)) {
                    count++;
                    colTwoIndex++;
                    if (colTwoIndex == colTwo.size()) {
                        answer += target * count;
                        System.out.printf("Answer: %d\n", answer);
                        return;
                    }
                }
                answer += target * count;
            }

            System.out.printf("Answer: %d\n", answer);

        } catch (IOException e) {
            System.err.println("Error reading file \"" + filename + "\":: " + e.getMessage());
            System.exit(1);
        }
    }

}