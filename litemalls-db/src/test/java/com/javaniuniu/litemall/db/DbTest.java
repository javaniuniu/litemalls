package com.javaniuniu.litemall.db;

import org.junit.Test;

//@WebAppConfiguration
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DbTest {
    @Test
    public void test() {
    }

    @Test
    public void countCharacters() {
        String[] words = {"ttt","dddd"};
        String chars = "ttdddty";

        int[] c = new int[26];
        int s = 'z'-'A';
        int s2 = 'a'-'a';
        int s3 = 3/2;
        c[s] = 1;
        for(char cc : chars.toCharArray()) {
            c[(cc - 'a')] += 1;
        }
        int res = 0;
        a: for(String word : words) {
            int[] w = new int[26];
            for(char ww : word.toCharArray()) {
                w[(int)(ww - 'a')] += 1;
            }
            for(int i=0; i<26; i++) {
                if(w[i] > c[i]) {
                    continue a;
                }
            }
            res += word.length();
        }
//        return res;

        System.out.println(res);
    }


    @Test
    public void longestPalindrome() {
        String s = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        int[] c = new int[58];
        for(char cc:s.toCharArray()) {
            c[(int)cc-'A']+=1;
        }
        int res = 0;
        boolean flg = false;
        for(int i = 0; i<58; i++) {
            if(c[i]%2==0&&c[i]!=0){
                res+=c[i];
//                flg = true;
            }
            if(c[i]%2==1){
                res+=c[i]-1;
                flg = true;
            }
        }
        if (flg) {
//            return res+1;
            System.out.println(res+1);
        }else {
//            return res;
            System.out.println(res);
        }
//        return res;
        System.out.println(res);
    }

}
