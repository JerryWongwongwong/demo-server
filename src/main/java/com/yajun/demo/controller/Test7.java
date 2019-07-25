package com.yajun.demo.controller;

import java.util.Random;

/**
 * @Author yajun
 * @Date 2019/3/5  16:42
 */
public class Test7 {



    /**
     * @Author yajun
     * @Date 2019/3/5  16:18
     */
    public static class GenerateActivateCode {

        /**
         * 生成随机数当作getItemID
         * n ： 需要的长度
         * @return
         */
        public static String getItemID( int n )
        {
            String val = "";
            Random random = new Random();
            for ( int i = 0; i < n; i++ )
            {
                String str = random.nextInt( 2 ) % 2 == 0 ? "num" : "char";
                if ( "char".equalsIgnoreCase( str ) )
                { // 产生字母
                    int nextInt = random.nextInt( 2 ) % 2 == 0 ? 65 : 97;
                    // System.out.println(nextInt + "!!!!"); 1,0,1,1,1,0,0
                    val += (char) ( nextInt + random.nextInt( 26 ) );
                }
                else if ( "num".equalsIgnoreCase( str ) )
                { // 产生数字
                    val += String.valueOf( random.nextInt( 10 ) );
                }
            }
            return val;
        }



    }


    public static void main(String[] args) {

        for(int i = 0 ; i > 100 ; i++){

        }

    }

}
