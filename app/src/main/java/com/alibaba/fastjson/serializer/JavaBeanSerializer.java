package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    public SerializeBeanInfo beanInfo;
    public final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    public final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        HashMap map = new HashMap();
        for (String str : strArr) {
            map.put(str, str);
        }
        return map;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            Iterator<LabelFilter> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 == null) {
            return true;
        }
        Iterator<LabelFilter> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(str)) {
                return false;
            }
        }
        return true;
    }

    public BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int iCompareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (iCompareTo < 0) {
                i = i2 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return this.sortedGetters[i2];
                }
                length = i2 - 1;
            }
        }
        return null;
    }

    public Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer == null) {
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            Iterator<AfterFilter> it = list.iterator();
            while (it.hasNext()) {
                c = it.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            Iterator<AfterFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            Iterator<BeforeFilter> it = list.iterator();
            while (it.hasNext()) {
                c = it.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            Iterator<BeforeFilter> it2 = list2.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String name = this.beanInfo.typeName;
        if (name == null) {
            Class<?> superclass = obj.getClass();
            if (TypeUtils.isProxy(superclass)) {
                superclass = superclass.getSuperclass();
            }
            name = superclass.getName();
        }
        jSONSerializer.write(name);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || (identityHashMap = jSONSerializer.references) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0236 A[Catch: Exception -> 0x03d4, all -> 0x040f, TryCatch #5 {Exception -> 0x03d4, blocks: (B:64:0x00d8, B:75:0x00f9, B:83:0x010d, B:99:0x0134, B:108:0x0151, B:111:0x0172, B:113:0x017a, B:116:0x0187, B:118:0x0192, B:120:0x0196, B:123:0x019d, B:125:0x01a0, B:127:0x01a5, B:129:0x01ab, B:131:0x01b6, B:133:0x01ba, B:136:0x01c1, B:138:0x01c4, B:141:0x01cc, B:143:0x01d4, B:145:0x01df, B:147:0x01e3, B:150:0x01ea, B:152:0x01ed, B:154:0x01f2, B:155:0x01f7, B:157:0x01ff, B:159:0x020a, B:161:0x020e, B:164:0x0215, B:166:0x0218, B:168:0x021d, B:170:0x0224, B:172:0x0228, B:176:0x0236, B:178:0x023a, B:180:0x0243, B:182:0x024a, B:184:0x0250, B:186:0x0254, B:189:0x025f, B:191:0x0263, B:193:0x0267, B:196:0x0272, B:198:0x0276, B:200:0x027a, B:203:0x0285, B:205:0x0289, B:207:0x028d, B:210:0x029b, B:212:0x029f, B:214:0x02a3, B:217:0x02b0, B:219:0x02b4, B:221:0x02b8, B:224:0x02c6, B:226:0x02ca, B:228:0x02ce, B:232:0x02da, B:234:0x02de, B:236:0x02e2, B:239:0x02ef, B:241:0x02fa, B:245:0x0303, B:247:0x0309, B:288:0x0386, B:290:0x038a, B:292:0x038e, B:295:0x0398, B:297:0x03a0, B:298:0x03a8, B:300:0x03ae, B:252:0x0314, B:253:0x0317, B:255:0x031d, B:258:0x0323, B:262:0x0333, B:265:0x033b, B:268:0x0345, B:270:0x034e, B:273:0x0354, B:274:0x0358, B:275:0x035c, B:277:0x0363, B:278:0x0367, B:279:0x036b, B:281:0x036f, B:283:0x0373, B:286:0x037f, B:287:0x0383, B:259:0x032b, B:97:0x012c, B:309:0x03c0), top: B:359:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x024a A[Catch: Exception -> 0x03d4, all -> 0x040f, TryCatch #5 {Exception -> 0x03d4, blocks: (B:64:0x00d8, B:75:0x00f9, B:83:0x010d, B:99:0x0134, B:108:0x0151, B:111:0x0172, B:113:0x017a, B:116:0x0187, B:118:0x0192, B:120:0x0196, B:123:0x019d, B:125:0x01a0, B:127:0x01a5, B:129:0x01ab, B:131:0x01b6, B:133:0x01ba, B:136:0x01c1, B:138:0x01c4, B:141:0x01cc, B:143:0x01d4, B:145:0x01df, B:147:0x01e3, B:150:0x01ea, B:152:0x01ed, B:154:0x01f2, B:155:0x01f7, B:157:0x01ff, B:159:0x020a, B:161:0x020e, B:164:0x0215, B:166:0x0218, B:168:0x021d, B:170:0x0224, B:172:0x0228, B:176:0x0236, B:178:0x023a, B:180:0x0243, B:182:0x024a, B:184:0x0250, B:186:0x0254, B:189:0x025f, B:191:0x0263, B:193:0x0267, B:196:0x0272, B:198:0x0276, B:200:0x027a, B:203:0x0285, B:205:0x0289, B:207:0x028d, B:210:0x029b, B:212:0x029f, B:214:0x02a3, B:217:0x02b0, B:219:0x02b4, B:221:0x02b8, B:224:0x02c6, B:226:0x02ca, B:228:0x02ce, B:232:0x02da, B:234:0x02de, B:236:0x02e2, B:239:0x02ef, B:241:0x02fa, B:245:0x0303, B:247:0x0309, B:288:0x0386, B:290:0x038a, B:292:0x038e, B:295:0x0398, B:297:0x03a0, B:298:0x03a8, B:300:0x03ae, B:252:0x0314, B:253:0x0317, B:255:0x031d, B:258:0x0323, B:262:0x0333, B:265:0x033b, B:268:0x0345, B:270:0x034e, B:273:0x0354, B:274:0x0358, B:275:0x035c, B:277:0x0363, B:278:0x0367, B:279:0x036b, B:281:0x036f, B:283:0x0373, B:286:0x037f, B:287:0x0383, B:259:0x032b, B:97:0x012c, B:309:0x03c0), top: B:359:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0442 A[Catch: all -> 0x047a, TryCatch #4 {all -> 0x047a, blocks: (B:339:0x0422, B:342:0x0442, B:343:0x0456, B:345:0x045c, B:346:0x0474, B:347:0x0479), top: B:357:0x0422 }] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x045c A[Catch: all -> 0x047a, TryCatch #4 {all -> 0x047a, blocks: (B:339:0x0422, B:342:0x0442, B:343:0x0456, B:345:0x045c, B:346:0x0474, B:347:0x0479), top: B:357:0x0422 }] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0422 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x03c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r29, java.lang.Object r30, java.lang.Object r31, java.lang.reflect.Type r32, int r33, boolean r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i2 >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i2] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i2]);
            i2++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
            return;
        }
        this.getters = new FieldSerializer[fieldInfoArr.length];
        while (true) {
            FieldSerializer[] fieldSerializerArr2 = this.getters;
            if (i >= fieldSerializerArr2.length) {
                return;
            }
            fieldSerializerArr2[i] = getFieldSerializer(serializeBeanInfo.fields[i].name);
            i++;
        }
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArrValues;
        int iBinarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArrValues = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArrValues.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArrValues) {
                    String strTranslate = propertyNamingStrategy.translate(str);
                    if (!str.equals(strTranslate)) {
                        jArr[i2] = TypeUtils.fnv1a_64(strTranslate);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArrValues = null;
        }
        int iBinarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (iBinarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArrValues == null) {
                propertyNamingStrategyArrValues = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int iBinarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (iBinarySearch3 >= 0) {
                    sArr[iBinarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArrValues) {
                    String strTranslate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(strTranslate2) && (iBinarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(strTranslate2))) >= 0) {
                        sArr[iBinarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[iBinarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer == null) {
            if (!z) {
                return null;
            }
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
    }
}
