package com.broadcom.bt.util.mime4j.field.address.parser;

import java.util.Stack;

/* loaded from: classes.dex */
public class JJTAddressListParserState {
    private boolean node_created;
    private Stack nodes = new Stack();
    private Stack marks = new Stack();
    private int sp = 0;
    private int mk = 0;

    public void clearNodeScope(Node node) {
        while (this.sp > this.mk) {
            popNode();
        }
        this.mk = ((Integer) this.marks.pop()).intValue();
    }

    public void closeNodeScope(Node node, int i) {
        this.mk = ((Integer) this.marks.pop()).intValue();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                node.jjtClose();
                pushNode(node);
                this.node_created = true;
                return;
            } else {
                Node nodePopNode = popNode();
                nodePopNode.jjtSetParent(node);
                node.jjtAddChild(nodePopNode, i2);
                i = i2;
            }
        }
    }

    public int nodeArity() {
        return this.sp - this.mk;
    }

    public boolean nodeCreated() {
        return this.node_created;
    }

    public void openNodeScope(Node node) {
        this.marks.push(new Integer(this.mk));
        this.mk = this.sp;
        node.jjtOpen();
    }

    public Node peekNode() {
        return (Node) this.nodes.peek();
    }

    public Node popNode() {
        int i = this.sp - 1;
        this.sp = i;
        if (i < this.mk) {
            this.mk = ((Integer) this.marks.pop()).intValue();
        }
        return (Node) this.nodes.pop();
    }

    public void pushNode(Node node) {
        this.nodes.push(node);
        this.sp++;
    }

    public void reset() {
        this.nodes.removeAllElements();
        this.marks.removeAllElements();
        this.sp = 0;
        this.mk = 0;
    }

    public Node rootNode() {
        return (Node) this.nodes.elementAt(0);
    }

    public void closeNodeScope(Node node, boolean z) {
        if (z) {
            int iNodeArity = nodeArity();
            this.mk = ((Integer) this.marks.pop()).intValue();
            while (true) {
                int i = iNodeArity - 1;
                if (iNodeArity > 0) {
                    Node nodePopNode = popNode();
                    nodePopNode.jjtSetParent(node);
                    node.jjtAddChild(nodePopNode, i);
                    iNodeArity = i;
                } else {
                    node.jjtClose();
                    pushNode(node);
                    this.node_created = true;
                    return;
                }
            }
        } else {
            this.mk = ((Integer) this.marks.pop()).intValue();
            this.node_created = false;
        }
    }
}
