package com.broadcom.bt.util.mime4j.field.address;

import com.broadcom.bt.util.mime4j.decoder.DecoderUtil;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTaddr_spec;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTaddress;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTaddress_list;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTangle_addr;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTdomain;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTgroup_body;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTlocal_part;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTmailbox;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTname_addr;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTphrase;
import com.broadcom.bt.util.mime4j.field.address.parser.ASTroute;
import com.broadcom.bt.util.mime4j.field.address.parser.Node;
import com.broadcom.bt.util.mime4j.field.address.parser.SimpleNode;
import com.broadcom.bt.util.mime4j.field.address.parser.Token;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Builder {
    private static Builder singleton = new Builder();

    public static class ChildNodeIterator implements Iterator {
        private int index = 0;
        private int len;
        private SimpleNode simpleNode;

        public ChildNodeIterator(SimpleNode simpleNode) {
            this.simpleNode = simpleNode;
            this.len = simpleNode.jjtGetNumChildren();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.len;
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextNode();
        }

        public Node nextNode() {
            SimpleNode simpleNode = this.simpleNode;
            int i = this.index;
            this.index = i + 1;
            return simpleNode.jjtGetChild(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void addSpecials(StringBuffer stringBuffer, Token token) {
        if (token != null) {
            addSpecials(stringBuffer, token.specialToken);
            stringBuffer.append(token.image);
        }
    }

    private Mailbox buildAddrSpec(ASTaddr_spec aSTaddr_spec) {
        return buildAddrSpec(null, aSTaddr_spec);
    }

    private Address buildAddress(ASTaddress aSTaddress) {
        ChildNodeIterator childNodeIterator = new ChildNodeIterator(aSTaddress);
        Node nodeNextNode = childNodeIterator.nextNode();
        if (nodeNextNode instanceof ASTaddr_spec) {
            return buildAddrSpec((ASTaddr_spec) nodeNextNode);
        }
        if (nodeNextNode instanceof ASTangle_addr) {
            return buildAngleAddr((ASTangle_addr) nodeNextNode);
        }
        if (!(nodeNextNode instanceof ASTphrase)) {
            throw new IllegalStateException();
        }
        String strBuildString = buildString((ASTphrase) nodeNextNode, false);
        Node nodeNextNode2 = childNodeIterator.nextNode();
        if (nodeNextNode2 instanceof ASTgroup_body) {
            return new Group(strBuildString, buildGroupBody((ASTgroup_body) nodeNextNode2));
        }
        if (nodeNextNode2 instanceof ASTangle_addr) {
            return new NamedMailbox(DecoderUtil.decodeEncodedWords(strBuildString), buildAngleAddr((ASTangle_addr) nodeNextNode2));
        }
        throw new IllegalStateException();
    }

    private Mailbox buildAngleAddr(ASTangle_addr aSTangle_addr) {
        DomainList domainList;
        ChildNodeIterator childNodeIterator = new ChildNodeIterator(aSTangle_addr);
        Node nodeNextNode = childNodeIterator.nextNode();
        if (nodeNextNode instanceof ASTroute) {
            DomainList domainListBuildRoute = buildRoute((ASTroute) nodeNextNode);
            Node nodeNextNode2 = childNodeIterator.nextNode();
            domainList = domainListBuildRoute;
            nodeNextNode = nodeNextNode2;
        } else {
            if (!(nodeNextNode instanceof ASTaddr_spec)) {
                throw new IllegalStateException();
            }
            domainList = null;
        }
        if (nodeNextNode instanceof ASTaddr_spec) {
            return buildAddrSpec(domainList, (ASTaddr_spec) nodeNextNode);
        }
        throw new IllegalStateException();
    }

    private MailboxList buildGroupBody(ASTgroup_body aSTgroup_body) {
        ArrayList arrayList = new ArrayList();
        ChildNodeIterator childNodeIterator = new ChildNodeIterator(aSTgroup_body);
        while (childNodeIterator.hasNext()) {
            Node nodeNextNode = childNodeIterator.nextNode();
            if (!(nodeNextNode instanceof ASTmailbox)) {
                throw new IllegalStateException();
            }
            arrayList.add(buildMailbox((ASTmailbox) nodeNextNode));
        }
        return new MailboxList(arrayList, true);
    }

    private Mailbox buildMailbox(ASTmailbox aSTmailbox) {
        Node nodeNextNode = new ChildNodeIterator(aSTmailbox).nextNode();
        if (nodeNextNode instanceof ASTaddr_spec) {
            return buildAddrSpec((ASTaddr_spec) nodeNextNode);
        }
        if (nodeNextNode instanceof ASTangle_addr) {
            return buildAngleAddr((ASTangle_addr) nodeNextNode);
        }
        if (nodeNextNode instanceof ASTname_addr) {
            return buildNameAddr((ASTname_addr) nodeNextNode);
        }
        throw new IllegalStateException();
    }

    private NamedMailbox buildNameAddr(ASTname_addr aSTname_addr) {
        ChildNodeIterator childNodeIterator = new ChildNodeIterator(aSTname_addr);
        Node nodeNextNode = childNodeIterator.nextNode();
        if (!(nodeNextNode instanceof ASTphrase)) {
            throw new IllegalStateException();
        }
        String strBuildString = buildString((ASTphrase) nodeNextNode, false);
        Node nodeNextNode2 = childNodeIterator.nextNode();
        if (nodeNextNode2 instanceof ASTangle_addr) {
            return new NamedMailbox(DecoderUtil.decodeEncodedWords(strBuildString), buildAngleAddr((ASTangle_addr) nodeNextNode2));
        }
        throw new IllegalStateException();
    }

    private DomainList buildRoute(ASTroute aSTroute) {
        ArrayList arrayList = new ArrayList(aSTroute.jjtGetNumChildren());
        ChildNodeIterator childNodeIterator = new ChildNodeIterator(aSTroute);
        while (childNodeIterator.hasNext()) {
            Node nodeNextNode = childNodeIterator.nextNode();
            if (!(nodeNextNode instanceof ASTdomain)) {
                throw new IllegalStateException();
            }
            arrayList.add(buildString((ASTdomain) nodeNextNode, true));
        }
        return new DomainList(arrayList, true);
    }

    private String buildString(SimpleNode simpleNode, boolean z) {
        Token token = simpleNode.firstToken;
        Token token2 = simpleNode.lastToken;
        StringBuffer stringBuffer = new StringBuffer();
        while (token != token2) {
            stringBuffer.append(token.image);
            token = token.next;
            if (!z) {
                addSpecials(stringBuffer, token.specialToken);
            }
        }
        stringBuffer.append(token2.image);
        return stringBuffer.toString();
    }

    public static Builder getInstance() {
        return singleton;
    }

    public AddressList buildAddressList(ASTaddress_list aSTaddress_list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aSTaddress_list.jjtGetNumChildren(); i++) {
            arrayList.add(buildAddress((ASTaddress) aSTaddress_list.jjtGetChild(i)));
        }
        return new AddressList(arrayList, true);
    }

    private Mailbox buildAddrSpec(DomainList domainList, ASTaddr_spec aSTaddr_spec) {
        ChildNodeIterator childNodeIterator = new ChildNodeIterator(aSTaddr_spec);
        return new Mailbox(domainList, buildString((ASTlocal_part) childNodeIterator.nextNode(), true), buildString((ASTdomain) childNodeIterator.nextNode(), true));
    }
}
