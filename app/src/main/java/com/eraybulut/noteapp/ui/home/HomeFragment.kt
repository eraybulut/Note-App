package com.eraybulut.noteapp.ui.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentHomeBinding
import com.eraybulut.noteapp.model.Note
import com.eraybulut.noteapp.service.SwipeToDeleteCallback
import com.eraybulut.noteapp.service.Tools
import com.eraybulut.noteapp.utils.extensions.onClick
import com.eraybulut.noteapp.utils.extensions.showToast

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(
    FragmentHomeBinding::inflate)
{

    private lateinit var noteAdapter: HomeNoteAdapter
    override val viewModel by viewModels<HomeFragmentViewModel>()

    override fun onCreateFinished() {

        noteAdapter = HomeNoteAdapter(object : NoteItemClickListener{
            override fun onItemClick(note: Note) {
                val action = HomeFragmentDirections.homeToEditNoteFragment(currentNote = note)
                findNavController().navigate(action)
            }

            override fun onDeleteItem(note: Note) {
                viewModel.deleteNote( note = note)
                requireContext().showToast(getString(R.string.deleteNotedSuccessfully))
            }

            override fun onShareItem(note: Note) {
                Tools().shareText(requireContext(), note = note)
            }
        })


        val swipeToDeleteCallback = SwipeToDeleteCallback(noteAdapter)
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        binding.noteRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
            itemTouchHelper.attachToRecyclerView(this)
        }
    }

    override fun initializeListeners() {
        binding.floatingActionButton.onClick {
            findNavController().navigate(R.id.home_to_addNoteFragment)
        }
    }

    override fun observeEvents() {
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
           noteAdapter.setData(ArrayList(it))
        })


    }
}