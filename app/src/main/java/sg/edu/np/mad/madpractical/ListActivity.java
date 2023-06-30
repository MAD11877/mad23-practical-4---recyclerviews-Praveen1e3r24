package sg.edu.np.mad.madpractical;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AA_RecyclerViewAdapter.OnUserClickListener {
    private ArrayList<User> users = new ArrayList<>();
    private AA_RecyclerViewAdapter adapter;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            ArrayList<User> updatedUserList = data.getParcelableArrayListExtra("updatedUserList");

            if (updatedUserList != null) {
                users.clear();
                users.addAll(updatedUserList);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        createUsers();

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        adapter = new AA_RecyclerViewAdapter(this, users, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void createUsers() {
        for (int i = 0; i < 20; i++) {
            int randomInt = (int) Math.round(Math.random() * 100000);
            int randomDescInt = (int) Math.round(Math.random() * 10000);
            String msg = "User" + randomInt;
            String description = "Description" + randomDescInt;

            users.add(new User(false, msg, description));
        }
    }

    @Override
    public void onUserClick(int position) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        intent.putExtra("user", users.get(position));
        intent.putParcelableArrayListExtra("users", users);
        intent.putExtra("userpos", position);
        startActivityForResult(intent, 1);
    }
}
