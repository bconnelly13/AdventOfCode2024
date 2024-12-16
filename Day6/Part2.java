package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Part2 {

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

            int count = 0;
            for (int i = 0; i < lines; i++) { // ypos
                for (int j = 0; j < lineLen; j++) { // xpos
                    String[][] currMap = new String[lines][lineLen];
                    for (int y = 0; y < lines; y++) {
                        for (int x = 0; x < lineLen; x++) {
                            currMap[y][x] = map[y][x];
                        }
                    }
                    String val = currMap[i][j];
                    if (!val.equals("^") && !val.equals("#")) {
                        currMap[i][j] = "#";
                    }
                    if (!guardEscapes(currMap, xpos, ypos)) {
                        answer++;
                    }
                    count++;
                    System.out.println(count);
                }
            }

            // map[0][0] = "#";
            // System.out.println(guardEscapes2(map, xpos, ypos));

            System.out.printf("Part 2 Answer: %d\n", answer);
        } catch (Exception e) {
            System.out.println("try catch error");
            e.printStackTrace();
        }
    }

    static void printMap(String[][] map) {
        for (String[] line : map) {
            for (String val : line) {
                System.out.print(val);
                for (int i = 0; i < 8 - val.length(); i++) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    static boolean guardEscapes2(String[][] map, int xpos, int ypos) {
        int lines = map.length;
        int lineLen = map[0].length;
        String direction = "^";
        while (true) {
            printMap(map);
            switch (direction) {
                case "^":
                    if (ypos == 0) {
                        return true;
                    }
                    if (map[ypos - 1][xpos].contains(direction)) {
                        return false;
                    }
                    if (map[ypos - 1][xpos].equals("#")) {
                        direction = ">";
                    } else {
                        map[ypos][xpos] += direction;
                        ypos--;
                    }
                    break;
                case "<":
                    if (xpos == 0) {
                        return true;
                    }
                    if (map[ypos][xpos - 1].contains(direction)) {
                        return false;
                    }
                    if (map[ypos][xpos - 1].equals("#")) {
                        direction = "^";
                    } else {
                        map[ypos][xpos] += direction;
                        xpos--;
                    }
                    break;
                case ">":
                    if (xpos == lineLen - 1) {
                        return true;
                    }
                    if (map[ypos][xpos + 1].contains(direction)) {
                        return false;
                    }
                    if (map[ypos][xpos + 1].equals("#")) {
                        direction = "v";
                    } else {
                        map[ypos][xpos] += direction;
                        xpos++;
                    }
                    break;
                case "v":
                    if (ypos == lines - 1) {
                        return true;
                    }
                    if (map[ypos + 1][xpos].contains(direction)) {
                        return false;
                    }
                    if (map[ypos + 1][xpos].equals("#")) {
                        direction = "<";
                    } else {
                        map[ypos][xpos] += direction;
                        ypos++;
                    }
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }

        }

    }

    static boolean guardEscapes(String[][] map, int xpos, int ypos) {
        int lines = map.length;
        int lineLen = map[0].length;
        String direction = "^";
        while (true) {
            switch (direction) {
                case "^":
                    if (ypos == 0) {
                        return true;
                    }
                    if (map[ypos - 1][xpos].contains(direction)) {
                        return false;
                    }
                    if (map[ypos - 1][xpos].equals("#")) {
                        direction = ">";
                    } else {
                        map[ypos][xpos] += direction;
                        ypos--;
                    }
                    break;
                case "<":
                    if (xpos == 0) {
                        return true;
                    }
                    if (map[ypos][xpos - 1].contains(direction)) {
                        return false;
                    }
                    if (map[ypos][xpos - 1].equals("#")) {
                        direction = "^";
                    } else {
                        map[ypos][xpos] += direction;
                        xpos--;
                    }
                    break;
                case ">":
                    if (xpos == lineLen - 1) {
                        return true;
                    }
                    if (map[ypos][xpos + 1].contains(direction)) {
                        return false;
                    }
                    if (map[ypos][xpos + 1].equals("#")) {
                        direction = "v";
                    } else {
                        map[ypos][xpos] += direction;
                        xpos++;
                    }
                    break;
                case "v":
                    if (ypos == lines - 1) {
                        return true;
                    }
                    if (map[ypos + 1][xpos].contains(direction)) {
                        return false;
                    }
                    if (map[ypos + 1][xpos].equals("#")) {
                        direction = "<";
                    } else {
                        map[ypos][xpos] += direction;
                        ypos++;
                    }
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }

        }

    }

}
