package Day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Part2 {
    // static String filename = "Day11/testinput.txt";
    static String filename = "Day11/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            long answer = 0;
            HashMap<Long, ArrayList<Long>> logs = new HashMap<>();
            HashMap<String, Long> counts = new HashMap<>();
            ArrayDeque<long[]> rocks = new ArrayDeque<>();
            int blinks = 75;
            int interval = 5;

            String[] data = bf.readLine().split(" ");

            for (String rock : data) {
                rocks.add(new long[] { Long.parseLong(rock), 0 });
                String hashVal = rock + ".0";
                counts.put(hashVal, (long) 1);
            }

            while (!rocks.isEmpty()) {
                long[] rock = rocks.removeFirst();
                long rockNum = rock[0];
                long timesSplit = rock[1];
                String hashVal = Long.toString(rockNum) + "." + Long.toString(timesSplit);
                ArrayList<Long> newRocks;
                long count = counts.remove(hashVal);
                if (logs.containsKey(rockNum)) {
                    newRocks = logs.get(rockNum);

                } else {
                    newRocks = new ArrayList<>();
                    newRocks.add(rockNum);
                    for (int i = 0; i < interval; i++) {
                        int size = newRocks.size();
                        for (int j = 0; j < size; j++) {
                            Long num = newRocks.get(j);
                            String numStr = Long.toString(num);
                            if (num == 0) {
                                newRocks.set(j, (long) 1);
                            } else if (numStr.length() % 2 == 0) {
                                newRocks.set(j, Long.parseLong(numStr.substring(0, numStr.length() / 2)));
                                String newRock = numStr.substring(numStr.length() / 2);
                                while (newRock.charAt(0) == '0' && newRock.length() > 1) {
                                    newRock = newRock.substring(1);
                                }
                                newRocks.add(Long.parseLong(newRock));
                            } else {
                                newRocks.set(j, num * 2024);
                            }
                        }
                    }
                    logs.put(rockNum, newRocks);
                }
                for (long r : newRocks) {
                    String newHashVal = Long.toString(r) + "." + Long.toString(timesSplit + interval);
                    if (counts.containsKey(newHashVal)) {
                        counts.put(newHashVal, counts.get(newHashVal) + count);
                    } else {
                        counts.put(newHashVal, (long) count);
                        if (timesSplit != blinks - interval) {
                            rocks.add(new long[] { r, timesSplit + interval });
                        }
                    }
                }
            }

            for (String key : counts.keySet()) {
                long val = counts.get(key);
                answer += val;
                if (val < 0) {
                    System.out.printf("uh-oh, it's %d\n", val);
                }
            }

            System.out.printf("Part 2 Answer: %d\n", answer);
        } catch (Exception e) {
            System.err.println("try catch error");
            e.printStackTrace();
        }
    }

}
