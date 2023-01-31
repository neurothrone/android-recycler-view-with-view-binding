package tech.neurothrone.recyclerviewwithviewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleListAdapter(
  private val peopleList: List<String>,
  val onRowClicked: (personName: String) -> Unit
) : RecyclerView.Adapter<PeopleListAdapter.PersonRowViewHolder>() {
  
  class PersonRowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView: TextView = view.findViewById(R.id.name_text_view)
  }
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonRowViewHolder {
    val inflater = LayoutInflater.from(parent.context).inflate(R.layout.person_row, parent, false)
    return PersonRowViewHolder(inflater)
  }
  
  override fun getItemCount(): Int = peopleList.size
  
  override fun onBindViewHolder(holder: PersonRowViewHolder, position: Int) {
    val name = peopleList[position]
    
    holder.nameTextView.text = name
    holder.itemView.setOnClickListener {
      onRowClicked(name)
    }
  }
}