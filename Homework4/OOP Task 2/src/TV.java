public class TV {
    private static final int MAX_CHANNELS_COUNT = 10;
    private String name;
    private Channel[] channels;
    private int channelsCount;

    public TV(String name) {
        this.name = name;
        this.channelsCount = 0;
        this.channels = new Channel[MAX_CHANNELS_COUNT];
    }

    public void addChannel(Channel channel){
        if(channelsCount < MAX_CHANNELS_COUNT){
            channels[channelsCount] = channel;
            channelsCount++;
        } else {
            System.err.println("Канал добавить нельзя");
        }
    }

    public void on(int channelNumber){
        if(channelNumber < channelsCount && channelNumber >= 0){
            channels[channelNumber].showProgram();
        } else {
            System.err.println("Нет такого канала");
        }
    }
}
