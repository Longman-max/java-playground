package stack;

import java.util.Scanner;

/**
 *
 * Name: Agbai Obasi Uwa
 * Registration number: 20231411752
 * Department: Computer Science
 * Group No: 1
 * S/N: 7
 */

public class Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        // Use Java's built-in Stack (full qualification avoids conflict with this class name)
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push characters onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Pop characters to build reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Output
        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }
}
