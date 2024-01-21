package net.pangos.ididit.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import net.pangos.ididit.databinding.ActivityChecklistsBinding

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

    }

    private fun addItemAction(txt: TextView){
        Toast.makeText(this, "You entered: " + txt.text, Toast.LENGTH_SHORT).show()

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