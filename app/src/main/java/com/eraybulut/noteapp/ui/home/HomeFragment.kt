package com.eraybulut.noteapp.ui.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentHomeBinding
import com.eraybulut.noteapp.model.Note
import com.eraybulut.noteapp.utils.SwipeToDeleteCallback
import com.eraybulut.noteapp.utils.extensions.gone
import com.eraybulut.noteapp.utils.extensions.shareText
import com.eraybulut.noteapp.utils.extensions.showToast
import com.eraybulut.noteapp.utils.extensions.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>(
    FragmentHomeBinding::inflate
) {

    private lateinit var noteAdapter: NoteAdapter
    override val viewModel by viewModels<HomeFragmentViewModel>()

    override fun onCreateFinished() {
        setupHomeRecyclerView()
        setupSwipeToView()
    }

    override fun initializeListeners() {
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.home_to_addNoteFragment)
        }
    }

    override fun observeEvents() {
        lifecycleScope.launch {
            viewModel.readAllData().collect{ noteData ->
                if (noteData.isEmpty()){
                    binding.lytDontHaveANote.visible()
                }
                else {
                    noteAdapter.setData(ArrayList(noteData))
                    binding.lytDontHaveANote.gone()
                }
            }
        }
    }

    private fun setupHomeRecyclerView() {
        noteAdapter = NoteAdapter(object : NoteItemClickListener {
            override fun onItemClick(note: Note) {
                val action = HomeFragmentDirections.homeToEditNoteFragment(currentNote = note)
                findNavController().navigate(action)
            }

            override fun onDeleteItem(note: Note,position : Int) {
                viewModel.deleteNote(note = note)
                requireContext().showToast(getString(R.string.deleteNotedSuccessfully))
            }

            override fun onShareItem(note: Note) {
                requireContext().shareText(note = note)
            }
        })
    }

    private fun setupSwipeToView() = with(binding) {
        val swipeToDeleteCallback = SwipeToDeleteCallback(noteAdapter)
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)

        noteRecyclerView.apply {
            adapter = noteAdapter
            itemTouchHelper.attachToRecyclerView(this)
        }
    }
}