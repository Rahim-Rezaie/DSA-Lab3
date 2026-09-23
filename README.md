# DSA Lab — Memory Management & Linked Lists

This repo contains today's lab work covering dynamic memory allocation, memory leak detection/fixing, and a full menu-driven Singly Linked List implementation in C++.

## Tasks

### 1. StringPool — Memory Leak Detection & Fix
A class-based program that manages a pool of dynamically allocated strings using an array of pointers (`string**`), demonstrating how memory leaks happen when a pointer is overwritten without freeing what it pointed to first — and how to fix it properly.

**File:** `string_pool.cpp`

**Covers:**
- Constructor initializing a fixed-size pool (max 5 strings)
- `addString()` — dynamically allocates and stores a new string
- `removeString()` — the leaky version, drops a pointer without freeing memory
- `removeStringFixed()` — the corrected version, properly `delete`s memory before removing
- `displayPool()` — shows current pool contents

### 2. Singly Linked List — Menu-Driven Program
A complete linked list implementation supporting insertion, deletion, traversal, reversal, searching, and node counting — all driven through an interactive menu.

**File:** `linked_list.cpp`

**Covers:**
- `insertAtHead()` — inserts a new node at the beginning of the list
- `insertAtThird()` — inserts a node specifically at the 3rd position, with edge-case handling for lists with fewer than 2 nodes
- `displayList()` — traverses and prints the list, terminating in `NULL`
- `deleteLast()` — removes the last node, handling empty-list and single-node edge cases
- `countNodes()` — returns the total number of nodes in the list
- `reverseList()` — reverses the list iteratively (no recursion)
- `searchValue()` — searches for a value and reports its position if found
- `deleteAllNodes()` — frees all remaining nodes on exit to prevent memory leaks

## Concepts covered
- Dynamic memory allocation with `new` and `delete`
- Pointer-to-pointer structures (`string**`)
- Identifying and fixing memory leaks
- Singly linked list construction and pointer manipulation
- Iterative list reversal
- Edge case handling (empty list, single node, out-of-bounds positions)

## How to run
```
g++ filename.cpp -o output
./output
```
