package com.broadcom.bt.util.mime4j.field.address.parser;

/* loaded from: classes.dex */
public class ASTaddress_list extends SimpleNode {
    public ASTaddress_list(int i) {
        super(i);
    }

    @Override // com.broadcom.bt.util.mime4j.field.address.parser.SimpleNode, com.broadcom.bt.util.mime4j.field.address.parser.Node
    public Object jjtAccept(AddressListParserVisitor addressListParserVisitor, Object obj) {
        return addressListParserVisitor.visit(this, obj);
    }

    public ASTaddress_list(AddressListParser addressListParser, int i) {
        super(addressListParser, i);
    }
}
