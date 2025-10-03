package com.ubai.lab_week_6

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ubai.lab_week_6.model.CatModel
import com.ubai.lab_week_6.model.Gender
import com.ubai.lab_week_6.model.CatBreed
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatViewHolder.OnClickListener {
                override fun onItemClick(cat: CatModel) {
                    showSelectionDialog(cat)
                }
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)


        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Luna",
                    "Mysterious night stalker",
                    "https://cdn2.thecatapi.com/images/5tx.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Simba",
                    "King of the couch",
                    "https://cdn2.thecatapi.com/images/8cj.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Oliver",
                    "Food enthusiast",
                    "https://cdn2.thecatapi.com/images/3bk.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Mittens",
                    "Professional napper",
                    "https://cdn2.thecatapi.com/images/4mn.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.BalineseJavanese,
                    "Shadow",
                    "Always watching",
                    "https://cdn2.thecatapi.com/images/9pq.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Leo",
                    "Gentle giant",
                    "https://cdn2.thecatapi.com/images/2rs.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Bella",
                    "Loves sunbeams",
                    "https://cdn2.thecatapi.com/images/1tu.jpg"
                )
            )
        )



    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}