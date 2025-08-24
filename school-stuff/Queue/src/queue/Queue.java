package queue;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * Name: Agbai Obasi Uwa
 * Registration number: 20231411752
 * Department: Computer Science
 * Group No: 1
 * S/N: 7
 */

public class Queue {

    // Simple ticket queue system
    static class TicketQueue {
        private LinkedList<String> queue;

        public TicketQueue() {
            queue = new LinkedList<>();
        }

        // Enqueue: Add customer to the queue
        public void enqueue(String customerName) {
            queue.addLast(customerName);
            System.out.println(customerName + " added to the ticket queue.");
        }

        // Dequeue: Serve customer (remove from front of queue)
        public void dequeue() {
            if (queue.isEmpty()) {
                System.out.println("No customers in queue.");
            } else {
                String served = queue.removeFirst();
                System.out.println("Ticket booked for: " + served);
            }
        }

        // Display all customers in queue
        public void displayQueue() {
            if (queue.isEmpty()) {
                System.out.println("Queue is empty.");
            } else {
                System.out.println("Current Queue: " + queue);
            }
        }
    }

    public static void main(String[] args) {
        TicketQueue ticketQueue = new TicketQueue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Ticket Booking System ---");
            System.out.println("1. Add Customer (Enqueue)");
            System.out.println("2. Serve Customer (Dequeue)");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    ticketQueue.enqueue(name);
                    break;
                case 2:
                    ticketQueue.dequeue();
                    break;
                case 3:
                    ticketQueue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
