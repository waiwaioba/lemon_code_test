package com.test.day08;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author 歪歪欧巴
 * @Description: TODO
 * @date 2020/5/13 22:33
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class HomeWork {
    public static void main(String[] args) throws Exception {
        //zuoye1();
        zuoye2();
    }

    public static void zuoye1(){
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("name","tom");
        hashMap.put("age","11");
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.size());
        System.out.println(hashMap.containsValue("王五"));
        hashMap.remove("age");
        //遍历所有的键名
        Set<String> keys = hashMap.keySet();
        for (String key : keys){
            System.out.println(key);
        }
        //遍历所有的键值对的值
        Collection<String> values =  hashMap.values();
       for (String value : values){
           System.out.println(value);
       }
        //遍历所有的键值对
        Set<Entry<String,String>> entrySets = hashMap.entrySet();
        for (Entry<String,String> entrySet : entrySets){
            System.out.println("键名:"+entrySet.getKey()+"，键值："+entrySet.getValue());
        }
    }

    public static void zuoye2() throws Exception{
        //读取纯文本文件
        File sourceFile = new File("D:\\py26\\test.txt");
        FileReader fileReader = new FileReader(sourceFile);
        //缓冲流读取对象
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        //先去只读取第一行内容,里面保存的是name、age、address
        line = bufferedReader.readLine();
        //通过split按照|进行分割
        String[] arr1 = line.split("\\|");
        //用list集合保存所有的hashMap对象
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        while ( (line = bufferedReader.readLine() )!= null) {
            //实例化HashMap对象
            HashMap<String,String> hashMap = new HashMap<String,String>();
            String[] arr2 = line.split("\\|");
            //将键名和键值存储到hashMap中，如：name:张三 age:25 address:长沙
            for(int i=0; i<arr2.length; i++){
                hashMap.put(arr1[i],arr2[i]);
            }
            list.add(hashMap);
        }
        bufferedReader.close();

        //循环遍历list集合中的所有hashMap对象
        for(int i =0 ;i<list.size();i++){
            System.out.println("=====第【"+(i+1)+"】个HashMap对象=====");
            HashMap<String,String> hashMap = list.get(i);
            Set<Entry<String,String>> entrySets = hashMap.entrySet();
            for (Entry<String,String> entrySet : entrySets){
                //用来获取键名
                System.out.println("键名:"+entrySet.getKey()+"，键值："+entrySet.getValue());
            }
        }
    }
}
