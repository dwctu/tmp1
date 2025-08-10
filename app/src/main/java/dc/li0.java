package dc;

import android.app.Application;
import android.content.Context;

/* compiled from: OAIDFactory.java */
/* loaded from: classes.dex */
public final class li0 {
    public static wh0 a;

    public static wh0 a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        wh0 wh0Var = a;
        if (wh0Var != null) {
            return wh0Var;
        }
        wh0 wh0VarB = b(context);
        a = wh0VarB;
        if (wh0VarB == null || !wh0VarB.a()) {
            wh0 wh0VarC = c(context);
            a = wh0VarC;
            return wh0VarC;
        }
        xh0.a("Manufacturer interface has been found: " + a.getClass().getName());
        return a;
    }

    public static wh0 b(Context context) {
        if (yh0.j() || yh0.m()) {
            return new hi0(context);
        }
        if (yh0.k()) {
            return new ii0(context);
        }
        if (yh0.n()) {
            return new ki0(context);
        }
        if (yh0.s() || yh0.l() || yh0.c()) {
            return new si0(context);
        }
        if (yh0.q()) {
            return new qi0(context);
        }
        if (yh0.r()) {
            return new ri0(context);
        }
        if (yh0.b()) {
            return new zh0(context);
        }
        if (yh0.h()) {
            fi0 fi0Var = new fi0(context);
            if (fi0Var.a()) {
                return fi0Var;
            }
        }
        if (yh0.i() || yh0.f()) {
            return new gi0(context);
        }
        if (yh0.p() || yh0.o()) {
            oi0 oi0Var = new oi0(context);
            return oi0Var.a() ? oi0Var : new ni0(context);
        }
        if (yh0.d(context)) {
            return new ai0(context);
        }
        if (yh0.e()) {
            return new bi0(context);
        }
        if (yh0.g()) {
            return new di0(context);
        }
        if (yh0.a()) {
            return new pi0(context);
        }
        return null;
    }

    public static wh0 c(Context context) {
        ji0 ji0Var = new ji0(context);
        if (ji0Var.a()) {
            xh0.a("Mobile Security Alliance has been found: " + ji0.class.getName());
            return ji0Var;
        }
        ei0 ei0Var = new ei0(context);
        if (ei0Var.a()) {
            xh0.a("Google Play Service has been found: " + ei0.class.getName());
            return ei0Var;
        }
        ci0 ci0Var = new ci0();
        xh0.a("OAID/AAID was not supported: " + ci0.class.getName());
        return ci0Var;
    }
}
