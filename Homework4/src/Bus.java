public class Bus {
    private int number;
    private String model;

    //сслыка на водитель
    private Driver driver;
    private boolean isRun;

    private Passenger[] passengers;
    private int passengersCount;

    private Bus(){
        this.passengers = new Passenger[3];
    }

    public Bus(int number, String model){
        this();
        this.number = number;
        this.model = model;
    }
    public Bus(int number, String model, Driver driver){
        this.number = number;
        this.model = model;
        this.driver = driver;
    }

    public Bus(Driver driver) {
        this.driver = driver;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }


    public void setDriver(Driver driver){
        if(!isRun){
            this.driver = driver;
        } else {
            System.err.println("Нельзя менять водителя");
        }
    }

    public void addPassengers(Passenger passenger){
        if(isRun){
            System.err.println("Машина уже едет");
            return;
        }
        if(this.passengersCount < passengers.length){
            passengers[passengersCount] = passenger;
            passengersCount++;
        } else {
            System.err.println("Мест больше нет!");
        }
    }

    public void go(){
        this.isRun = true;
        System.out.println("Автобус " + number
                + " Модель " + model
                + " поехал под управлением " + driver.getFirstName());
        for (int i = 0; i < passengersCount; i++) {
            System.out.println("Едет с нами " + passengers[i].getFirstName());
        }
    }

    public void stop(){
        this.isRun = false;
    }
}
