package com.eraybulut.noteapp.ui.fragment.add

import androidx.fragment.app.viewModels
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentAddNoteBinding
import com.eraybulut.noteapp.utils.extensions.getTextString
import com.eraybulut.noteapp.utils.extensions.onClick


class AddNoteFragment : BaseFragment<FragmentAddNoteBinding,AddNoteViewModel>(
    FragmentAddNoteBinding::inflate)
{
    override val viewModel by viewModels<AddNoteViewModel>()

    override fun onCreateFinished() {
        val title = binding.titleEditText.getTextString()
        val note = binding.noteEditText.getTextString()

        binding.addButton.onClick {
            viewModel.addNote(title,note)
        }
    }

    override fun initializeListeners() {

    }

    override fun observeEvents() {

    }

}