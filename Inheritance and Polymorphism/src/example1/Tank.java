package example1;

public class Tank extends MilitaryTransport{

   public Tank(double fuelAmount, double fuelConsumption, int bulletsCount){
       super(fuelAmount, fuelConsumption,bulletsCount);

   }

    public void go(int km){
        this.fuelAmount -= (km * fuelConsumption) / 100;
    }

    public void fire(){
       this.bulletsCount--;
    }
}
