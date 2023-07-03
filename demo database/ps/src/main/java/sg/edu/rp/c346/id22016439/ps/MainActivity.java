package sg.edu.rp.c346.id22016439.ps;

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


        text2 = findViewById(R.id.editTextText2);
        text = findViewById(R.id.editTextText);




       

    }
}