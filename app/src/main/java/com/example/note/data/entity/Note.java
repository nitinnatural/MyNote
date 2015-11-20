package com.example.note.data.entity;

import com.example.note.Config;
import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;

/**
 * @author  Nitin Anand(nitinnatural@gmail.com)
 */
@ParseClassName(Config.CLASS_NOTE)
public class Note extends ParseObject implements Serializable {

    public String title;
    public String content;
    public String color;

    // important column only initialize while retriving(fromParse)
    public String objectId;
    public Date createdAt;
    public Date updatedAt;

    public void setColor() {
        put(Keys.color, color);
    }

    void setTitle(){
        put(Keys.title, title);
    }

    void setContent(){
        put(Keys.content, content);
    }


    public void toParse(){
        if (title!=null)
            setTitle();

        if (color!=null)
            setColor();

        if (content!=null)
            setContent();

    }


    public void fromParse(){
        this.title = getString(Keys.title);
        this.content = getString(Keys.content);
        this.color = getString(Keys.color);

        this.objectId = getObjectId();
        this.createdAt = getCreatedAt();
        this.updatedAt = getUpdatedAt();

    }


    class Keys {
        public static final String title = "title";
        public static final String content = "content";
        public static final String color = "color";
        public static final String createdAt = "createdAt";
        public static final String updatedAt = "updatedAt";
        public static final String objectId = "objectId";

    }

}
