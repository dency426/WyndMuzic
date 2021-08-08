package tp.edu.wyndmuzicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlaySong extends AppCompatActivity {

    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    private int drawable;
    private int currentIndex = -1;
    private SeekBar seekBar;
    private MediaPlayer player = new MediaPlayer();
    private ImageView btnPlayPause = null;
    private SongCollection songCollection = new SongCollection();
    private SongCollection OriginalSongCollection = new SongCollection();
    Handler handler = new Handler();

    List<Song> shuffleList = Arrays.asList(songCollection.songs);

    ImageView repeatbtn;
    ImageView shufflebtn;
    Boolean repeatFlag = false;
    Boolean shuffleFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        Bundle songData = this.getIntent().getExtras();
        int currentIndex = songData.getInt("index");
        Log.d("temasek", "Retrieved position is: " + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
        seekBar = findViewById(R.id.seek1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (player != null && player.isPlaying()) {
                    player.seekTo(seekBar.getProgress());
                }
            }
        });

        repeatbtn = findViewById(R.id.repeatbtn);
        shufflebtn = findViewById(R.id.shufflebtn);


        seekBar.setMax(player.getDuration());
        handler.removeCallbacks(bar);
        handler.postDelayed(bar,1000);
    }
    Runnable bar = new Runnable() {
        @Override
        public void run() {
            if (player != null && player.isPlaying()) {
                seekBar.setProgress(player.getCurrentPosition());
                handler.postDelayed(this, 1000);
            }
        }
    };
    public void displaySongBasedOnIndex(int selectedIndex)
    {
        Song song = songCollection.getCurrentSong(selectedIndex);
        title = song.getTitle();
        artiste = song.getArtiste();
        fileLink = song.getFileLink();
        drawable = song.getDrawable();

        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);

        TextView txtArtiste = findViewById(R.id.txtArtist);
        txtArtiste.setText(artiste);

        ImageView iCoverArt = findViewById(R.id.imgCoverArt);
        iCoverArt.setImageResource(drawable);
    }

    public void playSong(String fileLink) {
        try {
            player.reset();
            player.setDataSource(fileLink);
            player.prepare();
            player.start();
            btnPlayPause.setImageResource(R.drawable.pause_btn);
            setTitle(title);
            gracefullyStopsWhenMusicEnds();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void playOrPauseMusic(View view)
    {
        if(player.isPlaying())
        {
            player.pause();
            seekBar.setMax(player.getDuration());
            handler.removeCallbacks(bar);
            handler.postDelayed(bar,1000);
            btnPlayPause.setImageResource(R.drawable.play_btn );
        }
        else
        {
            player.start();
            seekBar.setMax(player.getDuration());
            handler.removeCallbacks(bar);
            handler.postDelayed(bar,1000);
            btnPlayPause.setImageResource(R.drawable.pause_btn);
        }
    }

    private void gracefullyStopsWhenMusicEnds()
    {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(PlaySong.this, "Song ended", Toast.LENGTH_SHORT).show();

                if(repeatFlag){
                    playOrPauseMusic(null);
                }else{
                    btnPlayPause.setImageResource(R.drawable.play_btn);

                }
            }
        });
    }

    public void playNext(View view)
    {
        currentIndex = songCollection.getNextSong(currentIndex);
        Toast.makeText(this, "After clicking playNext, \n the current index of this song\n" +
                "in the SongCollection array is noew: " + currentIndex, Toast.LENGTH_LONG).show();
        Log.d("temasek", "After playNext, the index is now: " + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    public void playPrevious(View view)
    {
        currentIndex = songCollection.getPrevSong(currentIndex);
        Toast.makeText(this, "After clicking playPrevious, \nthe current index of this song\n" +
                "in the SongCollection array is now: " + currentIndex, Toast.LENGTH_LONG).show();
        Log.d("temasek", "After playPrevious, the index is now: " + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        player.release();
    }

    public void repeatOn(View view){

        if(repeatFlag){
            repeatbtn.setBackgroundResource(R.drawable.repeat_off);
        }else{

            repeatbtn.setBackgroundResource(R.drawable.repeat_on);
        }
        repeatFlag = !repeatFlag;
    }
    public void shuffleOn(View view) {

        if (shuffleFlag) {
            shufflebtn.setBackgroundResource(R.drawable.shuffle_off);
            songCollection = new SongCollection();
        } else {

            shufflebtn.setBackgroundResource(R.drawable.shuffle_on);
            Collections.shuffle(shuffleList);
            shuffleList.toArray(songCollection.songs);

        }

        shuffleFlag = !shuffleFlag;
    }
    }
