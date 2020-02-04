package com.lfy.name;

import com.lfy.name.stroke.CnToStrokeCount;

import org.junit.Test;

import opensource.jpinyin.PinyinFormat;
import opensource.jpinyin.PinyinHelper;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testCount(){
        CnToStrokeCount.main(null);
    }

    @Test
    public void testPinyin(){
        //https://github.com/shenkevin/jpinyin/blob/master/src/main/java/opensource/jpinyin/PinyinHelper.java
        String string = "拼音测试";
        String pinyin = PinyinHelper.convertToPinyinString(string,"_", PinyinFormat.WITH_TONE_NUMBER);
        System.out.println(pinyin);
    }
}