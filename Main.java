import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int setup = getSetupOption(input);

        if (setup == 1) {
            setupSchedule(input);
        }

        boolean exit = false;

        while (!exit) {
            int choice = getUserChoice(input);

            switch (choice) {
                case 1:
                    viewSchedule();
                    break;
                case 2:
                    addTasks(input);
                    viewSchedule();
                    break;
                case 3:
                    removeTasks(input);
                    viewSchedule();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }

    private static int getSetupOption(Scanner input) {
        System.out.print("Hello user, enter 1 if you need to set up your schedule, enter 2 if your schedule is already created: ");
        int setup = input.nextInt();

        while (setup != 1 && setup != 2) {
            System.out.print("Invalid input. Enter 1 to set up your schedule or 2 if your schedule is already created: ");
            setup = input.nextInt();
        }

        return setup;
    }

    private static void setupSchedule(Scanner input) {
        System.out.print("Enter the number of tasks you would like in your schedule: ");
        int numInputs = input.nextInt();
        input.nextLine(); //

        for (int i = 0; i < numInputs; i++) {
            System.out.print("Enter task " + (i + 1) + " and the time you want to complete it: ");
            tasks.add(input.nextLine());
        }
    }

    private static int getUserChoice(Scanner input) {
        System.out.println("Welcome back user. Enter 1 to view your current schedule, enter 2 to input new tasks into your schedule, or enter 3 to remove tasks from your day-to-day schedule: ");
        int choice = input.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.println("Invalid choice. Enter 1 to view your current schedule, 2 to input new tasks, or 3 to remove tasks: ");
            choice = input.nextInt();
        }

        return choice;
    }

    private static void viewSchedule() {
        if (!tasks.isEmpty()) {
            System.out.println("Schedule: ");
            for (String task : tasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("No schedule available.");
        }
    }

    private static void addTasks(Scanner input) {
        System.out.print("Enter the number of tasks you want to add: ");
        int numTasks = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numTasks; i++) {
            System.out.print("Enter task " + (tasks.size() + 1) + " and the time you want to complete it: ");
            tasks.add(input.nextLine());
        }
    }

    private static void removeTasks(Scanner input) {
        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number you want to remove: ");
            int index = input.nextInt();

            if (index >= 1 && index <= tasks.size()) {
                tasks.remove(index - 1);
                System.out.println("Task removed successfully.");
            } else {
                System.out.println("Invalid task number.");
            }
        } else {
            System.out.println("No tasks to remove.");
        }
    }
}