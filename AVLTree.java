class NodeAVL {
    int item, height;
    NodeAVL left, right;

    NodeAVL(int d) {
        item = d;
        height = 1;
    }
}


class AVLTree {
    NodeAVL root;

    int height(NodeAVL N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    NodeAVL rightRotate(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    NodeAVL leftRotate(NodeAVL x) {
        NodeAVL y = x.right;
        NodeAVL T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    int getBalanceFactor(NodeAVL N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    NodeAVL insertNodeAVL(NodeAVL NodeAVL, int item) {

        // Find the position and insert the NodeAVL
        if (NodeAVL == null)
            return (new NodeAVL(item));
        if (item < NodeAVL.item)
            NodeAVL.left = insertNodeAVL(NodeAVL.left, item);
        else if (item > NodeAVL.item)
            NodeAVL.right = insertNodeAVL(NodeAVL.right, item);
        else
            return NodeAVL;

        NodeAVL.height = 1 + max(height(NodeAVL.left), height(NodeAVL.right));
        int balanceFactor = getBalanceFactor(NodeAVL);
        if (balanceFactor > 1) {
            if (item < NodeAVL.left.item) {
                return rightRotate(NodeAVL);
            } else if (item > NodeAVL.left.item) {
                NodeAVL.left = leftRotate(NodeAVL.left);
                return rightRotate(NodeAVL);
            }
        }
        if (balanceFactor < -1) {
            if (item > NodeAVL.right.item) {
                return leftRotate(NodeAVL);
            } else if (item < NodeAVL.right.item) {
                NodeAVL.right = rightRotate(NodeAVL.right);
                return leftRotate(NodeAVL);
            }
        }
        return NodeAVL;
    }

    NodeAVL NodeAVLWithMimumValue(NodeAVL NodeAVL) {
        NodeAVL current = NodeAVL;
        while (current.left != null)
            current = current.left;
        return current;
    }

    NodeAVL deleteNodeAVL(NodeAVL root, int item) {

        if (root == null)
            return root;
        if (item < root.item)
            root.left = deleteNodeAVL(root.left, item);
        else if (item > root.item)
            root.right = deleteNodeAVL(root.right, item);
        else {
            if ((root.left == null) || (root.right == null)) {
                NodeAVL temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                NodeAVL temp = NodeAVLWithMimumValue(root.right);
                root.item = temp.item;
                root.right = deleteNodeAVL(root.right, temp.item);
            }
        }
        if (root == null)
            return root;


        root.height = max(height(root.left), height(root.right)) + 1;
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.left) >= 0) {
                return rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(root.right) <= 0) {
                return leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    void preOrder(NodeAVL NodeAVL) {
        if (NodeAVL != null) {
            System.out.print(NodeAVL.item + " ");
            preOrder(NodeAVL.left);
            preOrder(NodeAVL.right);
        }
    }

    private void printTree(NodeAVL currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.item);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }
}