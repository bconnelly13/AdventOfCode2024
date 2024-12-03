package Day3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Part2 {

    static String filename = "Day3/input.txt";
    // static String filename = "Day3/testinput2.txt"; // answer = 48

    public static void main(String[] args) {

        try {
            @SuppressWarnings("resource")
            BufferedReader bf = new BufferedReader(new FileReader(filename));

            String data = "";
            String line = bf.readLine();
            while (line != null) {
                data += line;
                line = bf.readLine();
            }

            int answer = 0;
            boolean enabled = true;
            for (int i = 0; i < data.length() - 8; i++) {
                int enableResult = checkEnable(data, i);
                if (enableResult == 0) {
                    enabled = false;
                } else if (enableResult == 1) {
                    enabled = true;
                }

                int[] result = checkMul(data, i);
                if (result[0] != -1 && enabled) {
                    answer += result[0] * result[1];
                }
            }

            System.out.printf("Answer: %d\n", answer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* Return values:
     * -1 -> do nothing
     * 0 -> disable
     * 1 -> enable
     */
    public static int checkEnable(String data, int i) {

        if (data.substring(i, i+7).equals("don't()")) {
            return 0;
        }

        if (data.substring(i, i+4).equals("do()")) {
            return 1;
        }

        return -1;
    }

    public static int[] checkMul(String data, int i) {
        int[] result = { -1, -1 };

        if (!data.substring(i, i + 4).equals("mul(")) {
            return result;
        }
        i += 4;

        String nums = "0123456789";
        String numOne = "";
        String numTwo = "";

        String c = data.substring(i, i + 1);
        while (nums.contains(c)) {
            numOne += c;
            i++;
            c = data.substring(i, i + 1);
        }

        if (numOne.equals("")) {
            return result;
        }

        if (!c.equals(",")) {
            return result;
        }

        i++;
        c = data.substring(i, i + 1);
        while (nums.contains(c)) {
            numTwo += c;
            i++;
            c = data.substring(i, i + 1);
        }

        if (numTwo.equals("")) {
            return result;
        }

        if (!c.equals(")")) {
            return result;
        }

        result[0] = Integer.parseInt(numOne);
        result[1] = Integer.parseInt(numTwo);
        return result;

    }

}
