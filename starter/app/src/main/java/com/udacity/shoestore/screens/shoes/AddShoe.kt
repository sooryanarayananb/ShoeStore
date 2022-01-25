package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe


class AddShoe : Fragment()
{
	lateinit var binding: FragmentAddShoeBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View?
	{
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container,
		false)

		binding.addShoeButton.setOnClickListener {
			openShoeListingPage()
		}

		return binding.root
	}

	private fun openShoeListingPage()
	{
		val shoeName = binding.shoeNameEditText.text.toString()
		val shoeSize = binding.shoeSizeEditText.text.toString().toDouble()
		val shoeCompany = binding.companyEditText.text.toString()
		val shoeDescription = binding.descriptionEditText.text.toString()

		val action = AddShoeDirections.actionAddShoeFragmentToShoesListing(Shoe(shoeName,
			shoeSize, shoeCompany, shoeDescription))
		this.findNavController().navigate(action)

	}

}