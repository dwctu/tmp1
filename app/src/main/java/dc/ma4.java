package dc;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* compiled from: PinyinHelper.java */
/* loaded from: classes5.dex */
public class ma4 {
    public static String[] a(char c, pa4 pa4Var) throws BadHanyuPinyinOutputFormatCombination {
        String[] strArrB = b(c);
        if (strArrB == null) {
            return null;
        }
        for (int i = 0; i < strArrB.length; i++) {
            strArrB[i] = la4.b(strArrB[i], pa4Var);
        }
        return strArrB;
    }

    public static String[] b(char c) {
        return ka4.c().b(c);
    }

    public static String[] c(char c, pa4 pa4Var) throws BadHanyuPinyinOutputFormatCombination {
        return a(c, pa4Var);
    }
}
