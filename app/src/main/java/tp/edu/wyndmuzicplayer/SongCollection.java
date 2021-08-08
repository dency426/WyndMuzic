package tp.edu.wyndmuzicplayer;

public class SongCollection {

    public Song[] songs = new Song[6];

    public SongCollection()
    {
        Song theWayYouLookTonight = new Song ("S1001",
                "1. The Way You Look Tonight",
                "Michael Buble",
                "https://p.scdn.co/mp3-preview/a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=2afe87a64b0042dabf51f37318616965",
                4.66,
                R.drawable.michael_buble_collection);

        Song billieJean = new Song ("S1002",
                "2. Billie Jean",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/14a1ddedf05a15ad0ac11ce28b40ea1a15fabd20?cid=2afe87a64b0042dabf51f37318616965",
                4.9,
                R.drawable.billie_jean);


        Song aintYourMama = new Song ("S1003",
                "3. Ain't Your Mama",
                "Jennifer Lopez",
                "https://p.scdn.co/mp3-preview/1a71ad2e5d2a5b54541abd53517dd7e124cc2e21?cid=2afe87a64b0042dabf51f37318616965",
                3.64,
                R.drawable.on_the_floor);


        Song iDontCare= new Song ("S1004",
                "4. I Don't Care",
                "Ed Sheeran",
                "https://p.scdn.co/mp3-preview/2b38831139f617ee032faae6482979f3e631db1a?cid=2afe87a64b0042dabf51f37318616965",
                3.67,
                R.drawable.photograph);


        Song beautifulPeople = new Song ("S1005",
                "5. Beautiful People",
                "Ed Sheeran",
                "\thttps://p.scdn.co/mp3-preview/3ad904af9567a7c7df7d23a8d6700296ded34b4f?cid=2afe87a64b0042dabf51f37318616965",
                3.3,
                R.drawable.photograph);


        Song roar = new Song ("S1006",
                "6. Roar",
                "Katy Perry",
                "https://p.scdn.co/mp3-preview/1c95eb77fbdb48f4308662beb76544ea0dba5962?cid=2afe87a64b0042dabf51f37318616965",
                3.35,
                R.drawable.roar);

        songs[0] = theWayYouLookTonight;
        songs[1] = billieJean;
        songs[2] = aintYourMama;
        songs[3] = iDontCare;
        songs[4] = beautifulPeople;
        songs[5] = roar;
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
