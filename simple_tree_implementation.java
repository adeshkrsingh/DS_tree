import java.util.*;
import java.io.*;

class SimpleTree {
    Node head;
    class Node {
        Node left, right;
        int data;

        Node(int d) {
            this.left = null;
            this.right = null;
            this.data = d;
        }
    }

    public void insert(int d) {
        head = insert_node(head, d);
    }
    public Node insert_node(Node node, int d) {
        if(node == null) {
            return new Node(d);
        }

        if(d < node.data) {
            node.left = insert_node(node.left , d);
        } else {
            node.right = insert_node(node.right, d);
        }
        return node;
    }
    public void traverse() {
        Node n = node_traverse(head);
    }

    public Node node_traverse(Node node) {
        if(node == null) {
            return;
        }

        node_traverse(node.left);
        System.out.println("node data : " + node.data);
        node_traverse(node.right);
        return;
    }

    public static void main(String[] args) {
        SimpleTree st = new SimpleTree();
        st.insert(10);
        st.insert(20);
        st.insert(15);
        st.insert(60);
        st.insert(22);
        st.insert(19);

        st.traverse();
    }
}