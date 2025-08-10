package dc;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import skin.support.exception.SkinCompatException;

/* compiled from: ColorState.java */
/* loaded from: classes5.dex */
public final class qh4 {
    public boolean a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;

    /* compiled from: ColorState.java */
    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;

        public qh4 a() {
            if (TextUtils.isEmpty(this.l)) {
                throw new SkinCompatException("Default color can not empty!");
            }
            return new qh4(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }

        public a b(String str) {
            if (qh4.a("colorAccelerated", str)) {
                this.h = str;
            }
            return this;
        }

        public a c(String str) {
            if (qh4.a("colorActivated", str)) {
                this.g = str;
            }
            return this;
        }

        public a d(String str) {
            if (qh4.a("colorChecked", str)) {
                this.f = str;
            }
            return this;
        }

        public a e(String str) {
            if (qh4.a("colorDefault", str)) {
                this.l = str;
            }
            return this;
        }

        public a f(String str) {
            if (qh4.a("colorDragCanAccept", str)) {
                this.j = str;
            }
            return this;
        }

        public a g(String str) {
            if (qh4.a("colorDragHovered", str)) {
                this.k = str;
            }
            return this;
        }

        public a h(String str) {
            if (qh4.a("colorEnabled", str)) {
                this.d = str;
            }
            return this;
        }

        public a i(String str) {
            if (qh4.a("colorFocused", str)) {
                this.c = str;
            }
            return this;
        }

        public a j(String str) {
            if (qh4.a("colorHovered", str)) {
                this.i = str;
            }
            return this;
        }

        public a k(String str) {
            if (qh4.a("colorPressed", str)) {
                this.e = str;
            }
            return this;
        }

        public a l(String str) {
            if (qh4.a("colorSelected", str)) {
                this.b = str;
            }
            return this;
        }

        public a m(String str) {
            if (qh4.a("colorWindowFocused", str)) {
                this.a = str;
            }
            return this;
        }
    }

    public qh4(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.k = str9;
        this.l = str10;
        this.m = str11;
        this.n = str12;
        boolean z = TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9) && TextUtils.isEmpty(str10) && TextUtils.isEmpty(str11);
        this.a = z;
        if (z && !str12.startsWith("#")) {
            throw new SkinCompatException("Default color cannot be a reference, when only default color is status_available!");
        }
    }

    public static boolean a(String str, String str2) {
        boolean z = !TextUtils.isEmpty(str2) && (!str2.startsWith("#") || str2.length() == 7 || str2.length() == 9);
        if (pi4.a && !z) {
            pi4.a("ColorState", "Invalid color -> " + str + ": " + str2);
        }
        return z;
    }

    public static qh4 b(JSONObject jSONObject) {
        if (!jSONObject.has("colorName") || !jSONObject.has("colorDefault") || !jSONObject.has("onlyDefaultColor")) {
            return null;
        }
        try {
            boolean z = jSONObject.getBoolean("onlyDefaultColor");
            String string = jSONObject.getString("colorName");
            String string2 = jSONObject.getString("colorDefault");
            if (z) {
                return new qh4(string, string2);
            }
            a aVar = new a();
            aVar.e(string2);
            if (jSONObject.has("colorWindowFocused")) {
                aVar.m(jSONObject.getString("colorWindowFocused"));
            }
            if (jSONObject.has("colorSelected")) {
                aVar.l(jSONObject.getString("colorSelected"));
            }
            if (jSONObject.has("colorFocused")) {
                aVar.i(jSONObject.getString("colorFocused"));
            }
            if (jSONObject.has("colorEnabled")) {
                aVar.h(jSONObject.getString("colorEnabled"));
            }
            if (jSONObject.has("colorPressed")) {
                aVar.k(jSONObject.getString("colorPressed"));
            }
            if (jSONObject.has("colorChecked")) {
                aVar.d(jSONObject.getString("colorChecked"));
            }
            if (jSONObject.has("colorActivated")) {
                aVar.c(jSONObject.getString("colorActivated"));
            }
            if (jSONObject.has("colorAccelerated")) {
                aVar.b(jSONObject.getString("colorAccelerated"));
            }
            if (jSONObject.has("colorHovered")) {
                aVar.j(jSONObject.getString("colorHovered"));
            }
            if (jSONObject.has("colorDragCanAccept")) {
                aVar.f(jSONObject.getString("colorDragCanAccept"));
            }
            if (jSONObject.has("colorDragHovered")) {
                aVar.g(jSONObject.getString("colorDragHovered"));
            }
            qh4 qh4VarA = aVar.a();
            qh4VarA.b = string;
            return qh4VarA;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String c(String str) {
        if (str.startsWith("#")) {
            return str;
        }
        qh4 qh4VarJ = vh4.g().j(str);
        if (qh4VarJ == null) {
            return null;
        }
        if (qh4VarJ.d()) {
            return qh4VarJ.n;
        }
        if (!pi4.a) {
            return null;
        }
        pi4.a("ColorState", str + " cannot reference " + qh4VarJ.b);
        return null;
    }

    public boolean d() {
        return this.a;
    }

    public ColorStateList e() {
        return this.a ? ColorStateList.valueOf(Color.parseColor(this.n)) : f();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.content.res.ColorStateList f() {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.qh4.f():android.content.res.ColorStateList");
    }

    public qh4(String str, String str2) {
        this.b = str;
        this.n = str2;
        this.a = true;
        if (!str2.startsWith("#")) {
            throw new SkinCompatException("Default color cannot be a reference, when only default color is status_available!");
        }
    }
}
