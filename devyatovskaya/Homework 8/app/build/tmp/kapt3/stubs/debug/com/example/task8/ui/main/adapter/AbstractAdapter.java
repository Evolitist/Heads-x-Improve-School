package com.example.task8.ui.main.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0002\u0016\u0017B3\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0015R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/task8/ui/main/adapter/AbstractAdapter;", "T", "VH", "Lcom/example/task8/ui/main/adapter/AbstractAdapter$ViewHolder;", "Landroidx/recyclerview/widget/ListAdapter;", "createViewHolder", "Lkotlin/Function2;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "clickCallback", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "(Lcom/example/task8/ui/main/adapter/AbstractAdapter$ViewHolder;I)V", "onCreateViewHolder", "parent", "viewType", "(Landroid/view/ViewGroup;I)Lcom/example/task8/ui/main/adapter/AbstractAdapter$ViewHolder;", "DiffCallback", "ViewHolder", "app_debug"})
public final class AbstractAdapter<T extends java.lang.Object, VH extends com.example.task8.ui.main.adapter.AbstractAdapter.ViewHolder<T>> extends androidx.recyclerview.widget.ListAdapter<T, VH> {
    private final kotlin.jvm.functions.Function2<android.view.LayoutInflater, android.view.ViewGroup, VH> createViewHolder = null;
    private final kotlin.jvm.functions.Function1<T, kotlin.Unit> clickCallback = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    VH holder, int position) {
    }
    
    public AbstractAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? extends VH> createViewHolder, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> clickCallback) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00022\u0006\u0010\u0007\u001a\u00028\u0002H\u0017\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00022\u0006\u0010\u0007\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/example/task8/ui/main/adapter/AbstractAdapter$DiffCallback;", "T", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback<T extends java.lang.Object> extends androidx.recyclerview.widget.DiffUtil.ItemCallback<T> {
        
        @java.lang.Override()
        public boolean areItemsTheSame(T oldItem, T newItem) {
            return false;
        }
        
        @android.annotation.SuppressLint(value = {"DiffUtilEquals"})
        @java.lang.Override()
        public boolean areContentsTheSame(T oldItem, T newItem) {
            return false;
        }
        
        public DiffCallback() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00070\nH&\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/task8/ui/main/adapter/AbstractAdapter$ViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "(Landroidx/viewbinding/ViewBinding;)V", "bind", "", "data", "onClick", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "app_debug"})
    public static abstract class ViewHolder<T extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public abstract void bind(T data, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super T, kotlin.Unit> onClick);
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        androidx.viewbinding.ViewBinding binding) {
            super(null);
        }
    }
}