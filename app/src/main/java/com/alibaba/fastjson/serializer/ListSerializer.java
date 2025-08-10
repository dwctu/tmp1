package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes.dex */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        int i2;
        Object obj3;
        boolean z;
        SerializeWriter serializeWriter = jSONSerializer.out;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        boolean z2 = serializeWriter.isEnabled(serializerFeature) || SerializerFeature.isEnabled(i, serializerFeature);
        SerializeWriter serializeWriter2 = jSONSerializer.out;
        Type collectionItemType = z2 ? TypeUtils.getCollectionItemType(type) : null;
        if (obj == null) {
            serializeWriter2.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            serializeWriter2.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            char c = ',';
            if (serializeWriter2.isEnabled(SerializerFeature.PrettyFormat)) {
                serializeWriter2.append('[');
                jSONSerializer.incrementIndent();
                int i3 = 0;
                for (Object obj4 : list) {
                    if (i3 != 0) {
                        serializeWriter2.append(c);
                    }
                    jSONSerializer.println();
                    if (obj4 == null) {
                        jSONSerializer.out.writeNull();
                    } else if (jSONSerializer.containsReference(obj4)) {
                        jSONSerializer.writeReference(obj4);
                    } else {
                        ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(obj4.getClass());
                        jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                        objectWriter.write(jSONSerializer, obj4, Integer.valueOf(i3), collectionItemType, i);
                    }
                    i3++;
                    c = ',';
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter2.append(']');
                return;
            }
            char c2 = ']';
            serializeWriter2.append('[');
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj5 = list.get(i4);
                if (i4 != 0) {
                    serializeWriter2.append(',');
                }
                if (obj5 == null) {
                    serializeWriter2.append((CharSequence) "null");
                } else {
                    Class<?> cls = obj5.getClass();
                    if (cls == Integer.class) {
                        serializeWriter2.writeInt(((Integer) obj5).intValue());
                    } else if (cls == Long.class) {
                        long jLongValue = ((Long) obj5).longValue();
                        if (z2) {
                            serializeWriter2.writeLong(jLongValue);
                            serializeWriter2.write(76);
                        } else {
                            serializeWriter2.writeLong(jLongValue);
                        }
                    } else {
                        if ((SerializerFeature.DisableCircularReferenceDetect.mask & i) != 0) {
                            i2 = i4;
                            jSONSerializer.getObjectWriter(obj5.getClass()).write(jSONSerializer, obj5, Integer.valueOf(i4), collectionItemType, i);
                            z = z2;
                        } else {
                            i2 = i4;
                            if (serializeWriter2.disableCircularReferenceDetect) {
                                obj3 = obj5;
                                z = z2;
                            } else {
                                obj3 = obj5;
                                z = z2;
                                jSONSerializer.context = new SerialContext(serialContext, obj, obj2, 0, 0);
                            }
                            if (jSONSerializer.containsReference(obj3)) {
                                jSONSerializer.writeReference(obj3);
                            } else {
                                ObjectSerializer objectWriter2 = jSONSerializer.getObjectWriter(obj3.getClass());
                                if ((SerializerFeature.WriteClassName.mask & i) == 0 || !(objectWriter2 instanceof JavaBeanSerializer)) {
                                    objectWriter2.write(jSONSerializer, obj3, Integer.valueOf(i2), collectionItemType, i);
                                } else {
                                    ((JavaBeanSerializer) objectWriter2).writeNoneASM(jSONSerializer, obj3, Integer.valueOf(i2), collectionItemType, i);
                                }
                            }
                        }
                        i4 = i2 + 1;
                        z2 = z;
                        c2 = ']';
                    }
                }
                i2 = i4;
                z = z2;
                i4 = i2 + 1;
                z2 = z;
                c2 = ']';
            }
            serializeWriter2.append(c2);
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
