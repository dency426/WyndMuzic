package tp.edu.wyndmuzicplayer;

public class SongCollection {

    private Song songs[] = new Song[2];

    public SongCollection()
    {
        Song theWayYouLookTonight = new Song ("S1001",
                "1. The Way You Look Tonight",
                "Michael Buble",
                "https://p.scdn.co/mp3-preview/efd5dc3b16c735e2cf39d3e27fce6ce36a26fbdb?cid=2afe87a64b0042dabf51f37318616965",
                4.66,
                R.drawable.michael_buble_collection);

        Song billieJean = new Song ("S1002",
                "2. Billie Jean",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/efd5dc3b16c735e2cf39d3e27fce6ce36a26fbdb?cid=2afe87a64b0042dabf51f37318616965",
                4.9,
                R.drawable.billie_jean);

        songs[0] = theWayYouLookTonight;
        songs[1] = billieJean;
    }

    public Song getCurrentSong(int currentSongId)
    {
        return songs[currentSongId];
    }

    public int searchSongById(String id)
    {
        for(int index = 0; index < songs.length; index++)
        {
            Song tempSong = songs[index];
            if(tempSong.getId().equals(id))
            {
                return index;
            }
        }
        return -1;
    }

    public int getNextSong(int currentSongIndex)
    {
        if(currentSongIndex >= songs.length-1)
        {
            return currentSongIndex;
        }
        else
        {
            return currentSongIndex + 1;
        }
    }

    public int getPrevSong(int currentSongIndex)
    {
        if(currentSongIndex <= 0)
        {
            return currentSongIndex;
        }
        else
        {
            return currentSongIndex - 1;
        }
    }
}
