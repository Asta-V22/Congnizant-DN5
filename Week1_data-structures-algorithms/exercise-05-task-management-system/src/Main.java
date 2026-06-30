import model.Task;
import service.TaskLinkedList;

/**
 * Demonstrates the singly linked list-based Task Management System.
 */
public class Main {

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // --- Add Tasks ---
        System.out.println("=== Adding Tasks ===");
        taskList.addTask(new Task(1, "Design database schema",    "Pending"));
        taskList.addTask(new Task(2, "Implement REST API",        "In Progress"));
        taskList.addTask(new Task(3, "Write unit tests",          "Pending"));
        taskList.addTask(new Task(4, "Set up CI/CD pipeline",     "Pending"));
        taskList.addTask(new Task(5, "Deploy to staging",         "Not Started"));

        System.out.println("\n=== All Tasks (Traverse) ===");
        taskList.traverse();
        System.out.println("  Total tasks: " + taskList.getSize());

        // --- Search ---
        System.out.println("\n=== Searching for Tasks ===");
        int searchId = 3;
        Task found = taskList.searchById(searchId);
        System.out.println("  Search ID " + searchId + ": "
                + (found != null ? found : "Not found"));

        int missingId = 99;
        Task notFound = taskList.searchById(missingId);
        System.out.println("  Search ID " + missingId + ": "
                + (notFound != null ? notFound : "Not found"));

        // --- Delete from middle ---
        System.out.println("\n=== Deleting Task 3 (Write unit tests) ===");
        taskList.deleteTask(3);

        System.out.println("\n=== Tasks After Deletion ===");
        taskList.traverse();
        System.out.println("  Total tasks: " + taskList.getSize());

        // --- Delete the head ---
        System.out.println("\n=== Deleting Task 1 (Head Node) ===");
        taskList.deleteTask(1);

        System.out.println("\n=== Tasks After Head Deletion ===");
        taskList.traverse();

        // --- Edge case: delete non-existent ---
        System.out.println("\n=== Edge Case: Delete Non-existent Task ===");
        taskList.deleteTask(99);
    }
}
