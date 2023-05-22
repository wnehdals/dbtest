package com.jdm.app.dbtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.jdm.app.dbtestapp.databinding.ActivityMainBinding
import com.jdm.app.dbtestapp.entity.FoodEntity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import com.jdm.app.dbtestapp.DBTestApp.Companion.pref

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val foodAdapter by lazy { FoodAdapter(this::onClickDelete, this::onClickEdit) }
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tvPlus.setOnClickListener {
            InputDialog(null, this::onClickAdd).show(supportFragmentManager, "")
            Log.e("jdm_Tag", "${pref.getIntValue("food")}")
        }
        binding.rvFood.adapter = foodAdapter

        mainViewModel.foodList.observe(this) {
            foodAdapter.addData(it)
        }
        mainViewModel.getFoodList()
    }

    private fun onClickDelete(foodEntity: FoodEntity) {
        mainViewModel.deleteFoodEntity(foodEntity)
    }
    private fun onClickEdit(foodEntity: FoodEntity) {
        InputDialog(foodEntity, this::updateFood).show(supportFragmentManager, "")
    }
    private fun onClickAdd(previousFood: FoodEntity?, newFoodEntity: FoodEntity) {

        mainViewModel.insertFoodEntity(newFoodEntity)
    }
    private fun updateFood(previousFood: FoodEntity?, newFoodEntity: FoodEntity) {
        if (previousFood != null) {
            newFoodEntity.id = previousFood.id
        }
        mainViewModel.updateFoddEntity(newFoodEntity)
    }
}