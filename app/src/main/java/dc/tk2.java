package dc;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MediaMetadataCompatExt.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010e\u001a\u00020f*\u00020\u0005\u001a\n\u0010g\u001a\u00020h*\u00020\u0005\u001a\f\u0010i\u001a\u00020\u0015*\u0004\u0018\u00010\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\".\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\n\"\u0004\b\u000b\u0010\f\"\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\".\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u000e8Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\".\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0018\u0010\f\"\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007\"\u0016\u0010\u001b\u001a\u00020\u000e*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010\"\u0016\u0010\u001d\u001a\u00020\u0015*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017\"\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b \u0010\u0007\".\u0010\u001f\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\f\"\u0018\u0010\"\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b#\u0010\u0007\"\u0018\u0010$\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b%\u0010\u0007\"\u0018\u0010&\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b'\u0010\u0007\"\u0018\u0010(\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b)\u0010\u0007\"\u0016\u0010*\u001a\u00020+*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b,\u0010-\"\u0018\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b/\u0010\u0007\".\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\f\"\u0016\u00101\u001a\u00020\u000e*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b2\u0010\u0010\"\u0016\u00103\u001a\u00020\u0015*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b4\u0010\u0017\".\u00103\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\n\"\u0004\b5\u0010\f\"\u0018\u00106\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b7\u0010\u0007\".\u00106\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\n\"\u0004\b8\u0010\f\"\u0018\u00109\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b:\u0010\u0007\".\u00109\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\n\"\u0004\b;\u0010\f\"\u0016\u0010<\u001a\u00020+*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b=\u0010-\"*\u0010<\u001a\u00020+*\u00020\t2\u0006\u0010\b\u001a\u00020+8Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\"\u0016\u0010A\u001a\u00020+*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bB\u0010-\"*\u0010A\u001a\u00020+*\u00020\t2\u0006\u0010\b\u001a\u00020+8Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@\"\u0016\u0010D\u001a\u00020E*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bF\u0010G\"*\u0010D\u001a\u00020E*\u00020\t2\u0006\u0010\b\u001a\u00020E8Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010H\"\u0004\bI\u0010J\"\u0018\u0010K\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bL\u0010\u0007\".\u0010K\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010\n\"\u0004\bM\u0010\f\"\u0018\u0010N\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bO\u0010\u0007\"*\u0010N\u001a\u00020\u0001*\u00020\t2\u0006\u0010\b\u001a\u00020\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\n\"\u0004\bP\u0010\f\"\u0016\u0010Q\u001a\u00020\u0015*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bR\u0010\u0017\".\u0010Q\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010\n\"\u0004\bS\u0010\f\"\u0016\u0010T\u001a\u00020+*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bU\u0010-\"\u0018\u0010V\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bW\u0010\u0007\".\u0010V\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00018Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010\n\"\u0004\bX\u0010\f\"\u0016\u0010Y\u001a\u00020+*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bZ\u0010-\"*\u0010Y\u001a\u00020+*\u00020\t2\u0006\u0010\b\u001a\u00020+8Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010>\"\u0004\b[\u0010@\"\u0016\u0010\\\u001a\u00020+*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b]\u0010-\"*\u0010\\\u001a\u00020+*\u00020\t2\u0006\u0010\b\u001a\u00020+8Ç\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010>\"\u0004\b^\u0010@\"\u0016\u0010_\u001a\u00020+*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b`\u0010-\"\u0018\u0010a\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bb\u0010\u0007\"\u0018\u0010c\u001a\u0004\u0018\u00010\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\bd\u0010\u0007¨\u0006j"}, d2 = {"AUDIO_BOOK_LIST", "", "METADATA_KEY_UAMP_FLAGS", "NO_GET", "album", "Landroid/support/v4/media/MediaMetadataCompat;", "getAlbum", "(Landroid/support/v4/media/MediaMetadataCompat;)Ljava/lang/String;", "value", "Landroid/support/v4/media/MediaMetadataCompat$Builder;", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)Ljava/lang/String;", "setAlbum", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;Ljava/lang/String;)V", "albumArt", "Landroid/graphics/Bitmap;", "getAlbumArt", "(Landroid/support/v4/media/MediaMetadataCompat;)Landroid/graphics/Bitmap;", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)Landroid/graphics/Bitmap;", "setAlbumArt", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;Landroid/graphics/Bitmap;)V", "albumArtUri", "Landroid/net/Uri;", "getAlbumArtUri", "(Landroid/support/v4/media/MediaMetadataCompat;)Landroid/net/Uri;", "setAlbumArtUri", "albumArtist", "getAlbumArtist", "art", "getArt", "artUri", "getArtUri", "artist", "getArtist", "setArtist", "author", "getAuthor", "compilation", "getCompilation", "composer", "getComposer", "date", "getDate", "discNumber", "", "getDiscNumber", "(Landroid/support/v4/media/MediaMetadataCompat;)J", "displayDescription", "getDisplayDescription", "setDisplayDescription", "displayIcon", "getDisplayIcon", "displayIconUri", "getDisplayIconUri", "setDisplayIconUri", "displaySubtitle", "getDisplaySubtitle", "setDisplaySubtitle", "displayTitle", "getDisplayTitle", "setDisplayTitle", "downloadStatus", "getDownloadStatus", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)J", "setDownloadStatus", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;J)V", TypedValues.TransitionType.S_DURATION, "getDuration", "setDuration", "flag", "", "getFlag", "(Landroid/support/v4/media/MediaMetadataCompat;)I", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;)I", "setFlag", "(Landroid/support/v4/media/MediaMetadataCompat$Builder;I)V", "genre", "getGenre", "setGenre", TtmlNode.ATTR_ID, "getId", "setId", "mediaUri", "getMediaUri", "setMediaUri", "rating", "getRating", MessageBundle.TITLE_ENTRY, "getTitle", "setTitle", "trackCount", "getTrackCount", "setTrackCount", "trackNumber", "getTrackNumber", "setTrackNumber", "userRating", "getUserRating", "writer", "getWriter", "year", "getYear", "toMediaItem", "Lcom/google/android/exoplayer2/MediaItem;", "toMediaItemMetadata", "Lcom/google/android/exoplayer2/MediaMetadata;", "toUri", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class tk2 {
    @NotNull
    public static final MediaItem a(@NotNull MediaMetadataCompat mediaMetadataCompat) {
        Intrinsics.checkNotNullParameter(mediaMetadataCompat, "<this>");
        MediaItem.Builder builder = new MediaItem.Builder();
        String string = mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID);
        if (string == null) {
            string = "";
        }
        builder.setMediaId(string);
        builder.setUri(c(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI)));
        builder.setMimeType(MimeTypes.APPLICATION_M3U8);
        MediaItem mediaItemBuild = builder.setMediaMetadata(b(mediaMetadataCompat)).build();
        Intrinsics.checkNotNullExpressionValue(mediaItemBuild, "with(com.google.android.…Metadata())\n    }.build()");
        return mediaItemBuild;
    }

    @NotNull
    public static final MediaMetadata b(@NotNull MediaMetadataCompat mediaMetadataCompat) {
        Intrinsics.checkNotNullParameter(mediaMetadataCompat, "<this>");
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.setTitle(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
        builder.setDisplayTitle(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE));
        builder.setDescription(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION));
        builder.setAlbumArtist(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
        builder.setAlbumTitle(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
        builder.setComposer(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
        builder.setTrackNumber(Integer.valueOf((int) mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)));
        builder.setTotalTrackCount(Integer.valueOf((int) mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS)));
        builder.setDiscNumber(Integer.valueOf((int) mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER)));
        builder.setWriter(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
        builder.setArtworkUri(c(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI)));
        Bundle bundle = new Bundle();
        bundle.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID));
        bundle.putLong(MediaMetadataCompat.METADATA_KEY_DURATION, mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
        MediaMetadata mediaMetadataBuild = builder.setExtras(bundle).build();
        Intrinsics.checkNotNullExpressionValue(mediaMetadataBuild, "with(MediaMetadata.Build…ras(extras)\n    }.build()");
        return mediaMetadataBuild;
    }

    @NotNull
    public static final Uri c(@Nullable String str) {
        Uri uri = str != null ? Uri.parse(str) : null;
        if (uri != null) {
            return uri;
        }
        Uri toUri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(toUri, "toUri");
        return toUri;
    }
}
