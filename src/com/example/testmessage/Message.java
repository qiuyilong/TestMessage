package com.example.testmessage;

import android.os.Parcel;
import android.os.Parcelable;

public class Message implements Parcelable {
	
	public final static String MSG_ID = "msgId";
	public final static String MSG_STATUS = "msg_status";
	public final static String MSG_TITLE = "msg_title";
	public final static String MSG_CONTENT = "msg_content";
	public final static String MSG_TIME = "msg_time";

	public final static String STATUS_READ = "read";
	public final static String STATUS_UNREAD = "unread";
	public final static String STATUS_INTERACTIVED = "interactived";
	public final static String STATUS_UNINTERACTIVED = "uninteractived";	
	
	public final static String SELECTED = "selected";
	public final static String UNSELECTED = "unselected";
	
	private String id;
	private String status;
	private String title;
	private String content;
	private String time;
	// for select
	private String selection = null;
	
	public String getId() {
		return this.id;
	}	
	public String getStatus() {
		return this.status;
	}	
	public String getTitle() {
		return this.title;
	}	
	public String getContent() {
		return this.content;
	}	
	public String getTime() {
		return this.time;
	}
	public String getSelection() {
		return this.selection;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}	
	public void setStatus(String status) {
		this.status = status;
	}	
	public void setTitle(String title) {
		this.title = title;
	}	
	public void setContent(String content) {
		this.content = content;
	}	
	public void setTime(String time) {
		this.time = time;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(this.id);
		dest.writeString(this.status);
		dest.writeString(this.title);
		dest.writeString(this.content);
		dest.writeString(this.time);
		dest.writeString(this.selection);
	}
	public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
        	Message message = new Message();
    		message.id = source.readString();
    		message.status = source.readString();
    		message.title = source.readString();
    		message.content = source.readString();
    		message.time = source.readString();
    		message.selection = source.readString();
            return message;
        }
        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
}
