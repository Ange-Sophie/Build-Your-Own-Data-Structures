# Build Your Own Data Structures (DSA I)

Java implementations of a generic singly linked list, linked-list stack, two-stack queue, array/string algorithms, and an LRU cache. No `java.util` collection is used inside the custom structures, except the explicitly required `HashMap` in `LRUCache`.

## Run

```bash
javac src/*.java
java -cp src Main
```

On Windows PowerShell, the same commands work when run from the project root.

## Complexity report

Here `n` is the number of elements, and `m` is the length of an input string. Space means **auxiliary space per call**, unless otherwise stated. Linked-list and stack/queue storage is O(n); LRU cache storage is O(capacity). `HashMap` complexities are expected/average-case.

| Class | Method | Time | Auxiliary space |
|---|---|---|---|
| MyLinkedList | `Node` constructor | O(1) | O(1) |
| MyLinkedList | `addFirst` | O(1) | O(1) |
| MyLinkedList | `addLast` | O(1) | O(1) |
| MyLinkedList | `removeFirst` | O(1) | O(1) |
| MyLinkedList | `get` | O(n) | O(1) |
| MyLinkedList | `size` | O(1) | O(1) |
| MyLinkedList | `reverse` | O(n) | O(1) |
| MyLinkedList | `findMiddle` | O(n) | O(1) |
| MyLinkedList | `isEmpty` | O(1) | O(1) |
| MyStack | `push` | O(1) | O(1) |
| MyStack | `pop` | O(1) | O(1) |
| MyStack | `peek` | O(1) | O(1) |
| MyStack | `isEmpty` | O(1) | O(1) |
| MyQueue | `enqueue` | O(1) | O(1) |
| MyQueue | `transfer` | O(n) worst, O(1) amortized per queue operation | O(1) additional; nodes move between stacks |
| MyQueue | `dequeue` | O(n) worst, O(1) amortized | O(1) additional |
| MyQueue | `peek` | O(n) worst, O(1) amortized | O(1) additional |
| MyQueue | `isEmpty` | O(1) | O(1) |
| ArrayStringUtils | `rotateRight` | O(n) | O(1) |
| ArrayStringUtils | `reverse` helper | O(n) | O(1) |
| ArrayStringUtils | `isAnagram` | O(n + 65536) = O(n) | O(65536) = O(1) |
| ArrayStringUtils | `twoSumSorted` | O(n) | O(1) for returned two-element array |
| ArrayStringUtils | `isBalanced` | O(m) | O(m) |
| LRUCache | `Node` constructor | O(1) | O(1) |
| LRUCache | constructor | O(1) | O(1) initially |
| LRUCache | `removeNode` | O(1) | O(1) |
| LRUCache | `addToFront` | O(1) | O(1) |
| LRUCache | `moveToFront` | O(1) | O(1) |
| LRUCache | `get` | O(1) average | O(1) |
| LRUCache | `put` | O(1) average | O(1) per new entry |
| Main | `main` demonstration | O(n) for the fixed-size demo; more generally proportional to inputs tested | O(n) for demo data |

## Backend applications

- **Linked list:** Linked nodes are used to maintain insertion/removal order in internal scheduling and cache structures.
- **Stack:** A stack supports undo history, expression parsing, and nested request-processing contexts.
- **Queue:** Queues buffer incoming jobs and requests so backend workers can process them in arrival order.
- **Arrays and strings:** Two-pointer scanning and in-place transformations support efficient validation and data processing.
- **LRU cache:** LRU caching keeps recently accessed database or API results in memory and evicts stale entries when full.

## Behavior notes

- `findMiddle` returns the second middle item for even-length lists.
- `isAnagram` is case-sensitive and compares UTF-16 code units, including spaces.
- `twoSumSorted` returns zero-based indices or `[-1, -1]` if no pair exists; input must be sorted ascending.
- `rotateRight` supports negative `k` as a left rotation.
- `LRUCache.get` returns `-1` for a missing key and supports positive capacities only.
