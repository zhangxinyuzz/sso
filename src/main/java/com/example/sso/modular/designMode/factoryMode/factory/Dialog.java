package com.example.sso.modular.designMode.factoryMode.factory;

import com.example.sso.modular.designMode.factoryMode.buttons.Button;

public abstract class Dialog {
    
    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses will override this method in order to create specific button
     * objects.
     */
    public abstract Button createButton();
}
