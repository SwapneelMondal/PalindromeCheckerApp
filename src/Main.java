import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

    // Existing Method (DO NOT TOUCH)
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
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

    // -------------------- UC3 --------------------
    public static boolean isPalindromeUsingReverse(String str) {
        str = str.toLowerCase();

        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }

        return str.equals(reversed);
    }

    // -------------------- UC4 --------------------
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

    // -------------------- UC5 --------------------
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

    // -------------------- UC6 --------------------
    public static boolean isPalindromeUsingQueueAndStack(String str) {
        str = str.toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            queue.add(ch);
            stack.push(ch);
        }

        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // -------------------- UC7 --------------------
    public static boolean isPalindromeUsingDeque(String str) {
        str = str.toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    // -------------------- UC8 --------------------
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindromeUsingLinkedList(String str) {
        str = str.toLowerCase();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(str.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // -------------------- UC9 --------------------
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        str = str.toLowerCase();

        if (left >= right) return true;

        if (str.charAt(left) != str.charAt(right)) return false;

        return isPalindromeRecursive(str, left + 1, right - 1);
    }

    public static boolean checkPalindromeRecursive(String str) {
        return isPalindromeRecursive(str, 0, str.length() - 1);
    }

    // -------------------- UC10 --------------------
    public static boolean isPalindromeIgnoringSpaces(String str) {

        String normalized = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // ==================== UC11 ====================
    static class PalindromeChecker {

        public boolean checkPalindrome(String str) {

            str = str.toLowerCase();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // ==================== UC12: Strategy Pattern ====================

    interface PalindromeStrategy {
        boolean check(String str);
    }

    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String str) {

            str = str.toLowerCase();
            Stack<Character> stack = new Stack<>();

            for (char c : str.toCharArray()) {
                stack.push(c);
            }

            for (char c : str.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String str) {

            str = str.toLowerCase();
            Deque<Character> deque = new ArrayDeque<>();

            for (char c : str.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {

                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    static class PalindromeContext {

        private PalindromeStrategy strategy;

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String str) {
            return strategy.check(str);
        }
    }

    // ===============================================================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input))
            System.out.println("Palindrome (Two Pointer Method)");
        else
            System.out.println("Not Palindrome (Two Pointer Method)");

        if (isPalindromeUsingReverse(input))
            System.out.println("Palindrome (Reverse Method - UC3)");
        else
            System.out.println("Not Palindrome (Reverse Method - UC3)");

        if (isPalindromeUsingCharArray(input))
            System.out.println("Palindrome (Character Array Method - UC4)");
        else
            System.out.println("Not Palindrome (Character Array Method - UC4)");

        if (isPalindromeUsingStack(input))
            System.out.println("Palindrome (Stack Method - UC5)");
        else
            System.out.println("Not Palindrome (Stack Method - UC5)");

        if (isPalindromeUsingQueueAndStack(input))
            System.out.println("Palindrome (Queue + Stack Method - UC6)");
        else
            System.out.println("Not Palindrome (Queue + Stack Method - UC6)");

        if (isPalindromeUsingDeque(input))
            System.out.println("Palindrome (Deque Method - UC7)");
        else
            System.out.println("Not Palindrome (Deque Method - UC7)");

        if (isPalindromeUsingLinkedList(input))
            System.out.println("Palindrome (Linked List Method - UC8)");
        else
            System.out.println("Not Palindrome (Linked List Method - UC8)");

        if (checkPalindromeRecursive(input))
            System.out.println("Palindrome (Recursive Method - UC9)");
        else
            System.out.println("Not Palindrome (Recursive Method - UC9)");

        if (isPalindromeIgnoringSpaces(input))
            System.out.println("Palindrome (Ignore Spaces & Case - UC10)");
        else
            System.out.println("Not Palindrome (Ignore Spaces & Case - UC10)");

        PalindromeChecker service = new PalindromeChecker();

        if (service.checkPalindrome(input))
            System.out.println("Palindrome (OOP Service - UC11)");
        else
            System.out.println("Not Palindrome (OOP Service - UC11)");

        // ================= UC12 Usage =================

        PalindromeContext context = new PalindromeContext();

        context.setStrategy(new StackStrategy());

        if (context.execute(input))
            System.out.println("Palindrome (Strategy Pattern - Stack)");
        else
            System.out.println("Not Palindrome (Strategy Pattern - Stack)");

        context.setStrategy(new DequeStrategy());

        if (context.execute(input))
            System.out.println("Palindrome (Strategy Pattern - Deque)");
        else
            System.out.println("Not Palindrome (Strategy Pattern - Deque)");

        // =================================================

        sc.close();
    }
}