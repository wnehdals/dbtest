package com.jdm.app.dbtestapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdm.app.dbtestapp.entity.FoodEntity
import com.jdm.app.dbtestapp.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val foodRepository: FoodRepository
    ) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _foodList: MutableLiveData<List<FoodEntity>> = MutableLiveData()
    val foodList: LiveData<List<FoodEntity>> get() = _foodList

    fun getFoodList() {
        foodRepository.loadAllFoodEntity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _foodList.value = it
            }, {

            }).addTo(compositeDisposable)
    }
    fun insertFoodEntity(foodEntity: FoodEntity) {
        foodRepository.insertFoodEntity(foodEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getFoodList()
            },{

            }).addTo(compositeDisposable)
    }
    fun updateFoddEntity(foodEntity: FoodEntity) {
        foodRepository.updateFoodEntity(foodEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getFoodList()
            },{

            }).addTo(compositeDisposable)
    }
    fun deleteFoodEntity(foodEntity: FoodEntity) {
        foodRepository.deleteFoodEntity(foodEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getFoodList()
            }, {

            })
    }

    override fun onCleared() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
        super.onCleared()
    }

}