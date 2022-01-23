package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R


class ShoesListing : Fragment()
{

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View?
	{
		// Inflate the layout for this fragment
		setHasOptionsMenu(true)
		return inflater.inflate(R.layout.fragment_shoes_listing, container, false)
	}

	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
		inflater.inflate(R.menu.main_menu, menu)
	}

//	override fun onOptionsItemSelected(item: MenuItem): Boolean {
//		return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//				|| super.onOptionsItemSelected(item)
//	}
}