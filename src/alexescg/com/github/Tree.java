package alexescg.com.github;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alex
 */
public class Tree<T> {
    private Node root;


    public Tree() {
        this.root = new Node(null);
        this.root.parent = null;
    }

    public void add(T val) {
        add(this.root, val);
    }

    private void add(Node current, T val) {
        if (current.children.isEmpty()) {
            Node child = new Node(val);
            child.parent = current;
            current.children.add(new Node(val));

        } else {
            Node child = new Node(val);
            child.parent = current;

//            add(current.children.);
//            if (current.children.) {
            //no esta vacio hijos, agregar nodo

        }
    }

    private class Node<T> {
        private Node parent;
        private List<Node<T>> children = new ArrayList<>();
        private T val;

        Node(T val) {
            this.val = val;
        }
    }

}
