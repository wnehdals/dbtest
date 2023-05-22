package com.jdm.app.dbtestapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.jdm.app.dbtestapp.databinding.InputDialogBinding
import com.jdm.app.dbtestapp.entity.FoodEntity

class InputDialog(
    private val previousFood: FoodEntity?,
    private val onClickConfirm: (FoodEntity?, FoodEntity) -> Unit
) : DialogFragment(){
    private var _binding: InputDialogBinding? = null
    val binding: InputDialogBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.input_dialog, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvInputNameConfirm.setOnClickListener {
            var name = binding.etInputNameTitle.text.toString()

            if (name.isNullOrEmpty()) {
                return@setOnClickListener
            }
            var kcal = binding.etInputNameKcal.text.toString()
            if (kcal.isNullOrEmpty() )
                return@setOnClickListener

            var foodEntity = FoodEntity(0, name, kcal.toInt())
            onClickConfirm(previousFood, foodEntity)
            dismiss()
        }
    }
}