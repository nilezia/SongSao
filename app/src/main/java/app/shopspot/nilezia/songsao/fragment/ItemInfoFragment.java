package app.shopspot.nilezia.songsao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.w3c.dom.Text;

import app.shopspot.nilezia.songsao.R;
import app.shopspot.nilezia.songsao.activity.MainActivity;
import app.shopspot.nilezia.songsao.model.PhotoItemModel;
import app.shopspot.nilezia.songsao.util.ConvertDate;

public class ItemInfoFragment extends Fragment {

    public ItemInfoFragment() {
        super();
    }

    public static ItemInfoFragment newInstance() {
        ItemInfoFragment fragment = new ItemInfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private PhotoItemModel photoItemModel;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivPhoto;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoItemModel = getActivity().getIntent().getParcelableExtra(MainFragment.PHOTO_LIST);
        if (savedInstanceState != null) {
            // Restore Instance State here
            onRestoreInstanceState(savedInstanceState);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {


        // init instance with rootView.findViewById here
//        tvName = (TextView) rootView.findViewById(R.id.tvName);
//        tvDate = (TextView) rootView.findViewById(R.id.tvDate);
//        ivPhoto = (ImageView) rootView.findViewById(R.id.ivPhoto);
//
//        tvName.setText(photoItemModel.getWho());
//        String date = ConvertDate.getInstance().ConvertDate(photoItemModel.getCreatedAt());
//        tvDate.setText(date);
//        Glide.with(getContext())
//                .load(photoItemModel.getUrl())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.mipmap.ic_launcher)
//                .crossFade()
//                .into(ivPhoto);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here

        Bundle bundle = new Bundle();
        bundle.putParcelable(MainFragment.PHOTO_LIST, photoItemModel);
        outState.putBundle("bundle", bundle);

    }

    private void onRestoreInstanceState(Bundle savedInstanceState) {


        Bundle bundle = savedInstanceState.getBundle("bundle");
        photoItemModel = bundle.getParcelable(MainFragment.PHOTO_LIST);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}