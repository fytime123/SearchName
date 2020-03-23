package com.lfy.name;

import android.text.TextUtils;

import com.lfy.name.stroke.CnToStrokeCount;

import java.util.ArrayList;
import java.util.List;

import opensource.jpinyin.PinyinFormat;
import opensource.jpinyin.PinyinHelper;

public class SearchChar {


    //去掉多音字
    public String removeMultiPinyin(String string){

        if(string == null || string.isEmpty())return string;
        char[] chars = string.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for(char c:chars){
            if(PinyinHelper.hasMultiPinyin(c)){
                continue;
            }
            buffer.append(c);
        }

        return buffer.toString();
    }

    //搜索笔画为n的字

    public String searchStrokeCount(String string,int n){
        if(string == null || string.isEmpty())return string;
        char[] chars = string.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for(char c:chars){
           int value =  CnToStrokeCount.getStrokeCount(c);
            if(value == n){
                buffer.append(c);
            }
        }

        return buffer.toString();
    }

    //组合出名字
    public List<String> composeName(String string1, String string2){
        if(string1 == null || string1.isEmpty()|| string2 == null || string2.isEmpty())return null;
        List<String> names = new ArrayList<>();
        char[] chars1 = string1.toCharArray();
        char[] chars2 = string2.toCharArray();
        for(char c1:chars1){
            for(char c2:chars2){
                if(c1 == c2){
                    continue;
                }
                String word = ""+c1+c2;

                if(isPinyinOk(word)) names.add(word);
            }
        }
        return names;
    }

    private boolean isPinyinOk(String name){
        String pinyin = PinyinHelper.convertToPinyinString(name,"_", PinyinFormat.WITH_TONE_NUMBER);
        String[] group = pinyin.split("_");
        if(group.length !=2)return false;

        char[] chars1= group[0].toCharArray();
        char[] chars2 = group[1].toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        if((chars1[length1 - 1] == '3' || chars1[length1 - 1] == '4') && (chars2[length2 -1] == '1'||chars2[length2 -1] == '2')){// && chars2[length2 -2] == 'g'){
            return true;
        }
        return false;
    }

}
