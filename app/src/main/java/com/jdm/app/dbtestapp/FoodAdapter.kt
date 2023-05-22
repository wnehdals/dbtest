package com.jdm.app.dbtestapp

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jdm.app.dbtestapp.databinding.ItemFoodBinding
import com.jdm.app.dbtestapp.entity.FoodEntity

class FoodAdapter(
    private val onClickDelete: (FoodEntity) -> Unit,
    private val onClickEdit: (FoodEntity) -> Unit
): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private val foodList = mutableListOf<FoodEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = foodList[position]
        holder.bindView(item, position)
        holder.binding.foodDelete.setOnClickListener { onClickDelete(item) }
        holder.binding.foodEdit.setOnClickListener { onClickEdit(item) }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
    fun addData(data: List<FoodEntity>) {
        foodList.clear()
        foodList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemFoodBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: FoodEntity, pos: Int) {
            binding.foodTitle.text = item.name
            binding.foodKcal.text = "${item.kcal} kcal"
        }
    }
}