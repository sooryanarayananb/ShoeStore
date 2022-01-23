package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.screens.login.LoginFragmentDirections


class WelcomeFragment : Fragment()
{

	var binding: FragmentWelcomeBinding? = null
	val args: WelcomeFragmentArgs by navArgs()


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View?
	{
		// Inflate the layout for this fragment
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome,
			container, false)

		binding?.continueButton?.setOnClickListener { onContinueButtonClick(it) }

		return binding?.root
	}


	override fun onViewCreated(view: View, savedInstanceState: Bundle?)
	{
		super.onViewCreated(view, savedInstanceState)
		val userName = args.userName
		binding?.currentUserText?.text = "Hi, $userName"
	}

	private fun onContinueButtonClick(view: View)
	{
		val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
		view.findNavController().navigate(action)
	}

}