package me.droan.udacityshowcase.showcase;

import java.util.List;

import me.droan.udacityshowcase.data.Post;

/**
 * Created by drone on 04-07-2016.
 */
public class ShowcasePresenter implements ShowcaseContract.Presenter {

    private ShowcaseContract.View showcaseView;
    private ShowcaseService service;

    public ShowcasePresenter(ShowcaseContract.View showcaseView, ShowcaseService service) {
        this.showcaseView = showcaseView;
        this.service = service;
        showcaseView.setPresenter(this);
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadPosts(List<Post> posts) {
        showcaseView.showPosts(posts);

    }

    @Override
    public void start() {
        service.fetchData(new ShowcaseService.DataChangeListener() {
            @Override
            public void onDataAdded(List<Post> posts) {
                loadPosts(posts);
            }
        });
    }
}
