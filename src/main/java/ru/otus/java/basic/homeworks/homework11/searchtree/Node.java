package ru.otus.java.basic.homeworks.homework11.searchtree;

public class Node implements Comparable<Node> {
    private Comparable value;
    private Node left;
    private Node right;

    public Comparable getValue() {
        return value;
    }

    public void setValue(Comparable value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
            "value=" + value +
            ", left=" + left +
            ", right=" + right +
            '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value.compareTo(o.getValue());
    }
}
