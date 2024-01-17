package net.pangos.ididit.ui.checklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.pangos.ididit.R
import net.pangos.ididit.databinding.FragmentChecklistBinding

class ChecklistFragment : Fragment() {

    private var _binding: FragmentChecklistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myViewModel =
            ViewModelProvider(this).get(ChecklistViewModel::class.java)

        _binding = FragmentChecklistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // [TODO] deprecated
        //val textView: TextView = binding.textChecklist
        //myViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}

        val listView: ListView = binding.listTasks
        val tasksList: Array<out String> = listView.resources.getStringArray(R.array.tasks)
        val listAdapter: ArrayAdapter<String> = ArrayAdapter(listView.context, android.R.layout.simple_list_item_1, tasksList)
        listView.adapter = listAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}