package com.example.treeapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.treeapp.R
import com.example.treeapp.domain.MyNode
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val temp = MyNode(
            name = "mainRoot",
            parent = null,
            children =  arrayListOf()
        )
        val str = Json.encodeToString(temp)
        val result = Json.decodeFromString<MyNode>(str)

        Log.i("serialization", str)

        Log.i("serialization", result.name)

        Log.i("serialization", result.toString())


    }
}