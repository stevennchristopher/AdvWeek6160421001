package com.example.adv160421001week6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adv160421001week6.R
import com.example.adv160421001week6.databinding.FragmentFoodListBinding
import com.example.adv160421001week6.viewmodel.ListViewModel

class FoodListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val foodListAdapter  = FoodListAdapter(arrayListOf())
    private lateinit var binding: FragmentFoodListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = foodListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.foodLivesData.observe(viewLifecycleOwner, Observer {
            foodListAdapter.updateFoodList(it)
        })
    }

}