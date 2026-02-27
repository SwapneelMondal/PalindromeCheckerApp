import java.util.Scanner;
import java.util.Stack;   // <-- Added for UC5

public class Main {

    // Existing Method (DO NOT TOUCH)
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase(); // ignore case
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // -------------------- UC3: New Method Added --------------------
    // Palindrome Check Using String Reverse (for loop + concatenation)
    public static boolean isPalindromeUsingReverse(String str) {
        str = str.toLowerCase(); // ignore case

        String reversed = "";

        // Reverse using for loop
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i); // String concatenation
        }

        // Compare using equals()
        return str.equals(reversed);
    }
    // ---------------------------------------------------------------


    // -------------------- UC4: Character Array Method --------------------
    // Palindrome Check Using Character Array (char[])
    public static boolean isPalindromeUsingCharArray(String str) {
        str = str.toLowerCase(); // ignore case

        char[] arr = str.toCharArray(); // Convert to character array

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    // ----------------------------------------------------------------------


    // ==================== UC5: Stack-Based Method ====================
    // Palindrome Check Using Stack (LIFO Principle)
    public static boolean isPalindromeUsingStack(String str) {
        str = str.toLowerCase(); // ignore case

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));  // Push operation
        }

        // Pop characters and build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();  // Pop operation
        }

        // Compare original and reversed string
        return str.equals(reversed);
    }
    // =================================================================


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Using Original Method
        if (isPalindrome(input)) {
            System.out.println("Palindrome (Two Pointer Method)");
        } else {
            System.out.println("Not Palindrome (Two Pointer Method)");
        }

        // Using UC3 Reverse Method
        if (isPalindromeUsingReverse(input)) {
            System.out.println("Palindrome (Reverse Method - UC3)");
        } else {
            System.out.println("Not Palindrome (Reverse Method - UC3)");
        }

        // -------------------- UC4 Call Added --------------------
        if (isPalindromeUsingCharArray(input)) {
            System.out.println("Palindrome (Character Array Method - UC4)");
        } else {
            System.out.println("Not Palindrome (Character Array Method - UC4)");
        }
        // --------------------------------------------------------

        // ==================== UC5 Call Added ====================
        if (isPalindromeUsingStack(input)) {
            System.out.println("Palindrome (Stack Method - UC5)");
        } else {
            System.out.println("Not Palindrome (Stack Method - UC5)");
        }
        // ========================================================
    }
}