package ra.tester;

import java.util.Date;
import java.util.Scanner;

public class PalindromeON {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter a phrase, Q to quit: ");
            String input = sc.nextLine();
            if ("Q".equalsIgnoreCase(input))
                System.exit(0);
            // O(n)
            long begin = new Date().getTime();
            boolean isPal = false;
            for(int i=0; i<10000000; i++) { // 10m load
                isPal = isPalindromeOn(input);
            }
            long end = new Date().getTime();
            if (isPal) {
                System.out.println(input + " is a palindrome; "+(end-begin)+" ms O(n)");
            } else {
                System.out.println(input + " is not a palindrome; "+(end-begin)+" ms O(n)");
            }

            // O(n/2)
            long begin2 = new Date().getTime();
            for(int i=0; i<10000000; i++) { // 10m load
                isPal = isPalindromeOn2(input);
            }
            long end2 = new Date().getTime();
            if (isPal) {
                System.out.println(input + " is a palindrome; "+(end2-begin2)+" ms O(n/2) (partial)");
            } else {
                System.out.println(input + " is not a palindrome; "+(end2-begin2)+" ms O(n/2) (partial)");
            }
        }
    }

    private static boolean isPalindromeOn(String input) {
        StringBuilder cleanedInput = new StringBuilder();
        StringBuilder rev = new StringBuilder();
        char[] chars = input.toCharArray();
        // O(n)
        for(char c : chars) {
            if(Character.getNumericValue(c) > 0) {
                cleanedInput.append(c);
            }
        }
        // O(n)
        String cleanedInputStr = cleanedInput.toString();
        for(int i=cleanedInputStr.length()-1; i>=0; i--) {
            rev.append(cleanedInputStr.charAt(i));
        }
        String revStr = rev.toString();
        // O(n)
        return revStr.equalsIgnoreCase(cleanedInputStr);
    }

    private static boolean isPalindromeOn2(String input) {
        StringBuilder cleanedInput = new StringBuilder();
        StringBuilder revEnd = new StringBuilder();
        char[] chars = input.toCharArray();
        // O(n)
        for(char c : chars) {
            if(Character.getNumericValue(c) > 0) {
                cleanedInput.append(c);
            }
        }
        String cleanedInputStr = cleanedInput.toString();
        // O(n/2)
        String begin = cleanedInputStr.substring(0, cleanedInputStr.length()/2);
        String end = cleanedInputStr.length()%2 == 0 ? cleanedInputStr.substring(cleanedInputStr.length()/2) : cleanedInputStr.substring(cleanedInputStr.length()/2+1);
        for(int i=end.length()-1; i>=0; i--) {
            revEnd.append(end.charAt(i));
        }
        String revEndStr = revEnd.toString();
        return revEndStr.equalsIgnoreCase(begin);
    }

}
