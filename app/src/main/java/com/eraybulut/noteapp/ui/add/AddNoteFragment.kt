package com.eraybulut.noteapp.ui.add

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentAddNoteBinding
import com.eraybulut.noteapp.model.Note
import com.eraybulut.noteapp.service.Tools
import com.eraybulut.noteapp.utils.extensions.getTextString
import com.eraybulut.noteapp.utils.extensions.onClick
import com.eraybulut.noteapp.utils.extensions.setBackgroundColorRes
import com.eraybulut.noteapp.utils.extensions.showToast
import com.google.android.flexbox.FlexboxLayoutManager

class AddNoteFragment : BaseFragment<FragmentAddNoteBinding, AddNoteViewModel>(
    FragmentAddNoteBinding::inflate)
{
    override val viewModel by viewModels<AddNoteViewModel>()
    private var selectedMood : String? = null
    private var selectedBackgroundColor : Int? = null
    private lateinit var colorArrayList : ArrayList<Int>

    override fun onCreateFinished() {
        binding.currentDate.text = Tools().currentTime()

        setupRecyclerView()
        setupColorRecyclerView()
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
        else saveNote(title = title,note = note, mood = selectedMood!!,selectedBackgroundColor!!)
    }

    private fun saveNote(title : String, note : String, mood : String,color : Int){
        val noteModel = Note(id = 0, title = title, note = note , mood = mood,date = Tools().currentTime(),color)
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
        modeArrayList.add(getString(R.string.modeWork))


        binding.modeRecyclerView.apply {
            layoutManager = FlexboxLayoutManager(requireContext())
            adapter = ModeAdapter(modeArrayList, object : MoteItemClickListener{
                override fun onModeItemClick(mode: String) {
                  selectedMood = mode
                }
            })
        }
    }

    private fun setupColorRecyclerView(){
        colorArrayList = ArrayList<Int>()
        colorArrayList.add(R.color.white)
        colorArrayList.add(R.color.color1)
        colorArrayList.add(R.color.color2)
        colorArrayList.add(R.color.color3)
        colorArrayList.add(R.color.color4)
        colorArrayList.add(R.color.color5)
        colorArrayList.add(R.color.color6)
        colorArrayList.add(R.color.color7)
        colorArrayList.add(R.color.color8)
        colorArrayList.add(R.color.color9)


        binding.colorRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = ColorAdapter(colorArrayList,object : ColorItemClickListener{
                override fun onColorItemClick(color: Int) {
                    selectedBackgroundColor = color
                }
            })
        }


    }

}