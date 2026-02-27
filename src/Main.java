import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

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

    // -------------------- UC3: Reverse Method --------------------
    public static boolean isPalindromeUsingReverse(String str) {
        str = str.toLowerCase(); // ignore case

        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }

        return str.equals(reversed);
    }
    // -------------------------------------------------------------


    // -------------------- UC4: Character Array Method --------------------
    public static boolean isPalindromeUsingCharArray(String str) {
        str = str.toLowerCase();

        char[] arr = str.toCharArray();

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
    public static boolean isPalindromeUsingStack(String str) {
        str = str.toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        return str.equals(reversed);
    }
    // =================================================================


    // ==================== UC6: Queue + Stack Method ====================
    public static boolean isPalindromeUsingQueueAndStack(String str) {
        str = str.toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            queue.add(ch);     // Enqueue (FIFO)
            stack.push(ch);    // Push (LIFO)
        }

        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                return false;
            }
        }

        return true;
    }
    // =================================================================


    // ==================== UC7: Deque-Based Method ====================
    public static boolean isPalindromeUsingDeque(String str) {
        str = str.toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters
        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        // Compare front and rear
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }
    // =================================================================


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // UC1 - Two Pointer
        if (isPalindrome(input)) {
            System.out.println("Palindrome (Two Pointer Method)");
        } else {
            System.out.println("Not Palindrome (Two Pointer Method)");
        }

        // UC3 - Reverse
        if (isPalindromeUsingReverse(input)) {
            System.out.println("Palindrome (Reverse Method - UC3)");
        } else {
            System.out.println("Not Palindrome (Reverse Method - UC3)");
        }

        // UC4 - Character Array
        if (isPalindromeUsingCharArray(input)) {
            System.out.println("Palindrome (Character Array Method - UC4)");
        } else {
            System.out.println("Not Palindrome (Character Array Method - UC4)");
        }

        // UC5 - Stack
        if (isPalindromeUsingStack(input)) {
            System.out.println("Palindrome (Stack Method - UC5)");
        } else {
            System.out.println("Not Palindrome (Stack Method - UC5)");
        }

        // UC6 - Queue + Stack
        if (isPalindromeUsingQueueAndStack(input)) {
            System.out.println("Palindrome (Queue + Stack Method - UC6)");
        } else {
            System.out.println("Not Palindrome (Queue + Stack Method - UC6)");
        }

        // UC7 - Deque
        if (isPalindromeUsingDeque(input)) {
            System.out.println("Palindrome (Deque Method - UC7)");
        } else {
            System.out.println("Not Palindrome (Deque Method - UC7)");
        }

        sc.close();
    }
}