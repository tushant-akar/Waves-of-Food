package com.example.wavesoffood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName = listOf(
        "Burger",
        "Sandwich",
        "Momos",
        "Pizza",
        "Brownie",
        "Sandwich",
        "Momos",
        "Pizza",
        "Brownie"
    )
    private val originalMenuItemPrice = listOf(
        "$5",
        "$7",
        "$9",
        "$10",
        "$15",
        "$7",
        "$9",
        "$10",
        "$15"
    )
    private val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu7,
        R.drawable.menu1,
        R.drawable.menu2,

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage,requireContext())
        binding.menuRecyclerView.layoutManager = (LinearLayoutManager(requireContext()))
        binding.menuRecyclerView.adapter = adapter
        //setup for search view
        setupSearchView()
        //show all menu items
        showAllMenu()
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuImage.clear()
        filteredMenuItemPrice.clear()
        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)
        adapter.notifyDataSetChanged()
    }
    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }
    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuImage.clear()
        filteredMenuItemPrice.clear()
        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query.toString(),ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }
}