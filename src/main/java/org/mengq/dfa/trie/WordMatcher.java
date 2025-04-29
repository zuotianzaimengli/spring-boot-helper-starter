package org.mengq.dfa.trie;

import org.mengq.dfa.model.Node;
import org.mengq.dfa.util.PinyinUtil;

/**
 * @Author meng
 * @Date 2025/4/25 17:57
 * @Description TODO
 */
public class WordMatcher {

    private static final String regex = "[^a-zA-Z0-9\\u4e00-\\u9fa5]";

    private final TrieWrapper trieWrapper;

    public WordMatcher(TrieWrapper trieWrapper) {
        this.trieWrapper = trieWrapper;
    }

    public boolean matcher(String word){
        return exactMatcher(word) ||
                pinyinExactMatcher(word);
    }


    private boolean exactMatcher(String word){
        return match(word);
    }

    private boolean pinyinExactMatcher(String word){
        if(word == null || word.isEmpty() || (word = word.replaceAll(regex,"")).isEmpty()) {
            return false;
        }
        return match(PinyinUtil.toPinyin(word));
    }

    private boolean match(String word) {
        if(word == null || word.isEmpty() || (word = word.replaceAll(regex,"")).isEmpty()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            Node node = trieWrapper.getRoot();
            int j = i;
            while (j < word.length() && node.getChildren().containsKey(word.charAt(j))) {
                node = node.getChildren().get(word.charAt(j));
                if (node.isEnd()) {
                    return true; // 匹配到敏感词
                }
                j++;
            }
        }
        return false;
    }

}
