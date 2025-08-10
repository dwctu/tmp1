package com.epicgames.unreal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MessageBox01 implements View.OnClickListener {
    public String Caption = "";
    public String Text = "";
    public ArrayList<String> ButtonText = new ArrayList<>();
    public int ButtonPressed = -1;
    public AlertDialog Alert = null;
    public HashMap<Integer, Integer> ButtonIdToIndex = new HashMap<>();
    public AlertDialog.Builder Builder = null;

    public void addButton(String str) {
        this.ButtonText.add(str);
    }

    public void clear() {
        this.Caption = "";
        this.Text = "";
        this.ButtonText.clear();
        this.ButtonPressed = -1;
    }

    public void createAlert() throws InterruptedException {
        dismissAlert();
        this.ButtonIdToIndex.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.Get());
        this.Builder = builder;
        builder.setTitle(this.Caption);
        this.Builder.setMessage(this.Text);
        if (this.ButtonText.size() >= 1) {
            this.Builder.setPositiveButton(this.ButtonText.get(0), (DialogInterface.OnClickListener) null);
        }
        if (this.ButtonText.size() >= 2) {
            this.Builder.setNeutralButton(this.ButtonText.get(1), (DialogInterface.OnClickListener) null);
        }
        this.Alert = null;
        GameActivity.Get().runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.MessageBox01.2
            @Override // java.lang.Runnable
            public void run() {
                MessageBox01 messageBox01 = MessageBox01.this;
                messageBox01.Alert = messageBox01.Builder.create();
            }
        });
        while (true) {
            AlertDialog alertDialog = this.Alert;
            if (alertDialog != null) {
                this.Builder = null;
                alertDialog.setCancelable(false);
                this.Alert.setCanceledOnTouchOutside(false);
                this.Alert.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.epicgames.unreal.MessageBox01.3
                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        Button button;
                        if (MessageBox01.this.ButtonText.size() >= 1) {
                            button = MessageBox01.this.Alert.getButton(-1);
                            MessageBox01.this.registerButton(button, 0);
                        } else {
                            button = null;
                        }
                        if (MessageBox01.this.ButtonText.size() >= 2) {
                            button = MessageBox01.this.Alert.getButton(-3);
                            MessageBox01.this.registerButton(button, 1);
                        }
                        if (button != null) {
                            ViewGroup viewGroup = (ViewGroup) button.getParent();
                            for (int i = 2; i < MessageBox01.this.ButtonText.size(); i++) {
                                Button button2 = new Button(GameActivity.Get());
                                button2.setText(MessageBox01.this.ButtonText.get(i));
                                viewGroup.addView(button2);
                                MessageBox01.this.registerButton(button2, i);
                            }
                        }
                    }
                });
                return;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void dismissAlert() {
        AlertDialog alertDialog = this.Alert;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.Alert = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ButtonPressed = this.ButtonIdToIndex.get(Integer.valueOf(view.getId())).intValue();
        dismissAlert();
    }

    public void registerButton(Button button, int i) {
        int id = button.getId();
        if (id == -1) {
            id = View.generateViewId();
        }
        button.setId(id);
        this.ButtonIdToIndex.put(Integer.valueOf(id), Integer.valueOf(i));
        button.setOnClickListener(this);
        if (this.ButtonText.size() > 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.gravity = 119;
            layoutParams.weight = 1.0f;
            layoutParams.width = -1;
            button.setLayoutParams(layoutParams);
        }
    }

    public void setCaption(String str) {
        this.Caption = str;
    }

    public void setText(String str) {
        this.Text = str;
    }

    public int show() throws InterruptedException {
        this.ButtonPressed = -1;
        createAlert();
        if (this.Alert != null) {
            GameActivity.Get().runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.MessageBox01.1
                @Override // java.lang.Runnable
                public void run() {
                    MessageBox01.this.Alert.show();
                }
            });
            while (this.ButtonPressed == -1 && this.Alert != null) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
        }
        return this.ButtonPressed;
    }
}
