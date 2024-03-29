
// 1. You are given a partially written GenericTree class.
// 2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.
// 3. Input and Output is managed for you.
import java.io.*;
import java.util.*;

public class IterativePreorderAndPostorderOfGenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    static class Pair {
        Node node;
        int state;

        // construcotr
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        // write your code here
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));

        String pre = "";
        String post = "";

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == -1) {
                pre += top.node.data + " ";
                top.state++;
            } else if (top.state == top.node.children.size()) {
                post += top.node.data + " ";
                st.pop();
            } else {
                Pair cp = new Pair(top.node.children.get(top.state), -1);
                st.push(cp);
                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        IterativePreandPostOrder(root);
    }

}