package com.broadcom.bt.util.mime4j.field.address.parser;

/* loaded from: classes.dex */
public class ASTangle_addr extends SimpleNode {
    public ASTangle_addr(int i) {
        super(i);
    }

    @Override // com.broadcom.bt.util.mime4j.field.address.parser.SimpleNode, com.broadcom.bt.util.mime4j.field.address.parser.Node
    public Object jjtAccept(AddressListParserVisitor addressListParserVisitor, Object obj) {
        return addressListParserVisitor.visit(this, obj);
    }

    public ASTangle_addr(AddressListParser addressListParser, int i) {
        super(addressListParser, i);
    }
}
