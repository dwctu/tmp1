package com.component.dxhttp.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import com.component.dxhttp.NetException;
import com.component.dxhttp.R;
import com.component.dxhttp.test.TestActivity;
import dc.Test;
import dc.de0;
import dc.ky;
import dc.ly;
import dc.ny;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: TestActivity.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, d2 = {"Lcom/component/dxhttp/test/TestActivity;", "Landroidx/activity/ComponentActivity;", "()V", "initSDK", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TestActivity extends ComponentActivity {

    /* compiled from: TestActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxhttp/test/TestActivity$onCreate$1$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends ny<String> {
        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            Object[] objArr = new Object[1];
            objArr[0] = Intrinsics.stringPlus("http onError == ", netException == null ? null : netException.message);
            de0.l(objArr);
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable String str) {
            de0.l(Intrinsics.stringPlus("http onSuccess response == ", str));
        }
    }

    /* compiled from: TestActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/component/dxhttp/test/TestActivity$onCreate$2$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "", "onError", "", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ny<String> {
        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            Object[] objArr = new Object[1];
            objArr[0] = Intrinsics.stringPlus("http onError == ", netException == null ? null : netException.message);
            de0.l(objArr);
        }

        @Override // dc.ny
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void d(@Nullable String str) {
            de0.l(Intrinsics.stringPlus("http onSuccess response == ", str));
        }
    }

    public static final void l4(View view) {
        ky.c("https://test10.lovense-api.com/surfease/anon/common/search/completion_suggest?prefix=a&type=4", null, new a());
    }

    public static final void m4(View view) {
        ky.d("https://test10.lovense-api.com/surfease/common/suggest_website_url_list_v2", new Test(null, null, 3, null), null, new b());
    }

    public final void i4() {
        ky.o("https://test10.lovense-api.com/surfease");
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ly.activity_test);
        i4();
        ((Button) findViewById(R.id.btnGetRequest)).setOnClickListener(new View.OnClickListener() { // from class: dc.zy
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestActivity.l4(view);
            }
        });
        Button button = (Button) findViewById(R.id.btnGoToJavaActivity);
        button.setText("post request");
        button.setOnClickListener(new View.OnClickListener() { // from class: dc.az
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestActivity.m4(view);
            }
        });
    }
}
