package org.mengq.autoconfiguration;

import org.mengq.dfa.trie.TrieWrapper;
import org.mengq.dfa.trie.WordComplementer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author meng
 * @Date 2025/7/8 17:37
 * @Description TODO
 */
@Configuration
public class WordComplementerConfig {

    @Bean
    @ConditionalOnMissingBean
    public WordComplementer wordComplementer(TrieWrapper trieWrapper){
        return new WordComplementer(trieWrapper);
    }
}
