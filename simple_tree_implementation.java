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
        System.out.println();
    }
    public Node insert_node(Node node, int d) {
        if(node == null) {
            System.out.print(" inserting : " + d);
            return new Node(d);
        }

        if(d < node.data) {
            System.out.print(" <-- ");
            node.left = insert_node(node.left , d);
        } else {
            System.out.print(" --> ");
            node.right = insert_node(node.right, d);
        }
        return node;
    }
    public void node_traverse_inorder(Node node) {
        // A+B
        if(node == null) {
           return;
        }
        node_traverse_inorder(node.left);
        System.out.println("node data : " + node.data);
        node_traverse_inorder(node.right);
    }
    public void node_traverse_preorder(Node node) {
        // +AB
        if(node == null) {
           return;
        }
        System.out.println("node data : " + node.data);
        node_traverse_preorder(node.left);
        node_traverse_preorder(node.right);
    }
    public void node_traverse_postorder(Node node) {
        // AB+
        if(node == null) {
           return;
        }
        node_traverse_postorder(node.left);
        node_traverse_postorder(node.right);
        System.out.println("node data : " + node.data);
    }
    public void traverse_inorder() {
        // A+B
        System.out.println("------ Inorder traversal -------");
        node_traverse_inorder(head);
    }
    public void traverse_preorder() {
        // +AB
        System.out.println("------- Preorder traversal --------");
        node_traverse_preorder(head);
    }
    public void traverse_postorder() {
        // AB+
        System.out.println("------- Postorder traversal -------");
        node_traverse_postorder(head);
    }

    public static void main(String[] args) {
        SimpleTree st = new SimpleTree();
        st.insert(10);
        st.insert(20);
        st.insert(15);
        st.insert(60);
        st.insert(22);
        st.insert(19);

        st.traverse_inorder();
        st.traverse_preorder();
        st.traverse_postorder();
    }
}