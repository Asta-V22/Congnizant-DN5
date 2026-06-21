package service;

import model.Employee;

/**
 * Manages employee records using a fixed-size array.
 *
 * Why Array?
 * - Arrays store elements in contiguous memory, enabling O(1) index-based access.
 * - Memory-efficient: no per-element overhead (unlike linked lists).
 * - This exercise demonstrates raw array operations to understand their limitations.
 *
 * Limitations:
 * - Fixed capacity: cannot grow dynamically (unlike ArrayList).
 * - Deletion requires shifting elements to fill gaps.
 * - Search requires linear scan (no hashing).
 */
public class EmployeeService {

    private Employee[] employees;
    private int size;

    public EmployeeService(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    /**
     * Adds an employee at the next available position.
     * Time: O(n) — checks for duplicate ID before adding.
     */
    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("  ERROR: Array is full (capacity=" + employees.length + "). Cannot add.");
            return;
        }

        // Check for duplicate ID
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employee.getEmployeeId()) {
                System.out.println("  ERROR: Employee ID " + employee.getEmployeeId() + " already exists.");
                return;
            }
        }

        employees[size++] = employee;
        System.out.println("  Added: " + employee);
    }

    /**
     * Searches for an employee by ID using linear scan.
     * Time: O(n)
     */
    public Employee searchById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    /**
     * Traverses and displays all employee records.
     * Time: O(n)
     */
    public void traverse() {
        if (size == 0) {
            System.out.println("  No employee records found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println("  [" + i + "] " + employees[i]);
        }
    }

    /**
     * Deletes an employee by ID. Shifts subsequent elements left to fill the gap.
     * Time: O(n) — linear scan + element shifting.
     */
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("  ERROR: Employee ID " + employeeId + " not found.");
            return;
        }

        System.out.println("  Deleted: " + employees[index]);

        // Shift elements left to fill the gap
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--size] = null;  // Clear last reference for garbage collection
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return employees.length;
    }
}
