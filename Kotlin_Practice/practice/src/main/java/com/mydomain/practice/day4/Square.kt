package com.mydomain.practice.day4

class Square(val side:Double): Shape() {
    override fun Area(): Double {
        return  side*side
    }

    override fun Perimeter(): Double {
        return  4*side
    }
}