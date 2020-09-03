/**
 * 
 */
package com.yfy.final_tag;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import com.yfy.beans.Record;
import com.yfy.jpush.Logger;

/**
 * @version 1.0
 * @Desprition
 */
public class MusicSearcher {

	private final static String TAG = MusicSearcher.class.getSimpleName();

	private Context context;
	private static MusicSearcher searcher = null;

	private MusicSearcher(Context context) {
		this.context = context;
	}

	public static MusicSearcher getInstance(Context context) {

		if (searcher == null) {
			synchronized (MusicSearcher.class) {
				if (searcher == null) {
					searcher = new MusicSearcher(context);
				}
			}
		}
		return searcher;
	}

	public List<Record> getRecord(String path) {

		List<Record> recordList = new ArrayList<Record>();
		Record record = null;
		Cursor cursor = context.getContentResolver().query(
				MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
				new String[] { MediaStore.Audio.Media._ID,
						MediaStore.Audio.Media.DISPLAY_NAME,
						MediaStore.Audio.Media.DURATION,
						MediaStore.Audio.Media.YEAR,
						MediaStore.Audio.Media.SIZE,
						MediaStore.Audio.Media.DATA },
				// MediaStore.Audio.Media.DATA + "=?",
				// new String[] { path }, null);

				null, null, null);
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(1).endsWith(".aac")) {
					record = new Record();
					record.setName(getName(cursor.getString(1)));
					record.setDuration(cursor.getInt(2));
					record.setDate(cursor.getString(3));
					record.setSize(cursor.getInt(4));
					record.setPath(cursor.getString(5));

					Logger.e(TAG, cursor.getString(5));
					recordList.add(record);
				}
			} while (cursor.moveToNext());
		}
		return recordList;
	}

	public void delete(String path) {
		String where = MediaStore.Audio.Media.DATA + " = ?";
		String[] whereparams = new String[]{path};
		
		context.getContentResolver()
				.delete(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, where,
						whereparams);
	}

	private String getName(String name) {
		int end = name.lastIndexOf(".");
		if (end != -1) {
			return name.substring(0, end);
		} else {
			return "";
		}
	}
}
