package com.eraybulut.noteapp.ui.fragment.home


import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentHomeBinding
import com.eraybulut.noteapp.utils.extensions.onClick

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(
    FragmentHomeBinding::inflate)
{

    private lateinit var noteAdapter: HomeNoteAdapter
    override val viewModel by viewModels<HomeFragmentViewModel>()

    override fun onCreateFinished() {
        binding.noteRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            noteAdapter = HomeNoteAdapter()
            adapter = noteAdapter
        }
    }

    override fun initializeListeners() {
        binding.floatingActionButton.onClick {
            findNavController().navigate(R.id.home_to_addNoteFragment)
        }
    }

    override fun observeEvents() {
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
           noteAdapter.setData(it)
        })
    }
}