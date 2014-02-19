package hisi.stb.sevic;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarDialogPreference extends DialogPreference implements OnSeekBarChangeListener {
	private SeekBar sb;
	private TextView hint;

	public SeekBarDialogPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		setDialogLayoutResource(R.layout.seek_bar_dialog_preference);
	}
	
	@Override
	protected View onCreateDialogView() {
		View view = super.onCreateDialogView();
		
		sb = (SeekBar)view.findViewById(R.id.seekbar);
		hint = (TextView)view.findViewById(R.id.textview);
		sb.setOnSeekBarChangeListener(this);
		sb.setProgress(getPersistedInt(0));
		
		return view;
	}
	
	@Override
	protected void onDialogClosed(boolean positiveResult) {
		if (positiveResult) {
			int value = sb.getProgress();
			if (getPersistedInt(0) != value) {
				persistInt(value);
				callChangeListener(value);
			}
		}	
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		hint.setText(String.valueOf(progress));
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	
}
