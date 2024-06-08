package entities;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private Map<Character, Node> children;

    public Node() {
        this.children = new HashMap<>();
    }

    public Map<Character, Node> getChildren() {
        return children;
    }
}
