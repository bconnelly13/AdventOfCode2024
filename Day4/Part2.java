import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Part2 {
    static String filename = "Day4/input.txt";
    // static String filename = "Day4/testinput.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));

            ArrayList<String> lines = new ArrayList<>();
            String line = bf.readLine();
            while (line != null) {
                lines.add(line);
                line = bf.readLine();
            }
            int numLines = lines.size();
            int lineLen = lines.get(0).length();
            String msams = "MSAMS";
            String smasm = "SMASM";
            String ssamm = "SSAMM";
            String mmass = "MMASS";
            String options = msams + " " + smasm + " " + ssamm + " " + mmass + " ";
            int answer = 0;
            // boolean[][] needed = new boolean[numLines][lineLen];
            // for (int i = 0; i < numLines; i++) {
            // for (int j = 0; j < lineLen; j++) {
            // needed[i][j] = false;
            // }
            // }

            for (int i = 1; i < numLines - 1; i++) {
                for (int j = 1; j < lineLen - 1; j++) {
                    String middle = lines.get(i).substring(j, j + 1);
                    if (middle.equals("A")) {
                        String substr = lines.get(i - 1).substring(j - 1, j) +
                                lines.get(i - 1).substring(j + 1, j + 2) +
                                middle +
                                lines.get(i + 1).substring(j - 1, j) +
                                lines.get(i + 1).substring(j + 1, j + 2);
                        if (options.contains(substr)) {
                            answer++;
                        }
                    }
                }
            }

            System.out.printf("Answer = %d\n", answer);

            // for (int i = 0; i < numLines; i++) {
            // for (int j = 0; j < lineLen; j++) {
            // if (needed[i][j]) {
            // System.out.print(lines.get(i).substring(j, j+1));
            // } else {
            // System.out.print(".");
            // }
            // }
            // System.out.println();
            // }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
