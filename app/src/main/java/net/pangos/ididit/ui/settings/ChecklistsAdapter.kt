package net.pangos.ididit.ui.settings

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import net.pangos.ididit.R

class ChecklistsAdapter(private val dataset: MutableList<String>): RecyclerView.Adapter<ChecklistsAdapter.ViewHolder>() {
    private val TAG = "CustomAdapter"

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener, OnLongClickListener {
        val textView: TextView = itemView.findViewById(R.id.rowTextView)

        init {
            // Define click listener for the ViewHolder's View
            //textView = itemView.findViewById(R.id.rowTextView)
            itemView.setOnClickListener{
                Log.d("Testing", "Clicked: $adapterPosition")
            }

            // you have to attach the adatper thereby listeners to the entire row views
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d(TAG, "clicked!")
            val pos = adapterPosition
            if (RecyclerView.NO_POSITION != pos) {
                val checklist = dataset[pos]
                Toast.makeText(v?.context, textView.text, Toast.LENGTH_SHORT).show()
            }
        }

        override fun onLongClick(v: View?): Boolean {
            Log.d(TAG, "long clicked!")
            val pos = adapterPosition
            if (RecyclerView.NO_POSITION != pos) {
                dataset.removeAt(pos)
                notifyItemRemoved(pos)
                Toast.makeText(v?.context, "Removed at $pos!", Toast.LENGTH_SHORT).show()
                return true
            }
            return false
        }
    }

    // ... constructor and member variables
    // Create new views (invoked by the layout manager). Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.checklist_row_item, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.textView.text = dataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataset.size

}