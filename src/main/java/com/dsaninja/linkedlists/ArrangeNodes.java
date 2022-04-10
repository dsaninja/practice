package com.dsaninja.linkedlists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Given a linked list, split it into two lists where each list contains
 * alternating elements from the original list and then finally join them back together.
 *
 * <pre>
 * Input : 1 —> 2 —> 3 —> 4 —> 5 —> null
 * Output: 1 —> 3 —> 5 —> 2 —> 4 —> null
 * </pre>
 *
 * @author gaurs
 */
public class ArrangeNodes {
    private class Node{
        private int data;
        private Node next;

        @Override
        public String toString() {
            return data + "->";
        }
    }

    public Node arrange(Node head){
        int counter = 1;
        Node itr = head, firstHead = null, secondHead = null;
        Node firstItr = null, secondItr = null;

        while (itr != null){
            if(counter++ % 2 == 0){
                if(null == secondHead){
                    secondHead = itr;
                    secondItr = secondHead;
                }else {
                    secondItr.next = itr;
                    secondItr = secondItr.next;
                }
            }else{
                if(null == firstHead){
                    firstHead = itr;
                    firstItr = firstHead;
                }else {
                    firstItr.next = itr;
                    firstItr = firstItr.next;
                }
            }

            itr = itr.next;
        }

        secondItr.next = null;
        firstItr.next = secondHead;
        return firstHead;
    }

    // ******************************************************
    // ****************** Test Cases ************************
    // ******************************************************

    @Test
    @DisplayName("test sorting a binary array using sort by counting zeros")
    public void testList(){

        Node head = new Node();
        head.data = 1;

        Node one = new Node();
        one.data = 2;
        head.next = one;

        Node three = new Node();
        three.data = 3;
        one.next = three;

        Node four = new Node();
        four.data = 4;
        three.next = four;

        Node five = new Node();
        five.data = 5;
        four.next = five;

        print(head);
        System.out.println("");
        print(arrange(head));
    }

    private void print(Node head) {
        while (null != head){
            System.out.print(head);
            head = head.next;
        }
    }
}
