package ru.otus.java.basic.homeworks.homework11.searchtree;

import java.util.List;

public class SearchTreeImpl  {
    private Node root;

    public SearchTreeImpl() {
        root = null;
    }

    public void insertAll(List<Comparable> list) {
        if (list.isEmpty()) return;
        if (list.size() == 1) {
            insert(list.get(0));
            return;
        }
        int middle = list.size() / 2;
        insert(list.get(middle));
        insertAll(list.subList(0, middle));
        insertAll(list.subList(middle + 1, list.size()));


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


    public List<Comparable> getSortedList() {


        return null;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node == null) { System.out.println(); return;}
        System.out.print(node.getValue() + "-->");
        printTree(node.getLeft());
        printTree(node.getRight());
    }
}
