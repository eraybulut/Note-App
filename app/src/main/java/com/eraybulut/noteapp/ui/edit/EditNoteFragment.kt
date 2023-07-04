package com.eraybulut.noteapp.ui.edit

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentEditNoteBinding
import com.eraybulut.noteapp.model.Note
import com.eraybulut.noteapp.utils.Tools
import com.eraybulut.noteapp.utils.extensions.getTextString
import com.eraybulut.noteapp.utils.extensions.shareText
import com.eraybulut.noteapp.utils.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        binding.deleteNoteButton.setOnClickListener {
            viewModel.deleteNote(args.currentNote)
            findNavController().popBackStack()
        }

        binding.updateButton.setOnClickListener {
            checkEditText()
        }

        binding.shareNoteButton.setOnClickListener {
            requireContext().shareText(note = args.currentNote)
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
        val noteModel = Note(args.currentNote.id,title,note,args.currentNote.mood,
            Tools().currentTime(),args.currentNote.backgroundColor)

        viewModel.updateNote(noteModel)
        requireContext().showToast(getString(R.string.updatedNote))
        findNavController().popBackStack()
    }
}