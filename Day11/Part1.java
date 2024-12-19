package Day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Part1 {
    // static String filename = "Day11/testinput.txt";
    static String filename = "Day11/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;
            int blinks = 25;

            String[] rocks = bf.readLine().split(" ");

            for (String rock : rocks) {
                ArrayList<String> nums = new ArrayList<>();
                nums.add(rock);
                for (int i = 0; i < blinks; i++) {
                    int size = nums.size();
                    for (int j = 0; j < size; j++) {
                        String num = nums.get(j);
                        if (num.equals("0")) {
                            nums.set(j, "1");
                        } else if (num.length() % 2 == 0) {
                            nums.set(j, num.substring(0, num.length() / 2));
                            String newRock = num.substring(num.length() / 2);
                            while (newRock.charAt(0) == '0' && newRock.length() > 1) {
                                newRock = newRock.substring(1);
                            }
                            nums.add(newRock);
                        } else {
                            nums.set(j, Long.toString(Long.parseLong(num) * 2024));
                        }
                    }
                }
                answer += nums.size();
            }

            System.out.printf("Part 1 Answer: %d\n", answer);
        } catch (Exception e) {
            System.err.println("try catch error");
            e.printStackTrace();
        }
    }
}
