package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Part2 {
    // static String filename = "Day8/testinput.txt";
    static String filename = "Day8/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;

            ArrayList<String[]> listInput = new ArrayList<>();
            String line = bf.readLine();
            while (line != null) {
                listInput.add(line.split(""));
                line = bf.readLine();
            }

            int lines = listInput.size();
            int lineLen = listInput.get(0).length;
            String[][] map = new String[lines][lineLen];
            boolean[][] antinodes = new boolean[lines][lineLen];
            for (int i = 0; i < lines; i++) {
                map[i] = listInput.get(i);
                for (int j = 0; j < lineLen; j++) {
                    antinodes[i][j] = false;
                }            
            }


            HashMap<String, ArrayList<int[]>> antennas = new HashMap<>();
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < lineLen; j++) {
                    String c = map[i][j];
                    if (!c.equals(".")) {
                        int[] newPair = {i, j};
                        ArrayList<int[]> pairs;
                        if (antennas.containsKey(c)) {
                            pairs = antennas.get(c);
                        } else {
                            pairs = new ArrayList<>();
                        }
                        pairs.add(newPair);
                        antennas.put(c, pairs);
                    }
                }
            }


            Set<String> keys = antennas.keySet();
            for (String c : keys) {
                ArrayList<int[]> pairs = antennas.get(c);
                int npairs = pairs.size();
                for (int i = 0; i < npairs; i++) {
                    int[] pair1 = pairs.get(i);
                    for (int j = i + 1; j < npairs; j++) {
                        int[] pair2 = pairs.get(j);
                        int ydiff = pair1[0] - pair2[0];
                        int xdiff = pair1[1] - pair2[1];

                        int newY = pair1[0];
                        int newX = pair1[1];

                        while (newY >= 0 && newY < lines && newX >= 0 && newX < lineLen) {
                            antinodes[newY][newX] = true;
                            // if (map[newY][newX].equals(".")) {
                            //     map[newY][newX] = "#";
                            // }
                            newY += ydiff;
                            newX += xdiff;
                            
                        }

                        newY = pair2[0];
                        newX = pair2[1];

                        while (newY >= 0 && newY < lines && newX >= 0 && newX < lineLen) {
                            antinodes[newY][newX] = true;
                            // if (map[newY][newX].equals(".")) {
                            //     map[newY][newX] = "#";
                            // }
                            newY -= ydiff;
                            newX -= xdiff;
                            
                        }

                    }
                }
            }

            

            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < lineLen; j++) {
                    // System.out.printf("%s", map[i][j]);
                    if (antinodes[i][j]) {
                        answer++;
                    }
                }
                // System.out.println();
            }



            System.out.printf("Part 2 Answer: %d\n", answer);
        } catch (Exception e) {
            System.out.println("try catch error");
            e.printStackTrace();
        }
    }
}
