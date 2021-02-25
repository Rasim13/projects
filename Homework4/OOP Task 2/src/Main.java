public class Main {

    public static void main(String[] args) {
	Channel ort = new Channel("Первый канал");
	Channel rtr = new Channel("Россия");
	Channel ntv = new Channel("НТВ");

	Program p1 = new Program("Малахов+");
	Program p2 = new Program("Жить здорово");
	Program p3 = new Program("Пусть говорят");

	ort.addProgram(p1);
	ort.addProgram(p2);
	ort.addProgram(p3);

	TV tv = new TV("Samsung");
	tv.addChannel(rtr);
	tv.addChannel(ort);
	tv.addChannel(ntv);
	RemoteController controller = new RemoteController(tv);

	controller.on(1);
	controller.on(1);
	controller.on(1);
	controller.on(1);

    }
}
