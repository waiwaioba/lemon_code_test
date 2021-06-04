package com.test.day08;

import java.io.*;

/**
 * @author 歪歪欧巴
 * @Description: TODO
 * @date 2020/5/13 20:45
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class IOTest {
    //FileNotFoundException抛给JVM去处理 main方法的上一级就是JVM虚拟机
    public static void main(String[] args) throws Exception {
        //选择自己处理异常 - 捕捉异常
       /* try {
            readByteFile();
        }catch(Exception e){
            System.out.println("这里是异常");
        }*/
        readTextFile();
    }

    public static void readByteFile() throws Exception {
        //InputStream --》抽象类 不能实例化
        //用子类FileInputStream  -->读取
        File sourceFile = new File("D:\\py27\\111.png");
        FileInputStream is = new FileInputStream(sourceFile);

        //目标文件
        File targetFile = new File("D:\\py26\\222.png");
        //FileOutputStream -->写入
        FileOutputStream os = new FileOutputStream(targetFile);

        //read(byte[] b)
        byte[] arr = new byte[1024]; //这个参数表示读取的数据存放到这个数组里面,每一次读取1024字节
        //循环读取文件的内容
        while (true) {
            //这个方法的返回值是为读取的内容大小，如果返回-1表示读到了文件末尾
            int size = is.read(arr);
            if ( size == -1) {
                break;
            } else {
                //写入到新的文件中--》复制到新图片
                //write(byte[] b , int off, int len)
                os.write(arr,0,size);
            }
        }

        os.close();
        is.close();
        //OutputStream
    }

    public static void readTextFile() throws Exception{
        //读取纯文本文件
        File sourceFile = new File("D:\\迅雷下载\\test.txt");
        FileReader fileReader = new FileReader(sourceFile);

        //目标文件
        File targetFile = new File("D:\\迅雷下载\\test_bak.txt");
        FileWriter fileWriter = new FileWriter(targetFile);
        //缓冲流写入对象
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //缓冲流读取对象
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ( (line = bufferedReader.readLine() )!= null) {
            //每读取一行内容，就写入到目标文件中
            bufferedWriter.write(line);
            //写完一行内容之后，需要进行换行
            bufferedWriter.newLine();
        }
        //使用结束，需要关闭缓冲流，为什么不需要关闭fileReader & fileWriter
        //因为是已经作为参数传进去给缓冲流
        bufferedReader.close();
        bufferedWriter.close();

    }


}


