package com.skeleton.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Raman Deep Kaur on 8/5/17.
 */

public class UserPosts implements Parcelable {


    public static final Creator<UserPosts> CREATOR = new Creator<UserPosts>() {
        @Override
        public UserPosts createFromParcel(final Parcel in) {
            return new UserPosts(in);
        }

        @Override
        public UserPosts[] newArray(final int size) {
            return new UserPosts[size];
        }
    };

    @SerializedName("userId")
    private int userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    /**
     * @param in parcel
     */
    protected UserPosts(final Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    /**
     * @return userid
     */


    public int getUserId() {
        return userId;
    }

    /**
     * @param userId iserid
     */
    public void setUserId(final int userId) {
        this.userId = userId;
    }

    /**
     * @return id
     */

    public int getPostId() {
        return id;
    }

    /**
     * @param id id
     */

    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return title
     */

    public String getTitle() {
        return title;
    }

    /**
     * @param title title
     */

    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return body
     */

    public String getBody() {
        return body;
    }

    /**
     * @param body body
     */

    public void setBody(final String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(userId);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(body);
    }
}
