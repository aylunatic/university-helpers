import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Raid5_Restorer {
    public static void main(String[] args) {
        while (true) {
            // scanner for reading input
            Scanner scanner = new Scanner(System.in);

            // get all numbers that are known
            System.out.println("Enter first block as hexadecimal without prefix:");
            String num1 = scanner.next();
            int num1Int = Integer.parseInt(num1, 16);

            System.out.println("Enter second block as hexadecimal without prefix:");
            String num2 = scanner.next();
            int num2Int = Integer.parseInt(num2, 16);

            System.out.println("Enter third block as hexadecimal without prefix:");
            String num3 = scanner.next();
            int num3Int = Integer.parseInt(num3, 16);

            //get parity number
            System.out.println("Enter parity block as hexadecimal without prefix:");
            String par = scanner.next();
            int parInt = Integer.parseInt(par, 16);

            System.out.println("Values are:");
            System.out.println(fix(Integer.toHexString(num1Int),8) + "    " + fix(Integer.toBinaryString(num1Int), 32));
            System.out.println(fix(Integer.toHexString(num2Int),8) + "    " + fix(Integer.toBinaryString(num2Int), 32));
            System.out.println(fix(Integer.toHexString(num3Int),8) + "    " + fix(Integer.toBinaryString(num3Int), 32));
            System.out.println("Parity is:");
            System.out.println(fix(Integer.toHexString(parInt),8)  + "    " + fix(Integer.toBinaryString(parInt), 32));

            int missingNumber = 0;

            for (int i = 0, ctr = 0; i < 32; i++, ctr = 0) {

                if ((num1Int >> i & 1 )== 1) ctr++;
                if ((num2Int >> i & 1 )== 1) ctr++;
                if ((num3Int >> i & 1 )== 1) ctr++;

                if ((((ctr % 2) == 0) && (((parInt >> i & 1 )== 1))) ||
                    (((ctr % 2) == 1) && (((parInt >> i & 1 )== 0)))) {
                    missingNumber = missingNumber | (int) Math.pow(2, i);
                }
            }

            System.out.println("Missing Number is:");
            System.out.println(Integer.toHexString(missingNumber)  + "    " + fix(Integer.toBinaryString(missingNumber), 32));
        }
    }

    public static String fix(String s, int length) {
        while (s.length() < length) {
            s = "0"+s;
            fix(s, length);
        }
        return s;
    }
}
