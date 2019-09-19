package br.com.edb2.abb;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        arvore.insert(new Node(15));
        arvore.insert(13);
        arvore.insert(4);
        arvore.insert(8);
        arvore.insert(20);
        arvore.insert(17);
        arvore.insert(19);

        JFrame frame = new JFrame("Visualizador de ABB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        ArvoreBinariaBuscaView view = new ArvoreBinariaBuscaView(arvore);
        frame.add(view);

        //Remove
        arvore.remove(13);
        arvore.remove(20);

        frame.setVisible(true);
    }
}
