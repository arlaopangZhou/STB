package hisi.stb.sevic;

import android.content.Context;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class AskDialogPreference extends DialogPreference {
	private TextView hint;
	private String hintText = "";
	
	public AskDialogPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setDialogLayoutResource(R.layout.ask_dialog_preference);
	}
	
	@Override
	protected View onCreateDialogView() {
		View view = super.onCreateDialogView();
		hint = (TextView)view.findViewById(R.id.ask_hint);
		hint.setText(hintText);
		return view;
	}

	@Override
	protected void onDialogClosed(boolean positiveResult) {
		callChangeListener(positiveResult);
	}

	public void setDescription(String str) {
		hintText = str;
	}
}
