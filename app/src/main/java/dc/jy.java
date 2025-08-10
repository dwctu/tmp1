package dc;

/* compiled from: NetworkCodeEnum.java */
/* loaded from: classes.dex */
public class jy {

    /* compiled from: NetworkCodeEnum.java */
    public static class a {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }

    public static a a(String str, String str2) {
        str.hashCode();
        switch (str) {
            case "20000":
            case "20001":
            case "20002":
            case "21002":
            case "50010":
            case "50021":
                str2 = "Unable to connect to the server";
                break;
        }
        return new a(str, str2);
    }

    public static String b() {
        return "Unable to connect to the server";
    }

    public static String c(String str) {
        return "数据解析错误：" + str;
    }

    public static String d(Throwable th) {
        if (th == null || th.getMessage() == null) {
            return "Unable to connect to the server";
        }
        String message = th.getMessage();
        message.hashCode();
        return !message.equals("HTTP 413 Request Entity Too Large") ? "Unable to connect to the server" : "HTTP 413 Request Entity Too Large";
    }

    public static String e() {
        return "Unable to connect to the server";
    }
}
