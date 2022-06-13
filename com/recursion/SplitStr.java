package com.recursion;

import java.util.Scanner;

public class SplitStr {

        public static int fuhe = 0; //能够实现的方案个数
        public static int zichuan = 1;  //分割出的子串个数

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();
            int res = 0;

            fenge(str);

            if(fuhe==1){
                res = zichuan;  //只有一种情况符合
            }else if(fuhe>1){
                res = -1;   //大于一种情况符合
            }

            System.out.println(res);

        }

        public static void fenge(String s){
            int len = s.length();
            int count = 0;
            for (int i = 0; i < len; i++) {
                count+=s.charAt(i);
                if (count > 999) {
                    break;
                }
                if (count >= 100 && count<=999 && isSXS(count)) {
                    if (i == s.length() - 1) {
                        fuhe++;
                    } else {
                        fenge(s.substring(i+1));
                        zichuan++;
                    }
                }
            }
        }

        public static boolean isSXS(int i){

            int b = i/100;  //百位数
            int s = i%100/10;   //十位数
            int g = i%100%10;   //个位数

            int count = (int) (Math.pow(b,3) + Math.pow(s,3) + Math.pow(g,3));

            if(count == i){
                return true;
            }

            return false;
        }
    }
