package com.example.movieticketorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieticketorder.databinding.ActivityMovieDetailBinding

class MovieDetail : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var genreList: ArrayList<Genre>
    private lateinit var recyclerGenres: RecyclerView
    lateinit var genreArray : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("Title")
        val desciption = intent.getStringExtra("Description")
        val Director = intent.getStringExtra("Director")
        val image = intent.getIntExtra("Image_Movie",0)
        val genres = intent.getStringArrayListExtra("Genres")
        genreArray= genres as ArrayList<String>
        recyclerGenres=findViewById(R.id.recycler_genres)

        genreList= arrayListOf<Genre>()
        getGenreList()

        with(binding){
            titleMovie.text = title
            deskripsiMovie.text = desciption
            Glide.with(this@MovieDetail).load(image).into(imageDetailMovie)
            director.text=Director

            binding.btnOrder.setOnClickListener {
                val intent = Intent(this@MovieDetail,Order_Activity::class.java)
                intent.putExtra("Title",title)
                intent.putExtra("Image",image)
                startActivity(intent)
                finish()
            }

        }

    }
    private fun getGenreList(){
        for (i in genreArray.indices){
            val genre = Genre(genreArray[i])
            genreList.add(genre)
        }
        recyclerGenres.adapter=GenreAdapter(genreList)
    }
}