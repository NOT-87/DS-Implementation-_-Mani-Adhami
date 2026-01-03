class NodeRBT {
    int data;
    NodeRBT parent;
    NodeRBT left;
    NodeRBT right;
    int color; // 1 = RED, 0 = BLACK
}

public class RedBlackTree {
    private NodeRBT root;
    private NodeRBT TNULL;

    private void preOrderHelper(NodeRBT NodeRBT) {
        if (NodeRBT != TNULL) {
            System.out.print(NodeRBT.data + " ");
            preOrderHelper(NodeRBT.left);
            preOrderHelper(NodeRBT.right);
        }
    }

    private void inOrderHelper(NodeRBT NodeRBT) {
        if (NodeRBT != TNULL) {
            inOrderHelper(NodeRBT.left);
            System.out.print(NodeRBT.data + " ");
            inOrderHelper(NodeRBT.right);
        }
    }

    private void postOrderHelper(NodeRBT NodeRBT) {
        if (NodeRBT != TNULL) {
            postOrderHelper(NodeRBT.left);
            postOrderHelper(NodeRBT.right);
            System.out.print(NodeRBT.data + " ");
        }
    }

    private NodeRBT searchTreeHelper(NodeRBT NodeRBT, int key) {
        if (NodeRBT == TNULL || key == NodeRBT.data)
            return NodeRBT;
        if (key < NodeRBT.data)
            return searchTreeHelper(NodeRBT.left, key);
        return searchTreeHelper(NodeRBT.right, key);
    }

    private void fixDelete(NodeRBT x) {
        NodeRBT s;
        while (x != root && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;

                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;

                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0;
    }

    private void rbTransplant(NodeRBT u, NodeRBT v) {
        if (u.parent == null)
            root = v;
        else if (u == u.parent.left)
            u.parent.left = v;
        else
            u.parent.right = v;
        v.parent = u.parent;
    }

    private void deleteNodeRBTHelper(NodeRBT NodeRBT, int key) {
        NodeRBT z = TNULL, x, y;

        while (NodeRBT != TNULL) {
            if (NodeRBT.data == key)
                z = NodeRBT;
            if (NodeRBT.data <= key)
                NodeRBT = NodeRBT.right;
            else
                NodeRBT = NodeRBT.left;
        }

        if (z == TNULL) {
            System.out.println("Key not found");
            return;
        }

        y = z;
        int yOriginalColor = y.color;

        if (z.left == TNULL) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;

            if (y.parent == z)
                x.parent = y;
            else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (yOriginalColor == 0)
            fixDelete(x);
    }

    private void fixInsert(NodeRBT k) {
        NodeRBT u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root)
                break;
        }
        root.color = 0;
    }

    public RedBlackTree() {
        TNULL = new NodeRBT();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    public void insert(int key) {
        NodeRBT NodeRBT = new NodeRBT();
        NodeRBT.data = key;
        NodeRBT.left = TNULL;
        NodeRBT.right = TNULL;
        NodeRBT.color = 1;

        NodeRBT y = null;
        NodeRBT x = root;

        while (x != TNULL) {
            y = x;
            if (NodeRBT.data < x.data)
                x = x.left;
            else
                x = x.right;
        }

        NodeRBT.parent = y;
        if (y == null)
            root = NodeRBT;
        else if (NodeRBT.data < y.data)
            y.left = NodeRBT;
        else
            y.right = NodeRBT;

        if (NodeRBT.parent == null) {
            NodeRBT.color = 0;
            return;
        }

        if (NodeRBT.parent.parent == null)
            return;

        fixInsert(NodeRBT);
    }

    /* ===== UI helpers ===== */

    public boolean search(int key) {
        return searchTreeHelper(root, key) != TNULL;
    }

    public void inorder() {
        inOrderHelper(root);
    }

    public void preorder() {
        preOrderHelper(root);
    }

    public void postorder() {
        postOrderHelper(root);
    }

    public NodeRBT minimum(NodeRBT NodeRBT) {
        while (NodeRBT.left != TNULL)
            NodeRBT = NodeRBT.left;
        return NodeRBT;
    }

    public NodeRBT getRoot() {
        return root;
    }

    public void leftRotate(NodeRBT x) {
        NodeRBT y = x.right;
        x.right = y.left;
        if (y.left != TNULL)
            y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    public void rightRotate(NodeRBT x) {
        NodeRBT y = x.left;
        x.left = y.right;
        if (y.right != TNULL)
            y.right.parent = x;

        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;

        y.right = x;
        x.parent = y;
    }
}
