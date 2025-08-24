package contactformproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * Name: Agbai Obasi Uwa
 * Registration number: 20231411752
 * Department: Computer Science
 * Group No: 1
 * S/N: 7
 */

public class ContactFormProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        // File path relative to project root
        String filePath = "contacts.txt";

        try {
            // Ensure file exists (create if not)
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();  // creates the file if it doesn’t exist
                System.out.println("New file created: " + filePath);
            }

            // Append mode = true
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("Name: " + name + ", Email: " + email + ", Phone: " + phone + "\n");
                System.out.println("Contact saved successfully to " + filePath);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving contact.");
            e.printStackTrace();
        }
    }
}
