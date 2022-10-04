package com.example.algorithm.elementary_1.code05;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Code02_TrieTreeTest
 * - @Author: WangJiLIn
 * - Description: 前缀树
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/27   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Code02_TrieTreeTest {

    public static void main(String[] args) {
        String[] strs = {"adffa", "adffan", "cafd", "a", "ad", "ad", "ad", "ad"};
        for (int i = 0; i < strs.length; i++) {
            Trie_1.insert(strs[i]);
//            Trie_1.prefixNumber(strs[i]);
        }
        int a = Trie_1.search("ad");
        int pro = Trie_1.prefixNumber("a");
        System.out.println(pro);
    }

}

class Trie_1 {
    private static Node1 root = new Node1();

    /**
     * 前缀树整理数据结构
     *
     * @param pre
     */
    static int prefixNumber(String pre) {
        //判断字符串不能为空
        if (pre == null) {
            return 0;
        }
        char[] chs = pre.toCharArray();
        Node1 node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            //得到0到25
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
            return node.pass;
        }
        return 0;
    }

    /**
     * 数组中插入数据
     *
     * @param word
     */
    public static void insert(String word) {
        if (word == null) {
            return;
        }
        char[] str = word.toCharArray();
        Node1 node = root;
        node.pass++;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new Node1();
            }
            node = node.nexts[path];
            node.pass++;

        }
        node.end++;
    }

    /**
     * 查找相同个数
     *
     * @param word
     * @return
     */
    public static int search(String word) {
        if (word == null) {
            return 0;
        }
        char[] chars = word.toCharArray();
        Node1 node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }


    public void delete(String word) {
        if (search(word) != 0) {
            char[] chs = word.toCharArray();
            Node1 node = root;
            node.pass--;
            int path = 0;
            for (int i = 0; i < chs.length; i++) {
                path = chs[i] - 'a';
                if (--node.nexts[path].pass == 0) {
                    node.nexts[path] = null;
                    return;
                }
                node = node.nexts[path];
            }
            node.end--;
        }
    }
}

class Node1 {
    /**
     * 开始位置
     */
    public int pass;
    /**
     * 结束位置
     */
    public int end;
    /**
     * 数组
     */
    public Node1[] nexts;

    public Node1() {
        this.pass = 0;
        this.end = 0;
        this.nexts = new Node1[26];
    }
}