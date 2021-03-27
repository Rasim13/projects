package example1;

public abstract class MilitaryTransport extends Transport{
    protected int bulletsCount;

    public MilitaryTransport(double fuelAmount, double fuelConsumption, int bulletsCount) {
        super(fuelAmount, fuelConsumption);
        this.bulletsCount = bulletsCount;
    }

    public abstract void fire();

    public int getBulletsCount() {
        return bulletsCount;
    }

}
