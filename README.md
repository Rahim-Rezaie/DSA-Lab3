# DSA Lab — Pointers, Memory Management & Linked Lists

A C++ lab exploring dynamic memory allocation, memory leak detection, and one of the most fundamental data structures in computer science — the Singly Linked List.

---

## 📁 Contents

| File | Description |
|---|---|
| `palindrome_check.cpp` | Iterative palindrome checker |
| `string_pool.cpp` | Memory leak detection & fix using a dynamic string pool |
| `linked_list.cpp` | Menu-driven Singly Linked List implementation |

---

## 1. Palindrome Checker (Iterative)

**Problem Statement**

Palindromes are strings that read the same backward as forward, disregarding spaces, punctuation, and case. They are an interesting concept in both string processing and algorithm design. This task focuses on implementing an **iterative method** to check whether a given string is a palindrome.

**Approach**

Uses a two-pointer technique — one pointer starts at the beginning, one at the end, and both move toward the middle comparing characters (case-insensitive) until they meet or a mismatch is found.

---

## 2. StringPool — Memory Leak Detection & Fix

**Problem Statement**

Develop a C++ program that finds memory leaks in a string processing application with the following requirements:

1. **Implement a class `StringPool`** that contains:
   - `string* stringPool` — dynamic array of strings
   - `int currentSize` — current number of strings in the pool
   - `int maxSize` — maximum size of the pool (set to 5)

2. **Methods:**
   - Constructor — initializes these fields
   - `addString()` — adds a string to the pool
   - `removeString()` — removes a string from the pool **without freeing memory**

3. **In the `main()` function:**
   - Add multiple strings to the pool
   - Remove strings without freeing memory
   - Detect and fix the memory leak by deleting removed strings and displaying the pool status

**What this demonstrates**

The leaky version shows how overwriting a pointer without calling `delete` first orphans that memory on the heap — reserved, but unreachable. The fixed version properly frees memory before the pointer is lost.

---

## 3. Singly Linked List — Menu-Driven Program

**Problem Statement**

You are required to design and implement a menu-driven C++ program that demonstrates the use of Singly Linked Lists, one of the fundamental data structures in computer science. A linked list is a linear data structure where each element (called a node) contains two parts:

1. **Data field** – to store the actual value.
2. **Pointer field (link)** – to store the address of the next node in the sequence.

Unlike arrays, linked lists do not require contiguous memory allocation, making them efficient for insertion and deletion operations at arbitrary positions. Through this task, dynamic memory allocation, pointer manipulation, and function-based program design are practiced.

**Program Requirements**

| # | Function | Description |
|---|---|---|
| 1 | `insertAtHead()` | Dynamically creates a new node and inserts it at the beginning of the list, so the most recently inserted node always becomes the new head. |
| 2 | `insertAtThird()` | Inserts a new node specifically at the 3rd position, traversing the list to find the correct spot. Handles lists with fewer than 2 nodes appropriately. |
| 3 | `displayList()` | Traverses the list from head to last node, printing all values in sequence separated by `->`, terminating clearly at `NULL`. |
| 4 | `deleteLast()` | Removes the final node in the list, handling special cases like an empty list or a list with only one node. Displays the updated list after deletion. |
| 5 | `countNodes()` | Traverses the list and returns the total number of nodes currently present. |
| 6 | `reverseList()` | Reverses the list **iteratively** (no recursion), so the last node becomes the first and so on. Displays the updated list to confirm correctness. |
| 7 | `searchValue()` | Accepts a value from the user and checks if it exists in the list. Displays the position if found, or an appropriate message if not. |
| 8 | Menu-driven `main()` | Repeatedly prompts the user to choose an operation (insert at head, insert at 3rd, display, delete last, count, reverse, search, exit) until exit is selected. |

---

## 🧠 Concepts Covered

- Dynamic memory allocation with `new` and `delete`
- Pointer manipulation and pointer-to-pointer structures
- Memory leak identification and correction
- Iterative algorithm design (two-pointer technique, list reversal)
- Singly linked list construction, traversal, insertion, and deletion
- Edge case handling (empty list, single node, out-of-bounds positions)
- Function-based, menu-driven program design

---

## ▶️ How to Run

```bash
g++ filename.cpp -o output
./output
```

Replace `filename.cpp` with any of the three source files above.
