package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment()
{

	var binding: FragmentInstructionsBinding? = null

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View?
	{
		// Inflate the layout for this fragment
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions,
			container, false)

		binding?.continueToListButton?.setOnClickListener { openShoeListing(it) }

		return binding?.root
	}

	private fun openShoeListing(view: View)
	{
		val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoesListing()
		view.findNavController().navigate(action)
	}


}