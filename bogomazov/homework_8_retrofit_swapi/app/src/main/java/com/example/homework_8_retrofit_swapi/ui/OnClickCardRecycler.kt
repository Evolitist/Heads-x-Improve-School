package com.example.homework_8_retrofit_swapi.ui

interface OnClickCardRecycler<T>{
    fun openNewFragment(dbModel: T)
}