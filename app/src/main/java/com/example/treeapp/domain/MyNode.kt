package com.example.treeapp.domain

import kotlinx.serialization.Serializable


@Serializable
data class MyNode (
    val name: String,
    val parent: MyNode?,
    val children: ArrayList<MyNode>
)