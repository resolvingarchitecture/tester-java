package ra.tester;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter a phrase, Q to quit: ");
            String input = sc.nextLine();
            if ("Q".equalsIgnoreCase(input))
                System.exit(0);
            if (isPalindrome(input)) {
                System.out.println(input + " is a palindrome.");
            } else {
                System.out.println(input + " is not a palindrome.");
            }
        }
    }

    private static boolean isPalindrome(String input) {
        StringBuilder cleanedInput = new StringBuilder();
        StringBuilder rev = new StringBuilder();
        char[] chars = input.toCharArray();
        for(char c : chars) {
            if(Character.getNumericValue(c) > 0) {
                cleanedInput.append(c);
            }
        }
        String cleanedInputStr = cleanedInput.toString();
        for(int i=cleanedInputStr.length()-1; i>=0; i--) {
            rev.append(cleanedInputStr.charAt(i));
        }
        String revStr = rev.toString();
        System.out.println("Reverse of input is: "+revStr);
        return revStr.equalsIgnoreCase(cleanedInputStr);
    }

}
