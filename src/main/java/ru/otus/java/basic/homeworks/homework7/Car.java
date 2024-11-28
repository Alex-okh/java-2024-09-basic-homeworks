package ru.otus.java.basic.homeworks.homework7;

public class Car extends Vehicle {
    public Car(String name, double maxFuel, double fuelPerKm) {
        super(name, new TerrainType[]{TerrainType.FOREST, TerrainType.SWAMP}, maxFuel, fuelPerKm);
    }
}
