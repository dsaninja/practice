package com.dsaninja.linkedlists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * How to reverse a doubly linked list using iteration?
 * <pre>
 * Original: 1 —> 2 —> 3 —> 4 —> 5 —> null
 * Reversed: 5 —> 4 —> 3 —> 2 —> 1 —> null
 * </pre>
 * https://www.techiedelight.com/reverse-doubly-linked-list/
 */
public class ReverseDoubleLinkedList{

    private Node reverse(Node root){
        Node current = root;
        Node temp = null;

        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        return temp.prev;
    }

    @Test
    @DisplayName("test reversing a list")
    public void test(){
        Node root = init();
        printList(root);
        root = reverse(root);
        printList(root);
    }

    private void printList(Node root){
        StringBuilder result = new StringBuilder();
        while(root != null){
            result.append(root.data);
            if(null != root.next){
                result.append("->");
            }
            root = root.next;
        }
        System.out.println(result);
    }

    public Node init(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.next = two;

        two.prev = one;
        two.next = three;

        three.prev = two;
        three.next = four;

        four.prev = three;
        four.next = five;

        five.prev = four;

        return one;
    }

    static class Node{
        private Node next;
        private Node prev;
        private int data;

        public Node(int data){
            this.data = data;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }

        @Override
        public String toString(){
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
