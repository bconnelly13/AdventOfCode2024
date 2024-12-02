package Day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part2 {
    static String filename = "Day2/input.txt";
    // static String filename = "Day2/testInput.txt";

    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            int answer = 0;
            String line = bf.readLine();

            while (line != null) {
                String[] lineArr = line.split(" ");
                int result = checkLine(lineArr);
                if (result == -1) {
                    answer++;
                } else {
                    String[] newArrOne = new String[lineArr.length - 1];
                    int newIndex = 0;
                    for (int i = 0; i < lineArr.length; i++) {
                        if (i != result) {
                            newArrOne[newIndex] = lineArr[i];
                            newIndex++;
                        }
                        
                    }
                    String[] newArrTwo = new String[lineArr.length - 1];
                    newIndex = 0;
                    for (int i = 0; i < lineArr.length; i++) {
                        if (i != result + 1) {
                            newArrTwo[newIndex] = lineArr[i];
                            newIndex++;
                        }
                        
                    }


                    printArrays(lineArr, newArrOne, newArrTwo);


                    if (checkLine(newArrOne) == -1 || checkLine(newArrTwo) == -1 || checkWithoutFirst(lineArr) == -1) {
                        answer++;
                    }
                }

                line = bf.readLine();
            }

            System.out.printf("Answer: %d\n", answer);



        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }

    public static boolean checkError(int num1, int num2, boolean inc) {
        return (num1 == num2) || (Math.abs(num1 - num2) > 3) || (inc && num1 > num2) || (!inc && num1 < num2);
    }

    public static int checkLine(String[] lineArr) {
        boolean inc = Integer.parseInt(lineArr[0]) < Integer.parseInt(lineArr[1]);
        for (int i = 0; i < lineArr.length - 1; i++) {
            int num1 = Integer.parseInt(lineArr[i]);
            int num2 = Integer.parseInt(lineArr[i+1]);
            if (checkError(num1, num2, inc)) {
                return i;
            }
        }
        return -1;
    }

    public static int checkWithoutFirst(String[] lineArr) {
        boolean inc = Integer.parseInt(lineArr[1]) < Integer.parseInt(lineArr[2]);
        for (int i = 1; i < lineArr.length - 1; i++) {
            int num1 = Integer.parseInt(lineArr[i]);
            int num2 = Integer.parseInt(lineArr[i+1]);
            if (checkError(num1, num2, inc)) {
                return i;
            }
        }
        return -1;
    }


    public static void printArrays(String[] lineArr, String[] newArrOne, String[] newArrTwo) {
        printArr(lineArr);
        printArr(newArrOne);
        printArr(newArrTwo);
        System.out.println();
    }


    public static void printArr(String[] arr) {
        for (String s : arr) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }




}
