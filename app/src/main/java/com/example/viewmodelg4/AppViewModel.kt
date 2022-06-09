package com.example.viewmodelg4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel:ViewModel() {
    //Cant
    private var cant=0
    var valor=MutableLiveData<Int>()

    //String
    var cadena=MutableLiveData<String>()

    fun increment(){
        cant++
        valor.value=cant
    }

    fun change(str:String){
        if(str != cadena.value)
            cadena.value=str
    }

}