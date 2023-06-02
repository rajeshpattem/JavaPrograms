import java.util.Optional;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a new value into the binary search tree.
     * @param value the value to be inserted
     */
    public void insert(int value) {
        // Use Optional to handle null checks
        root = Optional.ofNullable(root)
                // If the root is not null, call insertNode recursively
                .map(node -> insertNode(node, value))
                // If the root is null, create a new node as the root
                .orElse(new Node(value));
    }

    /**
     * Recursively inserts a new value into the binary search tree.
     * @param current the current node being evaluated
     * @param value the value to be inserted
     * @return the modified node after insertion
     */
    private Node insertNode(Node current, int value) {
        // If the current node is null, create a new node with the value
        if (current == null) {
            return new Node(value);
        }

        // If the value is less than the current node's value, go to the left
        if (value < current.value) {
            current.left = insertNode(current.left, value);
        }
        // If the value is greater than the current node's value, go to the right
        else if (value > current.value) {
            current.right = insertNode(current.right, value);
        }

        return current;
    }

    /**
     * Searches for a value in the binary search tree.
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean search(int value) {
        return searchNode(root, value);
    }

    /**
     * Recursively searches for a value in the binary search tree.
     * @param current the current node being evaluated
     * @param value the value to search for
     * @return true if the value is found, false otherwise
     */
    private boolean searchNode(Node current, int value) {
        // If the current node is null, the value is not found
        if (current == null) {
            return false;
        }

        // If the value matches the current node's value, return true
        if (value == current.value) {
            return true;
        }
        // If the value is less than the current node's value, go to the left
        else if (value < current.value) {
            return searchNode(current.left, value);
        }
        // If the value is greater than the current node's value, go to the right
        else {
            return searchNode(current.right, value);
        }
    }
}


