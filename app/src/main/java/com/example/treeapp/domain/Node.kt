package com.example.treeapp.domain

data class Node (
    val name: String,
    val parent: Node?,
    val children: MutableList<Node>
)