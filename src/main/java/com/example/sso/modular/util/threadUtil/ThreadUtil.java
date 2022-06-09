package com.example.sso.modular.util.threadUtil;

/**
 * @author zhangxinyu
 * @date 2022/05/26 16:38
 **/
public class ThreadUtil extends Thread {
    private static final String STR = "str";
    @Override
    public void run(){
        String s = STR;
        String newS = new String("str");
        System.out.println(s==newS);
        System.out.println(s.equals(newS));
    }

}
