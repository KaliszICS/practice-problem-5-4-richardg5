public class MusicPlayer implements Player {
    private boolean onOff;
    private String[] musicList;
    private String currentSong;
    private int volume;

    public MusicPlayer(String[] musicList) {
        this.musicList = musicList;
        this.volume = 0;
        this.onOff = false;
        this.currentSong = "";
    }

    @Override
    public void start() {
        this.onOff = true;
        this.currentSong = musicList[0];
    }

    @Override
    public void stop() {
        this.onOff = false;
        this.currentSong = "";
    }

    public boolean getOnOff() {
        return this.onOff;
    }

    @Override
    public void volumeUp() {
        this.volume++;
    }

    @Override
    public void volumeDown() {
        this.volume--;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    public void next() {
        for (int i = 0; i < this.musicList.length; i++) {
            if (this.musicList[i].equals(currentSong)) {
                if (i == this.musicList.length - 1) {
                    this.currentSong = this.musicList[0];
                } else {
                    this.currentSong = this.musicList[i + 1];
                }
                i = this.musicList.length;
            }
        }
    }

    public void previous() {
        for (int i = 0; i < this.musicList.length; i++) {
            if (this.musicList[i].equals(currentSong)) {
                if (i == 0) {
                    this.currentSong = this.musicList[this.musicList.length - 1];
                } else {
                    this.currentSong = this.musicList[i - 1];
                }
                i = this.musicList.length;
            }
        }
    }

    public String getCurrentSong() {
        return this.currentSong;
    }
}
