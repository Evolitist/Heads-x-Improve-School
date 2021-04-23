package com.example.task8.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/task8/network/SWApiService;", "", "getFilms", "Lcom/example/task8/network/Model;", "Lcom/example/task8/network/films/FilmApiModel;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlanets", "Lcom/example/task8/network/planets/PlanetApiModel;", "getStarShips", "Lcom/example/task8/network/starships/StarShipApiModel;", "app_debug"})
public abstract interface SWApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "starships")
    public abstract java.lang.Object getStarShips(@retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.task8.network.Model<com.example.task8.network.starships.StarShipApiModel>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "films")
    public abstract java.lang.Object getFilms(@retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.task8.network.Model<com.example.task8.network.films.FilmApiModel>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "planets")
    public abstract java.lang.Object getPlanets(@retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.task8.network.Model<com.example.task8.network.planets.PlanetApiModel>> p1);
}