public class Main {

    public static void main(String[] args) {
	Bus bus = new Bus(55, "Нефаз");
	Passenger p1 = new Passenger("a", "a");
	Passenger p2 = new Passenger("б","б");
	Passenger p3 = new Passenger("в","в");
	Passenger p4 = new Passenger("г","г");
	Passenger p5 = new Passenger("д","д");
	Driver marsel = new Driver("Марсель","Сидиков", 5);
	marsel.goToBus(bus);
	p1.goToBus(bus);
	p2.goToBus(bus);
	p3.goToBus(bus);
	p4.goToBus(bus);
	marsel.drive();
	p5.goToBus(bus);
    }
}
