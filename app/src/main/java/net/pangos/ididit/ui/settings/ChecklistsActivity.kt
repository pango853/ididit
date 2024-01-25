package net.pangos.ididit.ui.settings

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.pangos.ididit.R
import net.pangos.ididit.databinding.ActivityChecklistsBinding
import net.pangos.ididit.static.ChecklistSamples

class ChecklistsActivity : AppCompatActivity() {
    companion object{
        private val TAG = ChecklistsActivity::class.simpleName
    }

    private lateinit var binding: ActivityChecklistsBinding

    private val items: ArrayList<String> = ArrayList()
    private var rvAdapter:ChecklistsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChecklistsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // [TODO] Use ActionBar or Toolbar instead
        //setSupportActionBar(binding.toolbar)

        //val navController = findNavController(R.id.nav_host_fragment_content_test001)
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)

        val rvChecklists: RecyclerView = binding.checklists.rvChecklists
        val file = ChecklistSamples.generate()
        for (checklist in file.checklists){
            items.add(checklist.name)
        }
        rvAdapter = ChecklistsAdapter(items)
        rvChecklists.adapter = rvAdapter
        // Set layout manager to position the items
        rvChecklists.layoutManager = LinearLayoutManager(this)
    }

    fun newBtnAction(view: View) {
        val builder = AlertDialog.Builder(view.context)
        // Get the layout inflater.
        builder.setView(this.layoutInflater.inflate(R.layout.dialog_newfile, null))
            .setPositiveButton(R.string.create, DialogInterface.OnClickListener{dialog, id ->
                // action 1
            })
            .setPositiveButton(R.string.cancel, DialogInterface.OnClickListener{dialog, id ->
                dialog.cancel()
            })
//        Toast.makeText(this, "You entered: " + txt.text, Toast.LENGTH_SHORT).show()
//
//        val item = txt.text.toString()
//        // Unlike ListView, no need to change via adapter
//        rvAdapter?.let{
//            // just add data at the data source
//            items.add(item)
//
//            // then notify the adapter about it
//            it.notifyItemInserted(it.itemCount)
//        }
//
//        // finally, also clean up the existing textview
//        txt.text = ""
    }
    private fun removeItemAction(): Boolean{
        return false
    }


}

/*
        val navController = findNavController(R.id.nav_host_fragment_content_test001)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

*
* */