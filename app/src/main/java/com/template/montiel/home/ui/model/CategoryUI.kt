package com.template.montiel.home.ui.model

data class CategoryUI(
    var id: String,
    var description: String,
    var tickets: MutableList<String> = mutableListOf()
)