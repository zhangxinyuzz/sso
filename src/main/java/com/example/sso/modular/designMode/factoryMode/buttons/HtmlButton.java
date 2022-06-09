package com.example.sso.modular.designMode.factoryMode.buttons;

/**
 * @author zhangxinyu
 * @date 2022/06/06 10:28
 **/
public class HtmlButton implements Button{
    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
