package tp.edu.wyndmuzicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HomePage extends AppCompatActivity {
    SongCollection songCollection = new SongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    public void sendDataToActivity(int index)
    {
        Intent intent = new Intent(this, PlaySong.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    public void handleSelection(View view)
    {
        String resourceId = getResources().getResourceEntryName(view.getId());
        int currentArrayIndex = songCollection.searchSongById(resourceId);
        Log.d("temasek", "The id of the pressed ImageButton is: " + resourceId);
        Log.d("temasek", "button clicked" + currentArrayIndex);
        sendDataToActivity(currentArrayIndex);
    }

}