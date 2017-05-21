package alexescg.com.github;

import java.util.Collection;
import java.util.List;

/**
 * @author alex
 */
public class Tree<T> {
    private TreeNode<T> root;


    public Tree() {
        this.root = new TreeNode<>(null);
    }

    public void addCollection(Collection<T> collection) {
        TreeNode<T> current = root;
        for (T element : collection) {
            System.out.println(element);
            TreeNode<T> newNode = new TreeNode<>(element);
            newNode.setParent(current);
            current.addChild(newNode);
            current = newNode;
        }
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }


}
