package com.example.movieticketorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.movieticketorder.databinding.ActivitySecondBinding

class Activity_second : AppCompatActivity() {

    private lateinit var MovieRecyclerView: RecyclerView
    private lateinit var MovieList: ArrayList<Movie>
    lateinit var imageId:Array<Int>
    lateinit var title:Array<String>
    lateinit var description:Array<String>
    lateinit var Director : Array<String>
    lateinit var genres : List<String>
    lateinit var MovieGenre : Array<ArrayList<String>>


    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        with(binding) {
            user.text = name
        }

        imageId= arrayOf(
            R.drawable.all_quite_in_the_western_front,
            R.drawable.suzume,
            R.drawable.barbie,
            R.drawable.balerina,
            R.drawable.interstellar,
            R.drawable.oppenheimer,
            R.drawable.bullet_train,
            R.drawable.tennet,
        )
        genres= listOf<String>(
            "Action", // 0
            "Adventure", // 1
            "Slice Of Life", // 2
            "Sci-Fi", // 3
            "Romance", // 4
            "Supranatural", // 5
            "Comedy", // 6
            "Military", // 7
            "Fantasy", // 8
            "Psicological", // 9
            "History" // 10
        )

        MovieGenre= arrayOf(
            arrayListOf(genres[7],genres[0],genres[9]),
            arrayListOf(genres[1],genres[5],genres[8]),
            arrayListOf(genres[7],genres[6],genres[0]),
            arrayListOf(genres[0],genres[9],genres[1]),
            arrayListOf(genres[3],genres[0],genres[9]),
            arrayListOf(genres[10],genres[7],genres[2]),
            arrayListOf(genres[0],genres[6],genres[1]),
            arrayListOf(genres[0],genres[5],genres[7]),
        )

        title=resources.getStringArray(R.array.title)
        description=resources.getStringArray(R.array.description)
        Director=resources.getStringArray(R.array.Director)


        MovieRecyclerView=findViewById(R.id.list_movie)

        MovieList= arrayListOf<Movie>()
        getUserData()
    }
    private fun getUserData(){
        for (i in imageId.indices){

            val movies = Movie(imageId[i],title[i],description[i] , MovieGenre[i],Director[i])
            MovieList.add(movies)
        }

        val adapter=MovieAdapter(MovieList)
        MovieRecyclerView.adapter= adapter
    }

}
