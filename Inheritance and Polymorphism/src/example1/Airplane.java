public class Airplane extends Transport{

    private int length;

    public Airplane(double fuelAmount, double fuelConsumption, int length) {
        super(fuelAmount,fuelConsumption);
        this.length = length;
    }

    public void go(int km){
        this.fuelAmount -= (km * fuelConsumption) / 100;
        this.fuelConsumption -= 0.1;
    }

    public int getLength() {
        return length;
    }

}
