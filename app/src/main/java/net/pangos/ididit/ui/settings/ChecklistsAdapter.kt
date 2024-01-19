package net.pangos.ididit.ui.settings

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.pangos.ididit.R

class ChecklistsAdapter(private val dataset: List<String>): RecyclerView.Adapter<ChecklistsAdapter.ViewHolder>() {
    private val TAG = "CustomAdapter"

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.rowTextView)

        init {
            // Define click listener for the ViewHolder's View
            //textView = itemView.findViewById(R.id.rowTextView)
            itemView.setOnClickListener{
                Log.d("Testing", "Clicked: $adapterPosition")
            }
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