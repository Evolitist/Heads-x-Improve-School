package com.example.task8.ui.main.ViewModels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/example/task8/ui/main/ViewModels/ShipsViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/example/task8/network/SWApiService;", "db", "Lcom/example/task8/db/SwDatabase;", "(Lcom/example/task8/network/SWApiService;Lcom/example/task8/db/SwDatabase;)V", "dataFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/task8/network/starships/StarShipApiModel;", "errors", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getErrors", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "starships", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/task8/ui/main/models/Starship;", "getStarships", "()Landroidx/lifecycle/MutableLiveData;", "Lkotlinx/coroutines/Job;", "app_debug"})
public final class ShipsViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.task8.network.starships.StarShipApiModel>> dataFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> errors = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.task8.ui.main.models.Starship>> starships = null;
    private final com.example.task8.network.SWApiService apiService = null;
    private final com.example.task8.db.SwDatabase db = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> getErrors() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.task8.ui.main.models.Starship>> getStarships() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getStarships() {
        return null;
    }
    
    @javax.inject.Inject()
    public ShipsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.task8.network.SWApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.task8.db.SwDatabase db) {
        super();
    }
}