package ru.otus.java.basic.homeworks.homework11.searchtree;

import java.util.List;

public class SearchTreeImpl implements SearchTree <Comparable>{
    private Node root;

    public SearchTreeImpl() {
        root = null;
    }

    public void insertAll(List<Comparable> list) {
        list.forEach(this::insert);

    }

    public void insert(Comparable item) {
        Node newnode = new Node();
        newnode.setValue(item);
        if (root == null) {
            root = newnode;
        } else {
            Node currentNode = root;
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if (item.compareTo(currentNode.getValue()) == 0) {
                    return;
                }
                if (item.compareTo(currentNode.getValue()) < 0) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(newnode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newnode);
                        return;
                    }
                }
            }


        }
    }

    public Comparable find(Comparable item) {
        return find(item, root);
    }

    private Comparable find(Comparable item, Node node) {
        Node currentNode = node;
        if (node == null) return null;
        if (currentNode.getValue().equals(item)) {
            return item;
        }
        if (currentNode.getValue().compareTo(item) < 0) {
            return find(item, currentNode.getRight());
        } else {
            return find(item, currentNode.getLeft());
        }

    }

    @Override
    public List<Comparable> getSortedList() {


        return null;
    }
}
