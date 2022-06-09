package com.example.sso.modular;

import com.example.sso.modular.util.threadUtil.ThreadUtil;

/**
 * @author zhangxinyu
 * @date 2022/05/26 16:52
 **/
public class Test {
    public static void main(String[] args) {

        int [] arr = {1,2,5,78,26,34,6};
        for (int n :arr){
            System.out.print(n +"  ");
        }
        for (int i  = 0;i<arr.length;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j]<arr[j+1]){
                    int a = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = a;
                }
            }
        }
        for (int n :arr){
            System.out.print(n + "  ");
        }
    }
    public int qiuhe(int a){
        if (a<=100){
            a = a + this.qiuhe(a+1);
            a++;
            System.out.println(a);
        }
        return a;
    }
}
