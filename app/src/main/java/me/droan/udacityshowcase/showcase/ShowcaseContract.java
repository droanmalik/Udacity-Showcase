package me.droan.udacityshowcase.showcase;

import java.util.List;

import me.droan.udacityshowcase.BasePresenter;
import me.droan.udacityshowcase.BaseView;
import me.droan.udacityshowcase.data.Post;

/**
 * Created by drone on 04-07-2016.
 */
public class ShowcaseContract {

    interface View extends BaseView<Presenter> {
        void showPosts(List<Post> posts);

        void expand();

    }

    interface Presenter extends BasePresenter {
        void result(int requestCode, int resultCode);

        void loadPosts(List<Post> posts);
    }
}
