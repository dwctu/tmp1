package dc;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* compiled from: PingYinUtil.java */
/* loaded from: classes4.dex */
public class uf3 {
    public static String a(String str) {
        String str2 = "";
        if (str == null) {
            return "";
        }
        pa4 pa4Var = new pa4();
        pa4Var.e(oa4.b);
        pa4Var.f(qa4.b);
        pa4Var.g(ra4.b);
        try {
            char[] charArray = str.trim().toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                str2 = Character.toString(charArray[i]).matches("[\\u4E00-\\u9FA5]+") ? str2 + ma4.c(charArray[i], pa4Var)[0] : str2 + Character.toString(charArray[i]);
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return str2;
    }
}
