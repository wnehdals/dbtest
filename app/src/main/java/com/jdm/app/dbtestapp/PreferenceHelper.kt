package com.jdm.app.dbtestapp

interface PreferenceHelper {
    fun setValue(value: Int)
    fun setValue(value: String)
    fun setValue(value: Float)
    fun setValue(value: Boolean)

    fun getStrValue(key: String): String
    fun getIntValue(key: String): Int
    fun getFloatValue(key: String): Float
    fun getBooleanValue(key: String): Boolean


}