package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    public ParserConfig config;
    public ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final Object input;
    public transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i = 0; i < 17; i++) {
            primitiveClasses.add(clsArr[i]);
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        }
        if (!str.equals(jSONLexer.stringVal())) {
            throw new JSONException("type not match error");
        }
        jSONLexer.nextToken();
        if (jSONLexer.token() == 16) {
            jSONLexer.nextToken();
        }
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (!(collection instanceof List)) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(collection);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            int size = collection.size() - 1;
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, size);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        return obj instanceof char[] ? new String((char[]) this.input) : obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(r0.size() - 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        Object objEval;
        FieldInfo fieldInfo;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj2 = parseContext != null ? parseContext.object : null;
            if (str.startsWith("$")) {
                objEval = getObject(str);
                if (objEval == null) {
                    try {
                        objEval = JSONPath.eval(obj, str);
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                objEval = resolveTask.context.object;
            }
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (objEval != null && objEval.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    objEval = JSONPath.eval(this.contextArray[0].object, str);
                }
                fieldDeserializer.setValue(obj2, objEval);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class<?>) type2, (Collection) arrayList);
            return arrayList;
        }
        if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (!Object.class.equals(type3)) {
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class<?>) type3, (Collection) arrayList2);
                return arrayList2;
            }
            if (wildcardType.getLowerBounds().length == 0) {
                return parse();
            }
            throw new JSONException("not support type : " + type);
        }
        if (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 1) {
                throw new JSONException("not support : " + typeVariable);
            }
            Type type4 = bounds[0];
            if (type4 instanceof Class) {
                ArrayList arrayList3 = new ArrayList();
                parseArray((Class<?>) type4, (Collection) arrayList3);
                return arrayList3;
            }
        }
        if (type2 instanceof ParameterizedType) {
            ArrayList arrayList4 = new ArrayList();
            parseArray((ParameterizedType) type2, arrayList4);
            return arrayList4;
        }
        throw new JSONException("TODO : " + type);
    }

    public void parseExtra(Object obj, String str) {
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type extraType = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                extraType = it.next().getExtraType(obj, str);
            }
        }
        Object object = extraType == null ? parse() : parseObject(extraType);
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, object);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, object);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) {
            return parse(null);
        }
        String strStringVal = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return strStringVal;
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0262, code lost:
    
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x026d, code lost:
    
        if (r5.token() != 13) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x026f, code lost:
    
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0272, code lost:
    
        r0 = r16.config.getDeserializer(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x027a, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x027c, code lost:
    
        r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0;
        r2 = r0.createInstance(r16, r8);
        r3 = r10.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x028e, code lost:
    
        if (r3.hasNext() == false) goto L380;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0290, code lost:
    
        r4 = (java.util.Map.Entry) r3.next();
        r5 = r4.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x029c, code lost:
    
        if ((r5 instanceof java.lang.String) == false) goto L384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x029e, code lost:
    
        r5 = r0.getFieldDeserializer((java.lang.String) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02a4, code lost:
    
        if (r5 == null) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02a6, code lost:
    
        r5.setValue(r2, r4.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02ae, code lost:
    
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02af, code lost:
    
        if (r2 != null) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02b3, code lost:
    
        if (r8 != java.lang.Cloneable.class) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02b5, code lost:
    
        r2 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02c1, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02c3, code lost:
    
        r2 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02c8, code lost:
    
        r2 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02cf, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02d0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02d8, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02d9, code lost:
    
        setResolveStatus(2);
        r3 = r16.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02df, code lost:
    
        if (r3 == null) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02e1, code lost:
    
        if (r18 == null) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02e5, code lost:
    
        if ((r18 instanceof java.lang.Integer) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02eb, code lost:
    
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02ed, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02f4, code lost:
    
        if (r17.size() <= 0) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02f6, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r17, (java.lang.Class<java.lang.Object>) r8, r16.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0302, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0303, code lost:
    
        r0 = r16.config.getDeserializer(r8);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0313, code lost:
    
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0317, code lost:
    
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x031b, code lost:
    
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x031d, code lost:
    
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0328, code lost:
    
        return r0.deserialze(r16, r8, r18);
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0207 A[Catch: all -> 0x0601, TryCatch #1 {all -> 0x0601, blocks: (B:24:0x0075, B:26:0x0079, B:29:0x0083, B:32:0x0096, B:36:0x00af, B:110:0x0207, B:111:0x020d, B:113:0x0218, B:115:0x0220, B:119:0x0234, B:121:0x0242, B:124:0x0255, B:127:0x0262, B:129:0x026f, B:130:0x0272, B:132:0x027c, B:133:0x028a, B:135:0x0290, B:137:0x029e, B:139:0x02a6, B:144:0x02b5, B:145:0x02bb, B:147:0x02c3, B:148:0x02c8, B:152:0x02d1, B:153:0x02d8, B:154:0x02d9, B:157:0x02e3, B:159:0x02e7, B:161:0x02ed, B:162:0x02f0, B:164:0x02f6, B:167:0x0303, B:173:0x031d, B:174:0x0321, B:122:0x0248, B:181:0x0330, B:183:0x0338, B:185:0x0342, B:187:0x0353, B:189:0x0357, B:191:0x035d, B:194:0x0362, B:196:0x0366, B:215:0x03b0, B:217:0x03b8, B:220:0x03c1, B:221:0x03c6, B:197:0x0369, B:199:0x0371, B:202:0x0377, B:203:0x0383, B:206:0x038c, B:209:0x0392, B:212:0x0398, B:213:0x03a4, B:222:0x03c7, B:223:0x03e5, B:226:0x03e9, B:228:0x03ed, B:230:0x03f1, B:233:0x03f7, B:237:0x03ff, B:243:0x040f, B:245:0x041e, B:247:0x0429, B:248:0x0431, B:249:0x0434, B:261:0x0460, B:263:0x046b, B:267:0x0478, B:270:0x0488, B:271:0x04a9, B:256:0x0444, B:258:0x044e, B:260:0x045d, B:259:0x0453, B:274:0x04ae, B:276:0x04b8, B:278:0x04be, B:279:0x04c1, B:281:0x04cc, B:282:0x04d0, B:284:0x04db, B:287:0x04e2, B:290:0x04eb, B:291:0x04f0, B:294:0x04f5, B:296:0x04fa, B:300:0x0503, B:302:0x050b, B:305:0x0529, B:307:0x052f, B:310:0x0535, B:312:0x053b, B:314:0x0543, B:317:0x0552, B:320:0x055a, B:322:0x055e, B:323:0x0565, B:325:0x056a, B:326:0x056d, B:328:0x0575, B:331:0x057f, B:334:0x0589, B:335:0x058e, B:336:0x0593, B:337:0x05ae, B:303:0x051c, B:338:0x05af, B:340:0x05c1, B:343:0x05c8, B:346:0x05d3, B:347:0x05f4, B:39:0x00c1, B:40:0x00df, B:43:0x00e4, B:45:0x00ef, B:47:0x00f3, B:49:0x00f7, B:52:0x00fd, B:59:0x010c, B:61:0x0114, B:64:0x0124, B:65:0x013c, B:66:0x013d, B:67:0x0142, B:78:0x0157, B:79:0x015d, B:81:0x0164, B:83:0x016d, B:85:0x0175, B:87:0x017a, B:90:0x0182, B:91:0x019a, B:82:0x0169, B:92:0x019b, B:93:0x01b3, B:99:0x01bd, B:101:0x01c5, B:104:0x01d6, B:105:0x01f6, B:106:0x01f7, B:107:0x01fc, B:108:0x01fd, B:348:0x05f5, B:349:0x05fa, B:350:0x05fb, B:351:0x0600), top: B:356:0x0075, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03e9 A[Catch: all -> 0x0601, TryCatch #1 {all -> 0x0601, blocks: (B:24:0x0075, B:26:0x0079, B:29:0x0083, B:32:0x0096, B:36:0x00af, B:110:0x0207, B:111:0x020d, B:113:0x0218, B:115:0x0220, B:119:0x0234, B:121:0x0242, B:124:0x0255, B:127:0x0262, B:129:0x026f, B:130:0x0272, B:132:0x027c, B:133:0x028a, B:135:0x0290, B:137:0x029e, B:139:0x02a6, B:144:0x02b5, B:145:0x02bb, B:147:0x02c3, B:148:0x02c8, B:152:0x02d1, B:153:0x02d8, B:154:0x02d9, B:157:0x02e3, B:159:0x02e7, B:161:0x02ed, B:162:0x02f0, B:164:0x02f6, B:167:0x0303, B:173:0x031d, B:174:0x0321, B:122:0x0248, B:181:0x0330, B:183:0x0338, B:185:0x0342, B:187:0x0353, B:189:0x0357, B:191:0x035d, B:194:0x0362, B:196:0x0366, B:215:0x03b0, B:217:0x03b8, B:220:0x03c1, B:221:0x03c6, B:197:0x0369, B:199:0x0371, B:202:0x0377, B:203:0x0383, B:206:0x038c, B:209:0x0392, B:212:0x0398, B:213:0x03a4, B:222:0x03c7, B:223:0x03e5, B:226:0x03e9, B:228:0x03ed, B:230:0x03f1, B:233:0x03f7, B:237:0x03ff, B:243:0x040f, B:245:0x041e, B:247:0x0429, B:248:0x0431, B:249:0x0434, B:261:0x0460, B:263:0x046b, B:267:0x0478, B:270:0x0488, B:271:0x04a9, B:256:0x0444, B:258:0x044e, B:260:0x045d, B:259:0x0453, B:274:0x04ae, B:276:0x04b8, B:278:0x04be, B:279:0x04c1, B:281:0x04cc, B:282:0x04d0, B:284:0x04db, B:287:0x04e2, B:290:0x04eb, B:291:0x04f0, B:294:0x04f5, B:296:0x04fa, B:300:0x0503, B:302:0x050b, B:305:0x0529, B:307:0x052f, B:310:0x0535, B:312:0x053b, B:314:0x0543, B:317:0x0552, B:320:0x055a, B:322:0x055e, B:323:0x0565, B:325:0x056a, B:326:0x056d, B:328:0x0575, B:331:0x057f, B:334:0x0589, B:335:0x058e, B:336:0x0593, B:337:0x05ae, B:303:0x051c, B:338:0x05af, B:340:0x05c1, B:343:0x05c8, B:346:0x05d3, B:347:0x05f4, B:39:0x00c1, B:40:0x00df, B:43:0x00e4, B:45:0x00ef, B:47:0x00f3, B:49:0x00f7, B:52:0x00fd, B:59:0x010c, B:61:0x0114, B:64:0x0124, B:65:0x013c, B:66:0x013d, B:67:0x0142, B:78:0x0157, B:79:0x015d, B:81:0x0164, B:83:0x016d, B:85:0x0175, B:87:0x017a, B:90:0x0182, B:91:0x019a, B:82:0x0169, B:92:0x019b, B:93:0x01b3, B:99:0x01bd, B:101:0x01c5, B:104:0x01d6, B:105:0x01f6, B:106:0x01f7, B:107:0x01fc, B:108:0x01fd, B:348:0x05f5, B:349:0x05fa, B:350:0x05fb, B:351:0x0600), top: B:356:0x0075, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x040f A[Catch: all -> 0x0601, TryCatch #1 {all -> 0x0601, blocks: (B:24:0x0075, B:26:0x0079, B:29:0x0083, B:32:0x0096, B:36:0x00af, B:110:0x0207, B:111:0x020d, B:113:0x0218, B:115:0x0220, B:119:0x0234, B:121:0x0242, B:124:0x0255, B:127:0x0262, B:129:0x026f, B:130:0x0272, B:132:0x027c, B:133:0x028a, B:135:0x0290, B:137:0x029e, B:139:0x02a6, B:144:0x02b5, B:145:0x02bb, B:147:0x02c3, B:148:0x02c8, B:152:0x02d1, B:153:0x02d8, B:154:0x02d9, B:157:0x02e3, B:159:0x02e7, B:161:0x02ed, B:162:0x02f0, B:164:0x02f6, B:167:0x0303, B:173:0x031d, B:174:0x0321, B:122:0x0248, B:181:0x0330, B:183:0x0338, B:185:0x0342, B:187:0x0353, B:189:0x0357, B:191:0x035d, B:194:0x0362, B:196:0x0366, B:215:0x03b0, B:217:0x03b8, B:220:0x03c1, B:221:0x03c6, B:197:0x0369, B:199:0x0371, B:202:0x0377, B:203:0x0383, B:206:0x038c, B:209:0x0392, B:212:0x0398, B:213:0x03a4, B:222:0x03c7, B:223:0x03e5, B:226:0x03e9, B:228:0x03ed, B:230:0x03f1, B:233:0x03f7, B:237:0x03ff, B:243:0x040f, B:245:0x041e, B:247:0x0429, B:248:0x0431, B:249:0x0434, B:261:0x0460, B:263:0x046b, B:267:0x0478, B:270:0x0488, B:271:0x04a9, B:256:0x0444, B:258:0x044e, B:260:0x045d, B:259:0x0453, B:274:0x04ae, B:276:0x04b8, B:278:0x04be, B:279:0x04c1, B:281:0x04cc, B:282:0x04d0, B:284:0x04db, B:287:0x04e2, B:290:0x04eb, B:291:0x04f0, B:294:0x04f5, B:296:0x04fa, B:300:0x0503, B:302:0x050b, B:305:0x0529, B:307:0x052f, B:310:0x0535, B:312:0x053b, B:314:0x0543, B:317:0x0552, B:320:0x055a, B:322:0x055e, B:323:0x0565, B:325:0x056a, B:326:0x056d, B:328:0x0575, B:331:0x057f, B:334:0x0589, B:335:0x058e, B:336:0x0593, B:337:0x05ae, B:303:0x051c, B:338:0x05af, B:340:0x05c1, B:343:0x05c8, B:346:0x05d3, B:347:0x05f4, B:39:0x00c1, B:40:0x00df, B:43:0x00e4, B:45:0x00ef, B:47:0x00f3, B:49:0x00f7, B:52:0x00fd, B:59:0x010c, B:61:0x0114, B:64:0x0124, B:65:0x013c, B:66:0x013d, B:67:0x0142, B:78:0x0157, B:79:0x015d, B:81:0x0164, B:83:0x016d, B:85:0x0175, B:87:0x017a, B:90:0x0182, B:91:0x019a, B:82:0x0169, B:92:0x019b, B:93:0x01b3, B:99:0x01bd, B:101:0x01c5, B:104:0x01d6, B:105:0x01f6, B:106:0x01f7, B:107:0x01fc, B:108:0x01fd, B:348:0x05f5, B:349:0x05fa, B:350:0x05fb, B:351:0x0600), top: B:356:0x0075, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x046b A[Catch: all -> 0x0601, TryCatch #1 {all -> 0x0601, blocks: (B:24:0x0075, B:26:0x0079, B:29:0x0083, B:32:0x0096, B:36:0x00af, B:110:0x0207, B:111:0x020d, B:113:0x0218, B:115:0x0220, B:119:0x0234, B:121:0x0242, B:124:0x0255, B:127:0x0262, B:129:0x026f, B:130:0x0272, B:132:0x027c, B:133:0x028a, B:135:0x0290, B:137:0x029e, B:139:0x02a6, B:144:0x02b5, B:145:0x02bb, B:147:0x02c3, B:148:0x02c8, B:152:0x02d1, B:153:0x02d8, B:154:0x02d9, B:157:0x02e3, B:159:0x02e7, B:161:0x02ed, B:162:0x02f0, B:164:0x02f6, B:167:0x0303, B:173:0x031d, B:174:0x0321, B:122:0x0248, B:181:0x0330, B:183:0x0338, B:185:0x0342, B:187:0x0353, B:189:0x0357, B:191:0x035d, B:194:0x0362, B:196:0x0366, B:215:0x03b0, B:217:0x03b8, B:220:0x03c1, B:221:0x03c6, B:197:0x0369, B:199:0x0371, B:202:0x0377, B:203:0x0383, B:206:0x038c, B:209:0x0392, B:212:0x0398, B:213:0x03a4, B:222:0x03c7, B:223:0x03e5, B:226:0x03e9, B:228:0x03ed, B:230:0x03f1, B:233:0x03f7, B:237:0x03ff, B:243:0x040f, B:245:0x041e, B:247:0x0429, B:248:0x0431, B:249:0x0434, B:261:0x0460, B:263:0x046b, B:267:0x0478, B:270:0x0488, B:271:0x04a9, B:256:0x0444, B:258:0x044e, B:260:0x045d, B:259:0x0453, B:274:0x04ae, B:276:0x04b8, B:278:0x04be, B:279:0x04c1, B:281:0x04cc, B:282:0x04d0, B:284:0x04db, B:287:0x04e2, B:290:0x04eb, B:291:0x04f0, B:294:0x04f5, B:296:0x04fa, B:300:0x0503, B:302:0x050b, B:305:0x0529, B:307:0x052f, B:310:0x0535, B:312:0x053b, B:314:0x0543, B:317:0x0552, B:320:0x055a, B:322:0x055e, B:323:0x0565, B:325:0x056a, B:326:0x056d, B:328:0x0575, B:331:0x057f, B:334:0x0589, B:335:0x058e, B:336:0x0593, B:337:0x05ae, B:303:0x051c, B:338:0x05af, B:340:0x05c1, B:343:0x05c8, B:346:0x05d3, B:347:0x05f4, B:39:0x00c1, B:40:0x00df, B:43:0x00e4, B:45:0x00ef, B:47:0x00f3, B:49:0x00f7, B:52:0x00fd, B:59:0x010c, B:61:0x0114, B:64:0x0124, B:65:0x013c, B:66:0x013d, B:67:0x0142, B:78:0x0157, B:79:0x015d, B:81:0x0164, B:83:0x016d, B:85:0x0175, B:87:0x017a, B:90:0x0182, B:91:0x019a, B:82:0x0169, B:92:0x019b, B:93:0x01b3, B:99:0x01bd, B:101:0x01c5, B:104:0x01d6, B:105:0x01f6, B:106:0x01f7, B:107:0x01fc, B:108:0x01fd, B:348:0x05f5, B:349:0x05fa, B:350:0x05fb, B:351:0x0600), top: B:356:0x0075, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0552 A[Catch: all -> 0x0601, TryCatch #1 {all -> 0x0601, blocks: (B:24:0x0075, B:26:0x0079, B:29:0x0083, B:32:0x0096, B:36:0x00af, B:110:0x0207, B:111:0x020d, B:113:0x0218, B:115:0x0220, B:119:0x0234, B:121:0x0242, B:124:0x0255, B:127:0x0262, B:129:0x026f, B:130:0x0272, B:132:0x027c, B:133:0x028a, B:135:0x0290, B:137:0x029e, B:139:0x02a6, B:144:0x02b5, B:145:0x02bb, B:147:0x02c3, B:148:0x02c8, B:152:0x02d1, B:153:0x02d8, B:154:0x02d9, B:157:0x02e3, B:159:0x02e7, B:161:0x02ed, B:162:0x02f0, B:164:0x02f6, B:167:0x0303, B:173:0x031d, B:174:0x0321, B:122:0x0248, B:181:0x0330, B:183:0x0338, B:185:0x0342, B:187:0x0353, B:189:0x0357, B:191:0x035d, B:194:0x0362, B:196:0x0366, B:215:0x03b0, B:217:0x03b8, B:220:0x03c1, B:221:0x03c6, B:197:0x0369, B:199:0x0371, B:202:0x0377, B:203:0x0383, B:206:0x038c, B:209:0x0392, B:212:0x0398, B:213:0x03a4, B:222:0x03c7, B:223:0x03e5, B:226:0x03e9, B:228:0x03ed, B:230:0x03f1, B:233:0x03f7, B:237:0x03ff, B:243:0x040f, B:245:0x041e, B:247:0x0429, B:248:0x0431, B:249:0x0434, B:261:0x0460, B:263:0x046b, B:267:0x0478, B:270:0x0488, B:271:0x04a9, B:256:0x0444, B:258:0x044e, B:260:0x045d, B:259:0x0453, B:274:0x04ae, B:276:0x04b8, B:278:0x04be, B:279:0x04c1, B:281:0x04cc, B:282:0x04d0, B:284:0x04db, B:287:0x04e2, B:290:0x04eb, B:291:0x04f0, B:294:0x04f5, B:296:0x04fa, B:300:0x0503, B:302:0x050b, B:305:0x0529, B:307:0x052f, B:310:0x0535, B:312:0x053b, B:314:0x0543, B:317:0x0552, B:320:0x055a, B:322:0x055e, B:323:0x0565, B:325:0x056a, B:326:0x056d, B:328:0x0575, B:331:0x057f, B:334:0x0589, B:335:0x058e, B:336:0x0593, B:337:0x05ae, B:303:0x051c, B:338:0x05af, B:340:0x05c1, B:343:0x05c8, B:346:0x05d3, B:347:0x05f4, B:39:0x00c1, B:40:0x00df, B:43:0x00e4, B:45:0x00ef, B:47:0x00f3, B:49:0x00f7, B:52:0x00fd, B:59:0x010c, B:61:0x0114, B:64:0x0124, B:65:0x013c, B:66:0x013d, B:67:0x0142, B:78:0x0157, B:79:0x015d, B:81:0x0164, B:83:0x016d, B:85:0x0175, B:87:0x017a, B:90:0x0182, B:91:0x019a, B:82:0x0169, B:92:0x019b, B:93:0x01b3, B:99:0x01bd, B:101:0x01c5, B:104:0x01d6, B:105:0x01f6, B:106:0x01f7, B:107:0x01fc, B:108:0x01fd, B:348:0x05f5, B:349:0x05fa, B:350:0x05fb, B:351:0x0600), top: B:356:0x0075, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x055e A[Catch: all -> 0x0601, TryCatch #1 {all -> 0x0601, blocks: (B:24:0x0075, B:26:0x0079, B:29:0x0083, B:32:0x0096, B:36:0x00af, B:110:0x0207, B:111:0x020d, B:113:0x0218, B:115:0x0220, B:119:0x0234, B:121:0x0242, B:124:0x0255, B:127:0x0262, B:129:0x026f, B:130:0x0272, B:132:0x027c, B:133:0x028a, B:135:0x0290, B:137:0x029e, B:139:0x02a6, B:144:0x02b5, B:145:0x02bb, B:147:0x02c3, B:148:0x02c8, B:152:0x02d1, B:153:0x02d8, B:154:0x02d9, B:157:0x02e3, B:159:0x02e7, B:161:0x02ed, B:162:0x02f0, B:164:0x02f6, B:167:0x0303, B:173:0x031d, B:174:0x0321, B:122:0x0248, B:181:0x0330, B:183:0x0338, B:185:0x0342, B:187:0x0353, B:189:0x0357, B:191:0x035d, B:194:0x0362, B:196:0x0366, B:215:0x03b0, B:217:0x03b8, B:220:0x03c1, B:221:0x03c6, B:197:0x0369, B:199:0x0371, B:202:0x0377, B:203:0x0383, B:206:0x038c, B:209:0x0392, B:212:0x0398, B:213:0x03a4, B:222:0x03c7, B:223:0x03e5, B:226:0x03e9, B:228:0x03ed, B:230:0x03f1, B:233:0x03f7, B:237:0x03ff, B:243:0x040f, B:245:0x041e, B:247:0x0429, B:248:0x0431, B:249:0x0434, B:261:0x0460, B:263:0x046b, B:267:0x0478, B:270:0x0488, B:271:0x04a9, B:256:0x0444, B:258:0x044e, B:260:0x045d, B:259:0x0453, B:274:0x04ae, B:276:0x04b8, B:278:0x04be, B:279:0x04c1, B:281:0x04cc, B:282:0x04d0, B:284:0x04db, B:287:0x04e2, B:290:0x04eb, B:291:0x04f0, B:294:0x04f5, B:296:0x04fa, B:300:0x0503, B:302:0x050b, B:305:0x0529, B:307:0x052f, B:310:0x0535, B:312:0x053b, B:314:0x0543, B:317:0x0552, B:320:0x055a, B:322:0x055e, B:323:0x0565, B:325:0x056a, B:326:0x056d, B:328:0x0575, B:331:0x057f, B:334:0x0589, B:335:0x058e, B:336:0x0593, B:337:0x05ae, B:303:0x051c, B:338:0x05af, B:340:0x05c1, B:343:0x05c8, B:346:0x05d3, B:347:0x05f4, B:39:0x00c1, B:40:0x00df, B:43:0x00e4, B:45:0x00ef, B:47:0x00f3, B:49:0x00f7, B:52:0x00fd, B:59:0x010c, B:61:0x0114, B:64:0x0124, B:65:0x013c, B:66:0x013d, B:67:0x0142, B:78:0x0157, B:79:0x015d, B:81:0x0164, B:83:0x016d, B:85:0x0175, B:87:0x017a, B:90:0x0182, B:91:0x019a, B:82:0x0169, B:92:0x019b, B:93:0x01b3, B:99:0x01bd, B:101:0x01c5, B:104:0x01d6, B:105:0x01f6, B:106:0x01f7, B:107:0x01fc, B:108:0x01fd, B:348:0x05f5, B:349:0x05fa, B:350:0x05fb, B:351:0x0600), top: B:356:0x0075, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x056a A[Catch: all -> 0x0601, TryCatch #1 {all -> 0x0601, blocks: (B:24:0x0075, B:26:0x0079, B:29:0x0083, B:32:0x0096, B:36:0x00af, B:110:0x0207, B:111:0x020d, B:113:0x0218, B:115:0x0220, B:119:0x0234, B:121:0x0242, B:124:0x0255, B:127:0x0262, B:129:0x026f, B:130:0x0272, B:132:0x027c, B:133:0x028a, B:135:0x0290, B:137:0x029e, B:139:0x02a6, B:144:0x02b5, B:145:0x02bb, B:147:0x02c3, B:148:0x02c8, B:152:0x02d1, B:153:0x02d8, B:154:0x02d9, B:157:0x02e3, B:159:0x02e7, B:161:0x02ed, B:162:0x02f0, B:164:0x02f6, B:167:0x0303, B:173:0x031d, B:174:0x0321, B:122:0x0248, B:181:0x0330, B:183:0x0338, B:185:0x0342, B:187:0x0353, B:189:0x0357, B:191:0x035d, B:194:0x0362, B:196:0x0366, B:215:0x03b0, B:217:0x03b8, B:220:0x03c1, B:221:0x03c6, B:197:0x0369, B:199:0x0371, B:202:0x0377, B:203:0x0383, B:206:0x038c, B:209:0x0392, B:212:0x0398, B:213:0x03a4, B:222:0x03c7, B:223:0x03e5, B:226:0x03e9, B:228:0x03ed, B:230:0x03f1, B:233:0x03f7, B:237:0x03ff, B:243:0x040f, B:245:0x041e, B:247:0x0429, B:248:0x0431, B:249:0x0434, B:261:0x0460, B:263:0x046b, B:267:0x0478, B:270:0x0488, B:271:0x04a9, B:256:0x0444, B:258:0x044e, B:260:0x045d, B:259:0x0453, B:274:0x04ae, B:276:0x04b8, B:278:0x04be, B:279:0x04c1, B:281:0x04cc, B:282:0x04d0, B:284:0x04db, B:287:0x04e2, B:290:0x04eb, B:291:0x04f0, B:294:0x04f5, B:296:0x04fa, B:300:0x0503, B:302:0x050b, B:305:0x0529, B:307:0x052f, B:310:0x0535, B:312:0x053b, B:314:0x0543, B:317:0x0552, B:320:0x055a, B:322:0x055e, B:323:0x0565, B:325:0x056a, B:326:0x056d, B:328:0x0575, B:331:0x057f, B:334:0x0589, B:335:0x058e, B:336:0x0593, B:337:0x05ae, B:303:0x051c, B:338:0x05af, B:340:0x05c1, B:343:0x05c8, B:346:0x05d3, B:347:0x05f4, B:39:0x00c1, B:40:0x00df, B:43:0x00e4, B:45:0x00ef, B:47:0x00f3, B:49:0x00f7, B:52:0x00fd, B:59:0x010c, B:61:0x0114, B:64:0x0124, B:65:0x013c, B:66:0x013d, B:67:0x0142, B:78:0x0157, B:79:0x015d, B:81:0x0164, B:83:0x016d, B:85:0x0175, B:87:0x017a, B:90:0x0182, B:91:0x019a, B:82:0x0169, B:92:0x019b, B:93:0x01b3, B:99:0x01bd, B:101:0x01c5, B:104:0x01d6, B:105:0x01f6, B:106:0x01f7, B:107:0x01fc, B:108:0x01fd, B:348:0x05f5, B:349:0x05fa, B:350:0x05fb, B:351:0x0600), top: B:356:0x0075, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x057f A[Catch: all -> 0x0601, TRY_ENTER, TryCatch #1 {all -> 0x0601, blocks: (B:24:0x0075, B:26:0x0079, B:29:0x0083, B:32:0x0096, B:36:0x00af, B:110:0x0207, B:111:0x020d, B:113:0x0218, B:115:0x0220, B:119:0x0234, B:121:0x0242, B:124:0x0255, B:127:0x0262, B:129:0x026f, B:130:0x0272, B:132:0x027c, B:133:0x028a, B:135:0x0290, B:137:0x029e, B:139:0x02a6, B:144:0x02b5, B:145:0x02bb, B:147:0x02c3, B:148:0x02c8, B:152:0x02d1, B:153:0x02d8, B:154:0x02d9, B:157:0x02e3, B:159:0x02e7, B:161:0x02ed, B:162:0x02f0, B:164:0x02f6, B:167:0x0303, B:173:0x031d, B:174:0x0321, B:122:0x0248, B:181:0x0330, B:183:0x0338, B:185:0x0342, B:187:0x0353, B:189:0x0357, B:191:0x035d, B:194:0x0362, B:196:0x0366, B:215:0x03b0, B:217:0x03b8, B:220:0x03c1, B:221:0x03c6, B:197:0x0369, B:199:0x0371, B:202:0x0377, B:203:0x0383, B:206:0x038c, B:209:0x0392, B:212:0x0398, B:213:0x03a4, B:222:0x03c7, B:223:0x03e5, B:226:0x03e9, B:228:0x03ed, B:230:0x03f1, B:233:0x03f7, B:237:0x03ff, B:243:0x040f, B:245:0x041e, B:247:0x0429, B:248:0x0431, B:249:0x0434, B:261:0x0460, B:263:0x046b, B:267:0x0478, B:270:0x0488, B:271:0x04a9, B:256:0x0444, B:258:0x044e, B:260:0x045d, B:259:0x0453, B:274:0x04ae, B:276:0x04b8, B:278:0x04be, B:279:0x04c1, B:281:0x04cc, B:282:0x04d0, B:284:0x04db, B:287:0x04e2, B:290:0x04eb, B:291:0x04f0, B:294:0x04f5, B:296:0x04fa, B:300:0x0503, B:302:0x050b, B:305:0x0529, B:307:0x052f, B:310:0x0535, B:312:0x053b, B:314:0x0543, B:317:0x0552, B:320:0x055a, B:322:0x055e, B:323:0x0565, B:325:0x056a, B:326:0x056d, B:328:0x0575, B:331:0x057f, B:334:0x0589, B:335:0x058e, B:336:0x0593, B:337:0x05ae, B:303:0x051c, B:338:0x05af, B:340:0x05c1, B:343:0x05c8, B:346:0x05d3, B:347:0x05f4, B:39:0x00c1, B:40:0x00df, B:43:0x00e4, B:45:0x00ef, B:47:0x00f3, B:49:0x00f7, B:52:0x00fd, B:59:0x010c, B:61:0x0114, B:64:0x0124, B:65:0x013c, B:66:0x013d, B:67:0x0142, B:78:0x0157, B:79:0x015d, B:81:0x0164, B:83:0x016d, B:85:0x0175, B:87:0x017a, B:90:0x0182, B:91:0x019a, B:82:0x0169, B:92:0x019b, B:93:0x01b3, B:99:0x01bd, B:101:0x01c5, B:104:0x01d6, B:105:0x01f6, B:106:0x01f7, B:107:0x01fc, B:108:0x01fd, B:348:0x05f5, B:349:0x05fa, B:350:0x05fb, B:351:0x0600), top: B:356:0x0075, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0474 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0575 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 1542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i = this.contextArrayIndex;
        if (i <= 0) {
            return;
        }
        int i2 = i - 1;
        this.contextArrayIndex = i2;
        this.contextArray[i2] = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object resolveReference(java.lang.String r5) {
        /*
            r4 = this;
            com.alibaba.fastjson.parser.ParseContext[] r0 = r4.contextArray
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            r0 = 0
        L7:
            com.alibaba.fastjson.parser.ParseContext[] r2 = r4.contextArray
            int r3 = r2.length
            if (r0 >= r3) goto L22
            int r3 = r4.contextArrayIndex
            if (r0 >= r3) goto L22
            r2 = r2[r0]
            java.lang.String r3 = r2.toString()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L1f
            java.lang.Object r5 = r2.object
            return r5
        L1f:
            int r0 = r0 + 1
            goto L7
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.resolveReference(java.lang.String):java.lang.Object");
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number numberIntegerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return numberIntegerValue;
        }
        if (i == 3) {
            Number numberDecimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return numberDecimalValue;
        }
        if (i == 4) {
            String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(strStringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return strStringVal;
        }
        if (i == 12) {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
        if (i == 14) {
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
        }
        if (i == 18) {
            if ("NaN".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                return null;
            }
            throw new JSONException("syntax error, " + jSONLexer.info());
        }
        if (i == 26) {
            byte[] bArrBytesValue = jSONLexer.bytesValue();
            jSONLexer.nextToken();
            return bArrBytesValue;
        }
        switch (i) {
            case 6:
                jSONLexer.nextToken();
                return Boolean.TRUE;
            case 7:
                jSONLexer.nextToken();
                return Boolean.FALSE;
            case 8:
                jSONLexer.nextToken();
                return null;
            case 9:
                jSONLexer.nextToken(18);
                if (jSONLexer.token() != 18) {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken(10);
                accept(10);
                long jLongValue = jSONLexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new Date(jLongValue);
            default:
                switch (i) {
                    case 20:
                        if (jSONLexer.isBlankInput()) {
                            return null;
                        }
                        throw new JSONException("unterminated json string, " + jSONLexer.info());
                    case 21:
                        jSONLexer.nextToken();
                        HashSet hashSet = new HashSet();
                        parseArray(hashSet, obj);
                        return hashSet;
                    case 22:
                        jSONLexer.nextToken();
                        TreeSet treeSet = new TreeSet();
                        parseArray(treeSet, obj);
                        return treeSet;
                    case 23:
                        jSONLexer.nextToken();
                        return null;
                    default:
                        throw new JSONException("syntax error, " + jSONLexer.info());
                }
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i == 14) {
            if (Integer.TYPE != type) {
                if (String.class == type) {
                    deserializer = StringCodec.instance;
                    this.lexer.nextToken(4);
                } else {
                    deserializer = this.config.getDeserializer(type);
                    this.lexer.nextToken(deserializer.getFastMatchToken());
                }
            } else {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object objDeserialze = null;
                    if (Integer.TYPE != type) {
                        if (String.class == type) {
                            if (this.lexer.token() == 4) {
                                objDeserialze = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object obj2 = parse();
                                if (obj2 != null) {
                                    objDeserialze = obj2.toString();
                                }
                            }
                            collection.add(objDeserialze);
                        } else {
                            if (this.lexer.token() == 8) {
                                this.lexer.nextToken();
                            } else {
                                objDeserialze = deserializer.deserialze(this, type, Integer.valueOf(i2));
                            }
                            collection.add(objDeserialze);
                            checkListResolve(collection);
                        }
                    } else {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i2++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object objCast;
        Class<?> componentType;
        boolean zIsArray;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i3 = 0;
            while (i3 < typeArr.length) {
                if (this.lexer.token() == i) {
                    this.lexer.nextToken(16);
                    objCast = null;
                } else {
                    Type type = typeArr[i3];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                objCast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                objCast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i3 == typeArr.length - 1 && (type instanceof Class)) {
                                Class cls = (Class) type;
                                zIsArray = cls.isArray();
                                componentType = cls.getComponentType();
                            } else {
                                componentType = null;
                                zIsArray = false;
                            }
                            if (zIsArray && this.lexer.token() != i2) {
                                ArrayList arrayList = new ArrayList();
                                ObjectDeserializer deserializer = this.config.getDeserializer(componentType);
                                int fastMatchToken = deserializer.getFastMatchToken();
                                if (this.lexer.token() != 15) {
                                    while (true) {
                                        arrayList.add(deserializer.deserialze(this, type, null));
                                        if (this.lexer.token() != 16) {
                                            break;
                                        }
                                        this.lexer.nextToken(fastMatchToken);
                                    }
                                    if (this.lexer.token() != 15) {
                                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                    }
                                }
                                objCast = TypeUtils.cast(arrayList, type, this.config);
                            } else {
                                objCast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i3));
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        objCast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        objCast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i3] = objCast;
                if (this.lexer.token() == 15) {
                    break;
                }
                if (this.lexer.token() == 16) {
                    if (i3 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i3++;
                    i = 8;
                    i2 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0238, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable, java.lang.Object):java.lang.Object");
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Number numberDecimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i2 = jSONLexer.token();
                    Object object = null;
                    object = null;
                    if (i2 == 2) {
                        Number numberIntegerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        object = numberIntegerValue;
                    } else if (i2 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            numberDecimalValue = jSONLexer.decimalValue(true);
                        } else {
                            numberDecimalValue = jSONLexer.decimalValue(false);
                        }
                        object = numberDecimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i2 == 4) {
                        String strStringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        object = strStringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(strStringVal);
                            Object time = strStringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                time = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            object = time;
                        }
                    } else if (i2 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        object = bool;
                    } else if (i2 == 7) {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        object = bool2;
                    } else if (i2 == 8) {
                        jSONLexer.nextToken(4);
                    } else if (i2 == 12) {
                        object = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                    } else {
                        if (i2 == 20) {
                            throw new JSONException("unclosed jsonArray");
                        }
                        if (i2 == 23) {
                            jSONLexer.nextToken(4);
                        } else if (i2 == 14) {
                            JSONArray jSONArray = new JSONArray();
                            parseArray(jSONArray, Integer.valueOf(i));
                            object = jSONArray;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                object = jSONArray.toArray();
                            }
                        } else if (i2 != 15) {
                            object = parse();
                        } else {
                            jSONLexer.nextToken(16);
                            return;
                        }
                    }
                    collection.add(object);
                    checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i++;
                } finally {
                    setContext(parseContext);
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            }
            if (type == char[].class) {
                String strStringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) strStringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object objDeserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String strScanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (strScanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() != 16 || !this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(strScanSymbol) : null;
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + strScanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    objDeserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    objDeserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    objDeserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    objDeserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, objDeserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }
}
