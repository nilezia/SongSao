package app.shopspot.nilezia.songsao.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by NileZia on 17/3/2559.
 */
public class PhotoItemModel implements Parcelable{


    /**
     * _id : 56e8ce3967765933d8be90bd
     * _ns : ganhuo
     * createdAt : 2016-03-16T11:08:41.957Z
     * desc : 3.16
     * publishedAt : 2016-03-16T11:24:01.505Z
     * source : chrome
     * type : 福利
     * url : http://ww3.sinaimg.cn/large/610dc034gw1f1yj0vc3ntj20e60jc0ua.jpg
     * used : true
     * who : 代码家
     */

    @SerializedName("_id")
    private String id;
    @SerializedName("_ns")
    private String ns;
    @SerializedName("createdAt")
    private Date createdAt;
    @SerializedName("desc")
    private String desc;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("source")
    private String source;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("used")
    private boolean used;
    @SerializedName("who")
    private String who;

    protected PhotoItemModel(Parcel in) {
        id = in.readString();
        ns = in.readString();
        createdAt = (java.util.Date) in.readSerializable();
        desc = in.readString();
        publishedAt = in.readString();
        source = in.readString();
        type = in.readString();
        url = in.readString();
        used = in.readByte() != 0;
        who = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(ns);
        dest.writeSerializable(createdAt);
        dest.writeString(desc);
        dest.writeString(publishedAt);
        dest.writeString(source);
        dest.writeString(type);
        dest.writeString(url);
        dest.writeByte((byte) (used ? 1 : 0));
        dest.writeString(who);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoItemModel> CREATOR = new Creator<PhotoItemModel>() {
        @Override
        public PhotoItemModel createFromParcel(Parcel in) {
            return new PhotoItemModel(in);
        }

        @Override
        public PhotoItemModel[] newArray(int size) {
            return new PhotoItemModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
