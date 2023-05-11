package com.eraybulut.noteapp.ui.edit

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentEditNoteBinding
import com.eraybulut.noteapp.model.Note
import com.eraybulut.noteapp.service.Tools
import com.eraybulut.noteapp.utils.extensions.getTextString
import com.eraybulut.noteapp.utils.extensions.onClick
import com.eraybulut.noteapp.utils.extensions.showToast

class EditNoteFragment : BaseFragment<FragmentEditNoteBinding, EditNoteViewModel>(
    FragmentEditNoteBinding::inflate
) {

    private val args by navArgs<EditNoteFragmentArgs>()

    override val viewModel by viewModels<EditNoteViewModel>()

    override fun onCreateFinished() {
        binding.titleEditText.setText(args.currentNote.title)
        binding.noteEditText.setText(args.currentNote.note)
    }

    override fun initializeListeners() {
        binding.deleteNoteButton.onClick {
            viewModel.deleteNote(args.currentNote)
            findNavController().popBackStack()
        }

        binding.updateButton.onClick {
            checkEditText()
        }

        binding.shareNoteButton.onClick {
            Tools().shareText(requireContext(),args.currentNote)
        }
    }

    override fun observeEvents() {}

    private fun checkEditText(){
        val title = binding.titleEditText.getTextString()
        val notes = binding.noteEditText.getTextString()

        if (title.isBlank()) return requireContext().showToast(getString(R.string.emptyTitle))
        if (notes.isBlank()) return requireContext().showToast(getString(R.string.emptyNote))
        else updateNote(title = title, note = notes)
    }

    private fun updateNote(title : String,note : String){
        val noteModel = Note(args.currentNote.id,title,note,args.currentNote.mood,Tools().currentTime(),R.color.white)
        viewModel.updateNote(noteModel)
        requireContext().showToast(getString(R.string.updatedNote))
        findNavController().popBackStack()
    }
}