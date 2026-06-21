import model.Employee;
import service.EmployeeService;

/**
 * Demonstrates the array-based Employee Management System.
 * Shows add, search, traverse, and delete operations with edge cases.
 */
public class Main {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService(5);

        // --- Add Employees ---
        System.out.println("=== Adding Employees (capacity=5) ===");
        service.addEmployee(new Employee(201, "Arun",   "Developer",     85000.00));
        service.addEmployee(new Employee(202, "Bhavna", "Designer",      72000.00));
        service.addEmployee(new Employee(203, "Chetan", "Manager",      110000.00));
        service.addEmployee(new Employee(204, "Deepa",  "Tester",        68000.00));

        System.out.println("\n=== Current Records ===");
        service.traverse();
        System.out.println("  Size: " + service.getSize() + "/" + service.getCapacity());

        // --- Search ---
        System.out.println("\n=== Search by Employee ID ===");
        int searchId = 203;
        Employee found = service.searchById(searchId);
        System.out.println("  Searching for ID " + searchId + ": "
                + (found != null ? found : "Not found"));

        int missingId = 999;
        Employee notFound = service.searchById(missingId);
        System.out.println("  Searching for ID " + missingId + ": "
                + (notFound != null ? notFound : "Not found"));

        // --- Delete ---
        System.out.println("\n=== Deleting Employee 202 (Bhavna) ===");
        service.deleteEmployee(202);

        System.out.println("\n=== Records After Deletion ===");
        service.traverse();
        System.out.println("  Size: " + service.getSize() + "/" + service.getCapacity());

        // --- Add after deletion (reuse freed slot) ---
        System.out.println("\n=== Adding New Employee After Deletion ===");
        service.addEmployee(new Employee(205, "Esha", "Analyst", 77000.00));

        System.out.println("\n=== Final Records ===");
        service.traverse();

        // --- Edge case: array full ---
        System.out.println("\n=== Edge Case: Adding Beyond Capacity ===");
        service.addEmployee(new Employee(206, "Farhan", "Intern", 35000.00));
        service.addEmployee(new Employee(207, "Gauri",  "Lead",   95000.00));
    }
}
