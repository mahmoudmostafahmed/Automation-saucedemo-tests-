package com.Automationtask.saucedemosite.browser;

import com.Automationtask.saucedemosite.platform.saucedemo;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Browser {
    public saucedemo SauceDemo;

    public Browser() throws IOException, UnsupportedFlavorException {
        SauceDemo = new saucedemo();
    }
}
