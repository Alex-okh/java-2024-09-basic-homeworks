package ru.otus.java.basic.homeworks.homework7;

public enum TerrainType {PLANE, FOREST , SWAMP ;

    public static TerrainType random() {
        return TerrainType.values()[(int) (Math.random() * TerrainType.values().length)];
    }
}

