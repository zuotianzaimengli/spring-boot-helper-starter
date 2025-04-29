package org.mengq.dfa.trie;

import org.mengq.dfa.model.Node;
import org.mengq.dfa.util.PinyinUtil;

import java.util.List;

/**
 * @Author meng
 * @Date 2025/4/25 17:53
 * @Description TODO
 */
public class TrieWrapper {

    private final Node root;

    public TrieWrapper(){
        this.root = new Node();
    }

    public Node getRoot(){
        return root;
    }

    public void build(List<String> words){
        if(words != null && !words.isEmpty()) {
            //全词匹配
            doBuild(words);
            //转拼音后匹配
            doBuild(PinyinUtil.toPinyin(words));
        }
    }

    private void doBuild(List<String> words){
        if(words != null && !words.isEmpty()) {
            for (String word : words) {
                Node node = root;
                for (char c : word.toCharArray()) {
                   node = node.getChildren().computeIfAbsent(c,ch -> new Node());
                }
                node.setEnd(true);
            }
        }
    }
}
