package com.example.sso.modular.designMode.singleMode;

import lombok.Data;

/**
 * @author zhangxinyu
 * @date 2022/05/27 10:19
 **/
public final class LockSingle {
    private static volatile LockSingle instance;
    public String str;
    private LockSingle(String str){
        this.str=str;
    }
    public static LockSingle getInstance(String str){
        if (instance!=null){
            return instance;
        }
        synchronized (LockSingle.class){
            if (instance==null){
                instance= new LockSingle(str);
            }
            return instance;
        }
    }
}
