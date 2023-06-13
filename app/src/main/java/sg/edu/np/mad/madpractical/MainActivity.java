package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String msg =getIntent().getStringExtra("Msg");
        String desc = getIntent().getStringExtra("desc");

        TextView textView10 = findViewById(R.id.textView10);
        TextView textView3=findViewById(R.id.textView3);
        textView10.setText("hello");
        textView3.setText(desc);



       User user = new User("praveen","Male",1,true);
        Button follow = findViewById(R.id.button1);
        Button x = findViewById(R.id.button3);

        if (user.followed)
        {
            follow.setText("Follow");
        }
        else
        {
            follow.setText("Unfollow");
        }

        follow.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (user.followed)
                        {
                         user.followed=false;
                         follow.setText("Unfollow");

                        }
                        else {
                            user.followed=true;
                            follow.setText("Follow");
                        }
                        Toast.makeText(getApplicationContext(),"followed", Toast.LENGTH_SHORT).show();
                    }
                }

        );





            Intent receivingEnd=getIntent();
            String total =(String) receivingEnd.getStringExtra("number");


           // final TextView mTextView=(TextView) findViewById(R.id.textView);

            textView10.setText(total);


        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activityName= new Intent(MainActivity.this,MessageGroup.class);
                startActivity(activityName);
            }
        });


    }


}