package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements RecyclerViewInterface {
    ArrayList<UserModel> users = new ArrayList<>();
   static boolean x = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        createusers();
        AA_RecyclerViewAdapter adapter = new AA_RecyclerViewAdapter(this,users,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int number = (int) Math.round(Math.random() * 10000000);
                Intent activityName = new Intent(ListActivity.this, MainActivity.class);

                activityName.putExtra("number", "MAD " + number);
                startActivity(activityName);
            }
        });






    }
    public void createusers () {


        for (int i = 0; i < 20; i++) {
            int randomint = (int) Math.round(Math.random() * 100000);
            int randomdescint = (int) Math.round(Math.random() * 10000);
            String msg = "User" + randomint;
            String description = "Description" + randomdescint;

            users.add(new UserModel(msg, description));
        }

    }

    @Override
    public void onItemClick(int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(users.get(position).getMsg());
        builder.setMessage(users.get(position).getDesc());
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ListActivity.this,MainActivity.class);
                intent.putExtra("Msg",users.get(position).getMsg());
                intent.putExtra("desc",users.get(position).getDesc());
                startActivity(intent);
            }
        });
        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert=builder.create();
        alert.show();



    }
}