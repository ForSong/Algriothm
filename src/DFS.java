import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 深度优先搜索实现
 *
 * @author Zhizhuo Song
 * @version 2020/3/29
 */
public class DFS {
    // 建立整数id 和 对应这个整数id 的Node 的映射
    private HashMap<Integer, Node> nodeLookup = new HashMap<>();
    // 定义结点的数据结构
    public static class Node{
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();
        public Node(int id) {
            this.id = id;
        }
    }
    // 这个方法用于取出整数对应的节点
    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    public void addEdge(int start, int destination) {
        Node s = getNode(start);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathBFS(int start, int destination) {
        Node s = getNode(start);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathBFS(s, d, visited);
    }

    private boolean hasPathBFS(Node s, Node d, HashSet<Integer> visited) {
        // 已经包含了开始节点，说明没有路径
        // ?
        if (visited.contains(s)) {
            return false;
        }
        visited.add(s.id);
        if (s == d) {
            return true;
        }
        for (Node child : s.adjacent) {
            if (hasPathBFS(child, d, visited)) {
                return true;
            }
        }
        return false;
    }

}


