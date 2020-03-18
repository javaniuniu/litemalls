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
        int s = 't'-'a';
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

}
