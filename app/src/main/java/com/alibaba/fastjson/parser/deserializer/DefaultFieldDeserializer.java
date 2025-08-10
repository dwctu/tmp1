package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    public boolean customDeserilizer;
    public ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        boolean z = false;
        this.customDeserilizer = false;
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            Class<?> clsDeserializeUsing = annotation.deserializeUsing();
            if (clsDeserializeUsing != null && clsDeserializeUsing != Void.class) {
                z = true;
            }
            this.customDeserilizer = z;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        if (objectDeserializer != null) {
            return objectDeserializer.getFastMatchToken();
        }
        return 2;
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation == null || annotation.deserializeUsing() == Void.class) {
                FieldInfo fieldInfo = this.fieldInfo;
                this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
            } else {
                try {
                    this.fieldValueDeserilizer = (ObjectDeserializer) annotation.deserializeUsing().newInstance();
                } catch (Exception e) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e);
                }
            }
        }
        return this.fieldValueDeserilizer;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        Object objDeserialze;
        FieldInfo fieldInfo;
        int i;
        if (this.fieldValueDeserilizer == null) {
            getFieldValueDeserilizer(defaultJSONParser.getConfig());
        }
        ObjectDeserializer deserializer = this.fieldValueDeserilizer;
        Type fieldType = this.fieldInfo.fieldType;
        if (type instanceof ParameterizedType) {
            ParseContext context = defaultJSONParser.getContext();
            if (context != null) {
                context.type = type;
            }
            if (fieldType != type) {
                fieldType = FieldInfo.getFieldType(this.clazz, type, fieldType);
                deserializer = defaultJSONParser.getConfig().getDeserializer(fieldType);
            }
        }
        Type type2 = fieldType;
        if (!(deserializer instanceof JavaBeanDeserializer) || (i = (fieldInfo = this.fieldInfo).parserFeatures) == 0) {
            FieldInfo fieldInfo2 = this.fieldInfo;
            String str = fieldInfo2.format;
            objDeserialze = (str == null || !(deserializer instanceof ContextObjectDeserializer)) ? deserializer.deserialze(defaultJSONParser, type2, fieldInfo2.name) : ((ContextObjectDeserializer) deserializer).deserialze(defaultJSONParser, type2, fieldInfo2.name, str, fieldInfo2.parserFeatures);
        } else {
            objDeserialze = ((JavaBeanDeserializer) deserializer).deserialze(defaultJSONParser, type2, fieldInfo.name, i);
        }
        if ((objDeserialze instanceof byte[]) && ("gzip".equals(this.fieldInfo.format) || "gzip,base64".equals(this.fieldInfo.format))) {
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream((byte[]) objDeserialze));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int i2 = gZIPInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else if (i2 > 0) {
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                }
                objDeserialze = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new JSONException("unzip bytes error.", e);
            }
        }
        if (defaultJSONParser.getResolveStatus() == 1) {
            DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
            lastResolveTask.fieldDeserializer = this;
            lastResolveTask.ownerContext = defaultJSONParser.getContext();
            defaultJSONParser.setResolveStatus(0);
            return;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, objDeserialze);
        } else {
            setValue(obj, objDeserialze);
        }
    }

    public void parseFieldUnwrapped(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        throw new JSONException("TODO");
    }
}
