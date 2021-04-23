package com.example.task8.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/task8/di/ApiServiceModule;", "", "()V", "provideApiService", "Lcom/example/task8/network/SWApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofit", "app_debug"})
@dagger.Module()
public final class ApiServiceModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.task8.di.ApiServiceModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.OptIn(markerClass = {kotlinx.serialization.ExperimentalSerializationApi.class})
    @javax.inject.Singleton()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.task8.network.SWApiService provideApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    private ApiServiceModule() {
        super();
    }
}