package com.broadcom.bt.util.mime4j.field.address;

import com.broadcom.bt.util.mime4j.field.address.parser.AddressListParser;
import com.broadcom.bt.util.mime4j.field.address.parser.ParseException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AddressList {
    private ArrayList addresses;

    public AddressList(ArrayList arrayList, boolean z) {
        if (arrayList != null) {
            this.addresses = z ? arrayList : (ArrayList) arrayList.clone();
        } else {
            this.addresses = new ArrayList(0);
        }
    }

    public static void main(String[] strArr) throws Exception {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("> ");
                line = bufferedReader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(300L);
            }
            if (line.length() != 0 && !line.toLowerCase().equals("exit") && !line.toLowerCase().equals("quit")) {
                parse(line).print();
            }
            System.out.println("Goodbye.");
            return;
        }
    }

    public static AddressList parse(String str) throws ParseException {
        return Builder.getInstance().buildAddressList(new AddressListParser(new StringReader(str)).parse());
    }

    public MailboxList flatten() {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= size()) {
                z = false;
                break;
            }
            if (!(get(i) instanceof Mailbox)) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return new MailboxList(this.addresses, true);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size(); i2++) {
            get(i2).addMailboxesTo(arrayList);
        }
        return new MailboxList(arrayList, false);
    }

    public Address get(int i) {
        if (i < 0 || size() <= i) {
            throw new IndexOutOfBoundsException();
        }
        return (Address) this.addresses.get(i);
    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i).toString());
        }
    }

    public int size() {
        return this.addresses.size();
    }
}
