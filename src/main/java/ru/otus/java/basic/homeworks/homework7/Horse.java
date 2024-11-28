package ru.otus.java.basic.homeworks.homework7;

import java.util.Arrays;

public class Horse implements Drivable {
    private String name;
    private boolean occupied = false;
    private TerrainType[] restrictedTerrains = {TerrainType.SWAMP};
    private double stamina;
    private double staminaSpentPerKm;


    public Horse(String name) {
        this.name = name;
        stamina = 100;
        staminaSpentPerKm = 3;
    }

    @Override
    public boolean drive(int distance, TerrainType terrain) {
        for (TerrainType t : restrictedTerrains) {
            if (t == terrain) {
                System.out.println("Лошадь говорит: не могу тут пройти, хозяин.");
                return false;
            }
        }
        if (stamina < 10) {
            System.out.println("Лошадь устала и не хочет ехать.");
            return false;
        }

        System.out.printf("Проехали %d км на лошади.%n", distance);
        stamina -= distance * staminaSpentPerKm;
        if (stamina < 0) {
            System.out.println("Лошадь перенапряглась и сдохла");
        }
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
        return "Horse{" +
            "name='" + name + '\'' +
            ", occupied=" + occupied +
            ", restrictedTerrains=" + Arrays.toString(restrictedTerrains) +
            ", stamina=" + stamina +
            ", staminaSpentPerKm=" + staminaSpentPerKm +
            '}';
    }
}
