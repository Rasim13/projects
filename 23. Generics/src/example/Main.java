package example;

public class Main {

    public static void main(String[] args) {
        Cover<Nokia3310> nokiaCover = new Cover<>();
        Nokia3310 nokia3310 = new Nokia3310();

//        nokiaCover.setPhone(iphone);
        nokiaCover.setPhone(nokia3310);
        Nokia3310 nokiaFromCover = nokiaCover.getPhone();
        nokiaFromCover.call();

        Cover<Iphone> iphoneCover = new Cover<>();
        Iphone iphone = new Iphone();
        iphoneCover.setPhone(iphone);

        Iphone iphoneFromCover = iphoneCover.getPhone();
        iphoneFromCover.createPhoto();
    }
}
