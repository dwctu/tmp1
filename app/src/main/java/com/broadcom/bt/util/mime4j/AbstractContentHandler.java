package com.broadcom.bt.util.mime4j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class AbstractContentHandler implements ContentHandler {
    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void body(BodyDescriptor bodyDescriptor, InputStream inputStream) throws IOException {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void endBodyPart() {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void endHeader() {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void endMessage() {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void endMultipart() {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void epilogue(InputStream inputStream) throws IOException {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void field(String str) {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void preamble(InputStream inputStream) throws IOException {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void raw(InputStream inputStream) throws IOException {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void startBodyPart() {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void startHeader() {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void startMessage() {
    }

    @Override // com.broadcom.bt.util.mime4j.ContentHandler
    public void startMultipart(BodyDescriptor bodyDescriptor) {
    }
}
