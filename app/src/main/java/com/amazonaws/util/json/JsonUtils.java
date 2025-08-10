package com.amazonaws.util.json;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes.dex */
public class JsonUtils {
    public static final AwsJsonFactory a = new GsonFactory();

    public static AwsJsonReader a(Reader reader) {
        return a.b(reader);
    }

    public static AwsJsonWriter b(Writer writer) {
        return a.a(writer);
    }

    public static Map<String, String> c(Reader reader) {
        AwsJsonReader awsJsonReaderA = a(reader);
        try {
            if (awsJsonReaderA.peek() == null) {
                return Collections.EMPTY_MAP;
            }
            HashMap map = new HashMap();
            awsJsonReaderA.a();
            while (awsJsonReaderA.hasNext()) {
                String strE = awsJsonReaderA.e();
                if (awsJsonReaderA.d()) {
                    awsJsonReaderA.c();
                } else {
                    map.put(strE, awsJsonReaderA.f());
                }
            }
            awsJsonReaderA.b();
            awsJsonReaderA.close();
            return Collections.unmodifiableMap(map);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to parse JSON String.", e);
        }
    }

    public static Map<String, String> d(String str) {
        return (str == null || str.isEmpty()) ? Collections.EMPTY_MAP : c(new StringReader(str));
    }

    public static String e(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return MessageFormatter.DELIM_STR;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter awsJsonWriterB = b(stringWriter);
            awsJsonWriterB.a();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                awsJsonWriterB.c(entry.getKey());
                awsJsonWriterB.d(entry.getValue());
            }
            awsJsonWriterB.b();
            awsJsonWriterB.close();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AmazonClientException("Unable to serialize to JSON String.", e);
        }
    }
}
