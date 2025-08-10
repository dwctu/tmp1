package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
import org.bouncycastle.asn1.eac.EACTags;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes.dex */
public class AdderSerializer implements ObjectSerializer {
    public static final AdderSerializer instance = new AdderSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof LongAdder) {
            serializeWriter.writeFieldValue(MessageFormatter.DELIM_START, "value", ((LongAdder) obj).longValue());
            serializeWriter.write(EACTags.SECURE_MESSAGING_TEMPLATE);
        } else if (obj instanceof DoubleAdder) {
            serializeWriter.writeFieldValue(MessageFormatter.DELIM_START, "value", ((DoubleAdder) obj).doubleValue());
            serializeWriter.write(EACTags.SECURE_MESSAGING_TEMPLATE);
        }
    }
}
