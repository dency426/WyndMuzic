package tp.edu.wyndmuzicplayer;

public class Song {
    private String id;
    private String title;
    private String artiste;
    private String fileLink;
    private double songLength;
    private int drawable;

    /*
    Song theWayYouLookTonight = new Song ("S1001",
                "1. The Way You Look Tonight",
                "Michael Buble",
                "https://p.scdn.co/mp3-preview/a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=2afe87a64b0042dabf51f37318616965",
                4.66,
                R.drawable.michael_buble_collection);
     */

    public Song(String id, String title, String artiste, String fileLink, double songLength, int drawable)
    {
        this.id = id;
        this.title = title;
        this.artiste = artiste;
        this.fileLink = fileLink;
        this.songLength = songLength;
        this.drawable = drawable;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle(){ return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtiste() { return artiste; }
    public void setArtiste(String artiste) { this.artiste = artiste; }

    public String getFileLink() { return fileLink; }
    public void setFileLink(String fileLink) { this.fileLink = fileLink; }

    public double getSongLength() { return songLength; }
    public void setSongLength(double songLength) { this.songLength = songLength; }

    public int getDrawable() { return drawable; }
    public void setDrawable(int drawable) { this.drawable = drawable; }

}
