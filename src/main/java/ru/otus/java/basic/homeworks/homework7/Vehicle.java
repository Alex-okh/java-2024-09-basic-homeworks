package ru.otus.java.basic.homeworks.homework7;

import java.util.Arrays;

public class Vehicle implements Drivable {
    private String name;
    private boolean occupied = false;
    private TerrainType[] restrictedTerrains;
    private double maxFuel;
    private double currentFuel;
    private double fuelPerKm;

    Vehicle(String name, TerrainType[] restrictedTerrains, double maxFuel, double fuelPerKm) {
        this.name = name;
        this.restrictedTerrains = restrictedTerrains;
        this.maxFuel = maxFuel;
        this.currentFuel = maxFuel;
        this.fuelPerKm = fuelPerKm;
    }

    @Override
    public boolean drive(int distance, TerrainType terrain) {
        for (TerrainType t : restrictedTerrains) {
            if (t == terrain) {
                System.out.println("Не могу тут проехать.");
                return false;
            }
        }
        double neededFuel = distance * fuelPerKm;
        if (currentFuel < neededFuel) {
            System.out.print("Не хватает топлива для поездки");
            return false;
        }
        System.out.printf("Проехали %d км.%n", distance);
        currentFuel -= neededFuel;
        return true;
    }


    @Override
    public String getVehicleName() {
        return name;
    }

    @Override
    public void occupy() {
        occupied = true;
    }

    @Override
    public void leave() {
        occupied = false;
    }

    @Override
    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "name='" + name + '\'' +
            ", occupied=" + occupied +
            ", restrictedTerrains=" + Arrays.toString(restrictedTerrains) +
            ", maxFuel=" + maxFuel +
            ", currentFuel=" + currentFuel +
            ", fuelPerKm=" + fuelPerKm +
            '}';
    }
}
