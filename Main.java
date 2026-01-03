import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Stack");
            System.out.println("2. Queue (Circular)");
            System.out.println("3. Binary Search Tree");
            System.out.println("4. AVL Tree");
            System.out.println("5. Red Black Tree");
            System.out.println("6. Trie");
            System.out.println("7. Max-heap");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int c = sc.nextInt();
            if (c == 0) break;

            switch (c) {
                case 1: stackUI(); break;
                case 2: queueUI(); break;
                case 3: bstUI(); break;
                case 4: avlUI(); break;
                case 5: rbtUI(); break;
                case 6: trieUI(); break;
                case 7: heapUI(); break;
                default: System.out.println("Invalid choice");
            }
        }
    }

    /* ================= STACK ================= */

    static void stackUI() {
        System.out.print("Stack size: ");
        Stack stack = new Stack(sc.nextInt());

        while (true) {
            System.out.println("\n--- Stack ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Is Full");
            System.out.println("6. Print Stack");
            System.out.println("0. Back");

            int c = sc.nextInt();
            if (c == 0) break;

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(stack.peek());
                    break;
                case 4:
                    System.out.println(stack.isEmpty());
                    break;
                case 5:
                    System.out.println(stack.isFull());
                    break;
                case 6:
                    stack.printStack();
                    System.out.println();
                    break;
            }
        }
    }

    /* ================= QUEUE ================= */

    static void queueUI() {
        System.out.print("Queue size: ");
        Queue queue = new Queue(sc.nextInt());

        while (true) {
            System.out.println("\n--- Circular Queue ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Is Full");
            System.out.println("6. Print Queue");
            System.out.println("0. Back");

            int c = sc.nextInt();
            if (c == 0) break;

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                case 4:
                    System.out.println(queue.isEmpty());
                    break;
                case 5:
                    System.out.println(queue.isFull());
                    break;
                case 6:
                    queue.printQueue();
                    System.out.println();
                    break;
            }
        }
    }

    /* ================= BST ================= */

    static void bstUI() {
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            System.out.println("\n--- BST ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Inorder");
            System.out.println("4. Preorder");
            System.out.println("5. Postorder");
            System.out.println("0. Back");

            int c = sc.nextInt();
            if (c == 0) break;

            int v;
            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    bst.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Search value: ");
                    v = sc.nextInt();
                    System.out.println(bst.search(v));
                    break;
                case 3:
                    bst.inorder();
                    System.out.println();
                    break;
                case 4:
                    bst.preorder();
                    System.out.println();
                    break;
                case 5:
                    bst.postorder();
                    System.out.println();
                    break;
            }
        }
    }

    /* ================= AVL ================= */

    static void avlUI() {
        AVLTree avl = new AVLTree();

        while (true) {
            System.out.println("\n--- AVL Tree ---");
            System.out.println("1. Insert");
            System.out.println("2. Preorder");
            System.out.println("3. Height");
            System.out.println("0. Back");

            int c = sc.nextInt();
            if (c == 0) break;

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    avl.root = avl.insertNodeAVL(avl.root, sc.nextInt());
                    break;
                case 2:
                    avl.preOrder(avl.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println(avl.height(avl.root));
                    break;
            }
        }
    }

    /* ================= RED BLACK ================= */

    static void rbtUI() {
        RedBlackTree rbt = new RedBlackTree();

        while (true) {
            System.out.println("\n--- Red Black Tree ---");
            System.out.println("1. Insert");
            System.out.println("2. Inorder");
            System.out.println("3. Search");
            System.out.println("0. Back");

            int c = sc.nextInt();
            if (c == 0) break;

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    rbt.insert(sc.nextInt());
                    break;
                case 2:
                    rbt.inorder();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Search value: ");
                    System.out.println(rbt.search(sc.nextInt()));
                    break;
            }
        }
    }

    /* ================= TRIE ================= */

    static void trieUI() {
        Trie trie = new Trie();

        while (true) {
            System.out.println("\n--- Trie ---");
            System.out.println("1. Insert word");
            System.out.println("2. Search word");
            System.out.println("3. Starts with");
            System.out.println("4. Delete word");
            System.out.println("5. Print all words");
            System.out.println("0. Back");

            int c = sc.nextInt();
            if (c == 0) break;

            String s;
            switch (c) {
                case 1:
                    System.out.print("Word: ");
                    trie.insert(sc.next());
                    break;
                case 2:
                    System.out.print("Word: ");
                    System.out.println(trie.search(sc.next()));
                    break;
                case 3:
                    System.out.print("Prefix: ");
                    System.out.println(trie.startsWith(sc.next()));
                    break;
                case 4:
                    System.out.print("Word: ");
                    trie.delete(sc.next());
                    break;
                case 5:
                    trie.print();
                    break;
            }
        }
    }


    /* ================= MAX HEAP ================= */

    static void heapUI() {
        Heap heap = new Heap();
        ArrayList<Integer> arr = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Max Heap ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Print Heap");
            System.out.println("0. Back");

            int c = sc.nextInt();
            if (c == 0) break;

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    heap.insert(arr, sc.nextInt());
                    break;
                case 2:
                    System.out.print("Value to delete: ");
                    heap.deleteNode(arr, sc.nextInt());
                    break;
                case 3:
                    heap.printArray(arr);
                    break;
            }
        }
    }


}
