package br.com.edb2.abb;

public class ArvoreBinariaBusca {
    private Node raiz = null;

    public boolean isEmpty(){
        return raiz == null;
    }

    public Node getRoot(){
        return raiz;
    }

    public void insert(Node node){
        if(raiz == null){
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(int value){
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int key){
        if(raiz == null){
            return null;
        }
        return raiz.search(key);
    }

    public boolean remove(int key){
        if(raiz == null){
            //A árvore não possui nenhum nó
            return false;
        }
        if(raiz.getValue() == key){
            if(raiz.getLeft() == null && raiz.getRight() == null){
                //No raiz folha removido
                raiz = null;
                return true;
            }
        }
        return raiz.remove(key);
    }
}
