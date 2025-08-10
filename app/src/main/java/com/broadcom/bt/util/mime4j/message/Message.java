package com.broadcom.bt.util.mime4j.message;

import com.broadcom.bt.util.mime4j.BodyDescriptor;
import com.broadcom.bt.util.mime4j.ContentHandler;
import com.broadcom.bt.util.mime4j.MimeStreamParser;
import com.broadcom.bt.util.mime4j.field.Field;
import com.broadcom.bt.util.mime4j.field.UnstructuredField;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

/* loaded from: classes.dex */
public class Message extends Entity implements Body {

    public class MessageBuilder implements ContentHandler {
        private Stack stack = new Stack();

        public MessageBuilder() {
        }

        private void expect(Class cls) {
            if (cls.isInstance(this.stack.peek())) {
                return;
            }
            throw new IllegalStateException("Internal stack error: Expected '" + cls.getName() + "' found '" + this.stack.peek().getClass().getName() + "'");
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void body(com.broadcom.bt.util.mime4j.BodyDescriptor r3, java.io.InputStream r4) throws java.io.IOException {
            /*
                r2 = this;
                java.lang.Class<com.broadcom.bt.util.mime4j.message.Entity> r0 = com.broadcom.bt.util.mime4j.message.Entity.class
                r2.expect(r0)
                java.lang.String r0 = r3.getTransferEncoding()
                java.lang.String r1 = "base64"
                boolean r1 = r1.equals(r0)
                if (r1 == 0) goto L18
                com.broadcom.bt.util.mime4j.decoder.Base64InputStream r0 = new com.broadcom.bt.util.mime4j.decoder.Base64InputStream
                r0.<init>(r4)
            L16:
                r4 = r0
                goto L26
            L18:
                java.lang.String r1 = "quoted-printable"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L26
                com.broadcom.bt.util.mime4j.decoder.QuotedPrintableInputStream r0 = new com.broadcom.bt.util.mime4j.decoder.QuotedPrintableInputStream
                r0.<init>(r4)
                goto L16
            L26:
                java.lang.String r0 = r3.getMimeType()
                java.lang.String r1 = "text/"
                boolean r0 = r0.startsWith(r1)
                if (r0 == 0) goto L3d
                com.broadcom.bt.util.mime4j.message.MemoryTextBody r0 = new com.broadcom.bt.util.mime4j.message.MemoryTextBody
                java.lang.String r3 = r3.getCharset()
                r0.<init>(r4, r3)
                goto L42
            L3d:
                com.broadcom.bt.util.mime4j.message.MemoryBinaryBody r0 = new com.broadcom.bt.util.mime4j.message.MemoryBinaryBody
                r0.<init>(r4)
            L42:
                java.util.Stack r3 = r2.stack
                java.lang.Object r3 = r3.peek()
                com.broadcom.bt.util.mime4j.message.Entity r3 = (com.broadcom.bt.util.mime4j.message.Entity) r3
                r3.setBody(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.util.mime4j.message.Message.MessageBuilder.body(com.broadcom.bt.util.mime4j.BodyDescriptor, java.io.InputStream):void");
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void endBodyPart() {
            expect(BodyPart.class);
            this.stack.pop();
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void endHeader() {
            expect(Header.class);
            Header header = (Header) this.stack.pop();
            expect(Entity.class);
            ((Entity) this.stack.peek()).setHeader(header);
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void endMessage() {
            expect(Message.class);
            this.stack.pop();
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void endMultipart() {
            this.stack.pop();
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void epilogue(InputStream inputStream) throws IOException {
            expect(Multipart.class);
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int i = inputStream.read();
                if (i == -1) {
                    ((Multipart) this.stack.peek()).setEpilogue(stringBuffer.toString());
                    return;
                }
                stringBuffer.append((char) i);
            }
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void field(String str) {
            expect(Header.class);
            ((Header) this.stack.peek()).addField(Field.parse(str));
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void preamble(InputStream inputStream) throws IOException {
            expect(Multipart.class);
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int i = inputStream.read();
                if (i == -1) {
                    ((Multipart) this.stack.peek()).setPreamble(stringBuffer.toString());
                    return;
                }
                stringBuffer.append((char) i);
            }
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void raw(InputStream inputStream) throws IOException {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void startBodyPart() {
            expect(Multipart.class);
            BodyPart bodyPart = new BodyPart();
            ((Multipart) this.stack.peek()).addBodyPart(bodyPart);
            this.stack.push(bodyPart);
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void startHeader() {
            this.stack.push(new Header());
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void startMessage() {
            if (this.stack.isEmpty()) {
                this.stack.push(Message.this);
                return;
            }
            expect(Entity.class);
            Message message = new Message();
            ((Entity) this.stack.peek()).setBody(message);
            this.stack.push(message);
        }

        @Override // com.broadcom.bt.util.mime4j.ContentHandler
        public void startMultipart(BodyDescriptor bodyDescriptor) {
            expect(Entity.class);
            Entity entity = (Entity) this.stack.peek();
            Multipart multipart = new Multipart();
            entity.setBody(multipart);
            this.stack.push(multipart);
        }
    }

    public Message() {
    }

    public UnstructuredField getSubject() {
        return (UnstructuredField) getHeader().getField(Field.SUBJECT);
    }

    @Override // com.broadcom.bt.util.mime4j.message.Entity
    public void writeTo(OutputStream outputStream) throws IOException {
        getHeader().writeTo(outputStream);
        Body body = getBody();
        if (body instanceof Multipart) {
            ((Multipart) body).writeTo(outputStream);
        } else {
            body.writeTo(outputStream);
        }
    }

    public Message(InputStream inputStream) throws IOException {
        MimeStreamParser mimeStreamParser = new MimeStreamParser();
        mimeStreamParser.setContentHandler(new MessageBuilder());
        mimeStreamParser.parse(inputStream);
    }
}
