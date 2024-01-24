package net.pangos.ididit.ui.settings

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.pangos.ididit.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    companion object{
        private val TAG = SettingsFragment::class.simpleName
    }

    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val items: ArrayList<String> = ArrayList()
    private var rvAdapter:ChecklistsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this)[SettingsViewModel::class.java]

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val setting1: Button = binding.manageChecklistsBtn
        setting1.setOnClickListener{
            Log.d(TAG, "Testing intent here")

            val gotoChecklistsActivity = Intent(this.activity, ChecklistsActivity::class.java)
            startActivity(gotoChecklistsActivity)

            Log.d(TAG, "Testing intent here")
        }

        //val textView: TextView = binding.textSettings
        //notificationsViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}

        /* remove me
        val faButton: FloatingActionButton = binding.btnAdd
        faButton.setOnClickListener{
            // [TODO] try new way
            //val intent = Intent(this, AddActivity::class.java)
            //startActivity(intent)
            addItemAction(editText)
        }
        faButton.setOnLongClickListener{
            removeItemAction()
        }
         */

        return root
    }

    private fun addItemAction(txt: TextView){
        Toast.makeText(this.context, "You entered: " + txt.text, Toast.LENGTH_SHORT).show()

        val item = txt.text.toString()
        // Unlike ListView, no need to change via adapter
        // just a data at the data source
        val len = rvAdapter?.itemCount
        // then notify the adapter about it
        if (null != len) {
            items.add(item)
            rvAdapter?.notifyItemInserted(len)
            // also clean up the existing textview
            txt.text = ""
        }else{
            Log.d(TAG, "ERROR")
        }
    }
    private fun removeItemAction(): Boolean{
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // [NOTE] This won't work. onClick works only for activities, not fragments
    //fun onAddItem(view: View) {
    //    Toast.makeText(view.context, "You clicked!", Toast.LENGTH_SHORT).show()
    //}
}