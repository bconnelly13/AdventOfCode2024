package Day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Part1 {
    // static String filename = "Day12/testinput.txt";
    static String filename = "Day12/input.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;

            ArrayList<String> input = new ArrayList<>();
            String line = bf.readLine();
            while (line != null) {
                input.add(line);
                line = bf.readLine();
            }

            int lines = input.size();
            int lineLen = input.get(0).length();

            char[][] data = new char[lines][lineLen];
            boolean[][] mapped = new boolean[lines][lineLen];
            for (int i = 0; i < lines; i++) {
                String currLine = input.get(i);
                for (int j = 0; j < lineLen; j++) {
                    data[i][j] = currLine.charAt(j);
                    mapped[i][j] = false;
                }
            }

            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < lineLen; j++) {
                    if (!mapped[i][j]) {
                        ArrayDeque<DataPoint> queue = new ArrayDeque<>();
                        int area = 1;
                        int perimeter = 0;
                        queue.add(new DataPoint(data[i][j], i, j));
                        mapped[i][j] = true;
                        while (!queue.isEmpty()) {
                            DataPoint point = queue.removeFirst();

                            // Check up
                            if (point.i > 0) {
                                if (data[point.i - 1][point.j] == point.c) {
                                    if (!mapped[point.i - 1][point.j]) {
                                        queue.add(new DataPoint(data[point.i - 1][point.j], point.i - 1, point.j));
                                        area++;
                                        mapped[point.i - 1][point.j] = true;
                                    }
                                } else {
                                    perimeter++;
                                }
                            } else {
                                perimeter++;
                            }

                            // Check down
                            if (point.i < lines - 1) {
                                if (data[point.i + 1][point.j] == point.c) {
                                    if (!mapped[point.i + 1][point.j]) {
                                        queue.add(new DataPoint(data[point.i + 1][point.j], point.i + 1, point.j));
                                        area++;
                                        mapped[point.i + 1][point.j] = true;
                                    }
                                } else {
                                    perimeter++;
                                }
                            } else {
                                perimeter++;
                            }

                            // Check left
                            if (point.j > 0) {
                                if (data[point.i][point.j - 1] == point.c) {
                                    if (!mapped[point.i][point.j - 1]) {
                                        queue.add(new DataPoint(data[point.i][point.j - 1], point.i, point.j - 1));
                                        area++;
                                        mapped[point.i][point.j - 1] = true;
                                    }
                                } else {
                                    perimeter++;
                                }
                            } else {
                                perimeter++;
                            }

                            // Check right
                            if (point.j < lineLen - 1) {
                                if (data[point.i][point.j + 1] == point.c) {
                                    if (!mapped[point.i][point.j + 1]) {
                                        queue.add(new DataPoint(data[point.i][point.j + 1], point.i, point.j + 1));
                                        area++;
                                        mapped[point.i][point.j + 1] = true;
                                    }
                                } else {
                                    perimeter++;
                                }
                            } else {
                                perimeter++;
                            }
                        }
                        answer += area * perimeter;
                    }
                }
            }

            System.out.printf("Part 1 Answer: %d\n", answer);
        } catch (Exception e) {
            System.out.println("try catch error");
            e.printStackTrace();
        }
    }
}

class DataPoint {
    char c;
    int i;
    int j;

    public DataPoint(char c, int i, int j) {
        this.c = c;
        this.i = i;
        this.j = j;
    }
}
