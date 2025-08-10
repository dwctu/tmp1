package com.wear.bean;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.util.TextOverlayImageView;
import dc.at1;
import dc.nb0;
import dc.ob0;
import dc.qb0;
import dc.ws1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Toy {
    public static final String TOY_FEATURE_GRAVITY = "gravity";
    public static final String TOY_FEATURE_TENERA = "suction";
    public static final String TOY_FEATURE_XMACHINE = "thrust";
    public static final String TOY_XMACHINE = "XMachine";
    public at1 toyProxy;
    public static final Map<String, String> NAME_MAP = ws1.b;
    public static final Map<String, Integer> ICON_MAP = ws1.c;
    public static final Map<String, Integer[]> ICON_MAP_LINKED = ws1.d;
    public static final Map<String, int[][]> ICON_MAP_CONTROL = ws1.e;
    public static final Map<String, Integer> ICON_MAP_CONTROL_BACKGROUND = ws1.f;
    public static final Map<String, Integer> ICON_MAP_CONTROL_COLOR = ws1.g;
    public static final Map<String, Integer> ICON_MAP_CONTROL_Thumb = ws1.h;
    public static final Map<String, Integer> ICON_MAP_CONTROL_PROGRESS_DRAWABLE = ws1.i;
    public static final Map<String, String[]> TOY_OPERATION = ws1.j;
    public static final Map<String, Integer[]> TOY_MAP_FUNC = ws1.k;
    public static final Map<String, Integer> ICON_MAP_CONTROL_TRANS_COLOR = ws1.l;
    public static final Map<String, Integer> ICON_TOY_STRENGTH_COLOR = ws1.m;
    public static final Map<String, String> TOY_STRENGTH = ws1.n;
    public static final Map<String, String> TOY_COMPARE = ws1.o;
    public static final List<String> TOY_COMMEND = ws1.p;
    public static final Map<String, Integer> ICON_MAP_DRAWABLE = ws1.q;
    public static final Map<String, Integer> TOY_LANGUAGE = ws1.r;
    public static List<ToyConfigInfoBean> toyConfigBean = ws1.t;
    public static int ConfigVersionDev = ws1.u;
    public static int ConfigVersionRes = ws1.v;

    public Toy() {
        this.toyProxy = new at1();
    }

    public static boolean canAddAddressToNeedConnect(String str) {
        return at1.b.a(str);
    }

    public static boolean canBind(String str) {
        return at1.b.b(str);
    }

    public static final String changeSinglefuncLineToTayValue(String str, String str2) {
        return at1.b.c(str, str2);
    }

    public static final String changeSinglefuncLineToToyValue(String str, String str2) {
        return at1.b.d(str, str2);
    }

    public static final String changeToyValueToSinglefuncLine(String str, String str2) {
        return at1.b.e(str, str2);
    }

    public static int existDepthfund(String str, View view) {
        return at1.b.f(str, view);
    }

    public static int existPumpVFunc(String str, View view) {
        return at1.b.g(str, view);
    }

    public static int existRotationVFunc(String str, View view) {
        return at1.b.h(str, view);
    }

    public static int existSecondVibratorVFunc(String str, View view) {
        return at1.b.i(str, view);
    }

    public static int existSpeedFuns(String str, View view) {
        return at1.b.j(str, view);
    }

    public static int existSuckFunc(String str, View view) {
        return at1.b.k(str, view);
    }

    public static int existThirdVibratorVFunc(String str, View view) {
        return at1.b.l(str, view);
    }

    public static int existVibratorFunV(String str, View view) {
        return at1.b.m(str, view);
    }

    public static int existfingerFunf(String str, View view) {
        return at1.b.n(str, view);
    }

    public static int existfingerFunt(String str, View view) {
        return at1.b.o(str, view);
    }

    public static String generateType(String str) {
        return at1.b.p(str);
    }

    public static int getCurveLineColor(String str) {
        return at1.b.q(str);
    }

    public static int getCurveLineTransColor(String str) {
        return at1.b.r(str);
    }

    public static String getLableTitle(String str, String str2) {
        return at1.b.t(str, str2);
    }

    public static String getLdrToyFunction(String str) {
        return at1.b.u(str);
    }

    public static String getNameByFun(String str) {
        return at1.b.v(str);
    }

    public static int getSeekbarProgress(String str) {
        return at1.b.w(str);
    }

    public static int getSeekbarThumb(String str) {
        return at1.b.x(str);
    }

    public static int[] getToyFuncIcon(String str, int i, int i2, boolean z) {
        return at1.b.y(str, i, i2, z);
    }

    public static String getToyFunction(String str) {
        return at1.b.z(str);
    }

    public static int getToyIconLinkedId(String str, int i, boolean z) {
        return at1.b.A(str, i, z);
    }

    public static String getToyTypeByFunc(String str) {
        return at1.b.B(str);
    }

    public static boolean isAgArrayMessage(String str) {
        return at1.b.C(str);
    }

    public static boolean isAiTypeMessage(String str) {
        return at1.b.D(str);
    }

    public static boolean isContainFunction(String str) {
        return at1.b.E(str);
    }

    public static boolean isDeviceTypeMessage(String str) {
        return at1.b.F(str);
    }

    public static boolean isOurToy(String str) {
        return at1.b.G(str);
    }

    public static boolean isOurType(String str) {
        return at1.b.H(str);
    }

    public static boolean isPin(String str) {
        return at1.b.I(str);
    }

    public static int isVelvoFunt(String str, View view) {
        return at1.b.J(str, view);
    }

    public static int setBatteryImage(boolean z, boolean z2, int i) {
        return at1.b.K(z, z2, i);
    }

    public static void setToyConfig(String str) {
        at1.b.L(str);
    }

    public static void updateToyBatteryTrans(ImageView imageView, int i) {
        at1.b.N(imageView, i);
    }

    public void addConnectTryNumb() {
        this.toyProxy.F2();
    }

    public void addLanApiUpdateCount() {
        this.toyProxy.o0();
    }

    public boolean canAddConnectingLog(boolean z) {
        return this.toyProxy.S(z);
    }

    public boolean canGetBattery() {
        return this.toyProxy.E();
    }

    public boolean canSetLed() {
        return this.toyProxy.canSetLed();
    }

    public String getAddress() {
        return this.toyProxy.P();
    }

    public String getAgString() {
        return this.toyProxy.Y0();
    }

    public String getAiString() {
        return this.toyProxy.H1();
    }

    public String getAndUpdateDeviceId() {
        return this.toyProxy.m2();
    }

    public String getBatchId() {
        return this.toyProxy.a1();
    }

    public List<Integer> getBattayList() {
        return this.toyProxy.n1();
    }

    public int getBattery() {
        return this.toyProxy.W();
    }

    public long getBatteryRequestTime() {
        return this.toyProxy.Q();
    }

    public int getBindType() {
        return this.toyProxy.i1();
    }

    public List<Map<String, Long>> getCommandList() {
        return this.toyProxy.o();
    }

    public int getConnectApp() {
        return this.toyProxy.p2();
    }

    public long getConnectScanTime() {
        return this.toyProxy.U1();
    }

    public int getConnectTryNumb() {
        return this.toyProxy.a0();
    }

    public int getConnectType() {
        return this.toyProxy.b0();
    }

    public Long getConnectedTime() {
        return Long.valueOf(this.toyProxy.m());
    }

    public String getDataBaseType() {
        return this.toyProxy.G();
    }

    public String getDefineRename() {
        return this.toyProxy.s1();
    }

    public String getDeviceId() {
        return this.toyProxy.C();
    }

    public String getDeviceName() {
        return this.toyProxy.P1();
    }

    public String getDeviceType() {
        return this.toyProxy.L0();
    }

    public String getDeviceTypeMac(String str) {
        return this.toyProxy.z2(str);
    }

    public int getDfuIcon(boolean z) {
        return this.toyProxy.f1(z);
    }

    public int getDisConnectType() {
        return this.toyProxy.K1();
    }

    public String getEmail() {
        return this.toyProxy.getEmail();
    }

    public long getFeedbackDownTime() {
        return this.toyProxy.R0();
    }

    public String getFormApp() {
        return this.toyProxy.K();
    }

    public String getFullName() {
        return this.toyProxy.U0();
    }

    public ToyConfigInfoBean.FuncBean getFunc() {
        return this.toyProxy.H3();
    }

    public String getGenerationVersion() {
        return this.toyProxy.w1();
    }

    public long getGetCheckBindToyErrorTime() {
        return this.toyProxy.X();
    }

    public long getGetDfuErrorTime() {
        return this.toyProxy.J1();
    }

    public String getId() {
        return this.toyProxy.getId();
    }

    public int getIsCheckBindToy() {
        return this.toyProxy.w();
    }

    public int getIsDfuEnd() {
        return this.toyProxy.o2();
    }

    public int getIsLongRange() {
        return this.toyProxy.v2();
    }

    public int getIsPowerOff() {
        return this.toyProxy.w2();
    }

    public Integer getIsSelect() {
        return Integer.valueOf(this.toyProxy.S2());
    }

    public int getLanApiUpdateCount() {
        return this.toyProxy.y2();
    }

    public int getLdrIcon() {
        return this.toyProxy.getLdrIcon();
    }

    public int getLed() {
        return this.toyProxy.E1();
    }

    public Integer getLedSetting() {
        return Integer.valueOf(this.toyProxy.Q1());
    }

    public String getLogFormApp() {
        return this.toyProxy.L();
    }

    public String getLogToyType() {
        return this.toyProxy.P0();
    }

    public String getLogToyTypeAndRssi(int i) {
        return this.toyProxy.I0(i);
    }

    public List<qb0> getLvsMotorsFuncList() {
        return this.toyProxy.T0();
    }

    public int getMissionSolo() {
        return this.toyProxy.P2();
    }

    public int[] getMissionTchLvl() {
        return this.toyProxy.A1();
    }

    public List<List<String>> getMotors() {
        return this.toyProxy.x1();
    }

    public String getMultiplayOrder() {
        return this.toyProxy.B0();
    }

    public String getName() {
        return this.toyProxy.getName();
    }

    public String getNewLogToyTypeAndRssi(BleResultBean bleResultBean) {
        return this.toyProxy.q1(bleResultBean);
    }

    public String getOldEmail() {
        return this.toyProxy.h();
    }

    public String getOldId() {
        return this.toyProxy.O0();
    }

    public String getPinStatus() {
        return this.toyProxy.u0();
    }

    public long getPowerOffTime() {
        return this.toyProxy.f0();
    }

    public int[] getProgramDefaultLevel() {
        return this.toyProxy.c2();
    }

    public ArrayList<String> getProgramDefaultProgram() {
        return this.toyProxy.Y();
    }

    public int getProgramSpeed() {
        return this.toyProxy.l2();
    }

    public String getRealType() {
        return this.toyProxy.g0();
    }

    public boolean getReconnectOvertime() {
        return this.toyProxy.n0();
    }

    public Long getRquestConnectTime() {
        return Long.valueOf(this.toyProxy.L2());
    }

    public int getRssi() {
        return this.toyProxy.h0();
    }

    public int getRssiImg() {
        return this.toyProxy.x();
    }

    public List<String> getRssiList() {
        return this.toyProxy.H2();
    }

    public int getSearchToyIcon() {
        return this.toyProxy.n2();
    }

    public String getShowName() {
        return this.toyProxy.getShowName();
    }

    public String getSimpleFullName() {
        return this.toyProxy.S1();
    }

    public String getSimpleName() {
        return this.toyProxy.getSimpleName();
    }

    public String getSimpleType() {
        return this.toyProxy.q();
    }

    public int getStatus() {
        return this.toyProxy.getStatus();
    }

    @Nullable
    public ToyConfigInfoBean getToyConfigDataBean() {
        return this.toyProxy.F0();
    }

    public int getToyIcon() {
        return this.toyProxy.M0();
    }

    public int getToyRssiLevel() {
        return this.toyProxy.r1();
    }

    public List<String> getToySymbol() {
        return this.toyProxy.J();
    }

    public String getToyTypeKey() {
        return this.toyProxy.S0();
    }

    public String getToyUINameSpecialForMiniXMachine(int i) {
        return this.toyProxy.q2(i);
    }

    public int getToyVersion() {
        return this.toyProxy.W0();
    }

    public String getType() {
        return this.toyProxy.getType();
    }

    public String getUpCaseName() {
        return this.toyProxy.J2();
    }

    public DfuBean getUpdateDfu() {
        return this.toyProxy.A2();
    }

    public long getUpdateTime() {
        return this.toyProxy.X1();
    }

    public String getUuid() {
        return this.toyProxy.D1();
    }

    public Integer getVersion() {
        return Integer.valueOf(this.toyProxy.getVersion());
    }

    public String getWorkMode() {
        return this.toyProxy.H0();
    }

    public int getaColor() {
        return this.toyProxy.k2();
    }

    public boolean hasProgramToy() {
        return this.toyProxy.Z();
    }

    public boolean isAlarmEnable() {
        return this.toyProxy.h2();
    }

    public boolean isBAToy() {
        return this.toyProxy.G0();
    }

    public boolean isCanWearoy() {
        return this.toyProxy.b();
    }

    public boolean isCmdCompensation() {
        return this.toyProxy.M2();
    }

    public boolean isConnected() {
        return this.toyProxy.isConnected();
    }

    public boolean isDirection() {
        return this.toyProxy.R2();
    }

    public boolean isEAToy() {
        return this.toyProxy.f2();
    }

    public boolean isEI01Toy() {
        return this.toyProxy.j1();
    }

    public boolean isEL01Toy() {
        return this.toyProxy.K3();
    }

    public boolean isEncrypt() {
        return this.toyProxy.T1();
    }

    public boolean isF01IsNotice() {
        return this.toyProxy.r0();
    }

    public boolean isF01IsReady() {
        return this.toyProxy.m1();
    }

    public boolean isF01Off() {
        return this.toyProxy.K2();
    }

    public boolean isF01Toy() {
        return this.toyProxy.I();
    }

    public boolean isFeedbackModeEnable() {
        return this.toyProxy.e1();
    }

    public int isFeedbackModeEnableAndUpdateEnable() {
        return this.toyProxy.y1();
    }

    public boolean isGeminiToy() {
        return this.toyProxy.I1();
    }

    public boolean isGravity() {
        return this.toyProxy.x0();
    }

    public boolean isH01Toy() {
        return this.toyProxy.l();
    }

    public boolean isJ01Toy() {
        return this.toyProxy.p0();
    }

    public boolean isLanApiUpdateRequest() {
        return this.toyProxy.i0();
    }

    public boolean isMax() {
        return this.toyProxy.isMax();
    }

    public boolean isMaxToy() {
        return this.toyProxy.v0();
    }

    public boolean isMiniXMachine() {
        return this.toyProxy.w0();
    }

    public boolean isMultiplyInstruct() {
        return this.toyProxy.A();
    }

    public boolean isNora() {
        return this.toyProxy.y0();
    }

    public boolean isNoraToy() {
        return this.toyProxy.t2();
    }

    public boolean isQ01Toy() {
        return this.toyProxy.O1();
    }

    public boolean isQA01Toy() {
        return this.toyProxy.d2();
    }

    public boolean isRealDeviceType() {
        return this.toyProxy.Q0();
    }

    public boolean isSelect() {
        return this.toyProxy.v1();
    }

    public boolean isSetGradualSpeedUpEnable() {
        return this.toyProxy.C1();
    }

    public boolean isSetThresholdEnable() {
        return this.toyProxy.J0();
    }

    public boolean isSupportAir() {
        return this.toyProxy.a();
    }

    public boolean isSupportBt() {
        return this.toyProxy.isSupportBt();
    }

    public boolean isSupportControlPanel() {
        return this.toyProxy.isSupportControlPanel();
    }

    public boolean isSupportDepthMode() {
        return this.toyProxy.isSupportDepthMode();
    }

    public boolean isSupportGame() {
        return this.toyProxy.isSupportGame();
    }

    public boolean isSupportLEDColor(boolean z) {
        return this.toyProxy.V0(z);
    }

    public boolean isSupportLVS() {
        return this.toyProxy.g2();
    }

    public boolean isSupportLdr() {
        return this.toyProxy.isSupportLdr();
    }

    public boolean isSupportR() {
        return this.toyProxy.V1();
    }

    public boolean isSupportV1V2() {
        return this.toyProxy.t1();
    }

    public boolean isSupportV1V2F() {
        return this.toyProxy.M();
    }

    public boolean isSuppportPinCode() {
        return this.toyProxy.L1();
    }

    public boolean isSynControlAnimation() {
        return this.toyProxy.n();
    }

    public boolean isT01Toy() {
        return this.toyProxy.i();
    }

    public boolean isThridPartToy() {
        return this.toyProxy.isThridPartToy();
    }

    public boolean isToyListAdd() {
        return this.toyProxy.U();
    }

    public boolean isTransfer() {
        return this.toyProxy.D2();
    }

    public boolean isV01Toy() {
        return this.toyProxy.A0();
    }

    public boolean isVirtualToy() {
        return this.toyProxy.isVirtualToy();
    }

    public boolean isXMachine() {
        return this.toyProxy.j0();
    }

    public void pushBattay(int i) {
        this.toyProxy.b2(i);
    }

    public void pushCommand(String str) {
        this.toyProxy.E2(str);
    }

    public void pushRssi(int i) {
        this.toyProxy.T(i);
    }

    public void reduceConnectTryNumb() {
        this.toyProxy.X0();
    }

    public void setAddress(String str) {
        this.toyProxy.o1(str);
    }

    public void setAgString(String str) {
        this.toyProxy.R1(str);
    }

    public void setAiString(String str, boolean z) {
        this.toyProxy.c1(str, z);
    }

    public void setBatchId(String str) {
        this.toyProxy.W1(str);
    }

    public void setBattery(int i) {
        this.toyProxy.d(i);
    }

    public void setBatteryRequestTime(long j) {
        this.toyProxy.u(j);
    }

    public void setBindType(int i) {
        this.toyProxy.y(i);
    }

    public void setCanRssi(boolean z) {
        this.toyProxy.G2(z);
    }

    public void setConnectApp(int i) {
        this.toyProxy.x2(i);
    }

    public void setConnectPriority(ob0 ob0Var) {
        this.toyProxy.u2(ob0Var);
    }

    public void setConnectScanTime(long j) {
        this.toyProxy.e2(j);
    }

    public void setConnectTryNumb(int i) {
        this.toyProxy.Y1(i);
    }

    public void setConnectType(int i) {
        this.toyProxy.c0(i);
    }

    public void setConnectedTime(Long l) {
        this.toyProxy.B1(l.longValue());
    }

    public void setDefineRename(String str) {
        this.toyProxy.v(str);
    }

    public void setDeviceId(String str) {
        this.toyProxy.r(str);
    }

    public void setDeviceName(String str) {
        this.toyProxy.G1(str);
    }

    public void setDeviceType(String str) {
        this.toyProxy.N2(str);
    }

    public void setDirection(boolean z) {
        this.toyProxy.B(z);
    }

    public void setDisConnectType(int i) {
        this.toyProxy.u1(i);
    }

    public void setEmail(String str) {
        this.toyProxy.k1(str);
    }

    public void setEncrypt(boolean z) {
        this.toyProxy.t0(z);
    }

    public void setF01IsNotice(boolean z) {
        this.toyProxy.M1(z);
    }

    public void setF01IsOff(boolean z) {
        this.toyProxy.k0(z);
    }

    public void setF01IsReady(boolean z) {
        this.toyProxy.a2(z);
    }

    public void setFeedbackDownTime(long j) {
        this.toyProxy.k(j);
    }

    public void setFormApp(String str) {
        this.toyProxy.N1(str);
    }

    public void setGetCheckBindToyErrorTime(long j) {
        this.toyProxy.E0(j);
    }

    public void setGetDfuErrorTime(long j) {
        this.toyProxy.b1(j);
    }

    public void setId(String str) {
        this.toyProxy.K0(str);
    }

    public void setIsCheckBindToy(int i) {
        this.toyProxy.F(i);
    }

    public void setIsDfuEnd(int i) {
        this.toyProxy.I2(i);
    }

    public void setIsLongRange(int i) {
        this.toyProxy.p(i);
    }

    public void setIsPowerOff(int i) {
        this.toyProxy.C2(i);
    }

    public void setIsSelect(Integer num) {
        this.toyProxy.h1(num.intValue());
    }

    public void setLanApiUpdateCount(int i) {
        this.toyProxy.D0(i);
    }

    public void setLanApiUpdateRequest(boolean z) {
        this.toyProxy.s(z);
    }

    public void setLed(int i) {
        this.toyProxy.z1(i);
    }

    public void setLedSetting(Integer num) {
        this.toyProxy.Z0(num.intValue());
    }

    public void setLogFormApp(String str) {
        this.toyProxy.V(str);
    }

    public void setLvsMotorConfig(String str) {
        this.toyProxy.F1(str);
    }

    public void setMissionSolo(int i) {
        this.toyProxy.s2(i);
    }

    public void setMissionTchLvl(int[] iArr) {
        this.toyProxy.l1(iArr);
    }

    public void setName(String str) {
        this.toyProxy.j2(str);
    }

    public void setPinStatus(String str) {
        this.toyProxy.N(str);
    }

    public void setPowerOffTime(long j) {
        this.toyProxy.d1(j);
    }

    public void setRealDeviceType(boolean z) {
        this.toyProxy.C0(z);
    }

    public void setRealType(String str) {
        this.toyProxy.e(str);
    }

    public void setRenameDeviceName() {
        this.toyProxy.e0();
    }

    public void setRquestConnectTime(Long l) {
        this.toyProxy.z0(l.longValue());
    }

    public void setRssi(int i) {
        this.toyProxy.g1(i);
    }

    public void setSimpleToy(Integer num) {
        this.toyProxy.R(num.intValue());
    }

    public synchronized void setStatus(int i) {
        this.toyProxy.Q2(i);
    }

    public void setSynControlAnimation(boolean z) {
        this.toyProxy.m0(z);
    }

    public void setToyConfigDataBean(ToyConfigInfoBean toyConfigInfoBean) {
        this.toyProxy.H(toyConfigInfoBean);
    }

    public void setToyListAdd(boolean z) {
        this.toyProxy.l0(z);
    }

    public void setTransfer(boolean z) {
        this.toyProxy.t(z);
    }

    public void setType(String str) {
        this.toyProxy.i2(str);
    }

    public void setUpCaseName(String str) {
        this.toyProxy.f(str);
    }

    public void setUpdateDfu(DfuBean dfuBean) {
        this.toyProxy.c(dfuBean);
    }

    public void setUpdateTime(long j) {
        this.toyProxy.g(j);
    }

    public void setUuid(String str) {
        this.toyProxy.B2(str);
    }

    public void setVersion(Integer num) {
        this.toyProxy.setVersion(num.intValue());
    }

    public void setWorkMode(String str) {
        this.toyProxy.O2(str);
    }

    public void setaColor(int i) {
        this.toyProxy.N0(i);
    }

    public boolean supportChangeName() {
        return this.toyProxy.O();
    }

    public boolean supportCommand(String str) {
        return this.toyProxy.supportCommand(str);
    }

    public void synNameToType() {
        this.toyProxy.d0();
    }

    public boolean toyIsSupport() {
        return this.toyProxy.s0();
    }

    public boolean toyIsSupportLanApi() {
        return this.toyProxy.D();
    }

    public int typeInt() {
        return this.toyProxy.q0();
    }

    public void updateMyToyBattery(Context context, TextOverlayImageView textOverlayImageView) {
        this.toyProxy.z(context, textOverlayImageView);
    }

    public void updateToyBattery(ImageView imageView) {
        this.toyProxy.j(imageView);
    }

    public static String getFullName(String str) {
        return at1.b.s(str);
    }

    public static void updateToyBattery(ImageView imageView, int i) {
        at1.b.M(imageView, i);
    }

    public boolean isEI01Toy(int i) {
        return this.toyProxy.r2(i);
    }

    public boolean isGeminiToy(int i) {
        return this.toyProxy.Z1(i);
    }

    public void setToyConfigDataBean() {
        this.toyProxy.p1();
    }

    public Toy(nb0 nb0Var) {
        at1 at1Var = new at1();
        this.toyProxy = at1Var;
        at1Var.M3(nb0Var);
    }

    public Toy(ws1 ws1Var) {
        at1 at1Var = new at1();
        this.toyProxy = at1Var;
        at1Var.N3(ws1Var);
    }
}
