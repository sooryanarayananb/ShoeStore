package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment()
{
	var binding: FragmentLoginBinding? = null

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View?
	{
		binding = DataBindingUtil.inflate(inflater,
			R.layout.fragment_login, container, false)
		// Inflate the layout for this fragment
		binding?.loginButton?.setOnClickListener { view ->
			onLoginClick(view)
		}
		return binding?.root
	}

	private fun onLoginClick(v: View)
	{
		val userName = binding?.userNameEditText?.text.toString()
		val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(userName)
		v.findNavController().navigate(action)
	}

}