package Day9;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part2 {
    // static String filename = "Day9/testinput.txt";
    static String filename = "Day9/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            long answer = 0;

            String line = bf.readLine();
            String[] numStrs = line.split("");
            int len = numStrs.length;
            int sum = 0;
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(numStrs[i]);
                sum += nums[i];
            }

            int currIndex = 0;
            int currId = 0;
            int[] map = new int[sum];
            int numDots = 0;
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                for (int j = 0; j < num; j++) {
                    if (i % 2 == 0) {
                        map[currIndex] = currId;
                    } else {
                        map[currIndex] = -1;
                    }
                    currIndex++;
                }
                if (i % 2 == 0) {
                    currId++;
                } else {
                    numDots += num;
                }

            }

            int endIndex = sum - 1;
            int minDotIndex = 0;
            while (map[minDotIndex] != -1) {
                minDotIndex++;
            }
            while (map[endIndex] == -1) {
                endIndex--;
            }
            while (minDotIndex < endIndex) {
                int id = map[endIndex];
                int numFiles = 1;
                while (map[endIndex - 1] == id) {
                    endIndex--;
                    numFiles++;
                }

                int dotIndex = minDotIndex;
                int dotsFound = 0;
                while (true) {
                    if (dotIndex == endIndex) {
                        dotsFound = -1;
                        break;
                    }
                    if (map[dotIndex] == -1) {
                        dotsFound++;
                    } else {
                        dotsFound = 0;
                    }
                    if (dotsFound == numFiles) {
                        break;
                    }
                    dotIndex++;
                }

                if (dotsFound != -1) {
                    for (int i = 0; i < numFiles; i++) {
                        map[dotIndex - numFiles + i + 1] = id;
                    }
                    for (int i = endIndex; i < endIndex + numFiles; i++) {
                        map[i] = -1;
                    }
                }
                
                while (map[minDotIndex] != -1) {
                    minDotIndex++;
                }
                endIndex--;
                while (map[endIndex] == -1) {
                    endIndex--;
                }
            }

            // for (int i = 0; i < sum; i++) {
            // if (map[i] == -1) {
            // System.out.print(".");
            // } else {
            // System.out.print(map[i]);
            // }

            // }
            // System.out.println();

            for (int i = 0; i < sum; i++) {
                if (map[i] != -1) {
                    answer += i * map[i];
                }
            }

            System.out.printf("Part 2 Answer: %d\n", answer);
        } catch (Exception e) {
            System.out.println("try catch error");
            e.printStackTrace();
        }
    }
}
