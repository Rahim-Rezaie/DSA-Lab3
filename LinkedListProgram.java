import java.util.Scanner;

public class LinkedListProgram {

    // Node class - each node holds a value and a reference to the next node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null; // head of the list, starts empty

    // -----------------------------------------------------
    // 1. Insert a new node at the head of the list
    // -----------------------------------------------------
    static void insertAtHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head; // new node points to old head
        head = newNode;       // new node becomes the head
        System.out.println(value + " inserted at head.");
    }

    // -----------------------------------------------------
    // 2. Insert a new node at the 3rd position of the list
    // -----------------------------------------------------
    static void insertAtThird(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            System.out.println("List was empty. Inserted as only node.");
            return;
        }
        if (head.next == null) {
            head.next = newNode;
            System.out.println("List had 1 node. Inserted at end.");
            return;
        }

        Node temp = head.next; // move to 2nd node
        newNode.next = temp.next; // point new node to old 3rd node
        temp.next = newNode;       // 2nd node now points to new node
        System.out.println(value + " inserted at 3rd position.");
    }

    // -----------------------------------------------------
    // 3. Display the entire list
    // -----------------------------------------------------
    static void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        StringBuilder sb = new StringBuilder("List: ");
        while (temp != null) {
            sb.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
    }

    // -----------------------------------------------------
    // 4. Delete the last node of the list
    // -----------------------------------------------------
    static void deleteLast() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        if (head.next == null) {
            head = null; // Java's garbage collector handles cleanup automatically
            System.out.println("Only node deleted. List is now empty.");
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null; // dropping reference removes the last node
        System.out.println("Last node deleted.");
    }

    // -----------------------------------------------------
    // 5. Count the number of nodes in the list
    // -----------------------------------------------------
    static int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // -----------------------------------------------------
    // 6. Reverse the list iteratively
    // -----------------------------------------------------
    static void reverseList() {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next; // save next before breaking link
            current.next = prev;      // reverse the pointer direction
            prev = current;            // move prev forward
            current = nextNode;        // move current forward
        }
        head = prev; // prev ends up being the new head
        System.out.println("List reversed.");
    }

    // -----------------------------------------------------
    // 7. Search for a value in the list
    // -----------------------------------------------------
    static void searchValue(int value) {
        Node temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Value " + value + " found at position " + position + ".");
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Value " + value + " not found in the list.");
    }

    // -----------------------------------------------------
    // Helper - safely reads an integer, returns null if invalid
    // -----------------------------------------------------
    static Integer getIntInput(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next(); // discard the invalid token
            return null;
        }
    }

    // -----------------------------------------------------
    // Main - menu driven interface
    // -----------------------------------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Singly Linked List Menu -----");
            System.out.println("1. Insert at Head");
            System.out.println("2. Insert at 3rd Position");
            System.out.println("3. Display List");
            System.out.println("4. Delete Last Node");
            System.out.println("5. Count Nodes");
            System.out.println("6. Reverse List");
            System.out.println("7. Search Value");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            Integer choiceInput = getIntInput(scanner);
            if (choiceInput == null) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }
            choice = choiceInput;

            Integer value;

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at head: ");
                    value = getIntInput(scanner);
                    if (value != null) {
                        insertAtHead(value);
                        displayList();
                    } else {
                        System.out.println("Invalid integer entered.");
                    }
                    break;

                case 2:
                    System.out.print("Enter value to insert at 3rd position: ");
                    value = getIntInput(scanner);
                    if (value != null) {
                        insertAtThird(value);
                        displayList();
                    } else {
                        System.out.println("Invalid integer entered.");
                    }
                    break;

                case 3:
                    displayList();
                    break;

                case 4:
                    deleteLast();
                    displayList();
                    break;

                case 5:
                    System.out.println("Total nodes in list: " + countNodes());
                    break;

                case 6:
                    reverseList();
                    displayList();
                    break;

                case 7:
                    System.out.print("Enter value to search: ");
                    value = getIntInput(scanner);
                    if (value != null) {
                        searchValue(value);
                    } else {
                        System.out.println("Invalid integer entered.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
