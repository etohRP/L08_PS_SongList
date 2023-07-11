package sg.edu.rp.c346.id22016439.ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    RadioGroup rg;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rg = findViewById(R.id.rgStars);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                if (rg.getCheckedRadioButtonId() == R.id.radioButton1){
                    db.insertSong((etTitle.getText().toString()), (etSinger.getText().toString()),Integer.parseInt(etYear.getText().toString()),1);
                } else if (rg.getCheckedRadioButtonId() == R.id.radioButton2){
                    db.insertSong((etTitle.getText().toString()), (etSinger.getText().toString()),Integer.parseInt(etYear.getText().toString()),2);
                } else if (rg.getCheckedRadioButtonId() == R.id.radioButton3){
                    db.insertSong((etTitle.getText().toString()), (etSinger.getText().toString()),Integer.parseInt(etYear.getText().toString()),3);
                } else if (rg.getCheckedRadioButtonId() == R.id.radioButton4){
                    db.insertSong((etTitle.getText().toString()), (etSinger.getText().toString()),Integer.parseInt(etYear.getText().toString()),4);
                } else if (rg.getCheckedRadioButtonId() == R.id.radioButton5){
                    db.insertSong((etTitle.getText().toString()), (etSinger.getText().toString()),Integer.parseInt(etYear.getText().toString()),5);
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(i);
                //aaSongs.clear();
                //aaSongs.addAll(updatedSongList);
                //aaSongs.notifyDataSetChanged();
            }
        });
    }
}