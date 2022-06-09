package com.example.sso.modular.designMode.singleMode;

/**
 * @author zhangxinyu
 * @date 2022/05/27 10:13
 **/
public class Test {
    public static void main(String[] args) {
//        Nothing nothing = Nothing.getNothing("nihao");
//        System.out.println(nothing.str);
//        Nothing nothing1 = Nothing.getNothing("nihaoma");
//        System.out.println(nothing1.str);
        Thread thread1 = new Thread(new Test1());
        Thread thread2 = new Thread(new Test2());
        thread1.start();
        thread2.start();

    }
    static class Test1 implements Runnable{

        @Override
        public void run() {
            LockSingle lockSingle = LockSingle.getInstance("wocao");
            Nothing nothing = Nothing.getNothing("nihao");
            System.out.println(nothing.str);
            System.out.println(lockSingle.str);
        }
    }
    static class Test2 implements Runnable{

        @Override
        public void run() {
            LockSingle lockSingle = LockSingle.getInstance("qunimade");
            Nothing nothing = Nothing.getNothing("nihaogepi");
            System.out.println(nothing.str);
            System.out.println(lockSingle.str);
        }
    }
}
