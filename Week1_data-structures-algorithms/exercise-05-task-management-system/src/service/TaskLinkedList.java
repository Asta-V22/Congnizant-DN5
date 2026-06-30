package service;

import model.Task;

/**
 * Singly Linked List implementation for managing tasks.
 *
 * Each node holds a Task and a reference to the next node:
 *
 *   [Task A | next] --> [Task B | next] --> [Task C | null]
 *    ^head
 *
 * Singly Linked List vs Doubly Linked List:
 * - Singly: Each node has only a 'next' pointer. Traversal is forward-only.
 * - Doubly: Each node has 'next' and 'prev' pointers. Supports bidirectional traversal.
 *
 * We use Singly Linked List here because:
 * - Simpler implementation (fewer pointers to maintain).
 * - Lower memory overhead (one pointer per node vs two).
 * - Sufficient for this use case (no backward traversal needed).
 */
public class TaskLinkedList {

    /**
     * Internal node class — encapsulates a task and a link to the next node.
     * Package-private to the service: external code works only with Task objects.
     */
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public TaskLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds a task at the end of the linked list.
     * Time: O(n) — must traverse to the tail.
     *       Could be O(1) with a tail pointer, but kept simple for clarity.
     */
    public void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("  Added: " + task);
    }

    /**
     * Searches for a task by its ID.
     * Time: O(n) — linear traversal.
     */
    public Task searchById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Traverses the entire list and displays all tasks.
     * Time: O(n)
     */
    public void traverse() {
        if (head == null) {
            System.out.println("  Task list is empty.");
            return;
        }
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println("  [" + index + "] " + current.task);
            current = current.next;
            index++;
        }
    }

    /**
     * Deletes a task by its ID.
     * Time: O(n) — must find the node and its predecessor.
     *
     * Special case: Deleting the head node requires updating the head pointer.
     * General case: Link the previous node to the node after the deleted one.
     */
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("  ERROR: Task list is empty.");
            return;
        }

        // Special case: deleting the head
        if (head.task.getTaskId() == taskId) {
            System.out.println("  Deleted: " + head.task);
            head = head.next;
            size--;
            return;
        }

        // General case: find the node before the target
        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                System.out.println("  Deleted: " + current.next.task);
                current.next = current.next.next;  // Bypass the deleted node
                size--;
                return;
            }
            current = current.next;
        }

        System.out.println("  ERROR: Task ID " + taskId + " not found.");
    }

    public int getSize() {
        return size;
    }
}
