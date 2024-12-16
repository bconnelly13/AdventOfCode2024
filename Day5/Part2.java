package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Part2 {
    
    public static String filename = "Day5/input.txt";
    // public static String filename = "Day5/testinput.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;

            HashSet<Integer>[] prereqs = new HashSet[100];
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

            ArrayList<int[]> failedUpdates = new ArrayList<>();

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
                        failedUpdates.add(nums);
                        break;
                    }
                    numsLeft.remove(currNum);
                }

                line = bf.readLine();
            }


            
            
            for (int[] update : failedUpdates) {
                HashSet<Integer> updateNums = new HashSet<>();
                for (int i : update) {
                    updateNums.add(i);
                }

                int[] result = new int[update.length];

                for (int num : update) {
                    HashSet<Integer> newPrereqs = (HashSet<Integer>) prereqs[num].clone();
                    newPrereqs.retainAll(updateNums);
                    result[newPrereqs.size()] = num;
                }


                answer += result[result.length / 2];
                
            }





            System.out.printf("Part 2 Answer: %d\n", answer);




        } catch (Exception e) {
            System.err.println("try catch error");
            e.printStackTrace();
        }
    }

}
