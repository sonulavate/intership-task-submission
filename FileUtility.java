import java.io.*;
import java.util.Scanner;

public class FileUtility {

    static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== File Handling Utility ===");
            System.out.println("1. Write to file");
            System.out.println("2. Read from file");
            System.out.println("3. Modify file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    writeToFile(scanner);
                    break;
                case 2:
                    readFromFile();
                    break;
                case 3:
                    modifyFile(scanner);
                    break;
                case 4:
                    System.out.println("Program exited.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void writeToFile(Scanner scanner) {
        try {
            System.out.print("Enter text to write: ");
            String content = scanner.nextLine();
            FileWriter writer = new FileWriter(FILE_PATH);
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void readFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("File does not exist!");
                return;
            }
            Scanner reader = new Scanner(file);
            System.out.println("File Content:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void modifyFile(Scanner scanner) {
        try {
            System.out.print("Enter text to append: ");
            String content = scanner.nextLine();
            FileWriter writer = new FileWriter(FILE_PATH, true); // append mode
            writer.write("\n" + content);
            writer.close();
            System.out.println("File modified (appended) successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}
