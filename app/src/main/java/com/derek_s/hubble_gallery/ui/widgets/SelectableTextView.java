package com.derek_s.hubble_gallery.ui.widgets;

import android.content.Context;
import android.text.Selection;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;

// Workaround for crash when trying to scroll while text is selected
// https://code.google.com/p/android/issues/detail?id=137509
public class SelectableTextView extends TextView {

    public SelectableTextView(Context context) {
        this(context, null, 0);
    }

    public SelectableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTextIsSelectable(true);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        if (selStart == -1 || selEnd == -1) {
            CharSequence text = getText();
            if (text instanceof Spannable) {
                Selection.setSelection((Spannable) text, 0, 0);
            }
        } else {
            super.onSelectionChanged(selStart, selEnd);
        }
    }

}
