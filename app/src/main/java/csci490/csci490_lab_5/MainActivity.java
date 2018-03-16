package csci490.csci490_lab_5;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import csci490.csci490_lab_5.async.MyAsyncTask;
import csci490.csci490_lab_5.async.MyAsyncTask2;
import csci490.csci490_lab_5.data.LabDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "person_db";
    private EditText personName;
    private Button submitButton;
    private Button listButton;
    private LabDatabase personDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();

        personName = findViewById(R.id.personName);
        submitButton = findViewById(R.id.submitButton);
        listButton = findViewById(R.id.listButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked submit", Toast.LENGTH_SHORT).show();
                submitToDatabase(personName.getText().toString());
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked list", Toast.LENGTH_SHORT).show();
                retrieveName();
            }
        });
    }

    private void submitToDatabase(String name)
    {
        MyAsyncTask myAsyncTask = new MyAsyncTask(personDB, getApplicationContext());
        myAsyncTask.execute();
    }

    private void retrieveName()
    {
        MyAsyncTask2 myAsyncTask2 = new MyAsyncTask2(personDB, getApplicationContext());
        myAsyncTask2.execute();
    }
}
