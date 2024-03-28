package com.example.adv160421001week6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160421001week6.databinding.FoodListItemBinding
import com.example.adv160421001week6.model.Food

class FoodListAdapter(val foodList:ArrayList<Food>)
    :RecyclerView.Adapter<FoodListAdapter.FoodViewHodler>()
{
    class FoodViewHodler(var binding: FoodListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHodler {
        val binding = FoodListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return FoodViewHodler(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHodler, position: Int) {
        holder.binding.txtID.text = foodList[position].id
        holder.binding.txtName.text = foodList[position].name
        holder.binding.txtDesc.text = foodList[position].description
        holder.binding.txtIngredients.text = foodList[position].ingredients?.joinToString(", ")

        holder.binding.txtCalories.text = "Calories: " + foodList[position].nutrition?.calories
        holder.binding.txtProtein.text = "Protein: " + foodList[position].nutrition?.protein
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun updateFoodList(newFoodList: ArrayList<Food>) {
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }
}