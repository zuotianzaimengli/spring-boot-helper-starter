package org.mengq.autoconfiguration;

import org.mengq.dfa.trie.TrieWrapper;
import org.mengq.dfa.trie.WordMatcher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author meng
 * @Date 2025/4/25 18:56
 * @Description TODO
 */
@Configuration
public class WordMatcherConfig {

    @Bean
    @ConditionalOnMissingBean
    public WordMatcher wordMatcher(TrieWrapper trieWrapper){
        return new WordMatcher(trieWrapper);
    }
}
