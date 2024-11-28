package ru.otus.java.basic.homeworks.homework7;

import java.util.Arrays;

public class Bike implements Drivable {
    private String name;
    private boolean occupied = false;
    private TerrainType[] restrictedTerrains = {TerrainType.SWAMP};


    public Bike(String name) {
        this.name = name;
    }

   @Override
    public boolean drive(int distance, TerrainType terrain) {
        for (TerrainType t : restrictedTerrains) {
            if (t == terrain) {
                System.out.println("Не могу тут проехать.");
                return false;
            }
        }
        System.out.printf("Проехали %d км на велосипеде.%n", distance);
        return true;
    }

    @Override
    public String getVehicleName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bike{" +
            "name='" + name + '\'' +
            ", occupied=" + occupied +
            ", restrictedTerrains=" + Arrays.toString(restrictedTerrains) +
            '}';
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
}
