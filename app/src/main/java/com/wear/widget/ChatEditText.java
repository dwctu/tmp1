package com.wear.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.wear.protocol.EntityChatABean;
import com.wear.util.WearUtils;
import dc.gf3;
import dc.ie3;
import java.util.ArrayList;
import java.util.List;
import skin.support.widget.SkinCompatEditText;

/* loaded from: classes4.dex */
public class ChatEditText extends SkinCompatEditText {
    public View.OnKeyListener e;
    public ie3 f;

    public class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (i != 1 || i2 != 0 || ChatEditText.this.getSelectionStart() <= 0 || ChatEditText.this.getSelectionStart() != ChatEditText.this.getSelectionEnd() || ChatEditText.this.f == null || WearUtils.e1(ChatEditText.this.getText().toString()) || !ChatEditText.this.getText().toString().contains("[") || !ChatEditText.this.getText().toString().contains("]") || !ChatEditText.this.f.C(ChatEditText.this.getText().toString(), ChatEditText.this.getSelectionStart())) {
                return super.deleteSurroundingText(i, i2);
            }
            ChatEditText.this.onKeyDown(67, new KeyEvent(0, 67));
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (ChatEditText.this.e != null) {
                ChatEditText.this.e.onKey(ChatEditText.this, keyEvent.getKeyCode(), keyEvent);
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    public class b {
        public int a;
        public int b;
        public String c;

        public b(ChatEditText chatEditText, int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }
    }

    public ChatEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void d(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            sb.append(str2);
            sb.append(" ");
        } else {
            sb.append(str);
            sb.append(str2);
            sb.append(" ");
        }
        getText().insert(getSelectionStart(), sb.toString());
        SpannableString spannableString = new SpannableString(getText());
        int selectionEnd = (getSelectionEnd() - sb.toString().length()) - (TextUtils.isEmpty(str) ? 1 : 0);
        int selectionEnd2 = getSelectionEnd();
        e(spannableString, new b(this, selectionEnd, selectionEnd2, str2), str3);
        setText(spannableString);
        setSelection(selectionEnd2);
    }

    public final void e(Spannable spannable, b bVar, String str) {
        int i = bVar.a;
        int i2 = bVar.b;
        gf3 gf3Var = new gf3(bVar.c, str);
        if (i == -1 || i2 > spannable.length()) {
            return;
        }
        spannable.setSpan(gf3Var, i, i2, 33);
    }

    public List<EntityChatABean> getUserBean() {
        gf3[] gf3VarArr = (gf3[]) getText().getSpans(0, getText().length(), gf3.class);
        if (gf3VarArr == null || gf3VarArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (gf3 gf3Var : gf3VarArr) {
            String strSubstring = getText().toString().substring(getText().getSpanStart(gf3Var), getText().getSpanEnd(gf3Var));
            String strA = gf3Var.a();
            if (strSubstring.equals("@" + strA + " ")) {
                EntityChatABean entityChatABean = new EntityChatABean();
                entityChatABean.setJid(gf3Var.b());
                entityChatABean.setNickName(strA);
                arrayList.add(entityChatABean);
            }
        }
        return arrayList;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new a(super.onCreateInputConnection(editorInfo), true);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (i2 == 1 && i3 == 0) {
            for (gf3 gf3Var : (gf3[]) getText().getSpans(0, getText().length(), gf3.class)) {
                if (getText().getSpanEnd(gf3Var) == i && !charSequence.toString().endsWith(gf3Var.a())) {
                    getText().delete(getText().getSpanStart(gf3Var), getText().getSpanEnd(gf3Var));
                    return;
                }
            }
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i != 16908322) {
            return super.onTextContextMenuItem(i);
        }
        getText().toString();
        boolean zOnTextContextMenuItem = super.onTextContextMenuItem(i);
        String string = getText().toString();
        if (this.f == null || WearUtils.e1(string) || string.indexOf("[") == -1 || string.indexOf("]") == -1) {
            new SpannableString(string);
            setText(string);
        } else {
            List<SpannableString> listP = this.f.p(string);
            setText("");
            for (SpannableString spannableString : listP) {
                int selectionStart = getSelectionStart();
                Editable editableText = getEditableText();
                if (selectionStart < 0 || selectionStart >= string.length()) {
                    editableText.append((CharSequence) spannableString);
                } else {
                    editableText.insert(selectionStart, spannableString);
                }
                setSelection(selectionStart + spannableString.length());
            }
        }
        setSelection(string.length());
        return zOnTextContextMenuItem;
    }

    public void setEmojisUtils(ie3 ie3Var) {
        this.f = ie3Var;
    }

    public void setSoftKeyListener(View.OnKeyListener onKeyListener) {
        this.e = onKeyListener;
    }

    public ChatEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatEditText(Context context) {
        super(context);
    }
}
