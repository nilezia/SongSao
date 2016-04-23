package app.shopspot.nilezia.songsao.controller;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import app.shopspot.nilezia.songsao.fragment.MainFragment;
import app.shopspot.nilezia.songsao.model.PhotoItemModel;
import app.shopspot.nilezia.songsao.model.PhotoListItemModel;

/**
 * Created by NileZia on 17/3/2559.
 */
public class PhotoListItemController {


    private Context mContext;
    private PhotoListItemModel photoList;

    public PhotoListItemController() {

        this.mContext = Contextor.getInstance().getContext();

    }

    public PhotoListItemModel getPhotoList() {
        return photoList;
    }

    public int getCount() {

        if (photoList == null)
            return 0;

        if (photoList.getResults() == null)
            return 0;

        return photoList.getResults().size();

    }

public void AppendPhotoItemAtLastPosition(PhotoListItemModel newPhotolist){
    if(photoList == null)
        photoList = new PhotoListItemModel();
    if(photoList.getResults() == null)
        photoList.setResults(new ArrayList<PhotoItemModel>());

    photoList.getResults().addAll(photoList.getResults().size(),newPhotolist.getResults());
}

    public void setPhotoList(PhotoListItemModel photoList) {
        this.photoList = photoList;
    }

    public void onSaveInstanceState(Bundle outState) {

        Bundle bundle = new Bundle();
        bundle.putParcelable(MainFragment.PHOTO_LIST, photoList);
        outState.putBundle("bundle", bundle);
    }

    public void RestoreInstanceState(Bundle savedInstanceState) {

        Bundle bundle = savedInstanceState.getBundle("bundle");
        photoList = bundle.getParcelable(MainFragment.PHOTO_LIST);
        setPhotoList(photoList);

    }
}
