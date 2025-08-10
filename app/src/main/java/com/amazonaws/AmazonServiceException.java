package com.amazonaws;

/* loaded from: classes.dex */
public class AmazonServiceException extends AmazonClientException {
    private static final long serialVersionUID = 1;
    private String errorCode;
    private String errorMessage;
    private ErrorType errorType;
    private String requestId;
    private String serviceName;
    private int statusCode;

    public enum ErrorType {
        Client,
        Service,
        Unknown
    }

    public AmazonServiceException(String str) {
        super(str);
        this.errorType = ErrorType.Unknown;
        this.errorMessage = str;
    }

    public String a() {
        return this.errorCode;
    }

    public String b() {
        return this.errorMessage;
    }

    public String c() {
        return this.requestId;
    }

    public String d() {
        return this.serviceName;
    }

    public int e() {
        return this.statusCode;
    }

    public void f(String str) {
        this.errorCode = str;
    }

    public void g(String str) {
        this.errorMessage = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return b() + " (Service: " + d() + "; Status Code: " + e() + "; Error Code: " + a() + "; Request ID: " + c() + ")";
    }

    public void h(ErrorType errorType) {
        this.errorType = errorType;
    }

    public void i(String str) {
        this.requestId = str;
    }

    public void j(String str) {
        this.serviceName = str;
    }

    public void k(int i) {
        this.statusCode = i;
    }
}
