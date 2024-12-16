package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Part1 {
    // static String filename = "Day7/testinput.txt";
    static String filename = "Day7/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            long answer = 0;

            String line = bf.readLine();
            while (line != null) {
                int colonIndex = line.indexOf(":");
                long target = Long.parseLong(line.substring(0, colonIndex));
                String[] numStrs = line.substring(colonIndex + 2).split(" ");
                int len = numStrs.length;
                long[] nums = new long[len];
                for (int i = 0; i < len; i++) {
                    nums[i] = Long.parseLong(numStrs[i]);
                }

                long[] results = mathOptions(nums);
                // for (int i = 0; i < results.length; i++) {
                //     System.out.printf("%d ", results[i]);
                // }
                System.out.println();
                for (int i = 0; i < results.length; i++) {
                    if (results[i] == target) {
                        answer += target;
                        break;
                    }
                }


                line = bf.readLine();
            }



            System.out.printf("Part 1 Answer: %d\n", answer);
        } catch (Exception e) {
            System.out.println("try catch error");
            e.printStackTrace();
        }
    }

    public static long[] mathOptions(long[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        long[] result = mathOptions(Arrays.copyOfRange(nums, 0, nums.length - 1));
        long[] returnArr = new long[result.length * 2];
        for (int i = 0; i < result.length; i++) {
            returnArr[2*i] = nums[nums.length - 1] + result[i];
            returnArr[2*i+1] = nums[nums.length - 1] * result[i];
        }
        return returnArr;


    }



}
