package me.droan.udacityshowcase;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by drone on 03-07-2016.
 */
public class ShowcaseItem extends FrameLayout {
    @Bind(R.id.logo)
    ImageView logo;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.description)
    TextView description;

    public ShowcaseItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ShowcaseItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ShowcaseItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShowcaseItem(Context context) {
        super(context);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bind(Post post) {
        title.setText(post.title);
        description.setText(post.desc);
    }
}
