package com.google.auto.service.processor;

import com.google.common.base.Charsets;
import com.google.common.io.Closer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ServicesFiles {
    public static final String SERVICES_PATH = "META-INF/services";

    private ServicesFiles() {
    }

    public static String getPath(String str) {
        return "META-INF/services/" + str;
    }

    public static Set<String> readServiceFile(InputStream inputStream) throws Throwable {
        HashSet hashSet = new HashSet();
        try {
            BufferedReader bufferedReader = (BufferedReader) Closer.create().register(new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return hashSet;
                }
                int iIndexOf = line.indexOf(35);
                if (iIndexOf >= 0) {
                    line = line.substring(0, iIndexOf);
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    hashSet.add(strTrim);
                }
            }
        } finally {
        }
    }

    public static void writeServiceFile(Collection<String> collection, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charsets.UTF_8));
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            bufferedWriter.write(it.next());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
