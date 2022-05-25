package sg.edu.np.mad.MADPractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


//    User newUser = new User("YanYong", "Year 2 Student Studying in MAD", 1, true ); //bruh this is confusing ;-;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView username = findViewById(R.id.user);
//        Intent receive = getIntent();
//        int newInput = receive.getIntExtra("random", 1739039545);
//        username.setText(newUser.Name + " " + newInput);
//
//        TextView description = findViewById(R.id.description);
//        description.setText(newUser.Description);

        TextView name, description;
        Button followStatus;
        name = findViewById(R.id.user);
        description = findViewById(R.id.description);
        followStatus = findViewById(R.id.followButton);

        Intent receive = getIntent();
        String userName = receive.getStringExtra("name");
        String desc = receive.getStringExtra("desc");
        Integer id = receive.getIntExtra("id", 0);
        Boolean followed = receive.getBooleanExtra("followed", false);
        User userProfile = new User(userName, desc, id, followed);

        name.setText(userProfile.Name);
        description.setText(userProfile.Description);
        followStatus.setText((followed == true) ? "Followed" : "Unfollow");


        Button follow = findViewById(R.id.followButton);

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userProfile.Followed == true){
                    follow.setText("Unfollowed");
                    userProfile.Followed = false;
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
                else{
                    follow.setText("Followed");
                    userProfile.Followed = true;
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void messageClicked(View view){
        Button message = findViewById(R.id.messageButton);
        Intent messageGroup = new Intent(MainActivity.this, MessageGroup.class);
        startActivity(messageGroup);
    }
}
