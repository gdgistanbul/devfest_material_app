package com.gdgistanbul.devfestistanbul.event;

/**
 * Created by myener on 9/22/14.
 */
public class ItemEvent {
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private String str;
    
    public ItemEvent(String item){
        str=item;
    }
    
}
