package com.epicgames.unreal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class WebViewControl {
    private static final String TAG = "WebViewControl";
    private static int initialHeight = 500;
    private static int initialWidth = 500;
    private String NextContent;
    private String NextURL;
    public boolean PendingSetAndroid3DBrowser;
    public boolean PendingSetVisibility;
    private boolean SwizzlePixels;
    private boolean VulkanRenderer;
    private volatile boolean WaitOnBitmapRender;
    private boolean bClosed;
    private boolean bShown;
    public int curH;
    public int curW;
    public int curX;
    public int curY;
    private BitmapRenderer mBitmapRenderer = null;
    private OESTextureRenderer mOESTextureRenderer = null;
    private long nativePtr;
    private WebViewPositionLayout positionLayout;
    public GLWebView webView;

    public class ChromeClient extends WebChromeClient {
        private ChromeClient() {
        }

        public long GetNativePtr() {
            return WebViewControl.this.nativePtr;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            GameActivity.Log.warn(consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebView webView2 = new WebView(GameActivity._activity);
            webView.addView(webView2);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public native boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);

        @Override // android.webkit.WebChromeClient
        public native void onReceivedTitle(WebView webView, String str);
    }

    public class FrameUpdateInfo {
        public Buffer Buffer;
        public boolean FrameReady;
        public boolean RegionChanged;
        public float UOffset;
        public float UScale;
        public float VOffset;
        public float VScale;

        public FrameUpdateInfo() {
        }
    }

    public class OESTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mTextureID;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private boolean mFrameAvailable = false;
        private float[] mTransformMatrix = new float[16];
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private float mUScale = 1.0f;
        private float mVScale = -1.0f;
        private float mUOffset = 0.0f;
        private float mVOffset = 1.0f;

        public OESTextureRenderer(int i) {
            this.mSurfaceTexture = null;
            this.mSurface = null;
            this.mTextureID = -1;
            this.mTextureID = i;
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setDefaultBufferSize(WebViewControl.initialWidth, WebViewControl.initialHeight);
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
        }

        private FrameUpdateInfo getFrameUpdateInfo() {
            FrameUpdateInfo frameUpdateInfo = WebViewControl.this.new FrameUpdateInfo();
            frameUpdateInfo.Buffer = null;
            frameUpdateInfo.FrameReady = false;
            frameUpdateInfo.RegionChanged = false;
            frameUpdateInfo.UScale = this.mUScale;
            frameUpdateInfo.UOffset = this.mUOffset;
            frameUpdateInfo.VScale = -this.mVScale;
            frameUpdateInfo.VOffset = 1.0f - this.mVOffset;
            if (!this.mFrameAvailable) {
                return frameUpdateInfo;
            }
            this.mFrameAvailable = false;
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture == null) {
                return frameUpdateInfo;
            }
            frameUpdateInfo.FrameReady = true;
            surfaceTexture.updateTexImage();
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, 0);
            return frameUpdateInfo;
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            return this.mSurfaceTexture != null;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }

        public boolean resolutionChanged() {
            boolean z;
            synchronized (this) {
                z = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z;
        }

        public void setSize(int i, int i2) {
            synchronized (this) {
                if (i != this.mTextureWidth || i2 != this.mTextureHeight) {
                    this.mTextureWidth = i;
                    this.mTextureHeight = i2;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public FrameUpdateInfo updateVideoFrame() {
            FrameUpdateInfo frameUpdateInfo;
            synchronized (this) {
                frameUpdateInfo = getFrameUpdateInfo();
            }
            return frameUpdateInfo;
        }
    }

    public class ViewClient extends WebViewClient {
        private ViewClient() {
        }

        private native byte[] shouldInterceptRequestImpl(String str);

        public long GetNativePtr() {
            return WebViewControl.this.nativePtr;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            onPageLoad(str, false, webBackForwardListCopyBackForwardList.getSize(), webBackForwardListCopyBackForwardList.getCurrentIndex());
        }

        public native void onPageLoad(String str, boolean z, int i, int i2);

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            onPageLoad(str, true, webBackForwardListCopyBackForwardList.getSize(), webBackForwardListCopyBackForwardList.getCurrentIndex());
        }

        @Override // android.webkit.WebViewClient
        public native void onReceivedError(WebView webView, int i, String str, String str2);

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            byte[] bArrShouldInterceptRequestImpl = shouldInterceptRequestImpl(str);
            if (bArrShouldInterceptRequestImpl != null) {
                return new WebResourceResponse("text/html", "utf8", new ByteArrayInputStream(bArrShouldInterceptRequestImpl));
            }
            return null;
        }

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public WebViewControl(long j, int i, int i2, boolean z, boolean z2, final boolean z3, final boolean z4, final boolean z5) {
        this.SwizzlePixels = true;
        this.VulkanRenderer = false;
        this.WaitOnBitmapRender = false;
        initialWidth = i;
        initialHeight = i2;
        this.SwizzlePixels = z;
        this.VulkanRenderer = z2;
        this.WaitOnBitmapRender = false;
        this.nativePtr = j;
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.1
            @Override // java.lang.Runnable
            public void run() {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 19) {
                    WebView.setWebContentsDebuggingEnabled(z3 && !GameActivity._activity.nativeIsShippingBuild());
                }
                WebViewControl.this.webView = WebViewControl.this.new GLWebView(GameActivity._activity);
                WebViewControl.this.webView.setWebViewClient(new ViewClient());
                WebViewControl.this.webView.setWebChromeClient(new ChromeClient());
                WebViewControl.this.webView.getSettings().setJavaScriptEnabled(true);
                WebViewControl.this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                WebViewControl.this.webView.getSettings().setAllowFileAccess(true);
                WebViewControl.this.webView.getSettings().setAllowContentAccess(true);
                WebViewControl.this.webView.getSettings().setAllowFileAccessFromFileURLs(true);
                WebViewControl.this.webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
                WebViewControl.this.webView.getSettings().setSupportMultipleWindows(true);
                WebViewControl.this.webView.getSettings().setDomStorageEnabled(z5);
                if (i3 >= 21) {
                    WebViewControl.this.webView.getSettings().setMixedContentMode(0);
                }
                WebViewControl.this.webView.getSettings().setCacheMode(-1);
                WebViewControl.this.webView.getSettings().setLoadWithOverviewMode(true);
                WebViewControl.this.webView.getSettings().setUseWideViewPort(true);
                WebViewControl.this.webView.SetAndroid3DBrowser(true);
                if (z4) {
                    WebViewControl.this.webView.setBackgroundColor(0);
                }
                WebViewControl.this.positionLayout = new WebViewPositionLayout(GameActivity._activity, this);
                WebViewControl.this.positionLayout.addView(WebViewControl.this.webView, new ViewGroup.LayoutParams(-1, -1));
                WebViewControl.this.bShown = false;
                WebViewControl.this.NextURL = null;
                WebViewControl.this.NextContent = null;
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.curH = 0;
                webViewControl.curW = 0;
                webViewControl.curY = 0;
                webViewControl.curX = 0;
            }
        });
    }

    private boolean CreateBitmapRenderer() {
        releaseBitmapRenderer();
        BitmapRenderer bitmapRenderer = new BitmapRenderer(this.SwizzlePixels, this.VulkanRenderer);
        this.mBitmapRenderer = bitmapRenderer;
        if (!bitmapRenderer.isValid()) {
            this.mBitmapRenderer = null;
            return false;
        }
        this.mBitmapRenderer.setSize(initialWidth, initialHeight);
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.12
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.webView.setSurface(webViewControl.mBitmapRenderer.getSurface());
            }
        });
        return true;
    }

    private boolean CreateOESTextureRenderer(int i) {
        releaseOESTextureRenderer();
        OESTextureRenderer oESTextureRenderer = new OESTextureRenderer(i);
        this.mOESTextureRenderer = oESTextureRenderer;
        if (!oESTextureRenderer.isValid()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.setSize(initialWidth, initialHeight);
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.13
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.webView.setSurface(webViewControl.mOESTextureRenderer.getSurface());
            }
        });
        return true;
    }

    public boolean CanGoBackOrForward(int i) {
        return this.webView.canGoBackOrForward(i);
    }

    public void Close() {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.11
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewControl.this.bShown) {
                    ViewGroup viewGroup = (ViewGroup) WebViewControl.this.webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(WebViewControl.this.webView);
                    }
                    ViewGroup viewGroup2 = (ViewGroup) WebViewControl.this.positionLayout.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(WebViewControl.this.positionLayout);
                    }
                    WebViewControl.this.bShown = false;
                }
                WebViewControl.this.bClosed = true;
            }
        });
    }

    public void ExecuteJavascript(final String str) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.4
            @Override // java.lang.Runnable
            public void run() {
                GLWebView gLWebView = WebViewControl.this.webView;
                if (gLWebView != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        gLWebView.evaluateJavascript(str, null);
                        return;
                    }
                    gLWebView.loadUrl("javascript:" + str);
                }
            }
        });
    }

    public long GetNativePtr() {
        return this.nativePtr;
    }

    public void GoBackOrForward(final int i) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.9
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.goBackOrForward(i);
            }
        });
    }

    public void LoadString(final String str, final String str2) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.6
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.NextURL = str2;
                WebViewControl.this.NextContent = str;
            }
        });
    }

    public void LoadURL(final String str) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.5
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.NextURL = str;
                WebViewControl.this.NextContent = null;
            }
        });
    }

    public void Reload() {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.8
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.reload();
            }
        });
    }

    public void SetAndroid3DBrowser(boolean z) {
        this.PendingSetAndroid3DBrowser = z;
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.2
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.webView.SetAndroid3DBrowser(webViewControl.PendingSetAndroid3DBrowser);
            }
        });
    }

    public void SetVisibility(boolean z) {
        this.PendingSetVisibility = z;
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.3
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.webView.setVisibility(webViewControl.PendingSetVisibility ? 0 : 8);
            }
        });
    }

    public void StopLoad() {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.7
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.stopLoading();
            }
        });
    }

    public void Update(final int i, final int i2, final int i3, final int i4) {
        GameActivity._activity.runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.WebViewControl.10
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewControl.this.bClosed) {
                    return;
                }
                if (WebViewControl.this.bShown) {
                    WebViewControl webViewControl = WebViewControl.this;
                    if (webViewControl.webView != null) {
                        if (webViewControl.NextContent != null) {
                            WebViewControl webViewControl2 = WebViewControl.this;
                            webViewControl2.webView.loadDataWithBaseURL(webViewControl2.NextURL, WebViewControl.this.NextContent, "text/html", "UTF-8", null);
                            WebViewControl.this.NextURL = null;
                            WebViewControl.this.NextContent = null;
                        } else if (WebViewControl.this.NextURL != null) {
                            int iIndexOf = WebViewControl.this.NextURL.indexOf(58);
                            boolean zMatches = iIndexOf < 0;
                            if (!zMatches && !WebViewControl.this.NextURL.equalsIgnoreCase("about:blank")) {
                                try {
                                    String strSubstring = WebViewControl.this.NextURL.substring(iIndexOf + 1);
                                    zMatches = strSubstring.matches("[0-9]+");
                                    if (!zMatches) {
                                        String strSubstring2 = WebViewControl.this.NextURL.substring(0, iIndexOf);
                                        if ((WebViewControl.this.NextURL.equalsIgnoreCase("http") || WebViewControl.this.NextURL.equalsIgnoreCase("https")) && !strSubstring.startsWith("/")) {
                                            WebViewControl.this.NextURL = strSubstring2 + "://" + strSubstring;
                                        }
                                    }
                                } catch (IndexOutOfBoundsException unused) {
                                }
                            }
                            if (zMatches) {
                                WebViewControl.this.NextURL = "http://" + WebViewControl.this.NextURL;
                            }
                            WebViewControl webViewControl3 = WebViewControl.this;
                            webViewControl3.webView.loadUrl(webViewControl3.NextURL);
                            WebViewControl.this.NextURL = null;
                        } else {
                            GLWebView gLWebView = WebViewControl.this.webView;
                            if (!gLWebView.IsAndroid3DBrowser) {
                                gLWebView.requestFocus();
                            }
                        }
                    }
                } else {
                    WebViewControl.this.bShown = true;
                    GameActivity._activity.addContentView(WebViewControl.this.positionLayout, new ViewGroup.LayoutParams(-1, -1));
                    GLWebView gLWebView2 = WebViewControl.this.webView;
                    if (!gLWebView2.IsAndroid3DBrowser) {
                        gLWebView2.requestFocus();
                    }
                }
                WebViewControl webViewControl4 = WebViewControl.this;
                if (webViewControl4.webView != null) {
                    int i5 = i;
                    if (i5 == webViewControl4.curX && i2 == webViewControl4.curY && i3 == webViewControl4.curW && i4 == webViewControl4.curH) {
                        return;
                    }
                    webViewControl4.curX = i5;
                    webViewControl4.curY = i2;
                    webViewControl4.curW = i3;
                    webViewControl4.curH = i4;
                    webViewControl4.positionLayout.requestLayout();
                }
            }
        });
    }

    public boolean didResolutionChange() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.resolutionChanged();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.resolutionChanged();
        }
        return false;
    }

    public FrameUpdateInfo getVideoLastFrame(int i) {
        initBitmapRenderer();
        if (this.mBitmapRenderer == null) {
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo frameUpdateInfoUpdateFrameData = this.mBitmapRenderer.updateFrameData(i);
        this.WaitOnBitmapRender = false;
        return frameUpdateInfoUpdateFrameData;
    }

    public FrameUpdateInfo getVideoLastFrameData() {
        initBitmapRenderer();
        if (this.mBitmapRenderer == null) {
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo frameUpdateInfoUpdateFrameData = this.mBitmapRenderer.updateFrameData();
        this.WaitOnBitmapRender = false;
        return frameUpdateInfoUpdateFrameData;
    }

    public void initBitmapRenderer() {
        if (this.mBitmapRenderer != null || CreateBitmapRenderer()) {
            return;
        }
        GameActivity.Log.warn("initBitmapRenderer failed to alloc mBitmapRenderer ");
        release();
    }

    public native void nativeClearCachedAttributeState(int i, int i2);

    public void release() {
        if (this.mOESTextureRenderer != null) {
            while (this.WaitOnBitmapRender) {
            }
            releaseOESTextureRenderer();
        }
        if (this.mBitmapRenderer != null) {
            while (this.WaitOnBitmapRender) {
            }
            releaseOESTextureRenderer();
        }
        Close();
    }

    public void releaseBitmapRenderer() {
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            bitmapRenderer.release();
            this.mBitmapRenderer = null;
        }
    }

    public void releaseOESTextureRenderer() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            oESTextureRenderer.release();
            this.mOESTextureRenderer = null;
        }
    }

    public FrameUpdateInfo updateVideoFrame(int i) {
        if (this.mOESTextureRenderer == null && !CreateOESTextureRenderer(i)) {
            GameActivity.Log.warn("updateVideoFrame failed to alloc mOESTextureRenderer ");
            release();
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo frameUpdateInfoUpdateVideoFrame = this.mOESTextureRenderer.updateVideoFrame();
        this.WaitOnBitmapRender = false;
        return frameUpdateInfoUpdateVideoFrame;
    }

    public class GLWebView extends WebView {
        public boolean IsAndroid3DBrowser;
        private Surface mSurface;

        public GLWebView(Context context) {
            super(context);
            this.mSurface = null;
            this.IsAndroid3DBrowser = false;
            init();
        }

        public void SetAndroid3DBrowser(boolean z) {
            synchronized (this) {
                if (this.IsAndroid3DBrowser != z) {
                    this.IsAndroid3DBrowser = z;
                    WebViewControl.this.webView.setFocusableInTouchMode(!z);
                }
            }
        }

        public void init() {
            setOnTouchListener(new View.OnTouchListener() { // from class: com.epicgames.unreal.WebViewControl.GLWebView.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return GLWebView.this.IsAndroid3DBrowser;
                }
            });
        }

        @Override // android.webkit.WebView, android.view.View
        public void onDraw(Canvas canvas) throws Surface.OutOfResourcesException, IllegalArgumentException {
            if (!this.IsAndroid3DBrowser) {
                super.onDraw(canvas);
                return;
            }
            Surface surface = this.mSurface;
            if (surface != null) {
                try {
                    Canvas canvasLockCanvas = surface.lockCanvas(null);
                    float width = canvasLockCanvas.getWidth() / canvas.getWidth();
                    canvasLockCanvas.scale(width, width);
                    canvasLockCanvas.translate(-getScrollX(), -getScrollY());
                    super.onDraw(canvasLockCanvas);
                    this.mSurface.unlockCanvasAndPost(canvasLockCanvas);
                } catch (Exception e) {
                    String str = "error while rendering view to gl: " + e;
                }
            }
        }

        @Override // android.widget.AbsoluteLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
        }

        public void setSurface(Surface surface) {
            this.mSurface = surface;
        }

        public GLWebView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mSurface = null;
            this.IsAndroid3DBrowser = false;
            init();
        }

        public GLWebView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mSurface = null;
            this.IsAndroid3DBrowser = false;
            init();
        }
    }

    public class BitmapRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 16;
        private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 2;
        private int mBlitBuffer;
        private int mPositionAttrib;
        private int mProgram;
        private EGLContext mSavedContext;
        private EGLDisplay mSavedDisplay;
        private EGLSurface mSavedSurfaceDraw;
        private EGLSurface mSavedSurfaceRead;
        private boolean mSwizzlePixels;
        private int mTexCoordsAttrib;
        private int mTextureUniform;
        private FloatBuffer mTriangleVertices;
        private boolean mUseOwnContext;
        private boolean mVulkanRenderer;
        private Buffer mFrameData = null;
        private int mLastFramePosition = -1;
        private SurfaceTexture mSurfaceTexture = null;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private Surface mSurface = null;
        private boolean mFrameAvailable = false;
        private int mTextureID = -1;
        private int mFBO = -1;
        private int mBlitVertexShaderID = -1;
        private int mBlitFragmentShaderID = -1;
        private float[] mTransformMatrix = new float[16];
        private boolean mTriangleVerticesDirty = true;
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private boolean mCreatedEGLDisplay = false;
        private float[] mTriangleVerticesData = {-1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        private final String mBlitVextexShader = "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n";
        private final String mBlitFragmentShaderBGRA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
        private final String mBlitFragmentShaderRGBA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
        private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;

        public BitmapRenderer(boolean z, boolean z2) {
            this.mUseOwnContext = true;
            this.mVulkanRenderer = false;
            this.mSwizzlePixels = false;
            this.mSwizzlePixels = z;
            this.mVulkanRenderer = z2;
            this.mUseOwnContext = true;
            if (z2) {
                this.mSwizzlePixels = true;
            } else {
                String strGlGetString = GLES20.glGetString(7937);
                if (strGlGetString.contains("Adreno (TM) ") && (Integer.parseInt(strGlGetString.substring(12)) < 400 || Build.VERSION.SDK_INT < 22)) {
                    GameActivity.Log.debug("WebViewControl: disabled shared GL context on " + strGlGetString);
                    this.mUseOwnContext = false;
                }
            }
            if (!this.mUseOwnContext) {
                initSurfaceTexture();
                return;
            }
            initContext();
            saveContext();
            makeCurrent();
            initSurfaceTexture();
            restoreContext();
        }

        private void UpdateVertexData() {
            if (!this.mTriangleVerticesDirty || this.mBlitBuffer <= 0) {
                return;
            }
            this.mTriangleVertices.position(0);
            this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(34964, iArr, 0);
            int i = iArr[0];
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mTriangleVertices, 35044);
            GLES20.glBindBuffer(34962, i);
            this.mTriangleVerticesDirty = false;
        }

        private boolean copyFrameTexture(int i, Buffer buffer) {
            int i2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            int i3;
            boolean z6;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            char c;
            if (!this.mFrameAvailable) {
                return false;
            }
            this.mFrameAvailable = false;
            if (this.mSurfaceTexture == null) {
                return false;
            }
            int[] iArr = new int[1];
            int[] iArr2 = new int[4];
            if (this.mUseOwnContext) {
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(3553, 10241, iArr, 0);
                int i13 = iArr[0];
                GLES20.glGetTexParameteriv(3553, 10240, iArr, 0);
                int i14 = iArr[0];
                saveContext();
                makeCurrent();
                i2 = i14;
                i5 = 0;
                z6 = false;
                z5 = false;
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
                i3 = i13;
                i4 = 0;
            } else {
                GLES20.glGetError();
                boolean zGlIsEnabled = GLES20.glIsEnabled(3042);
                boolean zGlIsEnabled2 = GLES20.glIsEnabled(2884);
                boolean zGlIsEnabled3 = GLES20.glIsEnabled(3089);
                boolean zGlIsEnabled4 = GLES20.glIsEnabled(2960);
                boolean zGlIsEnabled5 = GLES20.glIsEnabled(2929);
                boolean zGlIsEnabled6 = GLES20.glIsEnabled(3024);
                GLES20.glGetIntegerv(36006, iArr, 0);
                int i15 = iArr[0];
                GLES20.glGetIntegerv(34964, iArr, 0);
                int i16 = iArr[0];
                GLES20.glGetIntegerv(2978, iArr2, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(3553, 10241, iArr, 0);
                int i17 = iArr[0];
                GLES20.glGetTexParameteriv(3553, 10240, iArr, 0);
                int i18 = iArr[0];
                glVerify("save state");
                i2 = i18;
                z = zGlIsEnabled6;
                z2 = zGlIsEnabled5;
                z3 = zGlIsEnabled4;
                z4 = zGlIsEnabled3;
                z5 = zGlIsEnabled2;
                i3 = i17;
                z6 = zGlIsEnabled;
                i4 = i16;
                i5 = i15;
            }
            this.mSurfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float[] fArr = this.mTransformMatrix;
            float f = fArr[12];
            float f2 = f + fArr[0];
            float f3 = fArr[13];
            float f4 = f3 + fArr[5];
            float[] fArr2 = this.mTriangleVerticesData;
            if (fArr2[2] != f || fArr2[6] != f2 || fArr2[11] != f3 || fArr2[3] != f4) {
                fArr2[10] = f;
                fArr2[2] = f;
                fArr2[14] = f2;
                fArr2[6] = f2;
                fArr2[15] = f3;
                fArr2[11] = f3;
                fArr2[7] = f4;
                fArr2[3] = f4;
                this.mTriangleVerticesDirty = true;
            }
            if (buffer != null) {
                buffer.position(0);
            }
            if (!this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
                glVerify("reset state");
            }
            GLES20.glViewport(0, 0, this.mTextureWidth, this.mTextureHeight);
            glVerify("set viewport");
            if (buffer != null) {
                GLES20.glGenTextures(1, iArr, 0);
                i6 = iArr[0];
            } else {
                i6 = i;
            }
            GLES20.glBindTexture(3553, i6);
            GLES20.glTexParameteri(3553, 10241, 9728);
            GLES20.glTexParameteri(3553, 10240, 9728);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            if (buffer != null) {
                GLES20.glTexImage2D(3553, 0, 6408, this.mTextureWidth, this.mTextureHeight, 0, 6408, 5121, null);
            }
            glVerify("set-up FBO texture");
            GLES20.glBindFramebuffer(36160, this.mFBO);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i6, 0);
            int iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (iGlCheckFramebufferStatus != 36053) {
                GameActivity.Log.warn("Failed to complete framebuffer attachment (" + iGlCheckFramebufferStatus + ")");
            }
            GLES20.glUseProgram(this.mProgram);
            UpdateVertexData();
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glEnableVertexAttribArray(this.mPositionAttrib);
            GLES20.glVertexAttribPointer(this.mPositionAttrib, 2, 5126, false, 16, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordsAttrib);
            GLES20.glVertexAttribPointer(this.mTexCoordsAttrib, 2, 5126, false, 16, 8);
            glVerify("setup movie texture read");
            GLES20.glClear(16384);
            GLES20.glUniform1i(this.mTextureUniform, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFlush();
            if (buffer != null) {
                i12 = 36064;
                i7 = i4;
                i8 = i2;
                i9 = i3;
                i11 = 36160;
                i10 = i6;
                GLES20.glReadPixels(0, 0, this.mTextureWidth, this.mTextureHeight, 6408, 5121, buffer);
            } else {
                i7 = i4;
                i8 = i2;
                i9 = i3;
                i10 = i6;
                i11 = 36160;
                i12 = 36064;
            }
            glVerify("draw & read movie texture");
            if (this.mUseOwnContext) {
                GLES20.glFramebufferTexture2D(i11, i12, 3553, 0, 0);
                if (buffer != null && i10 > 0) {
                    iArr[0] = i10;
                    GLES20.glDeleteTextures(1, iArr, 0);
                }
                restoreContext();
                GLES20.glTexParameteri(3553, 10241, i9);
                GLES20.glTexParameteri(3553, 10240, i8);
                return true;
            }
            int i19 = i9;
            GLES20.glBindFramebuffer(i11, i5);
            if (buffer == null || i10 <= 0) {
                c = 1;
            } else {
                iArr[0] = i10;
                c = 1;
                GLES20.glDeleteTextures(1, iArr, 0);
            }
            GLES20.glBindBuffer(34962, i7);
            GLES20.glViewport(iArr2[0], iArr2[c], iArr2[2], iArr2[3]);
            if (z6) {
                GLES20.glEnable(3042);
            }
            if (z5) {
                GLES20.glEnable(2884);
            }
            if (z4) {
                GLES20.glEnable(3089);
            }
            if (z3) {
                GLES20.glEnable(2960);
            }
            if (z2) {
                GLES20.glEnable(2929);
            }
            if (z) {
                GLES20.glEnable(3024);
            }
            GLES20.glTexParameteri(3553, 10241, i19);
            GLES20.glTexParameteri(3553, 10240, i8);
            GLES20.glDisableVertexAttribArray(this.mPositionAttrib);
            GLES20.glDisableVertexAttribArray(this.mTexCoordsAttrib);
            WebViewControl.this.nativeClearCachedAttributeState(this.mPositionAttrib, this.mTexCoordsAttrib);
            return true;
        }

        private int createShader(int i, String str) {
            int iGlCreateShader = GLES20.glCreateShader(i);
            if (iGlCreateShader == 0) {
                return iGlCreateShader;
            }
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return iGlCreateShader;
            }
            GameActivity.Log.error("Could not compile shader " + i + SignatureImpl.INNER_SEP);
            GameActivity.Log.error(GLES20.glGetShaderInfoLog(iGlCreateShader));
            GLES20.glDeleteShader(iGlCreateShader);
            return 0;
        }

        private void glVerify(String str) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            showGlError(str, iGlGetError);
            throw new RuntimeException(str + ": glGetError " + iGlGetError);
        }

        private void glWarn(String str) {
            while (true) {
                int iGlGetError = GLES20.glGetError();
                if (iGlGetError == 0) {
                    return;
                } else {
                    showGlError(str, iGlGetError);
                }
            }
        }

        private void initContext() {
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            EGLContext eGLContextEglGetCurrentContext = EGL14.EGL_NO_CONTEXT;
            if (this.mVulkanRenderer) {
                EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                this.mEglDisplay = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    GameActivity.Log.error("unable to get EGL14 display");
                    return;
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                    this.mEglDisplay = null;
                    GameActivity.Log.error("unable to initialize EGL14 display");
                    return;
                }
                this.mCreatedEGLDisplay = true;
            } else {
                this.mEglDisplay = EGL14.eglGetCurrentDisplay();
                eGLContextEglGetCurrentContext = EGL14.eglGetCurrentContext();
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
            this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfigArr[0], eGLContextEglGetCurrentContext, new int[]{12440, 2, 12344}, 0);
            if (EGL14.eglQueryString(this.mEglDisplay, 12373).contains("EGL_KHR_surfaceless_context")) {
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            } else {
                this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, eGLConfigArr[0], new int[]{12344}, 0);
            }
        }

        private void initSurfaceTexture() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i = iArr[0];
            this.mTextureID = i;
            if (i <= 0) {
                GameActivity.Log.error("mTextureID <= 0");
                release();
                return;
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setDefaultBufferSize(WebViewControl.initialWidth, WebViewControl.initialHeight);
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
            int[] iArr2 = new int[1];
            GLES20.glGenFramebuffers(1, iArr2, 0);
            int i2 = iArr2[0];
            this.mFBO = i2;
            if (i2 <= 0) {
                GameActivity.Log.error("mFBO <= 0");
                release();
                return;
            }
            int iCreateShader = createShader(35633, "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n");
            this.mBlitVertexShaderID = iCreateShader;
            if (iCreateShader == 0) {
                GameActivity.Log.error("mBlitVertexShaderID == 0");
                release();
                return;
            }
            int iCreateShader2 = createShader(35632, this.mSwizzlePixels ? "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n" : "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n");
            if (iCreateShader2 == 0) {
                GameActivity.Log.error("mBlitFragmentShaderID == 0");
                release();
                return;
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.mProgram = iGlCreateProgram;
            if (iGlCreateProgram <= 0) {
                GameActivity.Log.error("mProgram <= 0");
                release();
                return;
            }
            GLES20.glAttachShader(iGlCreateProgram, this.mBlitVertexShaderID);
            GLES20.glAttachShader(this.mProgram, iCreateShader2);
            GLES20.glLinkProgram(this.mProgram);
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(this.mProgram, 35714, iArr3, 0);
            if (iArr3[0] != 1) {
                GameActivity.Log.error("Could not link program: ");
                GameActivity.Log.error(GLES20.glGetProgramInfoLog(this.mProgram));
                GLES20.glDeleteProgram(this.mProgram);
                this.mProgram = 0;
                release();
                return;
            }
            this.mPositionAttrib = GLES20.glGetAttribLocation(this.mProgram, "Position");
            this.mTexCoordsAttrib = GLES20.glGetAttribLocation(this.mProgram, "TexCoords");
            this.mTextureUniform = GLES20.glGetUniformLocation(this.mProgram, "VideoTexture");
            GLES20.glGenBuffers(1, iArr2, 0);
            int i3 = iArr2[0];
            this.mBlitBuffer = i3;
            if (i3 <= 0) {
                GameActivity.Log.error("mBlitBuffer <= 0");
                release();
                return;
            }
            this.mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mTriangleVerticesDirty = true;
            if (this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
            }
        }

        private void makeCurrent() {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = this.mEglSurface;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext);
        }

        private void restoreContext() {
            EGL14.eglMakeCurrent(this.mSavedDisplay, this.mSavedSurfaceDraw, this.mSavedSurfaceRead, this.mSavedContext);
        }

        private void saveContext() {
            this.mSavedDisplay = EGL14.eglGetCurrentDisplay();
            this.mSavedContext = EGL14.eglGetCurrentContext();
            this.mSavedSurfaceDraw = EGL14.eglGetCurrentSurface(12377);
            this.mSavedSurfaceRead = EGL14.eglGetCurrentSurface(12378);
        }

        private void showGlError(String str, int i) {
            switch (i) {
                case 1280:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_INVALID_ENUM");
                    break;
                case 1281:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_INVALID_VALUE");
                    break;
                case 1282:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_INVALID_OPERATION");
                    break;
                case 1285:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_OUT_OF_MEMORY");
                    break;
                case 1286:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_INVALID_FRAMEBUFFER_OPERATION");
                    break;
                case 36054:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
                    break;
                case 36057:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
                    break;
                case 36061:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_UNSUPPORTED");
                    break;
                default:
                    GameActivity.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError " + i);
                    break;
            }
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            return this.mSurfaceTexture != null;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            int[] iArr = new int[1];
            int i = this.mBlitBuffer;
            if (i > 0) {
                iArr[0] = i;
                GLES20.glDeleteBuffers(1, iArr, 0);
                this.mBlitBuffer = -1;
            }
            int i2 = this.mProgram;
            if (i2 > 0) {
                GLES20.glDeleteProgram(i2);
                this.mProgram = -1;
            }
            int i3 = this.mBlitVertexShaderID;
            if (i3 > 0) {
                GLES20.glDeleteShader(i3);
                this.mBlitVertexShaderID = -1;
            }
            int i4 = this.mBlitFragmentShaderID;
            if (i4 > 0) {
                GLES20.glDeleteShader(i4);
                this.mBlitFragmentShaderID = -1;
            }
            int i5 = this.mFBO;
            if (i5 > 0) {
                iArr[0] = i5;
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.mFBO = -1;
            }
            int i6 = this.mTextureID;
            if (i6 > 0) {
                iArr[0] = i6;
                GLES20.glDeleteTextures(1, iArr, 0);
                this.mTextureID = -1;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface);
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.mEglDisplay, eGLContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            if (this.mCreatedEGLDisplay) {
                EGL14.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
                this.mCreatedEGLDisplay = false;
            }
        }

        public boolean resolutionChanged() {
            boolean z;
            synchronized (this) {
                z = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z;
        }

        public void setSize(int i, int i2) {
            synchronized (this) {
                if (i != this.mTextureWidth || i2 != this.mTextureHeight) {
                    this.mTextureWidth = i;
                    this.mTextureHeight = i2;
                    this.mFrameData = null;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public FrameUpdateInfo updateFrameData() {
            int i;
            int i2;
            synchronized (this) {
                if (this.mFrameData == null && (i = this.mTextureWidth) > 0 && (i2 = this.mTextureHeight) > 0) {
                    this.mFrameData = ByteBuffer.allocateDirect(i * i2 * 4);
                }
                if (!copyFrameTexture(0, this.mFrameData)) {
                    return null;
                }
                FrameUpdateInfo frameUpdateInfo = WebViewControl.this.new FrameUpdateInfo();
                frameUpdateInfo.Buffer = this.mFrameData;
                frameUpdateInfo.FrameReady = true;
                frameUpdateInfo.RegionChanged = false;
                return frameUpdateInfo;
            }
        }

        public FrameUpdateInfo updateFrameData(int i) {
            synchronized (this) {
                if (!copyFrameTexture(i, null)) {
                    return null;
                }
                FrameUpdateInfo frameUpdateInfo = WebViewControl.this.new FrameUpdateInfo();
                frameUpdateInfo.Buffer = null;
                frameUpdateInfo.FrameReady = true;
                frameUpdateInfo.RegionChanged = false;
                return frameUpdateInfo;
            }
        }
    }
}
