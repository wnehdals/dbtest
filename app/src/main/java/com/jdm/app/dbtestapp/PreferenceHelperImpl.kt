package com.jdm.app.dbtestapp

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferenceHelperImpl(appContext: Context){
    private val TAG = this.javaClass.simpleName
    private val prefName = "dbtest"

    private val preference: SharedPreferences = appContext.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    /**
     * get
     */

    fun getStrValue(key: String): String {
        return preference.getString(key, "")!!
    }
    fun getIntValue(key: String): Int {
        return preference.getInt(key, 0)
    }
    fun getFloatValue(key: String): Float {
        return preference.getFloat(key, 0f)
    }
    fun getBooleanValue(key: String): Boolean {
        return preference.getBoolean(key, false)
    }

    fun setPreference(key: String, nValue: Int): Boolean {
        val edit = preference.edit()
        edit.putInt(key, nValue)
        return edit.commit()
    }

    fun setPreference(key: String, value: Long): Boolean {
        val edit = preference.edit()
        edit.putLong(key, value)
        return edit.commit()
    }

    fun setPreference(key: String, strValue: String?): Boolean {
        val edit = preference.edit()
        edit.putString(key, strValue)
        return edit.commit()
    }

    fun setPreference(key: String, strValue: Boolean): Boolean {
        val edit = preference.edit()
        edit.putBoolean(key, strValue)
        return edit.commit()
    }

    fun setPreference(key: String, value: Float): Boolean {
        val edit = preference.edit()
        edit.putFloat(key, value)
        return edit.commit()
    }

}