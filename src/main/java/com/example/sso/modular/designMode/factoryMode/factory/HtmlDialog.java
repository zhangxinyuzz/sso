package com.example.sso.modular.designMode.factoryMode.factory;

import com.example.sso.modular.designMode.factoryMode.buttons.Button;
import com.example.sso.modular.designMode.factoryMode.buttons.HtmlButton;

/**
 * @author zhangxinyu
 * @date 2022/06/06 10:36
 **/
public class HtmlDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
