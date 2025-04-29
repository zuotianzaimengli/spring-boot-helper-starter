package org.mengq.dfa.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author meng
 * @Date 2025/4/25 17:48
 * @Description TODO
 */
public class Node {

    private Map<Character,Node> children;

    private boolean isEnd;

    public Node() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    public Node(Map<Character, Node> children, boolean isEnd) {
        this.children = children;
        this.isEnd = isEnd;
    }


    public Map<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, Node> children) {
        this.children = children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
