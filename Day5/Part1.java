package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Part1 {
    
    public static String filename = "Day5/input.txt";
    // public static String filename = "Day5/testinput.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;

            Set<Integer>[] prereqs = new Set[100];
            for (int i = 0; i < 100; i++) {
                prereqs[i] = new HashSet<>();
            }


            // Reads all the page ordering rules
            String line = bf.readLine();
            while (line.contains("|")) {
                int num1 = Integer.parseInt(line.substring(0,2));
                int num2 = Integer.parseInt(line.substring(3));
                prereqs[num2].add(num1);

                line = bf.readLine();

            }

            // Reads the updates
            line = bf.readLine();
            while (line != null) {
                String[] numStrings = line.split(",");
                int len = numStrings.length;
                int[] nums = new int[len];
                Set<Integer> numsLeft = new HashSet<>();
                for (int i = 0; i < len; i++) {
                    nums[i] = Integer.parseInt(numStrings[i]);
                    numsLeft.add(nums[i]);
                }

                boolean updateFailed = false;
                for (int currNum : nums) {
                    for (int numLeft : numsLeft) {
                        if (prereqs[currNum].contains(numLeft)) {
                            updateFailed = true;
                            break;
                        }
                        
                    }
                    if (updateFailed) {
                        break;
                    }
                    numsLeft.remove(currNum);
                }

                if (!updateFailed) {
                    answer += nums[nums.length / 2];
                }

                line = bf.readLine();
            }




            System.out.printf("Part 1 Answer: %d\n", answer);


        } catch (Exception e) {
            System.err.println("try catch error");
            e.printStackTrace();
        }
    }


}
