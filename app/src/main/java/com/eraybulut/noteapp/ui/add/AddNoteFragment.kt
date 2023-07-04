package com.eraybulut.noteapp.ui.add

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.common.BaseFragment
import com.eraybulut.noteapp.databinding.FragmentAddNoteBinding
import com.eraybulut.noteapp.model.Note
import com.eraybulut.noteapp.utils.Tools
import com.eraybulut.noteapp.utils.extensions.getTextString
import com.eraybulut.noteapp.utils.extensions.showToast
import com.google.android.flexbox.FlexboxLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding, AddNoteViewModel>(
    FragmentAddNoteBinding::inflate)
{
    override val viewModel by viewModels<AddNoteViewModel>()
    private lateinit var modeAdapter : ModeAdapter
    private lateinit var colorAdapter : ColorAdapter
    private var selectedMood : String? = null
    private var selectedBackgroundColor : Int? = null

    override fun onCreateFinished() {
        binding.currentDate.text = Tools().currentTime()

        setupModeRecyclerView()
        setupColorRecyclerView()
    }

    override fun initializeListeners() {
        binding.addButton.setOnClickListener {
            checkEditText()
        }
    }

    override fun observeEvents() {}

    private fun checkEditText() {
        val title = binding.titleEditText.getTextString()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
        val note = binding.noteEditText.getTextString()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

        if (title.isBlank()) return requireContext().showToast(getString(R.string.emptyTitle))
        if (note.isBlank()) return requireContext().showToast(getString(R.string.emptyNote))
        if (selectedMood.isNullOrBlank()) return requireContext().showToast(getString(R.string.emptyMode))
        else saveNote(title = title, note = note, mood = selectedMood?:getString(R.string.modeNotr), color= selectedBackgroundColor?:R.color.white)
    }

    private fun saveNote(title : String, note : String, mood : String,color : Int){
        val noteModel = Note(id = 0, title = title, note = note , mood = mood,date = Tools().currentTime(),color)
        viewModel.addNote(note = noteModel)
        findNavController().popBackStack()
        requireContext().showToast(getString(R.string.noteSharedSuccessfully))
    }

    private fun setupModeRecyclerView(){
        val modeList = listOf(
            getString(R.string.modeHappy),
            getString(R.string.modeSad),
            getString(R.string.modeNotr),
            getString(R.string.modeInspiration),
            getString(R.string.modeStar),
            getString(R.string.modeApplicationIdea),
            getString(R.string.modeWork),
            getString(R.string.modeHoliday)
        )

        modeAdapter = ModeAdapter().apply {
            addModeList(modeList)

            setOnClickListener { mode ->
                selectedMood = mode
            }
        }

        binding.modeRecyclerView.apply {
            layoutManager = FlexboxLayoutManager(requireContext())
            adapter = modeAdapter
        }
    }

    private fun setupColorRecyclerView(){
        val colorList = listOf(
            R.color.white,
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6,
            R.color.color7,
            R.color.color8,
            R.color.color9,
        )

        colorAdapter = ColorAdapter(object : ColorItemClickListener{
            override fun onColorItemClick(color: Int) {
                selectedBackgroundColor = color
            }
        })

        colorAdapter.addColorList(colorList)

        binding.colorRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = colorAdapter
        }
    }

}