package com.amazonaws.services.s3.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.StringUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.koushikdutta.async.http.body.DocumentBody;
import java.io.File;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

/* loaded from: classes.dex */
public final class Mimetypes {
    public static final Log b = LogFactory.b(Mimetypes.class);
    public static Mimetypes c = null;
    public final HashMap<String, String> a;

    public Mimetypes() {
        HashMap<String, String> map = new HashMap<>();
        this.a = map;
        map.put("3gp", MimeTypes.VIDEO_H263);
        map.put("ai", "application/postscript");
        map.put("aif", "audio/x-aiff");
        map.put("aifc", "audio/x-aiff");
        map.put("aiff", "audio/x-aiff");
        map.put("asc", "text/plain");
        map.put("atom", "application/atom+xml");
        map.put("au", "audio/basic");
        map.put("avi", "video/x-msvideo");
        map.put("bcpio", "application/x-bcpio");
        map.put("bin", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("bmp", "image/bmp");
        map.put("cdf", "application/x-netcdf");
        map.put("cgm", "image/cgm");
        map.put("class", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("cpio", "application/x-cpio");
        map.put("cpt", "application/mac-compactpro");
        map.put("csh", "application/x-csh");
        map.put("css", "text/css");
        map.put("dcr", "application/x-director");
        map.put("dif", "video/x-dv");
        map.put("dir", "application/x-director");
        map.put("djv", "image/vnd.djvu");
        map.put("djvu", "image/vnd.djvu");
        map.put("dll", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("dmg", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("dms", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("doc", "application/msword");
        map.put("dtd", "application/xml-dtd");
        map.put("dv", "video/x-dv");
        map.put("dvi", "application/x-dvi");
        map.put("dxr", "application/x-director");
        map.put("eps", "application/postscript");
        map.put("etx", "text/x-setext");
        map.put("exe", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("ez", "application/andrew-inset");
        map.put("flv", MimeTypes.VIDEO_FLV);
        map.put("gif", "image/gif");
        map.put("gram", "application/srgs");
        map.put("grxml", "application/srgs+xml");
        map.put("gtar", "application/x-gtar");
        map.put("gz", "application/x-gzip");
        map.put("hdf", "application/x-hdf");
        map.put("hqx", "application/mac-binhex40");
        map.put("htm", "text/html");
        map.put(XHTMLExtension.ELEMENT, "text/html");
        map.put("ice", "x-conference/x-cooltalk");
        map.put("ico", "image/x-icon");
        map.put("ics", "text/calendar");
        map.put("ief", "image/ief");
        map.put("ifb", "text/calendar");
        map.put("iges", "model/iges");
        map.put("igs", "model/iges");
        map.put("jnlp", "application/x-java-jnlp-file");
        map.put("jp2", "image/jp2");
        map.put("jpe", MimeTypes.IMAGE_JPEG);
        map.put("jpeg", MimeTypes.IMAGE_JPEG);
        map.put("jpg", MimeTypes.IMAGE_JPEG);
        map.put("js", "application/x-javascript");
        map.put("kar", "audio/midi");
        map.put("latex", "application/x-latex");
        map.put("lha", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("lzh", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("m3u", "audio/x-mpegurl");
        map.put("m4a", MimeTypes.AUDIO_AAC);
        map.put("m4p", MimeTypes.AUDIO_AAC);
        map.put("m4u", "video/vnd.mpegurl");
        map.put("m4v", "video/x-m4v");
        map.put("mac", "image/x-macpaint");
        map.put("man", "application/x-troff-man");
        map.put("mathml", "application/mathml+xml");
        map.put("me", "application/x-troff-me");
        map.put("mesh", "model/mesh");
        map.put("mid", "audio/midi");
        map.put("midi", "audio/midi");
        map.put("mif", "application/vnd.mif");
        map.put("mov", "video/quicktime");
        map.put("movie", "video/x-sgi-movie");
        map.put("mp2", MimeTypes.AUDIO_MPEG);
        map.put("mp3", MimeTypes.AUDIO_MPEG);
        map.put("mp4", MimeTypes.VIDEO_MP4);
        map.put("mpe", MimeTypes.VIDEO_MPEG);
        map.put("mpeg", MimeTypes.VIDEO_MPEG);
        map.put("mpg", MimeTypes.VIDEO_MPEG);
        map.put("mpga", MimeTypes.AUDIO_MPEG);
        map.put("ms", "application/x-troff-ms");
        map.put("msh", "model/mesh");
        map.put("mxu", "video/vnd.mpegurl");
        map.put("nc", "application/x-netcdf");
        map.put("oda", "application/oda");
        map.put("ogg", "application/ogg");
        map.put("ogv", "video/ogv");
        map.put("pbm", "image/x-portable-bitmap");
        map.put("pct", "image/pict");
        map.put("pdb", "chemical/x-pdb");
        map.put("pdf", "application/pdf");
        map.put("pgm", "image/x-portable-graymap");
        map.put("pgn", "application/x-chess-pgn");
        map.put("pic", "image/pict");
        map.put("pict", "image/pict");
        map.put("png", "image/png");
        map.put("pnm", "image/x-portable-anymap");
        map.put("pnt", "image/x-macpaint");
        map.put("pntg", "image/x-macpaint");
        map.put("ppm", "image/x-portable-pixmap");
        map.put("ppt", "application/vnd.ms-powerpoint");
        map.put("ps", "application/postscript");
        map.put("qt", "video/quicktime");
        map.put("qti", "image/x-quicktime");
        map.put("qtif", "image/x-quicktime");
        map.put("ra", "audio/x-pn-realaudio");
        map.put("ram", "audio/x-pn-realaudio");
        map.put("ras", "image/x-cmu-raster");
        map.put("rdf", "application/rdf+xml");
        map.put("rgb", "image/x-rgb");
        map.put("rm", "application/vnd.rn-realmedia");
        map.put("roff", "application/x-troff");
        map.put("rtf", "text/rtf");
        map.put("rtx", "text/richtext");
        map.put("sgm", "text/sgml");
        map.put("sgml", "text/sgml");
        map.put("sh", "application/x-sh");
        map.put("shar", "application/x-shar");
        map.put("silo", "model/mesh");
        map.put("sit", "application/x-stuffit");
        map.put("skd", "application/x-koan");
        map.put("skm", "application/x-koan");
        map.put("skp", "application/x-koan");
        map.put("skt", "application/x-koan");
        map.put("smi", "application/smil");
        map.put("smil", "application/smil");
        map.put("snd", "audio/basic");
        map.put("so", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        map.put("spl", "application/x-futuresplash");
        map.put("src", "application/x-wais-source");
        map.put("sv4cpio", "application/x-sv4cpio");
        map.put("sv4crc", "application/x-sv4crc");
        map.put("svg", "image/svg+xml");
        map.put("swf", "application/x-shockwave-flash");
        map.put("t", "application/x-troff");
        map.put("tar", "application/x-tar");
        map.put("tcl", "application/x-tcl");
        map.put("tex", "application/x-tex");
        map.put("texi", "application/x-texinfo");
        map.put("texinfo", "application/x-texinfo");
        map.put("tif", "image/tiff");
        map.put("tiff", "image/tiff");
        map.put("tr", "application/x-troff");
        map.put("tsv", "text/tab-separated-values");
        map.put("txt", "text/plain");
        map.put("ustar", "application/x-ustar");
        map.put("vcd", "application/x-cdlink");
        map.put("vrml", "model/vrml");
        map.put("vxml", "application/voicexml+xml");
        map.put("wav", "audio/x-wav");
        map.put("wbmp", "image/vnd.wap.wbmp");
        map.put("wbxml", "application/vnd.wap.wbxml");
        map.put("webm", MimeTypes.VIDEO_WEBM);
        map.put("wml", "text/vnd.wap.wml");
        map.put("wmlc", "application/vnd.wap.wmlc");
        map.put("wmls", "text/vnd.wap.wmlscript");
        map.put("wmlsc", "application/vnd.wap.wmlscriptc");
        map.put("wmv", "video/x-ms-wmv");
        map.put("wrl", "model/vrml");
        map.put("xbm", "image/x-xbitmap");
        map.put("xht", "application/xhtml+xml");
        map.put("xhtml", "application/xhtml+xml");
        map.put("xls", "application/vnd.ms-excel");
        map.put("xml", DocumentBody.CONTENT_TYPE);
        map.put("xpm", "image/x-xpixmap");
        map.put("xsl", DocumentBody.CONTENT_TYPE);
        map.put("xslt", "application/xslt+xml");
        map.put("xul", "application/vnd.mozilla.xul+xml");
        map.put("xwd", "image/x-xwindowdump");
        map.put("xyz", "chemical/x-xyz");
        map.put("zip", DfuBaseService.MIME_TYPE_ZIP);
    }

    public static synchronized Mimetypes a() {
        Mimetypes mimetypes = c;
        if (mimetypes != null) {
            return mimetypes;
        }
        c = new Mimetypes();
        if (b.isDebugEnabled()) {
            HashMap<String, String> map = c.a;
            for (String str : map.keySet()) {
                b.a("Setting mime type for extension '" + str + "' to '" + map.get(str) + "'");
            }
        }
        return c;
    }

    public String b(File file) {
        return c(file.getName());
    }

    public String c(String str) {
        int i;
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf <= 0 || (i = iLastIndexOf + 1) >= str.length()) {
            Log log = b;
            if (log.isDebugEnabled()) {
                log.a("File name has no extension, mime type cannot be recognised for: " + str);
            }
        } else {
            String strB = StringUtils.b(str.substring(i));
            if (this.a.containsKey(strB)) {
                String str2 = this.a.get(strB);
                Log log2 = b;
                if (log2.isDebugEnabled()) {
                    log2.a("Recognised extension '" + strB + "', mimetype is: '" + str2 + "'");
                }
                return str2;
            }
            Log log3 = b;
            if (log3.isDebugEnabled()) {
                log3.a("Extension '" + strB + "' is unrecognized in mime type listing, using default mime type: '" + DfuBaseService.MIME_TYPE_OCTET_STREAM + "'");
            }
        }
        return DfuBaseService.MIME_TYPE_OCTET_STREAM;
    }
}
