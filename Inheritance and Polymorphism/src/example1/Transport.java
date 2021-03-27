package example1;

public abstract class Transport {
    private static final double DEFAULT_FUEL_AMOUNT = 0.1;
    private static final double DEFAULT_FUEL_CONSUMPTION = 0.1;
    // поле объем топлива
    protected double fuelAmount = DEFAULT_FUEL_AMOUNT;
    // поле потребление топлива
    protected double fuelConsumption = DEFAULT_FUEL_CONSUMPTION;

    public Transport(double fuelAmount, double fuelConsumption) {
        if(fuelAmount > 0){
            this.fuelAmount = fuelAmount;
        } if(fuelConsumption > 0){
            this.fuelConsumption = fuelConsumption;
        }
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public abstract void go(int km);
}
