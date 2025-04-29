package org.mengq.dfa.util;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author meng
 * @Date 2025/4/26 00:38
 * @Description TODO
 */
public class PinyinUtil {

    public static String toPinyin(String word){
        StringBuilder sb = new StringBuilder();
        if(word != null && !word.isEmpty()) {
            for (char c : word.toCharArray()) {
                String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
                if (pinyinArray != null && pinyinArray.length > 0) {
                    sb.append(pinyinArray[0].replaceAll("\\d",""));
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static List<String> toPinyin(List<String> list){
        if(list != null && !list.isEmpty()) {
            return list.stream().map(PinyinUtil::toPinyin).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
