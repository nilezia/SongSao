package app.shopspot.nilezia.songsao.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import app.shopspot.nilezia.songsao.R;
import app.shopspot.nilezia.songsao.fragment.ItemInfoFragment;
import app.shopspot.nilezia.songsao.fragment.MainFragment;
import app.shopspot.nilezia.songsao.model.PhotoItemModel;

public class ItemInfoActivity extends AppCompatActivity {
    private PhotoItemModel photoItemModel;
    private ImageView ivPhoto;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        InitInstant();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .add(R.id.container, MainFragment.newInstance()).commit();
        }
    }

    private void InitInstant() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        //tvName = (TextView) findViewById(R.id.tvName);
        photoItemModel = getIntent().getParcelableExtra(MainFragment.PHOTO_LIST);
       // tvName.setText(photoItemModel.getWho());
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle(photoItemModel.getWho());
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM);
        Glide.with(getApplicationContext())
                .load(photoItemModel.getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(ivPhoto);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }
}
