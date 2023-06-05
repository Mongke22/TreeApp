package com.example.treeapp

data class Node (
    val name: String,
    val parent: Node?,
    val children: MutableList<Node>
)