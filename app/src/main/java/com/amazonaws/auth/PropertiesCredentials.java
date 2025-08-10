package com.amazonaws.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes.dex */
public class PropertiesCredentials implements AWSCredentials {
    public final String a;
    public final String b;

    public PropertiesCredentials(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File doesn't exist:  " + file.getAbsolutePath());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            if (properties.getProperty("accessKey") != null && properties.getProperty("secretKey") != null) {
                this.a = properties.getProperty("accessKey");
                this.b = properties.getProperty("secretKey");
            } else {
                throw new IllegalArgumentException("The specified file (" + file.getAbsolutePath() + ") doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String a() {
        return this.a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String b() {
        return this.b;
    }

    public PropertiesCredentials(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            if (properties.getProperty("accessKey") != null && properties.getProperty("secretKey") != null) {
                this.a = properties.getProperty("accessKey");
                this.b = properties.getProperty("secretKey");
                return;
            }
            throw new IllegalArgumentException("The specified properties data doesn't contain the expected properties 'accessKey' and 'secretKey'.");
        } finally {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
