package com.hanxuefeng.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] tmpArr = new int[16];
        for (int i = 0; i < 16; i++) {
            tmpArr[i] = i;
        }

        Random random = new Random();
        // 打乱数组
        for (int i = 0; i < tmpArr.length; i++) {
            int tmp = tmpArr[i];
            int index = random.nextInt(tmpArr.length);
            tmpArr[i] = tmpArr[index];
            tmpArr[index] = tmp;
        }
        int[][] tmpArray = new int[4][4];
        for (int i = 0; i < tmpArr.length; i++) {
            tmpArray[i / 4][i % 4] = tmpArr[i];
        }
    }
}
