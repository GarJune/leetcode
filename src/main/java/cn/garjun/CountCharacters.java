package cn.garjun;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :liangjiajun
 * @date :20200317
 * @description 拼写单词
 * @email :jaron.liang@jodoinc.comâ
 */
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        char[] charArray  = chars.toCharArray();
        Map<Character,Integer> charMap = new HashMap<>(1000);
        for (char c: charArray) {
            if(charMap.containsKey(c)){
                charMap.put(c,charMap.get(c)+1);
            }else {
                charMap.put(c,1);
            }
            //
        }
        int total = 0;
        for(String str : words){
            char[] array = str.toCharArray();
            Map<Character,Integer> map = new HashMap<>(charMap);
            boolean key = true;
            for (char each :array){
                if(map.containsKey(each)){
                    if(map.get(each) == 0){
                        key = false;
                        break;
                    }else{
                        map.put(each,map.get(each)-1);
                    }
                }else{
                    key = false;
                    break;
                }
            }
            if(key){
                total += array.length;
            }
        }
        return total;
    }
}
