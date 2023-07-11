package sg.edu.rp.c346.id22016439.ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

public class DisplayActivity extends AppCompatActivity {

    Button btnStars;
    Spinner spinnerYear;
    ListView lvResults;

    @Override
    protected void onResume() {
        super.onResume();
        btnStars.performClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnStars = findViewById(R.id.btnFilterStars);
        spinnerYear = findViewById(R.id.spinnerYear);
        lvResults = findViewById(R.id.lvDisplay);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);

        spinnerYear.setAdapter(adapter);

        DBHelper db = new DBHelper(DisplayActivity.this);
        ArrayList<Song> songList = db.getSongs();
        db.close();
        //ArrayList<Song> song = db.getSongs();
        ArrayAdapter aaSongs = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
        lvResults.setAdapter(aaSongs);

        btnStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Song> filteredSongList = new ArrayList<>();
                for (int i = 0; i < songList.size(); i++) {
                    if (songList.get(i).getStars() == 5) {
                        filteredSongList.add(songList.get(i));
                    }
                }
                ArrayAdapter<Song> aaFilteredSongs = new ArrayAdapter<>(DisplayActivity.this, android.R.layout.simple_list_item_1, filteredSongList);
                lvResults.setAdapter(aaFilteredSongs);
            }
        });

        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedYear = parent.getItemAtPosition(position).toString();

                ArrayList<Song> filteredSongList = new ArrayList<>();
                for (int i = 0; i < songList.size(); i++) {
                    if (String.valueOf(songList.get(i).getYear()).equals(selectedYear)) {
                        filteredSongList.add(songList.get(i));
                    }
                }

                ArrayAdapter<Song> aaFilteredSongs = new ArrayAdapter<>(DisplayActivity.this, android.R.layout.simple_list_item_1, filteredSongList);
                lvResults.setAdapter(aaFilteredSongs);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = songList.get(position);
                Intent intent = new Intent(DisplayActivity.this, EditActivity.class);
                intent.putExtra("song", song);
                startActivity(intent);
            }
        });
    }
}