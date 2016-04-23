package app.shopspot.nilezia.songsao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;


import java.io.IOException;

import app.shopspot.nilezia.songsao.R;
import app.shopspot.nilezia.songsao.activity.ItemInfoActivity;
import app.shopspot.nilezia.songsao.adapter.PhotoListAdapter;

import app.shopspot.nilezia.songsao.controller.HttpConnector;
import app.shopspot.nilezia.songsao.controller.PhotoListItemController;
import app.shopspot.nilezia.songsao.model.PhotoItemModel;
import app.shopspot.nilezia.songsao.model.PhotoListItemModel;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainFragment extends Fragment {

    public MainFragment() {
        super();
    }

    int page = 0;
    int FIRST_PAGE = 0;
    int NEXT_PAGE = 1;
    public static String PHOTO_LIST = "photolist";
    private PhotoListItemController photoListItemController;
    private PhotoListAdapter photoListAdapter;
    private boolean isLoading = false;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoListItemController = new PhotoListItemController();

        if (savedInstanceState != null)
            photoListItemController.RestoreInstanceState(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void initInstances(View rootView, Bundle savedInstanceState) {

        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);
        photoListAdapter = new PhotoListAdapter();
        photoListAdapter.setPhotoList(photoListItemController.getPhotoList());
        gridView.setAdapter(photoListAdapter);

        gridView.setOnItemClickListener(clickListener);

        if (savedInstanceState == null) {
            LoadData(FIRST_PAGE);
        }

        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

                if (i + i1 >= i2) {

                    if (photoListItemController.getCount() > 0) {
                        LoadData(NEXT_PAGE);
                    }
                }
            }
        });
    }

    private void LoadData(final int i) {
        if (isLoading)
            return;
        isLoading = true;

        if (i == NEXT_PAGE)
            page += 1;

        Log.e("httpConnect","Page : "+ page );
        Call<PhotoListItemModel> photoListItemModelCall = HttpConnector.getInstance().getConnector().LoadPhotoList("福利", 50, page);

        photoListItemModelCall.enqueue(new Callback<PhotoListItemModel>() {
            @Override
            public void onResponse(Response<PhotoListItemModel> response, Retrofit retrofit) {

                if (response.isSuccess()) {
                    PhotoListItemModel photoList = response.body();

                    if (i == NEXT_PAGE)
                        photoListItemController.AppendPhotoItemAtLastPosition(photoList);
                    else
                        photoListItemController.setPhotoList(photoList);

                    if (photoList.getResults().isEmpty()) {
                        photoListAdapter.setLoading(false);
                        photoListAdapter.notifyDataSetChanged();
                        Log.e("httpConnect", "page Overflow");
                        page -= 1;
                        return;
                    }


                    photoListAdapter.setPhotoList(photoListItemController.getPhotoList());
                    photoListAdapter.notifyDataSetChanged();
                    isLoading = false;

                } else {

                    try {
                        Log.e("httpConnect", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {

                Log.e("httpConnect", "t: " + t.toString());

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here

        photoListItemController.onSaveInstanceState(outState);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PHOTO_LIST, photoListItemController.getPhotoList());
        outState.putBundle("bundle", bundle);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            PhotoItemModel itemModel = photoListItemController.getPhotoList().getResults().get(i);
            Intent intent = new Intent(getActivity(), ItemInfoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable(PHOTO_LIST, itemModel);
            intent.putExtras(bundle);
            getActivity().startActivity(intent);
            getActivity().overridePendingTransition(0,0);
        }
    };
}