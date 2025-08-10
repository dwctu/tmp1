package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p002firebaseauthapi.zzwa;
import com.google.android.gms.internal.p002firebaseauthapi.zzwe;
import com.google.android.gms.internal.p002firebaseauthapi.zzwj;
import com.google.android.gms.internal.p002firebaseauthapi.zzwt;
import com.google.android.gms.internal.p002firebaseauthapi.zzxr;
import com.google.android.gms.internal.p002firebaseauthapi.zzyb;
import com.google.android.gms.internal.p002firebaseauthapi.zzza;
import com.google.android.gms.internal.p002firebaseauthapi.zzzn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzay;
import com.google.firebase.auth.internal.zzbg;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbj;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzbm;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class FirebaseAuth implements InternalAuthProvider {
    private FirebaseApp zza;
    private final List zzb;
    private final List zzc;
    private List zzd;
    private zzwa zze;

    @Nullable
    private FirebaseUser zzf;
    private com.google.firebase.auth.internal.zzw zzg;
    private final Object zzh;
    private String zzi;
    private final Object zzj;
    private String zzk;
    private final zzbg zzl;
    private final zzbm zzm;
    private final com.google.firebase.auth.internal.zzf zzn;
    private final Provider zzo;
    private zzbi zzp;
    private zzbj zzq;

    /* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public FirebaseAuth(@NonNull FirebaseApp firebaseApp, @NonNull Provider provider) {
        zzza zzzaVarZzb;
        zzwa zzwaVar = new zzwa(firebaseApp);
        zzbg zzbgVar = new zzbg(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzbm zzbmVarZzc = zzbm.zzc();
        com.google.firebase.auth.internal.zzf zzfVarZzb = com.google.firebase.auth.internal.zzf.zzb();
        this.zzb = new CopyOnWriteArrayList();
        this.zzc = new CopyOnWriteArrayList();
        this.zzd = new CopyOnWriteArrayList();
        this.zzh = new Object();
        this.zzj = new Object();
        this.zzq = zzbj.zza();
        this.zza = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zze = (zzwa) Preconditions.checkNotNull(zzwaVar);
        zzbg zzbgVar2 = (zzbg) Preconditions.checkNotNull(zzbgVar);
        this.zzl = zzbgVar2;
        this.zzg = new com.google.firebase.auth.internal.zzw();
        zzbm zzbmVar = (zzbm) Preconditions.checkNotNull(zzbmVarZzc);
        this.zzm = zzbmVar;
        this.zzn = (com.google.firebase.auth.internal.zzf) Preconditions.checkNotNull(zzfVarZzb);
        this.zzo = provider;
        FirebaseUser firebaseUserZza = zzbgVar2.zza();
        this.zzf = firebaseUserZza;
        if (firebaseUserZza != null && (zzzaVarZzb = zzbgVar2.zzb(firebaseUserZza)) != null) {
            zzH(this, this.zzf, zzzaVarZzb, false, false);
        }
        zzbmVar.zze(this);
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static void zzF(@NonNull FirebaseAuth firebaseAuth, @Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String str = "Notifying auth state listeners about user ( " + firebaseUser.getUid() + " ).";
        }
        firebaseAuth.zzq.execute(new zzm(firebaseAuth));
    }

    public static void zzG(@NonNull FirebaseAuth firebaseAuth, @Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String str = "Notifying id token listeners about user ( " + firebaseUser.getUid() + " ).";
        }
        firebaseAuth.zzq.execute(new zzl(firebaseAuth, new InternalTokenResult(firebaseUser != null ? firebaseUser.zze() : null)));
    }

    @VisibleForTesting
    public static void zzH(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzza zzzaVar, boolean z, boolean z2) {
        boolean z3;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzzaVar);
        boolean z4 = true;
        boolean z5 = firebaseAuth.zzf != null && firebaseUser.getUid().equals(firebaseAuth.zzf.getUid());
        if (z5 || !z2) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzf;
            if (firebaseUser2 == null) {
                z3 = true;
            } else {
                boolean z6 = !z5 || (firebaseUser2.zzd().zze().equals(zzzaVar.zze()) ^ true);
                z3 = true ^ z5;
                z4 = z6;
            }
            Preconditions.checkNotNull(firebaseUser);
            FirebaseUser firebaseUser3 = firebaseAuth.zzf;
            if (firebaseUser3 == null) {
                firebaseAuth.zzf = firebaseUser;
            } else {
                firebaseUser3.zzc(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzf.zzb();
                }
                firebaseAuth.zzf.zzi(firebaseUser.getMultiFactor().getEnrolledFactors());
            }
            if (z) {
                firebaseAuth.zzl.zzd(firebaseAuth.zzf);
            }
            if (z4) {
                FirebaseUser firebaseUser4 = firebaseAuth.zzf;
                if (firebaseUser4 != null) {
                    firebaseUser4.zzh(zzzaVar);
                }
                zzG(firebaseAuth, firebaseAuth.zzf);
            }
            if (z3) {
                zzF(firebaseAuth, firebaseAuth.zzf);
            }
            if (z) {
                firebaseAuth.zzl.zze(firebaseUser, zzzaVar);
            }
            FirebaseUser firebaseUser5 = firebaseAuth.zzf;
            if (firebaseUser5 != null) {
                zzx(firebaseAuth).zze(firebaseUser5.zzd());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzL(@Nullable String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (this.zzg.zzd() && str != null && str.equals(this.zzg.zza())) ? new zzq(this, onVerificationStateChangedCallbacks) : onVerificationStateChangedCallbacks;
    }

    private final boolean zzM(String str) {
        ActionCodeUrl link = ActionCodeUrl.parseLink(str);
        return (link == null || TextUtils.equals(this.zzk, link.zza())) ? false : true;
    }

    public static zzbi zzx(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzp == null) {
            firebaseAuth.zzp = new zzbi((FirebaseApp) Preconditions.checkNotNull(firebaseAuth.zza));
        }
        return firebaseAuth.zzp;
    }

    public void addAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzd.add(authStateListener);
        this.zzq.execute(new zzk(this, authStateListener));
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzb.add(idTokenListener);
        ((zzbj) Preconditions.checkNotNull(this.zzq)).execute(new zzj(this, idTokenListener));
    }

    @NonNull
    public Task<Void> applyActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zza(this.zza, str, this.zzk);
    }

    @NonNull
    public Task<ActionCodeResult> checkActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzb(this.zza, str, this.zzk);
    }

    @NonNull
    public Task<Void> confirmPasswordReset(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zzc(this.zza, str, str2, this.zzk);
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zzd(this.zza, str, str2, this.zzk, new zzs(this));
    }

    @NonNull
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzf(this.zza, str, this.zzk);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    @NonNull
    public final Task getAccessToken(boolean z) {
        return zzc(this.zzf, z);
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.zza;
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.zzf;
    }

    @NonNull
    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzg;
    }

    @Nullable
    public String getLanguageCode() {
        String str;
        synchronized (this.zzh) {
            str = this.zzi;
        }
        return str;
    }

    @Nullable
    public Task<AuthResult> getPendingAuthResult() {
        return this.zzm.zza();
    }

    @Nullable
    public String getTenantId() {
        String str;
        synchronized (this.zzj) {
            str = this.zzk;
        }
        return str;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    @Nullable
    public final String getUid() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public boolean isSignInWithEmailLink(@NonNull String str) {
        return EmailAuthCredential.zzi(str);
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzd.remove(authStateListener);
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzb.remove(idTokenListener);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    @NonNull
    public Task<Void> sendSignInLinkToEmail(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (!actionCodeSettings.canHandleCodeInApp()) {
            throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zzf(str2);
        }
        return this.zze.zzv(this.zza, str, actionCodeSettings, this.zzk);
    }

    @NonNull
    public Task<Void> setFirebaseUIVersion(@Nullable String str) {
        return this.zze.zzw(str);
    }

    public void setLanguageCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzh) {
            this.zzi = str;
        }
    }

    public void setTenantId(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzj) {
            this.zzk = str;
        }
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zze.zzx(this.zza, new zzs(this), this.zzk);
        }
        com.google.firebase.auth.internal.zzx zzxVar = (com.google.firebase.auth.internal.zzx) this.zzf;
        zzxVar.zzq(false);
        return Tasks.forResult(new com.google.firebase.auth.internal.zzr(zzxVar));
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (authCredentialZza instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
            return !emailAuthCredential.zzg() ? this.zze.zzA(this.zza, emailAuthCredential.zzd(), Preconditions.checkNotEmpty(emailAuthCredential.zze()), this.zzk, new zzs(this)) : zzM(Preconditions.checkNotEmpty(emailAuthCredential.zzf())) ? Tasks.forException(zzwe.zza(new Status(17072))) : this.zze.zzB(this.zza, emailAuthCredential, new zzs(this));
        }
        if (authCredentialZza instanceof PhoneAuthCredential) {
            return this.zze.zzC(this.zza, (PhoneAuthCredential) authCredentialZza, this.zzk, new zzs(this));
        }
        return this.zze.zzy(this.zza, authCredentialZza, this.zzk, new zzs(this));
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzz(this.zza, str, this.zzk, new zzs(this));
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zze.zzA(this.zza, str, str2, this.zzk, new zzs(this));
    }

    @NonNull
    public Task<AuthResult> signInWithEmailLink(@NonNull String str, @NonNull String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzD();
        zzbi zzbiVar = this.zzp;
        if (zzbiVar != null) {
            zzbiVar.zzc();
        }
    }

    @NonNull
    public Task<AuthResult> startActivityForSignInWithProvider(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzm.zzi(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzwe.zza(new Status(17057)));
        }
        this.zzm.zzg(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public Task<Void> updateCurrentUser(@NonNull FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser == null) {
            throw new IllegalArgumentException("Cannot update current user with null user!");
        }
        String tenantId = firebaseUser.getTenantId();
        if ((tenantId != null && !tenantId.equals(this.zzk)) || ((str = this.zzk) != null && !str.equals(tenantId))) {
            return Tasks.forException(zzwe.zza(new Status(17072)));
        }
        String apiKey = firebaseUser.zza().getOptions().getApiKey();
        String apiKey2 = this.zza.getOptions().getApiKey();
        if (!firebaseUser.zzd().zzj() || !apiKey2.equals(apiKey)) {
            return zzg(firebaseUser, new zzu(this));
        }
        zzE(com.google.firebase.auth.internal.zzx.zzk(this.zza, firebaseUser), firebaseUser.zzd(), true);
        return Tasks.forResult(null);
    }

    public void useAppLanguage() {
        synchronized (this.zzh) {
            this.zzi = zzwt.zza();
        }
    }

    public void useEmulator(@NonNull String str, int i) {
        Preconditions.checkNotEmpty(str);
        boolean z = false;
        if (i >= 0 && i <= 65535) {
            z = true;
        }
        Preconditions.checkArgument(z, "Port number must be in the range 0-65535");
        zzyb.zzf(this.zza, str, i);
    }

    @NonNull
    public Task<String> verifyPasswordResetCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zze.zzM(this.zza, str, this.zzk);
    }

    public final void zzD() {
        Preconditions.checkNotNull(this.zzl);
        FirebaseUser firebaseUser = this.zzf;
        if (firebaseUser != null) {
            zzbg zzbgVar = this.zzl;
            Preconditions.checkNotNull(firebaseUser);
            zzbgVar.zzc(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
            this.zzf = null;
        }
        this.zzl.zzc("com.google.firebase.auth.FIREBASE_USER");
        zzG(this, null);
        zzF(this, null);
    }

    public final void zzE(FirebaseUser firebaseUser, zzza zzzaVar, boolean z) {
        zzH(this, firebaseUser, zzzaVar, true, false);
    }

    public final void zzI(@NonNull PhoneAuthOptions phoneAuthOptions) {
        if (phoneAuthOptions.zzk()) {
            FirebaseAuth firebaseAuthZzb = phoneAuthOptions.zzb();
            String strCheckNotEmpty = ((com.google.firebase.auth.internal.zzag) Preconditions.checkNotNull(phoneAuthOptions.zzc())).zze() ? Preconditions.checkNotEmpty(phoneAuthOptions.zzh()) : Preconditions.checkNotEmpty(((PhoneMultiFactorInfo) Preconditions.checkNotNull(phoneAuthOptions.zzf())).getUid());
            if (phoneAuthOptions.zzd() == null || !zzxr.zzd(strCheckNotEmpty, phoneAuthOptions.zze(), (Activity) Preconditions.checkNotNull(phoneAuthOptions.zza()), phoneAuthOptions.zzi())) {
                firebaseAuthZzb.zzn.zza(firebaseAuthZzb, phoneAuthOptions.zzh(), (Activity) Preconditions.checkNotNull(phoneAuthOptions.zza()), firebaseAuthZzb.zzK()).addOnCompleteListener(new zzp(firebaseAuthZzb, phoneAuthOptions));
                return;
            }
            return;
        }
        FirebaseAuth firebaseAuthZzb2 = phoneAuthOptions.zzb();
        String strCheckNotEmpty2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        long jLongValue = phoneAuthOptions.zzg().longValue();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZze = phoneAuthOptions.zze();
        Activity activity = (Activity) Preconditions.checkNotNull(phoneAuthOptions.zza());
        Executor executorZzi = phoneAuthOptions.zzi();
        boolean z = phoneAuthOptions.zzd() != null;
        if (z || !zzxr.zzd(strCheckNotEmpty2, onVerificationStateChangedCallbacksZze, activity, executorZzi)) {
            firebaseAuthZzb2.zzn.zza(firebaseAuthZzb2, strCheckNotEmpty2, activity, firebaseAuthZzb2.zzK()).addOnCompleteListener(new zzo(firebaseAuthZzb2, strCheckNotEmpty2, jLongValue, timeUnit, onVerificationStateChangedCallbacksZze, activity, executorZzi, z));
        }
    }

    public final void zzJ(@NonNull String str, long j, @NonNull TimeUnit timeUnit, @NonNull PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @NonNull Activity activity, @NonNull Executor executor, boolean z, @Nullable String str2, @Nullable String str3) {
        long jConvert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (jConvert < 0 || jConvert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        this.zze.zzO(this.zza, new zzzn(str, jConvert, z, this.zzi, this.zzk, str2, zzK(), str3), zzL(str, onVerificationStateChangedCallbacks), activity, executor);
    }

    @VisibleForTesting
    public final boolean zzK() {
        return zzwj.zza(getApp().getApplicationContext());
    }

    @NonNull
    public final Task zza(@NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zze(firebaseUser, new zzi(this, firebaseUser));
    }

    @NonNull
    public final Task zzb(@NonNull FirebaseUser firebaseUser, @NonNull MultiFactorAssertion multiFactorAssertion, @Nullable String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        return multiFactorAssertion instanceof PhoneMultiFactorAssertion ? this.zze.zzg(this.zza, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzs(this)) : Tasks.forException(zzwe.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
    }

    @NonNull
    public final Task zzc(@Nullable FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzwe.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzza zzzaVarZzd = firebaseUser.zzd();
        return (!zzzaVarZzd.zzj() || z) ? this.zze.zzi(this.zza, firebaseUser, zzzaVarZzd.zzf(), new zzn(this)) : Tasks.forResult(zzay.zza(zzzaVarZzd.zze()));
    }

    @NonNull
    public final Task zzd(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzj(this.zza, firebaseUser, authCredential.zza(), new zzt(this));
    }

    @NonNull
    public final Task zze(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (!(authCredentialZza instanceof EmailAuthCredential)) {
            return authCredentialZza instanceof PhoneAuthCredential ? this.zze.zzq(this.zza, firebaseUser, (PhoneAuthCredential) authCredentialZza, this.zzk, new zzt(this)) : this.zze.zzk(this.zza, firebaseUser, authCredentialZza, firebaseUser.getTenantId(), new zzt(this));
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
        return "password".equals(emailAuthCredential.getSignInMethod()) ? this.zze.zzo(this.zza, firebaseUser, emailAuthCredential.zzd(), Preconditions.checkNotEmpty(emailAuthCredential.zze()), firebaseUser.getTenantId(), new zzt(this)) : zzM(Preconditions.checkNotEmpty(emailAuthCredential.zzf())) ? Tasks.forException(zzwe.zza(new Status(17072))) : this.zze.zzm(this.zza, firebaseUser, emailAuthCredential, new zzt(this));
    }

    @NonNull
    public final Task zzf(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential authCredentialZza = authCredential.zza();
        if (!(authCredentialZza instanceof EmailAuthCredential)) {
            return authCredentialZza instanceof PhoneAuthCredential ? this.zze.zzr(this.zza, firebaseUser, (PhoneAuthCredential) authCredentialZza, this.zzk, new zzt(this)) : this.zze.zzl(this.zza, firebaseUser, authCredentialZza, firebaseUser.getTenantId(), new zzt(this));
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialZza;
        return "password".equals(emailAuthCredential.getSignInMethod()) ? this.zze.zzp(this.zza, firebaseUser, emailAuthCredential.zzd(), Preconditions.checkNotEmpty(emailAuthCredential.zze()), firebaseUser.getTenantId(), new zzt(this)) : zzM(Preconditions.checkNotEmpty(emailAuthCredential.zzf())) ? Tasks.forException(zzwe.zza(new Status(17072))) : this.zze.zzn(this.zza, firebaseUser, emailAuthCredential, new zzt(this));
    }

    public final Task zzg(FirebaseUser firebaseUser, zzbk zzbkVar) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzs(this.zza, firebaseUser, zzbkVar);
    }

    public final Task zzh(MultiFactorAssertion multiFactorAssertion, com.google.firebase.auth.internal.zzag zzagVar, @Nullable FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzagVar);
        return this.zze.zzh(this.zza, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzagVar.zzd()), new zzs(this));
    }

    @NonNull
    public final Task zzi(@Nullable ActionCodeSettings actionCodeSettings, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzi != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zzf(this.zzi);
        }
        return this.zze.zzt(this.zza, actionCodeSettings, str);
    }

    @NonNull
    public final Task zzj(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider, @NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzm.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzwe.zza(new Status(17057)));
        }
        this.zzm.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final Task zzk(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider, @NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzm.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzwe.zza(new Status(17057)));
        }
        this.zzm.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final Task zzl(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzF(this.zza, firebaseUser, str, new zzt(this)).continueWithTask(new zzr(this));
    }

    @NonNull
    public final Task zzm(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zze.zzG(this.zza, firebaseUser, str, new zzt(this));
    }

    @NonNull
    public final Task zzn(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzH(this.zza, firebaseUser, str, new zzt(this));
    }

    @NonNull
    public final Task zzo(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zze.zzI(this.zza, firebaseUser, str, new zzt(this));
    }

    @NonNull
    public final Task zzp(@NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zze.zzJ(this.zza, firebaseUser, phoneAuthCredential.clone(), new zzt(this));
    }

    @NonNull
    public final Task zzq(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zze.zzK(this.zza, firebaseUser, userProfileChangeRequest, new zzt(this));
    }

    @NonNull
    public final Task zzr(@NonNull String str, @NonNull String str2, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzi;
        if (str3 != null) {
            actionCodeSettings.zzf(str3);
        }
        return this.zze.zzL(str, str2, actionCodeSettings);
    }

    @VisibleForTesting
    public final synchronized zzbi zzw() {
        return zzx(this);
    }

    @NonNull
    public final Provider zzy() {
        return this.zzo;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    @KeepForSdk
    public void removeIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.remove(idTokenListener);
        zzw().zzd(this.zzc.size());
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzi;
        if (str2 != null) {
            actionCodeSettings.zzf(str2);
        }
        actionCodeSettings.zzg(1);
        return this.zze.zzu(this.zza, str, actionCodeSettings, this.zzk);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    @KeepForSdk
    public void addIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzc.add(idTokenListener);
        zzw().zzd(this.zzc.size());
    }
}
