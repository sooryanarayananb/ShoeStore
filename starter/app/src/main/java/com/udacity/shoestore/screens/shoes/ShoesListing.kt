package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListingBinding
import com.udacity.shoestore.models.Shoe
import java.lang.StringBuilder


class ShoesListing : Fragment()
{

	private lateinit var binding: FragmentShoesListingBinding
	private lateinit var viewModel: ShoeListingViewModel
	private val args: ShoesListingArgs by navArgs()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View?
	{
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_listing, container,
		false)
		viewModel = ViewModelProvider(requireActivity()).get(ShoeListingViewModel::class.java)
		setHasOptionsMenu(true)

		val shoe = args.newShoe
		if(shoe != null)
		{
			viewModel.addShoe(shoe)
		}

		viewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
			displayShoeList(shoeList)
		})

		binding.addShoeActionButton.setOnClickListener { openAddShoeLayout(it) }

		return binding.root
	}

	private fun openAddShoeLayout(view: View)
	{
		val action = ShoesListingDirections.actionShoesListingToAddShoeFragment()
		view.findNavController().navigate(action)
	}


	private fun displayShoeList(shoeList: MutableList<Shoe>)
	{
		shoeList.iterator().forEach { shoe ->
			val shoeText = TextView(requireContext())
			shoeText.text = StringBuilder().append("\nShoe Name: ${shoe.name}"
					+ "\nCompany: ${shoe.company}" + "\nSize: ${shoe.size}"
					+ "\nDescription: ${shoe.description}")
			binding.shoeListLinearLayout.addView(shoeText)
		}
	}


	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
		inflater.inflate(R.menu.main_menu, menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
				|| super.onOptionsItemSelected(item)
	}
}