package com.udacity.shoestore.screens.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListingViewModel: ViewModel()
{
	private lateinit var _shoeList: MutableLiveData<MutableList<Shoe>>
	val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

	init
	{
		createInitialShoeList()
	}

	fun addShoe(shoe: Shoe)
	{
		_shoeList.value?.add(shoe)
	}

	private fun createInitialShoeList()
	{
		_shoeList = MutableLiveData<MutableList<Shoe>>().apply {
			value = mutableListOf(
				Shoe("Shoe 1", 13.0, "Brand 1", "Awesome shoes"),
				Shoe("Shoe 3", 14.0, "Brand 3", "Awesome shoes"),
				Shoe("Shoe 2", 15.0, "Brand 2", "Awesome shoes"),
				Shoe("Shoe 13", 123.0, "Brand 1", "Awesome shoes")
			)
		}
	}

}