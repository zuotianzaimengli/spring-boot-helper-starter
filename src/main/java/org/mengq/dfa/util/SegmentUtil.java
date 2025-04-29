package org.mengq.dfa.util;

import com.huaban.analysis.jieba.JiebaSegmenter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author meng
 * @Date 2025/4/26 00:33
 * @Description TODO
 */
public class SegmentUtil {

    private static final JiebaSegmenter SEGMENTER = new JiebaSegmenter();

    public static List<String> segment(String word){
        if(word != null && !word.isEmpty()) {
            return SEGMENTER.sentenceProcess(word);
        }
        return Collections.emptyList();
    }

    public static List<String> segment(List<String> words){
        if(words != null && !words.isEmpty()) {
            return words.stream().map(SEGMENTER::sentenceProcess)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
