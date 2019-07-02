package devrari.sandeep.googletraining;

import android.net.Uri;

/**
 * Created by user on 18/4/18.
 */

public final class ContentProvider_HW_Contract {
    public static final String AUTHORITY="devrari.sandeep.googletraining.provider";
    public static final String CONTENT_PATH="words";
    public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/"+CONTENT_PATH);
    static final int ALL_ITEMS=-2;
    static final String WORD_ID="id";

    static final String SINGLE_RECORD_MIME_TYPE="vnd.android.cursor.item/vnd.training.content.words";
    static final String MULTIPLE_RECORD_MIME_TYPE="vnd.android.cursor.dir/vnd.training.content.words";

    private ContentProvider_HW_Contract(){}
}
