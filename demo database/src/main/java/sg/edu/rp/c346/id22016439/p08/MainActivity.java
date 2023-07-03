package sg.edu.rp.c346.id22016439.p08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvResults;
    EditText text, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGet);
        tvResults = findViewById(R.id.tvResults);
        text2 = findViewById(R.id.editTextText2);
        text = findViewById(R.id.editTextText);




        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                String str = text2.getText().toString();
                String str2 = text.getText().toString();
                dbHelper.insertTask(str, str2);
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<String> data = db.getTaskContent();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);
            }
        });

    }
}