package com.byagowi.persiancalendar.view.dialog;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;

import com.byagowi.persiancalendar.Utils;

/**
 * persian_calendar
 * Author: hamidsafdari22@gmail.com
 * Date: 1/17/16
 */
public class LocationPreference extends DialogPreference {
    public String value;
    public String newValue;
    private Utils utils;

    public LocationPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        utils = Utils.getInstance(context);
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        super.onSetInitialValue(restorePersistedValue, defaultValue);
        value = restorePersistedValue ? getPersistedString("") : String.valueOf(defaultValue);
    }

    public void close(boolean positiveResult) {
        if (positiveResult) {
            if (callChangeListener(newValue)) {
                value = newValue;
                persistString(value);
            } else {
                newValue = getPersistedString("");
            }
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        utils.prepareShapePreference(holder);
    }
}
