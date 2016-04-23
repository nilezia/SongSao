package app.shopspot.nilezia.songsao.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import app.shopspot.nilezia.songsao.R;

/**
 * Created by NileZia on 19/3/2559.
 */
public class SquareProgress extends RelativeLayout {
    private ProgressBar progressBar;

    public SquareProgress(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    private void initInstances() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    private void initInflate() {

        inflate(getContext(), R.layout.progress_square, this);
    }

    public SquareProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
    }

    public SquareProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
    }

    @TargetApi(21)
    public SquareProgress(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
    }


    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
