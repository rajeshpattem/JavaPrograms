public class Main {
    public static void main(String[] args) {
        int[] elements = {5, 3, 8, 1, 4};

        BinarySearchTree bst = new BinarySearchTree();
        for (int element : elements) {
            bst.insert(element);
        }

        System.out.println("Searching for 4: " + bst.search(4));
        System.out.println("Searching for 9: " + bst.search(9));
    }
}