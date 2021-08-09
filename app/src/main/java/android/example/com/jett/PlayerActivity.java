package android.example.com.jett;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gauravk.audiovisualizer.visualizer.BarVisualizer;

import java.io.File;
import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    Button btnPlay, btnStop, btnNext, btnPrev, btnFf, btnFr;
    TextView txtSname, txtStart, txtStop;
    SeekBar mSeekBar;
    BarVisualizer mVisualizer;

    String sname;
    public static final String EXTRA_NAME = "song_name";
    static MediaPlayer sMediaPlayer;
    int position;

    static ArrayList<MusicFiles> mySongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        btnPlay = findViewById(R.id.play_button);
        btnNext = findViewById(R.id.button_next);
        btnPrev = findViewById(R.id.button_prev);
        btnFf = findViewById(R.id.button_fast_forward);
        btnFr = findViewById(R.id.button_fast_rewind);

        txtSname = findViewById(R.id.songTitle);
        txtStart = findViewById(R.id.txtStart);
        txtStop = findViewById(R.id.txtEnd);

        mSeekBar = findViewById(R.id.seekbar);

        mVisualizer = findViewById(R.id.bar);

        if (sMediaPlayer != null) {
            sMediaPlayer.stop();
            sMediaPlayer.release();
        }



        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        mySongs = (ArrayList) bundle.getParcelableArrayList("songs");

        String songName = i.getStringExtra("songName");

        position = bundle.getInt("pos", 0);

        txtSname.setSelected(true);
        Uri uri = Uri.parse(mySongs.get(position).toString());
        sname = mySongs.get(position).getTitle();
        txtSname.setText(sname);

        sMediaPlayer=MediaPlayer.create(getApplicationContext(), uri);
        sMediaPlayer.start();



        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (sMediaPlayer.isPlaying()) {
                        btnPlay.setBackgroundResource(R.drawable.ic_play);
                        sMediaPlayer.pause();
                    } else {
                        btnPlay.setBackgroundResource(R.drawable.ic_pause);
                        sMediaPlayer.start();
                    }


            }
        });



    }

}