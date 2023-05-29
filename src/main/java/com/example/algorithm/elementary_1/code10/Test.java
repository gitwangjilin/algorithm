package com.example.algorithm.elementary_1.code10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("1", "10", "13"));
        userList.add(new User("2", "10", "37"));
        userList.add(new User("400", "500", "37"));
        userList.add(new User("2", "2", "3"));
        userList.add(new User("4", "2", "42"));
        System.out.println(mergeUsers(userList));;
    }

    // (1,10,13) (2,10,37) (400,500,37)
    // 如果两个user，a字段一样、或者b字段一样、或者c字段一样，就认为是一个人
    // 请合并users，返回合并之后的用户数量
    public static int mergeUsers(List<User> users) {
        UnionSet<User> unionFind = new UnionSet<>(users);
        HashMap<String, User> mapA = new HashMap<>();
        HashMap<String, User> mapB = new HashMap<>();
        HashMap<String, User> mapC = new HashMap<>();
        for (User user : users) {
            if (mapA.containsKey(user.a)) {
                unionFind.union(user, mapA.get(user.a));
            } else {
                mapA.put(user.a, user);
            }
            if(mapB.containsKey(user.b)) {
                unionFind.union(user, mapB.get(user.b));
            }else {
                mapB.put(user.b, user);
            }
            if(mapC.containsKey(user.c)) {
                unionFind.union(user, mapC.get(user.c));
            }else {
                mapC.put(user.c, user);
            }
        }
        // 向并查集询问，合并之后，还有多少个集合？
        return unionFind.getSetNum();
    }

    public static class User {
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static class Node<v> {
        v value;

        public Node(v value) {
            this.value = value;
        }
    }

    /**
     * 初始化并查集
     *
     * @param <v>
     */
    public static class UnionSet<v> {
        //所有节点
        public HashMap<v, Node<v>> nodes = new HashMap<>();
        //父节点
        public HashMap<Node<v>, Node<v>> parents = new HashMap<>();
        // 只有一个点，它的代表点，才有记录
        public HashMap<Node<v>, Integer> sizeMap = new HashMap<>();

        /**
         * 合并集合
         *
         * @param values
         */
        public UnionSet(List<v> values) {
            for (v cur : values) {
                Node<v> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 判断是否是一个集合
         *
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(v a, v b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public int getSetNum() {
            return sizeMap.size();
        }
        /**
         * 找到父节点
         *
         * @param cur
         * @return
         */
        private Node<v> findFather(Node<v> cur) {
            Stack<Node<v>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        /**
         * 合并
         *
         * @param a
         * @param b
         */
        public void union(v a, v b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<v> aHead = findFather(nodes.get(a));
            Node<v> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<v> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<v> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }
        }
    }
}
