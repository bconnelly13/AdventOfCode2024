package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;



public class Part1 {

    static String filename = "Day2/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));

            int answer = 0;

            String line = bf.readLine();
            while (line != null) {
                String[] lineArr = line.split(" ");
                boolean inc = Integer.parseInt(lineArr[0]) < Integer.parseInt(lineArr[1]);
                answer++;
                for (int i = 0; i < lineArr.length - 1; i++) {
                    int num1 = Integer.parseInt(lineArr[i]);
                    int num2 = Integer.parseInt(lineArr[i+1]);

                    if (num1 == num2 || Math.abs(num1 - num2) > 3) {
                        answer--;
                        break;
                    }

                    if ((inc && num1 > num2) || (!inc && num1 < num2)) {
                        answer--;
                        break;
                    }
                }

                line = bf.readLine();
            }

            System.out.printf("Answer: %d\n", answer);

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
