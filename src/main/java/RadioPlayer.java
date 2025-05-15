public class RadioPlayer implements Player{
    private boolean onOff;
    private double[] stationList;
    private int volume;
    private double station;
    
    public RadioPlayer(double[] stationList) {
        this.stationList = stationList;
        this.volume = 0;
        this.onOff = false;
        this.station = 0;
    }

    @Override
    public void start() {
        onOff = true;
        this.station = this.stationList[0];
    }
    
    @Override
    public void stop() {
        onOff = false;
        this.station = 0;
    }

    public boolean getOnOff() {
        return this.onOff;
    }

    @Override
    public void volumeUp() {
        this.volume += 2;
    }

    @Override
    public void volumeDown() {
        this.volume -= 2;
    }
    
    @Override
    public int getVolume() {
        return this.volume;
    }

    public void next() {
        for (int i = 0; i < this.stationList.length; i++) {
            if (this.stationList[i] == this.station) {
                if (i == this.stationList.length - 1) {
                    this.station = this.stationList[0];
                } else {
                    this.station = this.stationList[i + 1];
                }
                i = this.stationList.length;
            }
        }
    }

    public void previous() {
        for (int i = 0; i < this.stationList.length; i++) {
            if (this.stationList[i] == this.station) {
                if (i == 0) {
                    this.station = this.stationList[this.stationList.length - 1];
                } else {
                    this.station = this.stationList[i - 1];
                }
                i = this.stationList.length;
            }
        }
    }

    public double getStation() {
        return this.station;
    }
}
