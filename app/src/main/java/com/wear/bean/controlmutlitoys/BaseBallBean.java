package com.wear.bean.controlmutlitoys;

import androidx.annotation.NonNull;
import com.wear.util.WearUtils;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class BaseBallBean implements Serializable {
    private boolean isSelected;
    private boolean isXMachine;
    private List<String> symbol;
    private String toyAddress;
    private String toyFun;
    private String toyName;

    public BaseBallBean(String str, String str2, String str3, boolean z, boolean z2, List<String> list) {
        this.toyName = str;
        this.toyAddress = str2;
        this.toyFun = str3;
        this.isSelected = z;
        this.isXMachine = z2;
        this.symbol = list;
    }

    public List<String> getSymbol() {
        return this.symbol;
    }

    public String getToyAddress() {
        return this.toyAddress;
    }

    public String getToyFun() {
        return this.toyFun;
    }

    public String getToyName() {
        return this.toyName;
    }

    public boolean isEqual(@NonNull String str, @NonNull String str2) {
        String str3;
        String str4;
        String str5;
        if (isFunction() || (str4 = this.toyAddress) == null || !str4.equals(str) || (str5 = this.toyFun) == null || !str5.equals(str2)) {
            return isFunction() && (str3 = this.toyFun) != null && str3.equals(str2);
        }
        return true;
    }

    public boolean isFunction() {
        return WearUtils.e1(this.toyAddress);
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isXMachine() {
        return this.isXMachine;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setSymbol(List<String> list) {
        this.symbol = list;
    }

    public boolean isEqual(boolean z, @NonNull String str, @NonNull String str2) {
        String str3;
        String str4;
        if (!z && (str4 = this.toyAddress) != null && str4.equals(str)) {
            String str5 = this.toyFun;
            if (str5 != null && str5.equals("t")) {
                if (!str2.equals("t") && !str2.equals("pos")) {
                    return false;
                }
            } else {
                String str6 = this.toyFun;
                if (str6 != null && str6.equals("pos")) {
                    if (!str2.equals("pos") && !str2.equals("t")) {
                        return false;
                    }
                } else {
                    String str7 = this.toyFun;
                    if (str7 == null || !str7.equals(str2)) {
                        return false;
                    }
                }
            }
        } else if (!z || (str3 = this.toyFun) == null || !str3.equals(str2)) {
            return false;
        }
        return true;
    }
}
