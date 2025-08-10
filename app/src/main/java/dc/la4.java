package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import kotlin.text.Typography;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* compiled from: PinyinFormatter.java */
/* loaded from: classes5.dex */
public class la4 {
    public static String a(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.matches("[a-z]*[1-5]?")) {
            return lowerCase;
        }
        if (!lowerCase.matches("[a-z]*[1-5]")) {
            return lowerCase.replaceAll(PSOProgramService.VS_Key, "ü");
        }
        int numericValue = Character.getNumericValue(lowerCase.charAt(lowerCase.length() - 1));
        char cCharAt = 'a';
        int iIndexOf = lowerCase.indexOf(97);
        int iIndexOf2 = lowerCase.indexOf(101);
        int iIndexOf3 = lowerCase.indexOf("ou");
        if (-1 == iIndexOf) {
            if (-1 == iIndexOf2) {
                if (-1 == iIndexOf3) {
                    iIndexOf = lowerCase.length() - 1;
                    while (true) {
                        if (iIndexOf < 0) {
                            cCharAt = Typography.dollar;
                            iIndexOf = -1;
                            break;
                        }
                        if (String.valueOf(lowerCase.charAt(iIndexOf)).matches("[aeiouv]")) {
                            cCharAt = lowerCase.charAt(iIndexOf);
                            break;
                        }
                        iIndexOf--;
                    }
                } else {
                    cCharAt = "ou".charAt(0);
                    iIndexOf = iIndexOf3;
                }
            } else {
                iIndexOf = iIndexOf2;
                cCharAt = 'e';
            }
        }
        if ('$' == cCharAt || -1 == iIndexOf) {
            return lowerCase;
        }
        char cCharAt2 = "āáăàaēéĕèeīíĭìiōóŏòoūúŭùuǖǘǚǜü".charAt(("aeiouv".indexOf(cCharAt) * 5) + (numericValue - 1));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(lowerCase.substring(0, iIndexOf).replaceAll(PSOProgramService.VS_Key, "ü"));
        stringBuffer.append(cCharAt2);
        stringBuffer.append(lowerCase.substring(iIndexOf + 1, lowerCase.length() - 1).replaceAll(PSOProgramService.VS_Key, "ü"));
        return stringBuffer.toString();
    }

    public static String b(String str, pa4 pa4Var) throws BadHanyuPinyinOutputFormatCombination {
        qa4 qa4Var = qa4.c;
        if (qa4Var == pa4Var.b() && (ra4.b == pa4Var.c() || ra4.a == pa4Var.c())) {
            throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
        }
        if (qa4.b == pa4Var.b()) {
            str = str.replaceAll("[1-5]", "");
        } else if (qa4Var == pa4Var.b()) {
            str = a(str.replaceAll("u:", PSOProgramService.VS_Key));
        }
        if (ra4.b == pa4Var.c()) {
            str = str.replaceAll("u:", PSOProgramService.VS_Key);
        } else if (ra4.c == pa4Var.c()) {
            str = str.replaceAll("u:", "ü");
        }
        return oa4.a == pa4Var.a() ? str.toUpperCase() : str;
    }
}
