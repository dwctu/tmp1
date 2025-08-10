package dc;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bigkoo.pickerview.lib.WheelView;
import com.google.android.vending.expansion.downloader.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: WheelTime.java */
/* loaded from: classes.dex */
public class hf {
    public static DateFormat w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public View a;
    public WheelView b;
    public WheelView c;
    public WheelView d;
    public WheelView e;
    public WheelView f;
    public WheelView g;
    public int h;
    public boolean[] i;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public WheelView.b v;
    public int j = 1900;
    public int k = 2100;
    public int l = 1;
    public int m = 12;
    public int n = 1;
    public int o = 31;
    public float u = 1.6f;

    /* compiled from: WheelTime.java */
    public class a implements df {
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;

        public a(List list, List list2) {
            this.a = list;
            this.b = list2;
        }

        @Override // dc.df
        public void a(int i) {
            int i2 = i + hf.this.j;
            hf.this.p = i2;
            int currentItem = hf.this.c.getCurrentItem();
            if (hf.this.j == hf.this.k) {
                hf.this.c.setAdapter(new ue(hf.this.l, hf.this.m));
                if (currentItem > hf.this.c.getAdapter().a() - 1) {
                    currentItem = hf.this.c.getAdapter().a() - 1;
                    hf.this.c.setCurrentItem(currentItem);
                }
                int i3 = currentItem + hf.this.l;
                if (hf.this.l == hf.this.m) {
                    hf hfVar = hf.this;
                    hfVar.y(i2, i3, hfVar.n, hf.this.o, this.a, this.b);
                    return;
                } else if (i3 != hf.this.l) {
                    hf.this.y(i2, i3, 1, 31, this.a, this.b);
                    return;
                } else {
                    hf hfVar2 = hf.this;
                    hfVar2.y(i2, i3, hfVar2.n, 31, this.a, this.b);
                    return;
                }
            }
            if (i2 == hf.this.j) {
                hf.this.c.setAdapter(new ue(hf.this.l, 12));
                if (currentItem > hf.this.c.getAdapter().a() - 1) {
                    currentItem = hf.this.c.getAdapter().a() - 1;
                    hf.this.c.setCurrentItem(currentItem);
                }
                int i4 = currentItem + hf.this.l;
                if (i4 != hf.this.l) {
                    hf.this.y(i2, i4, 1, 31, this.a, this.b);
                    return;
                } else {
                    hf hfVar3 = hf.this;
                    hfVar3.y(i2, i4, hfVar3.n, 31, this.a, this.b);
                    return;
                }
            }
            if (i2 != hf.this.k) {
                hf.this.c.setAdapter(new ue(1, 12));
                hf hfVar4 = hf.this;
                hfVar4.y(i2, 1 + hfVar4.c.getCurrentItem(), 1, 31, this.a, this.b);
                return;
            }
            hf.this.c.setAdapter(new ue(1, hf.this.m));
            if (currentItem > hf.this.c.getAdapter().a() - 1) {
                currentItem = hf.this.c.getAdapter().a() - 1;
                hf.this.c.setCurrentItem(currentItem);
            }
            int i5 = 1 + currentItem;
            if (i5 != hf.this.m) {
                hf.this.y(i2, i5, 1, 31, this.a, this.b);
            } else {
                hf hfVar5 = hf.this;
                hfVar5.y(i2, i5, 1, hfVar5.o, this.a, this.b);
            }
        }
    }

    /* compiled from: WheelTime.java */
    public class b implements df {
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;

        public b(List list, List list2) {
            this.a = list;
            this.b = list2;
        }

        @Override // dc.df
        public void a(int i) {
            int i2 = i + 1;
            if (hf.this.j == hf.this.k) {
                int i3 = (i2 + hf.this.l) - 1;
                if (hf.this.l == hf.this.m) {
                    hf hfVar = hf.this;
                    hfVar.y(hfVar.p, i3, hf.this.n, hf.this.o, this.a, this.b);
                    return;
                } else if (hf.this.l == i3) {
                    hf hfVar2 = hf.this;
                    hfVar2.y(hfVar2.p, i3, hf.this.n, 31, this.a, this.b);
                    return;
                } else if (hf.this.m == i3) {
                    hf hfVar3 = hf.this;
                    hfVar3.y(hfVar3.p, i3, 1, hf.this.o, this.a, this.b);
                    return;
                } else {
                    hf hfVar4 = hf.this;
                    hfVar4.y(hfVar4.p, i3, 1, 31, this.a, this.b);
                    return;
                }
            }
            if (hf.this.p == hf.this.j) {
                int i4 = (i2 + hf.this.l) - 1;
                if (i4 == hf.this.l) {
                    hf hfVar5 = hf.this;
                    hfVar5.y(hfVar5.p, i4, hf.this.n, 31, this.a, this.b);
                    return;
                } else {
                    hf hfVar6 = hf.this;
                    hfVar6.y(hfVar6.p, i4, 1, 31, this.a, this.b);
                    return;
                }
            }
            if (hf.this.p != hf.this.k) {
                hf hfVar7 = hf.this;
                hfVar7.y(hfVar7.p, i2, 1, 31, this.a, this.b);
            } else if (i2 == hf.this.m) {
                hf hfVar8 = hf.this;
                hfVar8.y(hfVar8.p, hf.this.c.getCurrentItem() + 1, 1, hf.this.o, this.a, this.b);
            } else {
                hf hfVar9 = hf.this;
                hfVar9.y(hfVar9.p, hf.this.c.getCurrentItem() + 1, 1, 31, this.a, this.b);
            }
        }
    }

    public hf(View view, boolean[] zArr, int i, int i2) {
        this.q = 18;
        this.a = view;
        this.i = zArr;
        this.h = i;
        this.q = i2;
        E(view);
    }

    public final void A() {
        this.d.setTextColorCenter(this.s);
        this.c.setTextColorCenter(this.s);
        this.b.setTextColorCenter(this.s);
        this.e.setTextColorCenter(this.s);
        this.f.setTextColorCenter(this.s);
        this.g.setTextColorCenter(this.s);
    }

    public void B(int i) {
        this.s = i;
        A();
    }

    public final void C() {
        this.d.setTextColorOut(this.r);
        this.c.setTextColorOut(this.r);
        this.b.setTextColorOut(this.r);
        this.e.setTextColorOut(this.r);
        this.f.setTextColorOut(this.r);
        this.g.setTextColorOut(this.r);
    }

    public void D(int i) {
        this.r = i;
        C();
    }

    public void E(View view) {
        this.a = view;
    }

    public String k() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.p == this.j) {
            int currentItem = this.c.getCurrentItem();
            int i = this.l;
            if (currentItem + i == i) {
                stringBuffer.append(this.b.getCurrentItem() + this.j);
                stringBuffer.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
                stringBuffer.append(this.c.getCurrentItem() + this.l);
                stringBuffer.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
                stringBuffer.append(this.d.getCurrentItem() + this.n);
                stringBuffer.append(" ");
                stringBuffer.append(this.e.getCurrentItem());
                stringBuffer.append(SignatureImpl.INNER_SEP);
                stringBuffer.append(this.f.getCurrentItem());
                stringBuffer.append(SignatureImpl.INNER_SEP);
                stringBuffer.append(this.g.getCurrentItem());
            } else {
                stringBuffer.append(this.b.getCurrentItem() + this.j);
                stringBuffer.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
                stringBuffer.append(this.c.getCurrentItem() + this.l);
                stringBuffer.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
                stringBuffer.append(this.d.getCurrentItem() + 1);
                stringBuffer.append(" ");
                stringBuffer.append(this.e.getCurrentItem());
                stringBuffer.append(SignatureImpl.INNER_SEP);
                stringBuffer.append(this.f.getCurrentItem());
                stringBuffer.append(SignatureImpl.INNER_SEP);
                stringBuffer.append(this.g.getCurrentItem());
            }
        } else {
            stringBuffer.append(this.b.getCurrentItem() + this.j);
            stringBuffer.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
            stringBuffer.append(this.c.getCurrentItem() + 1);
            stringBuffer.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
            stringBuffer.append(this.d.getCurrentItem() + 1);
            stringBuffer.append(" ");
            stringBuffer.append(this.e.getCurrentItem());
            stringBuffer.append(SignatureImpl.INNER_SEP);
            stringBuffer.append(this.f.getCurrentItem());
            stringBuffer.append(SignatureImpl.INNER_SEP);
            stringBuffer.append(this.g.getCurrentItem());
        }
        return stringBuffer.toString();
    }

    public void l(Boolean bool) {
        this.d.g(bool);
        this.c.g(bool);
        this.b.g(bool);
        this.e.g(bool);
        this.f.g(bool);
        this.g.g(bool);
    }

    public final void m() {
        this.d.setTextSize(this.q);
        this.c.setTextSize(this.q);
        this.b.setTextSize(this.q);
        this.e.setTextSize(this.q);
        this.f.setTextSize(this.q);
        this.g.setTextSize(this.q);
    }

    public void n(boolean z) {
        this.b.setCyclic(z);
        this.c.setCyclic(z);
        this.d.setCyclic(z);
        this.e.setCyclic(z);
        this.f.setCyclic(z);
        this.g.setCyclic(z);
    }

    public final void o() {
        this.d.setDividerColor(this.t);
        this.c.setDividerColor(this.t);
        this.b.setDividerColor(this.t);
        this.e.setDividerColor(this.t);
        this.f.setDividerColor(this.t);
        this.g.setDividerColor(this.t);
    }

    public void p(int i) {
        this.t = i;
        o();
    }

    public final void q() {
        this.d.setDividerType(this.v);
        this.c.setDividerType(this.v);
        this.b.setDividerType(this.v);
        this.e.setDividerType(this.v);
        this.f.setDividerType(this.v);
        this.g.setDividerType(this.v);
    }

    public void r(WheelView.b bVar) {
        this.v = bVar;
        q();
    }

    public void s(int i) {
        this.k = i;
    }

    public void t(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str != null) {
            this.b.setLabel(str);
        } else {
            this.b.setLabel(this.a.getContext().getString(pe.pickerview_year));
        }
        if (str2 != null) {
            this.c.setLabel(str2);
        } else {
            this.c.setLabel(this.a.getContext().getString(pe.pickerview_month));
        }
        if (str3 != null) {
            this.d.setLabel(str3);
        } else {
            this.d.setLabel(this.a.getContext().getString(pe.pickerview_day));
        }
        if (str4 != null) {
            this.e.setLabel(str4);
        } else {
            this.e.setLabel(this.a.getContext().getString(pe.pickerview_hours));
        }
        if (str5 != null) {
            this.f.setLabel(str5);
        } else {
            this.f.setLabel(this.a.getContext().getString(pe.pickerview_minutes));
        }
        if (str6 != null) {
            this.g.setLabel(str6);
        } else {
            this.g.setLabel(this.a.getContext().getString(pe.pickerview_seconds));
        }
    }

    public final void u() {
        this.d.setLineSpacingMultiplier(this.u);
        this.c.setLineSpacingMultiplier(this.u);
        this.b.setLineSpacingMultiplier(this.u);
        this.e.setLineSpacingMultiplier(this.u);
        this.f.setLineSpacingMultiplier(this.u);
        this.g.setLineSpacingMultiplier(this.u);
    }

    public void v(float f) {
        this.u = f;
        u();
    }

    public void w(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        List listAsList = Arrays.asList("1", ExifInterface.GPS_MEASUREMENT_3D, "5", "7", "8", "10", "12");
        List listAsList2 = Arrays.asList("4", "6", "9", "11");
        this.p = i;
        WheelView wheelView = (WheelView) this.a.findViewById(ne.year);
        this.b = wheelView;
        wheelView.setAdapter(new ue(this.j, this.k));
        this.b.setCurrentItem(i - this.j);
        this.b.setGravity(this.h);
        WheelView wheelView2 = (WheelView) this.a.findViewById(ne.month);
        this.c = wheelView2;
        int i9 = this.j;
        int i10 = this.k;
        if (i9 == i10) {
            wheelView2.setAdapter(new ue(this.l, this.m));
            this.c.setCurrentItem((i2 + 1) - this.l);
        } else if (i == i9) {
            wheelView2.setAdapter(new ue(this.l, 12));
            this.c.setCurrentItem((i2 + 1) - this.l);
        } else if (i == i10) {
            wheelView2.setAdapter(new ue(1, this.m));
            this.c.setCurrentItem(i2);
        } else {
            wheelView2.setAdapter(new ue(1, 12));
            this.c.setCurrentItem(i2);
        }
        this.c.setGravity(this.h);
        this.d = (WheelView) this.a.findViewById(ne.day);
        int i11 = this.j;
        int i12 = this.k;
        if (i11 == i12 && this.l == this.m) {
            int i13 = i2 + 1;
            if (listAsList.contains(String.valueOf(i13))) {
                if (this.o > 31) {
                    this.o = 31;
                }
                this.d.setAdapter(new ue(this.n, this.o));
            } else if (listAsList2.contains(String.valueOf(i13))) {
                if (this.o > 30) {
                    this.o = 30;
                }
                this.d.setAdapter(new ue(this.n, this.o));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                if (this.o > 28) {
                    this.o = 28;
                }
                this.d.setAdapter(new ue(this.n, this.o));
            } else {
                if (this.o > 29) {
                    this.o = 29;
                }
                this.d.setAdapter(new ue(this.n, this.o));
            }
            this.d.setCurrentItem(i3 - this.n);
        } else if (i == i11 && (i8 = i2 + 1) == this.l) {
            if (listAsList.contains(String.valueOf(i8))) {
                this.d.setAdapter(new ue(this.n, 31));
            } else if (listAsList2.contains(String.valueOf(i8))) {
                this.d.setAdapter(new ue(this.n, 30));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                this.d.setAdapter(new ue(this.n, 28));
            } else {
                this.d.setAdapter(new ue(this.n, 29));
            }
            this.d.setCurrentItem(i3 - this.n);
        } else if (i == i12 && (i7 = i2 + 1) == this.m) {
            if (listAsList.contains(String.valueOf(i7))) {
                if (this.o > 31) {
                    this.o = 31;
                }
                this.d.setAdapter(new ue(1, this.o));
            } else if (listAsList2.contains(String.valueOf(i7))) {
                if (this.o > 30) {
                    this.o = 30;
                }
                this.d.setAdapter(new ue(1, this.o));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                if (this.o > 28) {
                    this.o = 28;
                }
                this.d.setAdapter(new ue(1, this.o));
            } else {
                if (this.o > 29) {
                    this.o = 29;
                }
                this.d.setAdapter(new ue(1, this.o));
            }
            this.d.setCurrentItem(i3 - 1);
        } else {
            int i14 = i2 + 1;
            if (listAsList.contains(String.valueOf(i14))) {
                this.d.setAdapter(new ue(1, 31));
            } else if (listAsList2.contains(String.valueOf(i14))) {
                this.d.setAdapter(new ue(1, 30));
            } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
                this.d.setAdapter(new ue(1, 28));
            } else {
                this.d.setAdapter(new ue(1, 29));
            }
            this.d.setCurrentItem(i3 - 1);
        }
        this.d.setGravity(this.h);
        WheelView wheelView3 = (WheelView) this.a.findViewById(ne.hour);
        this.e = wheelView3;
        wheelView3.setAdapter(new ue(0, 23));
        this.e.setCurrentItem(i4);
        this.e.setGravity(this.h);
        WheelView wheelView4 = (WheelView) this.a.findViewById(ne.min);
        this.f = wheelView4;
        wheelView4.setAdapter(new ue(0, 59));
        this.f.setCurrentItem(i5);
        this.f.setGravity(this.h);
        WheelView wheelView5 = (WheelView) this.a.findViewById(ne.second);
        this.g = wheelView5;
        wheelView5.setAdapter(new ue(0, 59));
        this.g.setCurrentItem(i6);
        this.g.setGravity(this.h);
        a aVar = new a(listAsList, listAsList2);
        b bVar = new b(listAsList, listAsList2);
        this.b.setOnItemSelectedListener(aVar);
        this.c.setOnItemSelectedListener(bVar);
        boolean[] zArr = this.i;
        if (zArr.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.b.setVisibility(zArr[0] ? 0 : 8);
        this.c.setVisibility(this.i[1] ? 0 : 8);
        this.d.setVisibility(this.i[2] ? 0 : 8);
        this.e.setVisibility(this.i[3] ? 0 : 8);
        this.f.setVisibility(this.i[4] ? 0 : 8);
        this.g.setVisibility(this.i[5] ? 0 : 8);
        m();
    }

    public void x(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.j;
            if (i > i4) {
                this.k = i;
                this.m = i2;
                this.o = i3;
                return;
            } else {
                if (i == i4) {
                    int i5 = this.l;
                    if (i2 > i5) {
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                        return;
                    } else {
                        if (i2 != i5 || i2 <= this.n) {
                            return;
                        }
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.j = calendar.get(1);
            this.k = calendar2.get(1);
            this.l = calendar.get(2) + 1;
            this.m = calendar2.get(2) + 1;
            this.n = calendar.get(5);
            this.o = calendar2.get(5);
            return;
        }
        int i6 = calendar.get(1);
        int i7 = calendar.get(2) + 1;
        int i8 = calendar.get(5);
        int i9 = this.k;
        if (i6 < i9) {
            this.l = i7;
            this.n = i8;
            this.j = i6;
        } else if (i6 == i9) {
            int i10 = this.m;
            if (i7 < i10) {
                this.l = i7;
                this.n = i8;
                this.j = i6;
            } else {
                if (i7 != i10 || i8 >= this.o) {
                    return;
                }
                this.l = i7;
                this.n = i8;
                this.j = i6;
            }
        }
    }

    public final void y(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.d.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.d.setAdapter(new ue(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.d.setAdapter(new ue(i3, i4));
        } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            if (i4 > 28) {
                i4 = 28;
            }
            this.d.setAdapter(new ue(i3, i4));
        } else {
            if (i4 > 29) {
                i4 = 29;
            }
            this.d.setAdapter(new ue(i3, i4));
        }
        if (currentItem > this.d.getAdapter().a() - 1) {
            this.d.setCurrentItem(this.d.getAdapter().a() - 1);
        }
    }

    public void z(int i) {
        this.j = i;
    }
}
