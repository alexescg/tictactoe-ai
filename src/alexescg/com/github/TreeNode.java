package alexescg.com.github;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alex
 */
class TreeNode<T> {
    private T data = null;
    private List<TreeNode<T>> children = new ArrayList<>();
    private TreeNode<T> parent = null;

    TreeNode(T data) {
        this.data = data;
    }


    void addChild(TreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        TreeNode<T> newChild = new TreeNode<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(List<TreeNode<T>> children) {
        for (TreeNode<T> t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }

    public boolean hasChildren() {
        return this.getChildren().size() > 0;
    }

    public TreeNode<T> getChild(T val) {
        for (TreeNode<T> child : this.getChildren()) {
            if (child.data.equals(val)) {
                return child;
            }
        }
        return null;
    }
}
