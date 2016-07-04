package me.droan.udacityshowcase.showcase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.droan.udacityshowcase.R;
import me.droan.udacityshowcase.data.Post;

/**
 * Created by drone on 04-07-2016.
 */
public class ShowcaseFragment extends Fragment implements ShowcaseContract.View {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private ShowcaseAdapter adapter;
    private ShowcaseContract.Presenter showcasePresenter;

    public static ShowcaseFragment newInstance() {

        Bundle args = new Bundle();

        ShowcaseFragment fragment = new ShowcaseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ShowcaseAdapter(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        showcasePresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.showcase_fragment, container, false);
        ButterKnife.bind(this, view);
        initToolbar();
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new UnscrollableLinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void initToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.showcase_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void showPosts(List<Post> posts) {
        adapter.refresh(posts);
    }

    @Override
    public void expand() {

    }

    @Override
    public void setPresenter(ShowcaseContract.Presenter presenter) {
        this.showcasePresenter = presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private static class UnscrollableLinearLayoutManager extends LinearLayoutManager {
        public UnscrollableLinearLayoutManager(Context context) {
            super(context, LinearLayoutManager.VERTICAL, false);
        }

        @Override
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override
        public boolean canScrollVertically() {
            return false;
        }
    }
}
