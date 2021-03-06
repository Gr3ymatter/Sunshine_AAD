package com.example.android.sunshine.app.CustomViews;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.sunshine.app.R;

/**
 * Created by salaf on 17-Jan-16.
 */
public class LocationEditTextPreference extends EditTextPreference {

    int DEFAULT_MIN_LOCATION_VALUE = 2;
    int mMinLength;

    public LocationEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LocationEditTextPreference, 0, 0);

        try{
            mMinLength = a.getInteger(R.styleable.LocationEditTextPreference_minLength, DEFAULT_MIN_LOCATION_VALUE);
        } finally
        {
            a.recycle();
        }

    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);
        EditText editText =  getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Dialog d = getDialog();
                if(d instanceof AlertDialog)
                {
                    Button positiveButton = ((AlertDialog) d).getButton(AlertDialog.BUTTON_POSITIVE);

                    if(s.length() < mMinLength){

                        positiveButton.setEnabled(false);

                    }
                    else
                    {
                        positiveButton.setEnabled(true);
                    }
                }

            }
        });
    }
}
