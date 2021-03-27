public class MilitaryAirplane extends MilitaryTransport {
    public MilitaryAirplane(double fuelAmount, double fuelConsumption, int bulletsCount) {
        super(fuelAmount, fuelConsumption, bulletsCount);
    }

    public void go(int km){
        this.fuelAmount -= (km * fuelConsumption) / 100;
        this.fuelConsumption -= 0.1;
    }

    public void fire(){
        this.bulletsCount -= 10;
    }
}
