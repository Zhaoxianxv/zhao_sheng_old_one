/**
 *
 */
package com.yfy.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.zhao_sheng.R;
import com.gy.aac.impl.MyPlayerCallback;
import com.gy.aac.impl.Player;
import com.gy.aac.impl.TimeUtils;
import com.yfy.beans.Record;
import com.yfy.dialog.AbstractDialog.OnCustomDialogListener;
import com.yfy.final_tag.StringUtils;

/**
 * @author yfy1
 * @Date 2015年12月25日
 * @version 1.0
 * @Desprition
 */
public class ReordPlayDialog {
	private MyDialog myDialog;
	private Context context;
	private Record record;

	private TextView record_name, record_date, record_size, current_time,
			total_time;
	private ImageView start_pause_iv;
	private SeekBar seekBar;

	private Player player;

	private final static int PREPARE = 1;
	private final static int PlAY = 2;
	private final static int PAUSE = 3;

	private int state = PREPARE;

	private Drawable playDrawable, pauseDrawable;

	public ReordPlayDialog(Context context) {
		this.context = context;
		initDialog();
		initDrawable();
	}

	@SuppressWarnings("deprecation")
	private void initDrawable() {
		Resources resources = context.getResources();
		playDrawable = resources.getDrawable(R.drawable.play2);
		pauseDrawable = resources.getDrawable(R.drawable.pause2);
	}

	private void initDialog() {
		myDialog = new MyDialog(context, R.layout.layout_record_play_dialog,
				new int[] { R.id.record_name, R.id.record_date,
						R.id.record_size, R.id.start_pause_iv,
						R.id.current_time, R.id.seekBar, R.id.total_time,
						R.id.back, R.id.select, R.id.start_pause_frala },
				new int[] { R.id.start_pause_frala, R.id.back, R.id.select });

		myDialog.setOnCustomDialogListener(onCustomDialogListener);
		myDialog.setOnShowListener(onShowListener);
		myDialog.setOnDismissListener(onDismissListener);
	}

	private OnDismissListener onDismissListener = new OnDismissListener() {
		@Override
		public void onDismiss(DialogInterface dialog) {
			stop();
		}
	};

	private OnShowListener onShowListener = new OnShowListener() {

		@Override
		public void onShow(DialogInterface dialog) {
			record_name.setText(record.getName());
			record_date.setText("创建时间：" + record.getDate());
			record_size.setText("文件大小：" + StringUtils.convertBytesToOther(record.getSize()));
			current_time.setText("00:00");
			total_time.setText(TimeUtils.convertMilliSecondToMinute2(record
					.getDuration()));
		}
	};

	private OnCustomDialogListener onCustomDialogListener = new OnCustomDialogListener() {

		@Override
		public void onClick(View v, AbstractDialog myDialog) {

			if (listener != null) {
				listener.onClick(v, myDialog, record);
			}
			switch (v.getId()) {
				case R.id.start_pause_frala:
					handlePlay();
					break;
				case R.id.back:
					myDialog.dismiss();
					break;
			}
		}

		private void handlePlay() {
			switch (state) {
				case PREPARE:
					player.playUrl(record.getPath());
					start_pause_iv.setImageDrawable(pauseDrawable);
					state = PlAY;
					break;
				case PlAY:
					player.pause();
					start_pause_iv.setImageDrawable(playDrawable);
					state = PAUSE;
					break;
				case PAUSE:
					player.play();
					start_pause_iv.setImageDrawable(pauseDrawable);
					state = PlAY;
					break;
			}
		}

		@Override
		public void init(AbstractDialog myDialog) {
			super.init(myDialog);
			record_name = myDialog.getView(TextView.class, R.id.record_name);
			record_date = myDialog.getView(TextView.class, R.id.record_date);
			record_size = myDialog.getView(TextView.class, R.id.record_size);
			current_time = myDialog.getView(TextView.class, R.id.current_time);
			total_time = myDialog.getView(TextView.class, R.id.total_time);
			start_pause_iv = myDialog.getView(ImageView.class,
					R.id.start_pause_iv);
			seekBar = myDialog.getView(SeekBar.class, R.id.seekBar);
			seekBar.setOnSeekBarChangeListener(new SeekBarChangeEvent());

			player = new Player(seekBar, current_time);
			player.setMyPlayerCallback(new MyPlayerCallback() {

				@Override
				public void onPrepared() {
					seekBar.setEnabled(true);
				}

				@Override
				public void onCompletion() {
					state = PREPARE;
					seekBar.setEnabled(false);
					seekBar.setProgress(0);
					current_time.setText("00:00");
					start_pause_iv.setImageDrawable(playDrawable);
				}
			});
		}
	};

	class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
		int progress;

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
									  boolean fromUser) {
			if (null != player && player.mediaPlayer != null) {
				this.progress = progress * player.mediaPlayer.getDuration()
						/ seekBar.getMax();
				current_time.setText(TimeUtils
						.convertMilliSecondToMinute2(player.currentPosition));
			}
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			if (player.mediaPlayer != null) {
				player.mediaPlayer.seekTo(progress);
			}
		}
	}

	private OnInnerClickListener listener = null;

	public void setOnInnerClickListener(
			OnInnerClickListener onInnerClickListener) {
		this.listener = onInnerClickListener;
	}

	public static interface OnInnerClickListener {
		public void onClick(View v, AbstractDialog myDialog, Record record);
	}

	public void stop() {
		state = PREPARE;
		seekBar.setEnabled(false);
		seekBar.setProgress(0);
		current_time.setText("00:00");
		start_pause_iv.setImageDrawable(playDrawable);
		player.stop();
	}

	public void showAtBottom(Record record) {
		this.record = record;
		myDialog.showAtBottom();
	}

	public void showAtCenter(Record record) {
		this.record = record;
		myDialog.showAtCenter();
	}

	public void setWindowAnim(int resId) {
		myDialog.getWindow().setWindowAnimations(resId);
	}

	public void dismiss() {
		myDialog.dismiss();
	}

	public void destory() {
		if (player != null) {
			player.stop();
		}
		recycleDrawable(playDrawable, pauseDrawable);
	}

	private void recycleDrawable(Drawable... drawables) {
		for (Drawable drawable : drawables) {
			if (drawable != null) {
				drawable.setCallback(null);
				drawable = null;
			}
		}
	}

}
