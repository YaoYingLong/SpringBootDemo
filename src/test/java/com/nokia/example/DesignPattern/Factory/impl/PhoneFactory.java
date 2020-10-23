package com.nokia.example.DesignPattern.Factory.impl;

import com.nokia.example.DesignPattern.Factory.Phone;

/**
 * @author by YingLong on 2020/10/23
 */
public class PhoneFactory {
    public Phone makePhone(String type) {
        switch (type) {
            case "XiaoMi":
                return new MiPhone();
            case "HuaWei":
                return new HwPhone();
        }
        return null;
    }
}
