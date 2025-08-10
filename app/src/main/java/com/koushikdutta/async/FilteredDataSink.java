package com.koushikdutta.async;

/* loaded from: classes3.dex */
public class FilteredDataSink extends BufferedDataSink {
    public FilteredDataSink(DataSink dataSink) {
        super(dataSink);
        setMaxBuffer(0);
    }

    public ByteBufferList filter(ByteBufferList byteBufferList) {
        return byteBufferList;
    }

    @Override // com.koushikdutta.async.BufferedDataSink
    public void onDataAccepted(ByteBufferList byteBufferList) {
        ByteBufferList byteBufferListFilter = filter(byteBufferList);
        if (byteBufferListFilter != byteBufferList) {
            byteBufferList.recycle();
            byteBufferListFilter.get(byteBufferList);
        }
    }
}
