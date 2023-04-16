package com.eraybulut.noteapp.ui.fragment.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentHomeBinding
import com.eraybulut.noteapp.utils.extensions.onClick
import com.eraybulut.noteapp.utils.extensions.showToast


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(
    FragmentHomeBinding::inflate)
{
    override val viewModel by viewModels<HomeFragmentViewModel>()

    override fun onCreateFinished() {
        binding.noteRecyclerView.apply {
            
        }
    }

    override fun initializeListeners() {
        binding.floatingActionButton.onClick {
            findNavController().navigate(R.id.home_to_addNoteFragment)
        }
    }

    override fun observeEvents() {
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
            Log.e("KEY",it.toString())
        })
    }
}