package tech.neurothrone.recyclerviewwithviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import tech.neurothrone.recyclerviewwithviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  
  
  private val peopleList: List<String> = listOf(
    "Captain Zane",
    "Cookie",
    "First Mate Chuckles"
  )
//  private val peopleListAdapter = PeopleListAdapter(peopleList)
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    
    binding.peopleRecyclerView.layoutManager = LinearLayoutManager(this)
    binding.peopleRecyclerView.adapter = PeopleListAdapter(peopleList, onRowClicked = { personName ->
      Toast.makeText(
        this,
        "You clicked on $personName",
        Toast.LENGTH_SHORT
      ).show()
    })
  }
}