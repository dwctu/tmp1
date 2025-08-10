package dc;

import com.wear.bean.socketio.chatBase.BaseAckRequestBean;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: SetToyRequest.java */
/* loaded from: classes3.dex */
public class i32 extends BaseAckRequestBean {
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
    public String m;
    public String n;

    public void a(String str) {
        this.j = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.k = str;
    }

    public void d(String str) {
        this.l = str;
    }

    public void e(String str) {
        this.i = str;
    }

    public void f(String str) {
        this.d = str;
    }

    public void g(String str) {
        this.f = str;
    }

    @Override // com.wear.bean.socketio.chatBase.BaseAckRequestBean, dc.pf2
    public String getAction() {
        return "app_lan_set_info_ts";
    }

    public void h(String str) {
        this.a = str;
    }

    public void i(String str) {
        this.n = str;
    }

    public void j(String str) {
        this.h = str;
    }

    public void k(String str) {
        this.m = str;
    }

    public void l(String str) {
        this.b = str;
    }

    public void m(String str) {
        this.e = str;
    }

    public void n(String str) {
        this.g = str;
    }

    public String toString() {
        return "SetToyRequest{platform='" + this.a + "', version='" + this.b + "', appVersion='" + this.c + "', httpPort='" + this.d + "', wsPort='" + this.e + "', httpsPort='" + this.f + "', wssPort='" + this.g + "', sys='" + this.h + "', gameAppId='" + this.i + "', appType='" + this.j + "', deviceCode='" + this.k + "', domain='" + this.l + "', toys='" + this.m + "', suid='" + this.n + '\'' + MessageFormatter.DELIM_STOP;
    }
}
