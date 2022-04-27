public class BinaryTree<E extends Comparable<E>> {

    // only 1 Field
    private Node<E> mRoot;

    public BinaryTree()
    {
        mRoot = null;
    }

    public void clear()
    {
        mRoot = null;
        // Request garbage collection
        System.gc();
    }

    public boolean add(E element)
    {
        // Call recursive method at the root
        mRoot = addRecursive(mRoot, element);
        return true;
    }

    private Node<E> addRecursive(Node<E> current, E element)
    {
        // When current node is full / Leaf Node
        if (current == null)
            current = new Node(element);
        // If element is less than current nodes data
        else if (element.compareTo(current.mData) < 0)
            current.mLeft = addRecursive(current.mLeft, element);
        // If element is greater than current nodes data
        else if (element.compareTo(current.mData) > 0)
            current.mRight = addRecursive(current.mRight, element);

            return current;
    }

    @Override
    public String toString() {
        // 1 start at the root
        StringBuilder sb = new StringBuilder("[");
        inOrderTraverse(mRoot, sb);
        // Replace comma w ]
        sb.setCharAt(sb.length()-2, ']');
        // Print sb
        return sb.toString();
    }

    private void inOrderTraverse (Node current, StringBuilder sb)
    {
        // If we hit null stop
        if (current == null)
            return;
        // 1. Traverse Left (Recursion)
        inOrderTraverse(current.mLeft, sb);
        // 2. Visit Root
        sb.append(current.mData).append(", ");
        // 3. Traverse Right
        inOrderTraverse(current.mRight, sb);

    }

    // Nested inner class
    private class Node<E extends Comparable<E>>
    {
        private Node<E> mLeft;
        private E mData;
        private Node<E> mRight;

        public Node (E data, Node<E> left, Node<E> right)
        {
            mLeft = left;
            mRight = right;
            mData = data;
        }

        public Node (E data)
        {
            this(data, null, null);
        }

        public boolean isLeaf()
        {
            return (mLeft == null & mRight == null);
        }
    }


}
