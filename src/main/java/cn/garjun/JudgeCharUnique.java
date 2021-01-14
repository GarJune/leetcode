package cn.garjun;

import sun.lwawt.macosx.CSystemTray;

/**
 * @author liangjiajun
 * @create 2020-03-05
 * @description
 **/
public class JudgeCharUnique {
    public static void main(String[] args) {
        System.out.println((byte)'z');
    }
    public boolean isUnique(String astr) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : astr.toCharArray()){
            if(stringBuilder.toString().contains(String.valueOf(c))){
               return false;
            }
            stringBuilder.append(c);
        }
        return true;

    }
}
