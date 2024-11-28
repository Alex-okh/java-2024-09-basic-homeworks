package ru.otus.java.basic.homeworks.homework7;

public interface Drivable {
    boolean drive(int distance, TerrainType terrain);

    String getVehicleName();

    void occupy();

    void leave();

    boolean isOccupied();
}
