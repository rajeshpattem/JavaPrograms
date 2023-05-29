public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(5);
        tree.insertNode(root, 2);
        tree.insertNode(root, 4);
        tree.insertNode(root, 8);
        tree.insertNode(root, 7);
        tree.insertNode(root, 7);
        tree.insertNode(root, 3);
        tree.insertNode(root, 9);

        tree.traverseTree(root);
    }
}

class Node {

    int value; //data stored as type int
    Node left, right; //reference to left and right pointer

    Node(int value) { //constructor
        this.value = value;
        // store null value for left and right child
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node rootNode;

    public void traverseTree(Node root) {
        if (root != null) {
            traverseTree(root.left);
            System.out.println(root.value);
            traverseTree(root.right);
        }
    }

    public void insertNode(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
                System.out.println("Inserted " + value + " to left of " + node.value);
            } else {
                insertNode(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                System.out.println("Inserted " + value + " to right of " + node.value);
            } else {
                insertNode(node.right, value);
            }
        }

    }
}

