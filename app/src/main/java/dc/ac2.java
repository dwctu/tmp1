package dc;

import android.text.TextUtils;
import com.wear.bean.socketio.msg.response.SocketIoBean;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: PacketSocketIo.java */
/* loaded from: classes3.dex */
public class ac2 {
    public final ArrayBlockingQueue<String> a = new ArrayBlockingQueue<>(5000);
    public String b;
    public Collection<ac2> c;
    public volatile long d;

    public ac2(Collection<ac2> collection, String str) {
        this.b = str;
        this.c = collection;
    }

    public String a(long j) throws InterruptedException {
        this.d = System.currentTimeMillis();
        long jCurrentTimeMillis = j;
        String strPoll = null;
        do {
            try {
                strPoll = this.a.poll(jCurrentTimeMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (strPoll != null) {
                return strPoll;
            }
            jCurrentTimeMillis = j - (System.currentTimeMillis() - this.d);
        } while (jCurrentTimeMillis > 0);
        return null;
    }

    public String b(long j) throws Exception {
        String strA = a(j);
        this.c.remove(this);
        if (TextUtils.isEmpty(strA)) {
            throw new TimeoutException("timeOut");
        }
        return strA;
    }

    public boolean c(SocketIoBean socketIoBean, String str) {
        if (socketIoBean != null && !this.b.equals(socketIoBean.getAckId())) {
            return false;
        }
        while (!this.a.offer(str)) {
            this.a.poll();
        }
        return true;
    }
}
