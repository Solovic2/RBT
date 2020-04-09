package eg.edu.alexu.csd.filestructure.redblacktree;

import java.awt.*;

public class myNode <T extends Comparable<T>, V> implements INode<T,V> {
    myNode left,right;
    T key;
    V val;
    boolean color;
    myNode (T key, V val,boolean c){
        left=null;
        right=null;
        this.key=key;
        this.val=val;
        this.color=c;
    }

    myNode root=null;
    @Override
    public void setParent(INode<T, V> parent) {
        root= new myNode(parent.getKey(),parent.getValue(),parent.getColor());
        root= (myNode) parent;
    }

    @Override
    public INode<T, V> getParent() {
        if(root!=null) {
            return root;
        }
        return null;
    }

    @Override
    public void setLeftChild(INode<T, V> leftChild) {
        if(root.left!=null) {
//            root.left = (myNode) leftChild;
                root.left.val=leftChild.getValue();
                root.left.key=leftChild.getKey();
                root.left.color=leftChild.getColor();
        }
    }

    @Override
    public INode<T, V> getLeftChild() {
        if(root.left!=null) {
            return root.left;
        }
        return null;
    }

    @Override
    public void setRightChild(INode<T, V> rightChild) {
        if(root.right!=null) {
//            root.right = (myNode) rightChild;
            root.right.val=rightChild.getValue();
            root.right.key=rightChild.getKey();
            root.right.color=rightChild.getColor();
        }
    }

    @Override
    public INode<T, V> getRightChild() {
        if(root.right!=null) {
            return root.right;
        }
        return null;
    }

    @Override
    public T getKey() {
        if(root.key !=null) return (T) root.key;
        return null;
    }

    @Override
    public void setKey(T key) {
        if(root.key !=null)root.key=key;
    }

    @Override
    public V getValue() {
        return (V) root.val;
    }

    @Override
    public void setValue(V value) {
        root.val=value;
    }

    @Override
    public boolean getColor() {
        return root.color;
    }

    @Override
    public void setColor(boolean color) {
        root.color=color;
    }
    @Override
    public boolean isNull() {
        if(root!=null) return true;
        return false;
    }
}
