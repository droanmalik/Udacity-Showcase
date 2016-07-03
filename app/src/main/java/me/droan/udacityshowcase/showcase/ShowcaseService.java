package me.droan.udacityshowcase.showcase;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import me.droan.udacityshowcase.data.Post;

/**
 * Created by drone on 04-07-2016.
 */
public class ShowcaseService {

    List<Post> posts = new ArrayList<>();
    private DataChangeListener listener;

    public void fetchData(final DataChangeListener listener) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = database.getReference("posts:");
        myRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("HELLO", "onChildAdded() called with: " + "dataSnapshot = [" + dataSnapshot + "], s = [" + s + "]");
                Post value = dataSnapshot.getValue(Post.class);
                posts.add(value);
                listener.onDataAdded(posts);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public interface DataChangeListener {
        void onDataAdded(List<Post> posts);
    }
}
