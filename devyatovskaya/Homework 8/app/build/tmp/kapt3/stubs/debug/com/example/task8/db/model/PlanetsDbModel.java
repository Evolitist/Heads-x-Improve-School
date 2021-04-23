package com.example.task8.db.model;

import java.lang.System;

@androidx.room.Entity(tableName = "planets")
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001J\t\u0010*\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006+"}, d2 = {"Lcom/example/task8/db/model/PlanetsDbModel;", "", "id", "", "name", "", "diameter", "orbitalPeriod", "rotationPeriod", "gravity", "population", "climate", "terrain", "surfaceWater", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClimate", "()Ljava/lang/String;", "getDiameter", "getGravity", "getId", "()I", "getName", "getOrbitalPeriod", "getPopulation", "getRotationPeriod", "getSurfaceWater", "getTerrain", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class PlanetsDbModel {
    @androidx.room.PrimaryKey()
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "name")
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "diameter")
    private final java.lang.String diameter = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "orbitalPeriod")
    private final java.lang.String orbitalPeriod = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "rotationPeriod")
    private final java.lang.String rotationPeriod = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "gravity")
    private final java.lang.String gravity = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "population")
    private final java.lang.String population = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "climate")
    private final java.lang.String climate = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "terrain")
    private final java.lang.String terrain = null;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "surfaceWater")
    private final java.lang.String surfaceWater = null;
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDiameter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrbitalPeriod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRotationPeriod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGravity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPopulation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClimate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTerrain() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSurfaceWater() {
        return null;
    }
    
    public PlanetsDbModel(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String diameter, @org.jetbrains.annotations.NotNull()
    java.lang.String orbitalPeriod, @org.jetbrains.annotations.NotNull()
    java.lang.String rotationPeriod, @org.jetbrains.annotations.NotNull()
    java.lang.String gravity, @org.jetbrains.annotations.NotNull()
    java.lang.String population, @org.jetbrains.annotations.NotNull()
    java.lang.String climate, @org.jetbrains.annotations.NotNull()
    java.lang.String terrain, @org.jetbrains.annotations.NotNull()
    java.lang.String surfaceWater) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.task8.db.model.PlanetsDbModel copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String diameter, @org.jetbrains.annotations.NotNull()
    java.lang.String orbitalPeriod, @org.jetbrains.annotations.NotNull()
    java.lang.String rotationPeriod, @org.jetbrains.annotations.NotNull()
    java.lang.String gravity, @org.jetbrains.annotations.NotNull()
    java.lang.String population, @org.jetbrains.annotations.NotNull()
    java.lang.String climate, @org.jetbrains.annotations.NotNull()
    java.lang.String terrain, @org.jetbrains.annotations.NotNull()
    java.lang.String surfaceWater) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}