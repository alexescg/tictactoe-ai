package alexescg.com.github;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alex
 */
public class Tree<T> {
    private Node root;


    public Tree() {
        this.root = new Node(null, null);
        this.root.parent = null;
    }

    public void add(T val) {
        add(this.root, val);
    }

    private void add(Node current, T val) {
        if (current.children.isEmpty()) {
            current.children.add(new Node(current, val));
        } else if (true) {
            //no esta vacio hijos, agregar nodo

        }
    }

    private class Node {
        private Node parent;
        private List<Node> children = new ArrayList<>();
        private T val;

        public Node(Node parent, T val) {
            this.parent = parent;
            this.val = val;
        }
    }

}
