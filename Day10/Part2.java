package Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Part2 {
    // static String filename = "Day10/testinput.txt";
    static String filename = "Day10/input.txt";
    static ArrayList<int[]> nines;

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;

            ArrayList<String> lines = new ArrayList<>();
            String line = bf.readLine();
            while (line != null) {
                lines.add(line);
                line = bf.readLine();
            }

            int nlines = lines.size();
            int lineLen = lines.get(0).length();
            int[][] data = new int[nlines][lineLen];
            for (int i = 0; i < nlines; i++) {
                String[] lineSplit = lines.get(i).split("");
                for (int j = 0; j < lineLen; j++) {
                    data[i][j] = Integer.parseInt(lineSplit[j]);
                }
            }

            for (int i = 0; i < nlines; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (data[i][j] == 0) {
                        nines = new ArrayList<>();
                        int val = findPaths(data, i, j, 0);
                        answer += val;
                    }
                }
            }



            System.out.printf("Part 2 Answer: %d\n", answer);
        } catch (Exception e) {
            System.out.println("try catch error");
            e.printStackTrace();
        }
    }

    public static int findPaths(int[][] data, int i, int j, int val) {
        if (val == 9) {
            // for (int k = 0; k < nines.size(); k++) {
            //     if (nines.get(k)[0] == i && nines.get(k)[1] == j) {
            //         return 0;
            //     }
            // }
            // nines.add(new int[] { i, j });
            return 1;
        }

        int sum = 0;
        int nlines = data.length;
        int lineLen = data[0].length;

        if (i - 1 >= 0 && data[i - 1][j] == val + 1) {
            sum += findPaths(data, i - 1, j, val + 1);
        }
        if (i + 1 < nlines && data[i + 1][j] == val + 1) {
            sum += findPaths(data, i + 1, j, val + 1);
        }
        if (j - 1 >= 0 && data[i][j - 1] == val + 1) {
            sum += findPaths(data, i, j - 1, val + 1);
        }
        if (j + 1 < lineLen && data[i][j + 1] == val + 1) {
            sum += findPaths(data, i, j + 1, val + 1);
        }

        return sum;
    }
}
