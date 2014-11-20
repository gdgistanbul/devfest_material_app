package com.gdgistanbul.devfestistanbul.event;

/**
 * Created by myener on 9/22/14.
 */
public class FocusEvent {
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    int index;

    public FocusEvent(int index) {
        this.index = index;
    }
}
