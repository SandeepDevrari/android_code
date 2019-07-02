package devrari.sandeep.googletraining;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static android.content.ContentValues.TAG;
import static java.lang.Integer.parseInt;

/**
 * Created by user on 18/4/18.
 */

public class ContentProvider_HW_Provider extends ContentProvider {
    private String[] dataMock;
    private static UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);

    @Override
    public boolean onCreate() {
        dataMock=getContext().getResources().getStringArray(R.array.words);
        setUriMatcher();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int id = -1;
        switch (uriMatcher.match(uri)) {
            case 0:
                // Matches URI to get all of the entries.
                id = ContentProvider_HW_Contract.ALL_ITEMS;
                // Look at the remaining arguments
                // to see whether there are constraints.
                // In this example, we only support getting
                //a specific entry by id. Not full search.
                // For a real-life app, you need error-catching code;
                // here we assume that the
                // value we need is actually in selectionArgs and valid.
                if (selection != null){
                    id = parseInt(selectionArgs[0]);
                }
                break;

            case 1:
                // The URI ends in a numeric value, which represents an id.
                // Parse the URI to extract the value of the last,
                // numeric part of the path,
                // and set the id to that value.
                id = parseInt(uri.getLastPathSegment());
                // With a database, you would then use this value and
                // the path to build a query.
                break;

            case UriMatcher.NO_MATCH:
                // You should do some error handling here.
                Log.d(TAG, "NO MATCH FOR THIS URI IN SCHEME.");
                id = -1;
                break;
            default:
                // You should do some error handling here.
                Log.d(TAG, "INVALID URI - URI NOT RECOGNIZED.");
                id = -1;
        }
        Log.d(TAG, "query: " + id);
        return populateCursor(id);
    }

    private Cursor populateCursor(int id) {
        MatrixCursor cursor = new MatrixCursor(new String[] { ContentProvider_HW_Contract.CONTENT_PATH });
        // If there is a valid query, execute it and add the result to the cursor.
        if (id == ContentProvider_HW_Contract.ALL_ITEMS) {
            for (int i = 0; i < dataMock.length; i++) {
                String word = dataMock[i];
                cursor.addRow(new Object[]{word});
            }
        } else if (id >= 0) {
            // Execute the query to get the requested word.
            String word =dataMock[id];
            // Add the result to the cursor.
            cursor.addRow(new Object[]{word});
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case 0:
                return ContentProvider_HW_Contract.MULTIPLE_RECORD_MIME_TYPE;

            case 1:
                return ContentProvider_HW_Contract.SINGLE_RECORD_MIME_TYPE;

            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    private void setUriMatcher(){
        uriMatcher.addURI(ContentProvider_HW_Contract.AUTHORITY,ContentProvider_HW_Contract.CONTENT_PATH+"/#",1);
        uriMatcher.addURI(ContentProvider_HW_Contract.AUTHORITY,ContentProvider_HW_Contract.CONTENT_PATH,0);
    }
}
