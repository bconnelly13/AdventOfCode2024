import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Part1 {

    static String filename = "Day4/input.txt";
    // static String filename = "Day4/testinput.txt"; // answer = 18

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
            String xmas = "XMAS";
            String samx = "SAMX";
            int answer = 0;
            boolean[][] needed = new boolean[numLines][lineLen];
            for (int i = 0; i < numLines; i++) {
                for (int j = 0; j < lineLen; j++) {
                    needed[i][j] = false;
                }
            }

            // Check horizontal
            
            for (int i = 0; i < numLines; i++ ) {
                String currLine = lines.get(i);
                for (int j = 0; j < lineLen - 3; j++) {
                    String substr = currLine.substring(j, j + 4);
                    if (substr.equals(xmas) || substr.equals(samx)) {
                        answer++;
                        needed[i][j] = true;
                        needed[i][j+1] = true;
                        needed[i][j+2] = true;
                        needed[i][j+3] = true;
                    }
                }
            }


            // Check vertical
            for (int i = 0; i < lineLen; i++) {
                for (int j = 0; j < numLines - 3; j++) {
                    String substr = lines.get(j).substring(i, i + 1) +
                            lines.get(j + 1).substring(i, i + 1) +
                            lines.get(j + 2).substring(i, i + 1) +
                            lines.get(j + 3).substring(i, i + 1);
                    if (substr.equals(xmas) || substr.equals(samx)) {
                        answer++;
                        needed[j][i] = true;
                        needed[j+1][i] = true;
                        needed[j+2][i] = true;
                        needed[j+3][i] = true;
                    }
                }
            }

            
            // Check diagonal going right
            for (int i = 0; i < numLines - 3; i++) {
                for (int j = 0; j < lineLen - 3; j++) {
                    String substr = lines.get(i).substring(j, j + 1) +
                            lines.get(i + 1).substring(j + 1, j + 2) +
                            lines.get(i + 2).substring(j + 2, j + 3) +
                            lines.get(i + 3).substring(j + 3, j + 4);
                    if (substr.equals(xmas) || substr.equals(samx)) {
                        answer++;
                        
                        needed[i][j] = true;
                        needed[i+1][j+1] = true;
                        needed[i+2][j+2] = true;
                        needed[i+3][j+3] = true;
                    }
                }
            }

           

            // Check diagonal going left
            for (int i = 0; i < numLines - 3; i++) {
                for (int j = 3; j < lineLen; j++) {
                    String substr = lines.get(i).substring(j, j + 1) +
                            lines.get(i + 1).substring(j - 1, j) +
                            lines.get(i + 2).substring(j - 2, j - 1) +
                            lines.get(i + 3).substring(j - 3, j - 2);
                    if (substr.equals(xmas) || substr.equals(samx)) {
                        answer++;
                        needed[i][j] = true;
                        needed[i+1][j-1] = true;
                        needed[i+2][j-2] = true;
                        needed[i+3][j-3] = true;
                    }
                }
            }

            System.out.printf("Answer = %d\n", answer);

            // for (int i = 0; i < numLines; i++) {
            //     for (int j = 0; j < lineLen; j++) {
            //         if (needed[i][j]) {
            //             System.out.print(lines.get(i).substring(j, j+1));
            //         } else {
            //             System.out.print(".");
            //         }
            //     }
            //     System.out.println();
            // }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
