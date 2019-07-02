package com.example.angry.trainer;

/**
 * Created by Angry on 6/14/2018.
 */

public class PojoClassForCustomListView {
    private String textView;
    private String button;

    public PojoClassForCustomListView(String textView, String button) {
        this.textView = textView;
        this.button = button;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
