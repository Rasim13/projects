package ru.itis.example;

public class Unit {
    private String name;
    private double hp;
    private double mana;

    public Unit(String name, double hp, double mana) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
    }

    public Unit(String name) {
        this.name = name;

    }

    public Unit() {

    }

    public void manaUp(double manaValue) {
        this.mana += manaValue;
    }

    public void damage(int damageValue) {
        this.hp -= calculateDamage(damageValue);
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public double getMana() {
        return mana;
    }

    private double calculateDamage(int damageValue) {
        return damageValue / 10.0;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", mana=" + mana +
                '}';
    }
}
