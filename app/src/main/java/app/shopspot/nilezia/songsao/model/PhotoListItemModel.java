package app.shopspot.nilezia.songsao.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by NileZia on 17/3/2559.
 */
public class PhotoListItemModel implements Parcelable{

    /**
     * error : false
     * results : [{"_id":"56e8ce3967765933d8be90bd","_ns":"ganhuo","createdAt":"2016-03-16T11:08:41.957Z","desc":"3.16","publishedAt":"2016-03-16T11:24:01.505Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1f1yj0vc3ntj20e60jc0ua.jpg","used":true,"who":"代码家"}]
     */

    @SuppressWarnings("error") private boolean error;
    @SerializedName("results") private List<PhotoItemModel> results;

    public PhotoListItemModel() {
    }

    protected PhotoListItemModel(Parcel in) {
        error = in.readByte() != 0;
        results = in.createTypedArrayList(PhotoItemModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (error ? 1 : 0));
        dest.writeTypedList(results);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoListItemModel> CREATOR = new Creator<PhotoListItemModel>() {
        @Override
        public PhotoListItemModel createFromParcel(Parcel in) {
            return new PhotoListItemModel(in);
        }

        @Override
        public PhotoListItemModel[] newArray(int size) {
            return new PhotoListItemModel[size];
        }
    };

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<PhotoItemModel> getResults() {
        return results;
    }

    public void setResults(List<PhotoItemModel> results) {
        this.results = results;
    }
}
