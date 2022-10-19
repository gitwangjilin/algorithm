package com.example.algorithm.elementary_1.code02;

public class LinkedListTest {
    public static void main(String[] args) {
        LikedList likedList = new LikedList();
        likedList.addNode(new Node(1, "小王"));
        likedList.addNode(new Node(2, "小罗"));
        likedList.addNode(new Node(3, "小王1"));
        likedList.addNode(new Node(4, "小王2"));
        likedList.look();
        System.out.println("==========");
//        likedList.reversal();
//        likedList.look();
        likedList.findLastIndexNode(1);
    }

}

class LikedList {
    public static Node tempNode = new Node(-1, "");

    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        Node help = tempNode;
        while (help.next != null) {
            help = help.next;
        }
        help.next = node;
    }

    public void look() {
        if (tempNode == null) {
            return;
        }
        Node heal = tempNode;
        while (heal.next != null) {
            System.out.println(heal.next);
            heal = heal.next;
        }
    }

    public void reversal() {
        if (tempNode.next == null || tempNode.next.next == null) {
            return;
        }

        Node cur = tempNode.next;
        Node pro = new Node(-1, "");
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pro.next;
            pro.next = cur;
            cur = next;
        }
        tempNode.next = pro.next;
    }

    public void findLastIndexNode(int index) {
        if (tempNode.next == null) {
            return;
        }
        int count = 1;
        Node heal = tempNode;
        while (heal.next != null) {
            count++;
            heal = heal.next;
        }
        Node heal1 = tempNode;
        int abs = Math.abs(index - count);
        int count1 = 1;
        if (count >= index) {
            while (heal1.next != null) {
                count1++;
                if (count1 == abs) {
                    System.out.println(heal1);
                }


                heal1 = heal1.next;
            }
        } else {
            System.out.println("超了");
            return;
        }
        System.out.println(count);
    }
}

class Node {
    public int id;
    public String name;
    public Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}