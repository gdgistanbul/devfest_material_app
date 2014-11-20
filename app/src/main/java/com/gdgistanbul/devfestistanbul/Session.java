package com.gdgistanbul.devfestistanbul;

import android.graphics.Bitmap;

/**
 * Created by myener on 11/17/14.
 */
public class Session {
    private int id;
    private String speaker;
    private String name;
    private String summary;
    private Bitmap bitmap;

    public Session(int id, String speaker, String name, String summary, Bitmap bitmap) {
        this.id = id;
        this.speaker = speaker;
        this.name = name;
        this.summary = summary;
        this.bitmap = bitmap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
