package org.aspectj.runtime.reflect;

import com.broadcom.bt.util.io.FilenameUtils;
import java.lang.reflect.Modifier;
import kotlin.text.Typography;
import org.jivesoftware.smack.sasl.SASLAnonymous;

/* loaded from: classes5.dex */
public class StringMaker {
    public static StringMaker longStringMaker;
    public static StringMaker middleStringMaker;
    public static StringMaker shortStringMaker;
    public int cacheOffset;
    public boolean shortTypeNames = true;
    public boolean includeArgs = true;
    public boolean includeThrows = false;
    public boolean includeModifiers = false;
    public boolean shortPrimaryTypeNames = false;
    public boolean includeJoinPointTypeName = true;
    public boolean includeEnclosingPoint = true;
    public boolean shortKindName = true;

    static {
        StringMaker stringMaker = new StringMaker();
        shortStringMaker = stringMaker;
        stringMaker.shortTypeNames = true;
        stringMaker.includeArgs = false;
        stringMaker.includeThrows = false;
        stringMaker.includeModifiers = false;
        stringMaker.shortPrimaryTypeNames = true;
        stringMaker.includeJoinPointTypeName = false;
        stringMaker.includeEnclosingPoint = false;
        stringMaker.cacheOffset = 0;
        StringMaker stringMaker2 = new StringMaker();
        middleStringMaker = stringMaker2;
        stringMaker2.shortTypeNames = true;
        stringMaker2.includeArgs = true;
        stringMaker2.includeThrows = false;
        stringMaker2.includeModifiers = false;
        stringMaker2.shortPrimaryTypeNames = false;
        shortStringMaker.cacheOffset = 1;
        StringMaker stringMaker3 = new StringMaker();
        longStringMaker = stringMaker3;
        stringMaker3.shortTypeNames = false;
        stringMaker3.includeArgs = true;
        stringMaker3.includeThrows = false;
        stringMaker3.includeModifiers = true;
        stringMaker3.shortPrimaryTypeNames = false;
        stringMaker3.shortKindName = false;
        stringMaker3.cacheOffset = 2;
    }

    public void addSignature(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (this.includeArgs) {
            stringBuffer.append("(");
            addTypeNames(stringBuffer, clsArr);
            stringBuffer.append(")");
        } else if (clsArr.length == 0) {
            stringBuffer.append("()");
        } else {
            stringBuffer.append("(..)");
        }
    }

    public void addThrows(StringBuffer stringBuffer, Class[] clsArr) {
        if (!this.includeThrows || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        addTypeNames(stringBuffer, clsArr);
    }

    public void addTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(makeTypeName(clsArr[i]));
        }
    }

    public String makeKindName(String str) {
        int iLastIndexOf = str.lastIndexOf(45);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    public String makeModifiersString(int i) {
        if (!this.includeModifiers) {
            return "";
        }
        String string = Modifier.toString(i);
        if (string.length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    public String makePrimaryTypeName(Class cls, String str) {
        return makeTypeName(cls, str, this.shortPrimaryTypeNames);
    }

    public String makeTypeName(Class cls, String str, boolean z) {
        if (cls == null) {
            return SASLAnonymous.NAME;
        }
        if (!cls.isArray()) {
            return z ? stripPackageName(str).replace(Typography.dollar, FilenameUtils.EXTENSION_SEPARATOR) : str.replace(Typography.dollar, FilenameUtils.EXTENSION_SEPARATOR);
        }
        Class<?> componentType = cls.getComponentType();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(makeTypeName(componentType, componentType.getName(), z));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    public String stripPackageName(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    public String makeTypeName(Class cls) {
        return makeTypeName(cls, cls.getName(), this.shortTypeNames);
    }
}
