package com.test.day08;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author 歪歪欧巴
 * @Description: TODO
 * @date 2020/5/13 20:16
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class HashMapTest {
    public static void main(String[] args) {
        //1、实例化HashMap对象
        HashMap<String,String> hashMap = new HashMap<String,String>();
        //2、hashMap常用API
        hashMap.put("name","tom");
        hashMap.put("age","11");
        hashMap.put("address","长沙");
        //System.out.println(hashMap.get("address"));
       // hashMap.remove("age");
        //System.out.println(hashMap.get("age"));
        //遍历所有的键名
        /*Set<String> keys = hashMap.keySet();
        for (String key : keys){
            System.out.println(key);
        }*/
        //遍历所有的键值对的值
      /* Collection<String> values =  hashMap.values();
       for (String value : values){
           System.out.println(value);
       }*/
      //遍历所有的键值对 Entry<String,String>  -- 键值对
        Set<Entry<String,String>> entrySets = hashMap.entrySet();
        for (Entry<String,String> entrySet : entrySets){
            //用来获取键名
            System.out.println("键名:"+entrySet.getKey()+"，键值："+entrySet.getValue());
        }

        System.out.println(hashMap.containsKey("address"));
        System.out.println(hashMap.containsValue("address"));
    }
}
