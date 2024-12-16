package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Part1 {
    
    // static String filename = "Day6/testinput.txt";
    static String filename = "Day6/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;
            int xpos = -1;
            int ypos = -1;

            ArrayList<String[]> startMap = new ArrayList<>();
            String line = bf.readLine();
            while (line != null) {
                int index = line.indexOf("^");
                if (index != -1) {
                    xpos = index;
                    ypos = startMap.size();
                }
                String[] lineArr = line.split("");
                startMap.add(lineArr);
                line = bf.readLine();
            }


            int lines = startMap.size();
            int lineLen = startMap.get(0).length;
            String[][] map = new String[lines][lineLen];
            for (int i = 0; i < lines; i++) {
                map[i] = startMap.get(i);
            } 


            answer++;
            while (true) {
                String guard = map[ypos][xpos];
                if ((xpos == 0 && guard.equals("<")) || 
                    (xpos == lineLen - 1 && guard.equals(">")) || 
                    (ypos == 0 && guard.equals("^")) || 
                    (ypos == lines - 1 && guard.equals("v"))) {
                    break;
                }
                switch (guard) {
                    case "^":
                        if (map[ypos-1][xpos].equals("#")) {
                            map[ypos][xpos] = ">";
                        } else {
                            if (!map[ypos-1][xpos].equals("X")) {
                                answer++;
                            }
                            map[ypos-1][xpos] = "^";
                            map[ypos][xpos] = "X";
                            ypos--;
                        }
                        break;
                    case "<":
                        if (map[ypos][xpos-1].equals("#")) {
                            map[ypos][xpos] = "^";
                        } else {
                            if (!map[ypos][xpos-1].equals("X")) {
                                answer++;
                            }
                            map[ypos][xpos-1] = "<";
                            map[ypos][xpos] = "X";
                            xpos--;
                        }
                        break;
                    case ">":
                        if (map[ypos][xpos+1].equals("#")) {
                            map[ypos][xpos] = "v";
                        } else {
                            if (!map[ypos][xpos+1].equals("X")) {
                                answer++;
                            }
                            map[ypos][xpos+1] = ">";
                            map[ypos][xpos] = "X";
                            xpos++;
                        }
                        break;
                    case "v":
                        if (map[ypos+1][xpos].equals("#")) {
                            map[ypos][xpos] = "<";
                        } else {
                            if (!map[ypos+1][xpos].equals("X")) {
                                answer++;
                            }
                            map[ypos+1][xpos] = "v";
                            map[ypos][xpos] = "X";
                            ypos++;
                        }
                        break;
                    default:
                        System.out.println("ERROR");
                        break;
                }


            }


            System.out.printf("Part 1 Answer: %d\n", answer);
        } catch (Exception e) {
            System.out.println("try catch error");
            e.printStackTrace();
        }
    }

}
