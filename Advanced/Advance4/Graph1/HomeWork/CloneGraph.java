package Graph1.HomeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public static void main(String[] args) {
        
    }
    //https://leetcode.com/problems/clone-graph/description/
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node==null) return null;

        HashMap<Node, Node> hm = new HashMap<>();
        return dfs(node, hm);
    }


    Node dfs(Node node, HashMap<Node, Node> hm){
        if(hm.containsKey(node)) return hm.get(node);

        Node clone = new Node(node.val);
        hm.put(node, clone);

        for(Node nei: node.neighbors){
            clone.neighbors.add(dfs(nei, hm));
        }
        return clone;
    }
}
