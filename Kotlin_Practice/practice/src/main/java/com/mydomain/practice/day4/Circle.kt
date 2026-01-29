package com.mydomain.practice.day4

import kotlin.math.PI

class Circle(val radius: Double): Shape() {

    override fun Area(): Double {
        return PI*radius*radius
    }

    override fun Perimeter(): Double {
        return 2*PI*radius
    }
}