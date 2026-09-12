import java.util.Scanner; //Mohan Kumar 
// Java project - 01
public class SmartCurriculumApp {
    static Scanner sc = new Scanner(System.in);
    static String name;
    static String id;
    static String roll;
    static boolean studentAdded = false;   // track if a student exists yet
    static int present = 0;
    static int absent = 0;
    static int points = 0;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- SMART CURRICULUM APP ---");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Add Activity");
            System.out.println("4. View Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {          // guard against non-numeric input
                System.out.print("Please enter a number (1-5): ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    attendance();
                    break;
                case 3:
                    activity();
                    break;
                case 4:
                    viewStudent();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);

        sc.close();
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        id = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        roll = sc.nextLine();
        studentAdded = true;
        System.out.println("Student Added Successfully!");
    }

    static void attendance() {
        if (!studentAdded) {
            System.out.println("Please add a student first (option 1).");
            return;
        }
        System.out.print("Enter P for Present / A for Absent: ");
        char ch = sc.next().charAt(0);
        sc.nextLine();  // consume leftover newline

        if (ch == 'P' || ch == 'p') {
            present++;
            System.out.println("Attendance Marked: Present");
        } else if (ch == 'A' || ch == 'a') {
            absent++;
            System.out.println("Attendance Marked: Absent");
        } else {
            System.out.println("Invalid choice");
        }
    }

    static void activity() {
        if (!studentAdded) {
            System.out.println("Please add a student first (option 1).");
            return;
        }
        System.out.print("Enter Activity Name: ");
        String activityName = sc.nextLine();

        System.out.print("Enter Points: ");
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int p = sc.nextInt();
        sc.nextLine();  // consume leftover newline

        points += p;
        System.out.println(activityName + " added successfully!");
    }

    static void viewStudent() {
        if (!studentAdded) {
            System.out.println("No student added yet.");
            return;
        }

        int totalDays = present + absent;
        double attendancePercent = (totalDays == 0) ? 0.0 : (present * 100.0) / totalDays;

        System.out.println("\n--- STUDENT DETAILS ---");
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + roll);
        System.out.println("Present    : " + present);
        System.out.println("Absent     : " + absent);
        System.out.printf("Attendance : %.2f%%\n", attendancePercent);
        System.out.println("Points     : " + points);
    }
}
