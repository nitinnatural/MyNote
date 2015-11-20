package com.example.note.data;


/**
 * Model class of note object
 * @author Nitin Anand {nitinnatural@gmail.com}
 *
 */

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Note implements Serializable {

	public String mId;
	public String mContent;
	public Date mCreateAt;
	public String mTitle;
	public int mColor;
	
	// constructor
	public Note() {
	}
	
	public Note(String value, String title, int color){
		this.mContent = value;
		this.mCreateAt = new Date();
		this.mId = UUID.randomUUID().toString();
		this.mTitle = title;
		this.mColor = color;
	}
	
	// getter methods

	public String getId(){
		return mId;
	}

	public String getContent(){
		return mContent;
	}

	public String getTitle(){
		return mTitle;
	}

	public Date getCreatedAt(){
		return mCreateAt;
	}

	public int getColor(){
		return mColor;
	}

	// setter methods
	public void setId(String id){
		this.mId = id;
	}

	public void setTitle(String title){
		this.mTitle = title;
	}

	public void setContent(String content){
		this.mContent = content;
	}
	public void setColor(int color){
		this.mColor = color;
	}
	public void setCreatedAt(Date date){
		this.mCreateAt = date;
	}
}
