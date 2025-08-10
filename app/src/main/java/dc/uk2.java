package dc;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotificationManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/wear/media/NotificationManager;", "", "context", "Landroid/content/Context;", "sessionToken", "Landroid/support/v4/media/session/MediaSessionCompat$Token;", "notificationListener", "Lcom/google/android/exoplayer2/ui/PlayerNotificationManager$NotificationListener;", "(Landroid/content/Context;Landroid/support/v4/media/session/MediaSessionCompat$Token;Lcom/google/android/exoplayer2/ui/PlayerNotificationManager$NotificationListener;)V", "notificationManager", "Lcom/google/android/exoplayer2/ui/PlayerNotificationManager;", "serviceJob", "Lkotlinx/coroutines/CompletableJob;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "hideNotification", "", "showNotificationForPlayer", "player", "Lcom/google/android/exoplayer2/Player;", "DescriptionAdapter", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class uk2 {

    @NotNull
    public final Context a;

    @NotNull
    public final hz3 b;

    @NotNull
    public final wz3 c;

    @NotNull
    public final PlayerNotificationManager d;

    /* compiled from: NotificationManager.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00142\n\u0010\u0019\u001a\u00060\u001aR\u00020\u001bH\u0016J\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/wear/media/NotificationManager$DescriptionAdapter;", "Lcom/google/android/exoplayer2/ui/PlayerNotificationManager$MediaDescriptionAdapter;", "controller", "Landroid/support/v4/media/session/MediaControllerCompat;", "(Lcom/wear/media/NotificationManager;Landroid/support/v4/media/session/MediaControllerCompat;)V", "currentBitmap", "Landroid/graphics/Bitmap;", "getCurrentBitmap", "()Landroid/graphics/Bitmap;", "setCurrentBitmap", "(Landroid/graphics/Bitmap;)V", "currentIconUri", "Landroid/net/Uri;", "getCurrentIconUri", "()Landroid/net/Uri;", "setCurrentIconUri", "(Landroid/net/Uri;)V", "createCurrentContentIntent", "Landroid/app/PendingIntent;", "player", "Lcom/google/android/exoplayer2/Player;", "getCurrentContentText", "", "getCurrentContentTitle", "getCurrentLargeIcon", Callback.METHOD_NAME, "Lcom/google/android/exoplayer2/ui/PlayerNotificationManager$BitmapCallback;", "Lcom/google/android/exoplayer2/ui/PlayerNotificationManager;", "resolveUriAsBitmap", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class a implements PlayerNotificationManager.MediaDescriptionAdapter {

        @NotNull
        public final MediaControllerCompat a;

        @Nullable
        public Uri b;

        @Nullable
        public Bitmap c;
        public final /* synthetic */ uk2 d;

        /* compiled from: NotificationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.media.NotificationManager$DescriptionAdapter$getCurrentLargeIcon$1", f = "NotificationManager.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: dc.uk2$a$a, reason: collision with other inner class name */
        public static final class C0224a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ PlayerNotificationManager.BitmapCallback $callback;
            public final /* synthetic */ Uri $iconUri;
            public Object L$0;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0224a(Uri uri, PlayerNotificationManager.BitmapCallback bitmapCallback, Continuation<? super C0224a> continuation) {
                super(2, continuation);
                this.$iconUri = uri;
                this.$callback = bitmapCallback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return a.this.new C0224a(this.$iconUri, this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((C0224a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r4.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r0 = r4.L$0
                    dc.uk2$a r0 = (dc.uk2.a) r0
                    kotlin.ResultKt.throwOnFailure(r5)
                    goto L31
                L13:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L1b:
                    kotlin.ResultKt.throwOnFailure(r5)
                    dc.uk2$a r5 = dc.uk2.a.this
                    android.net.Uri r1 = r4.$iconUri
                    if (r1 == 0) goto L37
                    r4.L$0 = r5
                    r4.label = r2
                    java.lang.Object r1 = dc.uk2.a.a(r5, r1, r4)
                    if (r1 != r0) goto L2f
                    return r0
                L2f:
                    r0 = r5
                    r5 = r1
                L31:
                    android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
                    r3 = r0
                    r0 = r5
                    r5 = r3
                    goto L38
                L37:
                    r0 = 0
                L38:
                    r5.f(r0)
                    dc.uk2$a r5 = dc.uk2.a.this
                    android.graphics.Bitmap r5 = r5.getC()
                    if (r5 == 0) goto L48
                    com.google.android.exoplayer2.ui.PlayerNotificationManager$BitmapCallback r0 = r4.$callback
                    r0.onBitmap(r5)
                L48:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: dc.uk2.a.C0224a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: NotificationManager.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.media.NotificationManager$DescriptionAdapter$resolveUriAsBitmap$2", f = "NotificationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Bitmap>, Object> {
            public final /* synthetic */ Uri $uri;
            public int label;
            public final /* synthetic */ uk2 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(uk2 uk2Var, Uri uri, Continuation<? super b> continuation) {
                super(2, continuation);
                this.this$0 = uk2Var;
                this.$uri = uri;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.this$0, this.$uri, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Bitmap> continuation) {
                return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return kf.w(this.this$0.a).c(vk2.a).j().F0(this.$uri).M0(CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA).get();
            }
        }

        public a(@NotNull uk2 uk2Var, MediaControllerCompat controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.d = uk2Var;
            this.a = controller;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Bitmap getC() {
            return this.c;
        }

        @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String getCurrentContentText(@NotNull Player player) {
            Intrinsics.checkNotNullParameter(player, "player");
            return "";
        }

        @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
        @Nullable
        public PendingIntent createCurrentContentIntent(@NotNull Player player) {
            Intrinsics.checkNotNullParameter(player, "player");
            return this.a.getSessionActivity();
        }

        @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String getCurrentContentTitle(@NotNull Player player) {
            Intrinsics.checkNotNullParameter(player, "player");
            return String.valueOf(this.a.getMetadata().getDescription().getTitle());
        }

        public final Object e(Uri uri, Continuation<? super Bitmap> continuation) {
            return sy3.g(n04.b(), new b(this.d, uri, null), continuation);
        }

        public final void f(@Nullable Bitmap bitmap) {
            this.c = bitmap;
        }

        @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
        @Nullable
        public Bitmap getCurrentLargeIcon(@NotNull Player player, @NotNull PlayerNotificationManager.BitmapCallback callback) {
            Bitmap bitmap;
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Uri iconUri = this.a.getMetadata().getDescription().getIconUri();
            if (Intrinsics.areEqual(this.b, iconUri) && (bitmap = this.c) != null) {
                return bitmap;
            }
            this.b = iconUri;
            uy3.d(this.d.c, null, null, new C0224a(iconUri, callback, null), 3, null);
            return null;
        }

        @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
        public /* synthetic */ CharSequence getCurrentSubText(Player player) {
            return xx0.$default$getCurrentSubText(this, player);
        }
    }

    public uk2(@NotNull Context context, @NotNull MediaSessionCompat.Token sessionToken, @NotNull PlayerNotificationManager.NotificationListener notificationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(notificationListener, "notificationListener");
        this.a = context;
        hz3 hz3VarB = e24.b(null, 1, null);
        this.b = hz3VarB;
        this.c = xz3.a(n04.c().plus(hz3VarB));
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(context, sessionToken);
        PlayerNotificationManager.Builder builder = new PlayerNotificationManager.Builder(context, 45881, "com.wear.media.NOW_PLAYING");
        builder.setMediaDescriptionAdapter(new a(this, mediaControllerCompat));
        builder.setNotificationListener(notificationListener);
        builder.setChannelNameResourceId(R.string.notification_channel);
        PlayerNotificationManager playerNotificationManagerBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(playerNotificationManagerBuild, "builder.build()");
        this.d = playerNotificationManagerBuild;
        playerNotificationManagerBuild.setMediaSessionToken(sessionToken);
        playerNotificationManagerBuild.setSmallIcon(R.drawable.ic_launcher);
        playerNotificationManagerBuild.setUseRewindAction(false);
        playerNotificationManagerBuild.setUseFastForwardAction(false);
    }

    public final void c() {
        this.d.setPlayer(null);
    }

    public final void d(@NotNull Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.d.setPlayer(player);
    }
}
