package com.example.viewmodelg4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelg4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var views:ActivityMainBinding
    lateinit var vm:AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        views= ActivityMainBinding.inflate(layoutInflater)

        vm=ViewModelProvider(this).get(AppViewModel::class.java)

        setContentView(views.root)

        views.btnPlus.setOnClickListener {
            vm.increment()
        }

        vm.valor.observe(this, Observer {
            views.txtCant.text=it.toString()
        })

        val textbox=views.tilCantidad

        val _watcher=object :TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.i("result","Iteracion.... ")
                vm.change(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        }

        textbox.editText?.addTextChangedListener(_watcher)

        vm.cadena.observe(this, Observer {
            textbox.editText?.setText(it.toString())
            textbox.editText?.setSelection(it.length)
        })

    }

}