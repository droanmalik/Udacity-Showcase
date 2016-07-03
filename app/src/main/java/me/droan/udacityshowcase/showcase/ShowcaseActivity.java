package me.droan.udacityshowcase.showcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.droan.udacityshowcase.R;
import me.droan.udacityshowcase.util.ActivityUtil;

public class ShowcaseActivity extends AppCompatActivity {
    private static final String TAG = "ShowcaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcase_activity);

        //create the fragment
        ShowcaseFragment showcaseFragment = (ShowcaseFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (showcaseFragment == null) {
            showcaseFragment = ShowcaseFragment.newInstance();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), showcaseFragment, R.id.contentFrame);
        }

        //set services
        ShowcaseService service = new ShowcaseService();
        //create the presenter
        ShowcasePresenter showcasePresenter = new ShowcasePresenter(showcaseFragment, service);

    }

}
