package ru.otus.java.basic.homeworks.homework11.searchtree;

import java.util.ArrayList;
import java.util.List;

public class SearchTreeImpl implements SearchTree {
    private Node root;

    public SearchTreeImpl() {
        root = null;
    }

    public <T extends Comparable<T>> void insertAll(List<T> list) {
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
            return;
        }

        Node currentNode = root;
        Node parentNode;

        while (true) {
            parentNode = currentNode;
            if (newnode.compareTo(currentNode) == 0) {
                return;
            }
            if (newnode.compareTo(currentNode) < 0) {
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

    @Override
    public Object find(Object item) {
        return find((Comparable) item, root);
    }

    private Comparable find(Comparable item, Node node) {
        if (node == null) return null;
        if (node.getValue().equals(item)) {
            return item;
        }
        if (node.getValue().compareTo(item) < 0) {
            return find(item, node.getRight());
        } else {
            return find(item, node.getLeft());
        }

    }


    public List<Object> getSortedList() {
        return getSortedList(root);
    }

    private List<Object> getSortedList(Node node) {
        if (node == null) return new ArrayList<>();
        List<Object> result = getSortedList(node.getLeft());
        result.add(node.getValue());
        result.addAll(getSortedList(node.getRight()));
        return result;


    }

}
