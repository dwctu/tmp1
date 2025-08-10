package com.wear.network.presenter.bean;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class SignUpCodeBean {
    private String exponent;
    private String modulus;

    public String getExponent() {
        return this.exponent;
    }

    public String getModulus() {
        return this.modulus;
    }

    public void setExponent(String str) {
        this.exponent = str;
    }

    public void setModulus(String str) {
        this.modulus = str;
    }

    public String toString() {
        return "SignUpCodeBean{modulus='" + this.modulus + "', exponent='" + this.exponent + '\'' + MessageFormatter.DELIM_STOP;
    }
}
