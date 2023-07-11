package sg.edu.rp.c346.id22016439.ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class EditActivity extends AppCompatActivity {

    EditText etSongID, etTitle, etSinger, etYear;
    RadioGroup rg;
    Button btnUpdate, btnDelete, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etSongID = findViewById(R.id.etSongID);
        etTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rg = findViewById(R.id.rgStars);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent intent = getIntent();
        Song data = (Song) intent.getSerializableExtra("song");
        etSongID.setText(String.valueOf(data.getId()));
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(EditActivity.this);
                if (rg.getCheckedRadioButtonId() == R.id.radioButton1){
                    data.setTitle(etTitle.getText().toString());
                    data.setSingers(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(1);
                    db.updateSong(data);
                    db.close();
                    finish();
                } else if (rg.getCheckedRadioButtonId() == R.id.radioButton2){
                    data.setTitle(etTitle.getText().toString());
                    data.setSingers(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(2);
                    db.updateSong(data);
                    db.close();
                    finish();
                } else if (rg.getCheckedRadioButtonId() == R.id.radioButton3){
                    data.setTitle(etTitle.getText().toString());
                    data.setSingers(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(3);
                    db.updateSong(data);
                    db.close();
                    finish();
                } else if (rg.getCheckedRadioButtonId() == R.id.radioButton4){
                    data.setTitle(etTitle.getText().toString());
                    data.setSingers(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(4);
                    db.updateSong(data);
                    db.close();
                    finish();
                } else if (rg.getCheckedRadioButtonId() == R.id.radioButton5){
                    data.setTitle(etTitle.getText().toString());
                    data.setSingers(etSinger.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setStars(5);
                    db.updateSong(data);
                    db.close();
                    finish();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(EditActivity.this);
                db.deleteSong(data.getId());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}