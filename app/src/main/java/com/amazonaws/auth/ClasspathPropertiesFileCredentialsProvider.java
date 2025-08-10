package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: classes.dex */
public class ClasspathPropertiesFileCredentialsProvider implements AWSCredentialsProvider {
    public static String b = "AwsCredentials.properties";
    public final String a;

    public ClasspathPropertiesFileCredentialsProvider() {
        this(b);
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        InputStream resourceAsStream = ClasspathPropertiesFileCredentialsProvider.class.getResourceAsStream(this.a);
        if (resourceAsStream == null) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.a + " file on the classpath");
        }
        try {
            return new PropertiesCredentials(resourceAsStream);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.a + " file on the classpath", e);
        }
    }

    public String toString() {
        return ClasspathPropertiesFileCredentialsProvider.class.getSimpleName() + "(" + this.a + ")";
    }

    public ClasspathPropertiesFileCredentialsProvider(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Credentials file path cannot be null");
        }
        if (str.startsWith("/")) {
            this.a = str;
            return;
        }
        this.a = "/" + str;
    }
}
