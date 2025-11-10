package kio.week19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_길찾기게임 {
    private class Node {
        int val;
        int x;
        int y;
        Node left;
        Node right;
        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
    }
    void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    List<Integer> preorder, postorder;
    void find(Node node){
        if(node != null) {
            preorder.add(node.val);
            find(node.left);
            find(node.right);
            postorder.add(node.val);
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]); // i+1은 원래 입력 순서
        }
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y) return o1.x - o2.x;
            return o2.y - o1.y;
        });
        Node root = nodes[0];
        for(int i = 1; i < n; i++) {
            insertNode(root, nodes[i]);
        }
        preorder = new ArrayList<>();
        postorder = new ArrayList<>();
        find(root);
        return new int[][]{
                preorder.stream().mapToInt(i->i).toArray(),
                postorder.stream().mapToInt(i->i).toArray()
        };
    }
}
