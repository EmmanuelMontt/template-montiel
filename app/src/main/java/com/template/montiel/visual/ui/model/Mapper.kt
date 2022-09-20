package com.template.montiel.visual.ui.model

interface Mapper<I, O> {
    fun map(input: I): O
}
