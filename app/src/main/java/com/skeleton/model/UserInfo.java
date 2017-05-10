package com.skeleton.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abc on 09-May-17.
 */
public class UserInfo implements Parcelable {

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(final Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(final int size) {
            return new UserInfo[size];
        }
    };

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
    @SerializedName("address")
    private Address address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("website")
    private String website;
    @SerializedName("company")
    private Company company;

    /**
     * @param in input parcel
     */
    protected UserInfo(final Parcel in) {
        id = in.readInt();
        name = in.readString();
        username = in.readString();
        email = in.readString();
        phone = in.readString();
        website = in.readString();
    }


    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * @param name name
     */

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return username
     */

    public String getUsername() {
        return username;
    }

    /**
     * @param username username
     */

    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return address
     */

    public Address getAddress() {
        return address;
    }

    /**
     * @param address address
     */

    public void setAddress(final Address address) {
        this.address = address;
    }

    /**
     * @return phone
     */

    public String getPhone() {
        return phone;
    }

    /**
     * @param phone phone
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * @return website
     */

    public String getWebsite() {
        return website;
    }

    /**
     * @param website website
     */
    public void setWebsite(final String website) {
        this.website = website;
    }

    /**
     * @return return
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company company
     */

    public void setCompany(final Company company) {
        this.company = company;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(website);
    }

    /**
     * geo
     */

    public static class Geo {
        @SerializedName("lat")
        private String lat;
        @SerializedName("lng")
        private String lng;

        /**
         * @return lat
         */
        public String getLat() {
            return lat;
        }

        /**
         * @param lat lat
         */
        public void setLat(final String lat) {
            this.lat = lat;
        }


        /**
         * @return lng
         */
        public String getLng() {
            return lng;
        }

        /**
         * @param lng lng
         */
        public void setLng(final String lng) {
            this.lng = lng;
        }
    }

    /**
     * class
     */
    public static class Address {
        @SerializedName("street")
        private String street;
        @SerializedName("suite")
        private String suite;
        @SerializedName("city")
        private String city;
        @SerializedName("zipcode")
        private String zipcode;
        @SerializedName("geo")
        private Geo geo;

        /**
         * @return street
         */
        public String getStreet() {
            return street;
        }

        /**
         * @param street street
         */

        public void setStreet(final String street) {
            this.street = street;
        }

        /**
         * @return suite
         */

        public String getSuite() {
            return suite;
        }

        /**
         * @param suite suite
         */

        public void setSuite(final String suite) {
            this.suite = suite;
        }

        /**
         * @return city
         */

        public String getCity() {
            return city;
        }

        /**
         * @param city city
         */

        public void setCity(final String city) {
            this.city = city;
        }

        /**
         * @return zipcode
         */

        public String getZipcode() {
            return zipcode;
        }

        /**
         * @param zipcode zipcode
         */
        public void setZipcode(final String zipcode) {
            this.zipcode = zipcode;
        }

        /**
         * @return geo
         */

        public Geo getGeo() {
            return geo;
        }

        /**
         * @param geo geo
         */

        public void setGeo(final Geo geo) {
            this.geo = geo;
        }
    }

    /**
     * class
     */
    public static class Company {
        @SerializedName("name")
        private String name;
        @SerializedName("catchPhrase")
        private String catchPhrase;
        @SerializedName("bs")
        private String bs;

        /**
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name name
         */
        public void setName(final String name) {
            this.name = name;
        }

        /**
         * @return catch
         */

        public String getCatchPhrase() {
            return catchPhrase;
        }

        /**
         * @param catchPhrase catch
         */

        public void setCatchPhrase(final String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        /**
         * @return bs
         */
        public String getBs() {
            return bs;
        }

        /**
         * @param bs bs
         */

        public void setBs(final String bs) {
            this.bs = bs;
        }
    }
}