package org.mengq.autoconfiguration;

import org.mengq.common.resolver.CustomArgumentResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author meng
 * @Date 2025/6/18 17:36
 * @Description TODO
 */
@Configuration
public class ArgumentResolverConfig {

    @Bean
    @ConditionalOnMissingBean
    public CustomArgumentResolver customArgumentResolver(){
        return new CustomArgumentResolver();
    }
}
