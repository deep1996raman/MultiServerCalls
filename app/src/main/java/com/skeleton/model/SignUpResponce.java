package com.skeleton.model;
import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mcgreen on 9/5/17.
 */

public class SignUpResponce {

    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private ContactsContract.Data data;

    /**
     *
     *
     * @return server code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return data
     */
    public ContactsContract.Data getData() {
        return data;
    }
}

