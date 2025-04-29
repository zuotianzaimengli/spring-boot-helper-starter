package org.mengq.autoconfiguration;

import org.mengq.dfa.trie.TrieWrapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author meng
 * @Date 2025/4/25 18:59
 * @Description TODO
 */
@Configuration
public class TrieWrapperConfig {

    @Bean
    @ConditionalOnMissingBean
    public TrieWrapper trieWrapper(){
        return new TrieWrapper();
    }
}
