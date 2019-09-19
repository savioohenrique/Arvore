package br.com.edb2.abb;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value){
        this.value = value;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

    public int getValue(){
        return value;
    }

    public void insert(Node node){
        if(node.value < this.value){
            if(this.left ==null){
                this.left = node;
            }else{
                this.left.insert(node);
            }
        }else if(node.value > this.value){
            if(this.right == null){
                this.right = node;
            }else{
                this.right.insert(node);
            }
        }
    }

    public Node search(int key){
        if(key == this.value){
            return this;
        }

        if(key < this.value){
            if(this.left != null){
                return this.left.search(key);
            }
        }

        if(key > this.value){
            if(this.right != null){
                return this.right.search(key);
            }
        }
        return null;
    }

    private boolean remove(int key, Node father) {
        Node node = search(key);
        if (node == null) {
            return false;
        }

        if(this == node){
            if (isLeaf()) {
                if (father != null) {
                    if (key > father.getValue()) {
                        father.right = null;
                    } else {
                        father.left = null;
                    }
                    return true;
                }
            } else if (hasOneChild()) {
                if (hasLeftChild()) {
                    this.value = node.left.getValue();
                    return this.left.remove(this.getValue(), this);
                } else {
                    this.value = node.right.getValue();
                    return this.right.remove(this.getValue(), this);
                }
            } else {
                Node auxiliar = checarFilhoMaisProximo(node.left);
                this.value = auxiliar.value;
                return this.left.remove(this.getValue(), this);
            }
        } else if (key > this.getValue()) {
            return this.right.remove(key, this);
        } else {
            return this.left.remove(key, this);
        }
        return false;
    }

    public boolean remove(int key) {
        return remove(key, null);
    }

    public Node checarFilhoMaisProximo(Node arvore){
        if(arvore.left == null){
            return arvore;
        }
        return checarFilhoMaisProximo(arvore.left);
    }

    private boolean hasRightChild() {
        return this.right != null;
    }

    private boolean hasLeftChild() {
        return this.left != null;
    }

    private boolean hasOneChild() {
        return (hasRightChild() == false && hasLeftChild()) || (hasRightChild() && hasLeftChild() == false);
    }

    private boolean isLeaf() {
        return this.hasRightChild() == false &&  this.hasLeftChild() == false ;
    }
}
