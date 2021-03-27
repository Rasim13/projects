package TemplateMethod.example2;

public class HousingClient {
    public static void main(String[] args) {
        HouseTemplate houseType = new WoodenHouse();
        houseType.buildHouse();
        System.out.println("\n=============================\n");
        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
