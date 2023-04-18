package com.eraybulut.noteapp.ui.add

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentAddNoteBinding
import com.eraybulut.noteapp.model.Note
import com.eraybulut.noteapp.service.Tools
import com.eraybulut.noteapp.utils.extensions.getTextString
import com.eraybulut.noteapp.utils.extensions.onClick
import com.eraybulut.noteapp.utils.extensions.showToast
import com.google.android.flexbox.FlexboxLayoutManager

class AddNoteFragment : BaseFragment<FragmentAddNoteBinding, AddNoteViewModel>(
    FragmentAddNoteBinding::inflate)
{
    override val viewModel by viewModels<AddNoteViewModel>()
    private var selectedMood : String? = null

    override fun onCreateFinished() {
        binding.currentDate.text = Tools().currentTime()


        setupRecyclerView()
    }

    override fun initializeListeners() {
        binding.addButton.onClick {
            checkEditText()
        }
    }

    override fun observeEvents() {}

    private fun checkEditText(){
        val title = binding.titleEditText.getTextString().capitalize()
        val note = binding.noteEditText.getTextString().capitalize()

        if (title.isBlank()) return requireContext().showToast(getString(R.string.emptyTitle))
        if (note.isBlank()) return requireContext().showToast(getString(R.string.emptyNote))
        if (selectedMood.isNullOrBlank()) return requireContext().showToast(getString(R.string.emptyMode))
        else saveNote(title = title,note = note, mood = selectedMood!!)
    }

    private fun saveNote(title : String, note : String, mood : String){
        val noteModel = Note(id = 0, title = title, note = note , mood = mood,date = Tools().currentTime())
        viewModel.addNote(note = noteModel)
        findNavController().popBackStack()
        requireContext().showToast(getString(R.string.noteSharedSuccessfully))
    }

    private fun setupRecyclerView(){
        val modeArrayList = ArrayList<String>()
        modeArrayList.add(getString(R.string.modeHappy))
        modeArrayList.add(getString(R.string.modeSad))
        modeArrayList.add(getString(R.string.modeNotr))
        modeArrayList.add(getString(R.string.modeInspiration))
        modeArrayList.add(getString(R.string.modeStar))
        modeArrayList.add(getString(R.string.modeApplicationIdea))


        binding.modeRecyclerView.apply {
            layoutManager = FlexboxLayoutManager(requireContext())
            adapter = ModeAdapter(modeArrayList, object : ModeItemClickListener{
                override fun onItemClick(mode: String) {
                  selectedMood = mode
                }
            })
        }
    }

}