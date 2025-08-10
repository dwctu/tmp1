package org.jivesoftware.smack.provider;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.rsm.packet.RSMSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class IntrospectionProvider {

    public static abstract class IQIntrospectionProvider<I extends IQ> extends IQProvider<I> {
        private final Class<I> elementClass;

        public IQIntrospectionProvider(Class<I> cls) {
            this.elementClass = cls;
        }

        @Override // org.jivesoftware.smack.provider.Provider
        public I parse(XmlPullParser xmlPullParser, int i) throws SmackException, XmlPullParserException, IOException {
            try {
                return (I) IntrospectionProvider.parseWithIntrospection(this.elementClass, xmlPullParser, i);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                throw new SmackException(e);
            }
        }
    }

    public static abstract class PacketExtensionIntrospectionProvider<PE extends ExtensionElement> extends ExtensionElementProvider<PE> {
        private final Class<PE> elementClass;

        public PacketExtensionIntrospectionProvider(Class<PE> cls) {
            this.elementClass = cls;
        }

        @Override // org.jivesoftware.smack.provider.Provider
        public PE parse(XmlPullParser xmlPullParser, int i) throws SmackException, XmlPullParserException, IOException {
            try {
                return (PE) IntrospectionProvider.parseWithIntrospection(this.elementClass, xmlPullParser, i);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                throw new SmackException(e);
            }
        }
    }

    private static Object decode(Class<?> cls, String str) throws ClassNotFoundException {
        String name = cls.getName();
        name.hashCode();
        if (name.equals("double")) {
            return Double.valueOf(str);
        }
        if (name.equals("java.lang.Class")) {
            return Class.forName(str);
        }
        if (name.equals("int")) {
            return Integer.valueOf(str);
        }
        if (name.equals("byte")) {
            return Byte.valueOf(str);
        }
        if (name.equals("long")) {
            return Long.valueOf(str);
        }
        if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
            return Boolean.valueOf(str);
        }
        if (name.equals(TypedValues.Custom.S_FLOAT)) {
            return Float.valueOf(str);
        }
        if (name.equals("short")) {
            return Short.valueOf(str);
        }
        if (name.equals("java.lang.String")) {
            return str;
        }
        return null;
    }

    public static Object parseWithIntrospection(Class<?> cls, XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        Object objNewInstance = cls.newInstance();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String strNextText = xmlPullParser.nextText();
                Class<?> returnType = objNewInstance.getClass().getMethod("get" + Character.toUpperCase(name.charAt(0)) + name.substring(1), new Class[0]).getReturnType();
                Object objDecode = decode(returnType, strNextText);
                objNewInstance.getClass().getMethod(RSMSet.ELEMENT + Character.toUpperCase(name.charAt(0)) + name.substring(1), returnType).invoke(objNewInstance, objDecode);
            } else if (next == 3 && xmlPullParser.getDepth() == i) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return objNewInstance;
            }
        }
    }
}
