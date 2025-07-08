package org.mengq.dfa.trie;

import org.mengq.dfa.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author meng
 * @Date 2025/7/8 17:08
 * @Description 自动补全
 */
public class WordComplementer {

    private final TrieWrapper trieWrapper;

    public WordComplementer(TrieWrapper trieWrapper){
        this.trieWrapper = trieWrapper;
    }

    public List<String> autoComplement(String prefix){
        Node begin = getBeginNode(prefix);
        List<String> result = new ArrayList<>();
        doComplement(begin,result,prefix);
        return result;
    }

    private Node getBeginNode(String prefix){
        Node root = trieWrapper.getRoot();
        for (char c : prefix.toCharArray()) {
            if(!root.getChildren().containsKey(c)) {
                return null;
            }
            root = root.getChildren().get(c);
        }
        return root;
    }

    private void doComplement(Node begin,List<String> list,String prefix){
        if(begin == null || begin.getChildren() == null || begin.getChildren().isEmpty()) {
            return;
        }
        for (Map.Entry<Character, Node> entry : begin.getChildren().entrySet()) {
            StringBuilder sb = new StringBuilder(prefix);
            sb.append(entry.getKey());
            if(entry.getValue().isEnd()) {
                list.add(sb.toString());
            }
            doComplement(entry.getValue(),list,sb.toString());
        }
    }
}
