package com.example.sso.modular.designMode.singleMode;

import lombok.Data;

/**
 * @author zhangxinyu
 * @date 2022/05/27 10:07
 **/
public final class Nothing {
    private static Nothing nothing;
    public String str;
    private Nothing(String str){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.str=str;
    }
    public static Nothing getNothing(String str){
        if (nothing==null){
            nothing = new Nothing(str);
        }
        return nothing;
    }

}
