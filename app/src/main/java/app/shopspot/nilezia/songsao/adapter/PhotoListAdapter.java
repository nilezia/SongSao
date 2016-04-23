package app.shopspot.nilezia.songsao.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import app.shopspot.nilezia.songsao.R;
import app.shopspot.nilezia.songsao.model.PhotoListItemModel;

import app.shopspot.nilezia.songsao.view.SquareProgress;

/**
 * Created by NileZia on 17/3/2559.
 */
public class PhotoListAdapter extends BaseAdapter {

    PhotoListItemModel photoList;
    boolean isLoading = true;

    @Override
    public int getCount() {

        if (photoList == null)
            return 0;
        if (photoList.getResults() == null)
            return 0;

        return photoList.getResults().size();
    }

    @Override
    public Object getItem(int i) {
        return photoList.getResults().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {

        return position == getCount() - 1 ? 1 : 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (i == getCount() - 1) {

            SquareProgress progressBar;
            if (view != null) {
                progressBar = (SquareProgress) view;

            } else {
                progressBar = new SquareProgress(viewGroup.getContext());
            }

            if (isLoading) {
                return progressBar;
            } else {
                progressBar.setVisibility(View.GONE);
                return progressBar;
            }
        }
        ViewHolder viewHolder;
        LayoutInflater mInflater =
                (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {

            view = mInflater.inflate(R.layout.photitem, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.ivPhoto = (ImageView) view.findViewById(R.id.ivPhoto);
            viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);

            view.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvName.setText(photoList.getResults().get(i).getWho());

        Glide.with(viewGroup.getContext())
                .load(photoList.getResults().get(i).getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(viewHolder.ivPhoto);


        return view;
    }


    public void setPhotoList(PhotoListItemModel photoList) {
        this.photoList = photoList;
    }

    static class ViewHolder {
        private ImageView ivPhoto;
        private TextView tvName;

    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
}
