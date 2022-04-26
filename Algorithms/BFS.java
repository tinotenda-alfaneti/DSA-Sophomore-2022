package Algorithms;

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;

public class BFS<T> {

    public static class Node<T> {
 
        private T data = null;
        private List<Node<T>> children = new LinkedList<>();
        private Node<T> parent = null;
         
        public Node(T data) {
            this.data = data;
        }
         
        public Node<T> addChild(Node<T> child) {
            child.setParent(this);
            this.children.add(child);
            return child;
        }
         
        public void addChildren(List<Node<T>> children) {
            children.forEach(each -> each.setParent(this));
            this.children.addAll(children);
        }
         
        public List<Node<T>> getChildren() {
            return children;
        }
         
        public T getData() {
            return data;
        }
         
        public void setData(T data) {
            this.data = data;
        }
         
        private void setParent(Node<T> parent) {
            this.parent = parent;
        }
         
        public Node<T> getParent() {
            return parent;
        }
         
    }


    public void bfsSearch (Node<T> root) {
        Queue<Node<T>> queue = new LinkedList<>();
        HashSet<Node<T>> seen = new HashSet<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node<T> current = queue.poll();
            if (!seen.contains(current)) {
                seen.add(current);
                System.out.println(current.getData()); // Do what you want with the Node

            };
            for (Node<T> adjacent: current.getChildren()) {
                if (!seen.contains(adjacent)) {
                    queue.add(adjacent);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);
        
        Node<Integer> child = new Node<>(50);
        root.addChild(child);
        Node<Integer> sec_child = new Node<>(60);
        child.addChild(sec_child);

        List<Node<Integer>> children = new LinkedList<>();
        children.add(new Node<Integer>(20));
        children.add(new Node<Integer>(30));
        children.add(new Node<Integer>(40));
        root.addChildren(children);
    

        BFS<Integer> test = new BFS<>();
        test.bfsSearch(root);
    
    }
    

}