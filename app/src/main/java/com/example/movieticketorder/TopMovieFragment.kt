package com.example.movieticketorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieticketorder.databinding.FragmentTopMovieBinding

class TopMovieFragment : Fragment() {

    private lateinit var MovieRecyclerView: RecyclerView
    private lateinit var MovieList: ArrayList<Movie>
    lateinit var imageId: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var Director: Array<String>
    lateinit var genres: List<String>
    lateinit var MovieGenre: Array<ArrayList<String>>

    private var _binding: FragmentTopMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopMovieBinding.inflate(inflater, container, false)
        val view = binding.root

        val name = arguments?.getString(MainActivity.EXTRA_NAME)
        name?.let { binding.user.text = it }

        imageId = arrayOf(
            R.drawable.all_quite_in_the_western_front,
            R.drawable.suzume,
            R.drawable.barbie,
            R.drawable.balerina,
            R.drawable.interstellar,
            R.drawable.oppenheimer,
            R.drawable.bullet_train,
            R.drawable.tennet
        )

        genres = listOf(
            "Action",
            "Adventure",
            "Slice Of Life",
            "Sci-Fi",
            "Romance",
            "Supernatural",
            "Comedy",
            "Military"
        )

        MovieGenre = arrayOf(
            arrayListOf(genres[0], genres[3], genres[7]),
            arrayListOf(genres[1], genres[5], genres[6]),
            arrayListOf(genres[1], genres[2], genres[5]),
            arrayListOf(genres[2], genres[3], genres[7]),
            arrayListOf(genres[3], genres[4], genres[8]),
            arrayListOf(genres[3], genres[5], genres[9]),
            arrayListOf(genres[0], genres[6], genres[9]),
            arrayListOf(genres[0], genres[4], genres[7])
        )

        title = resources.getStringArray(R.array.title)
        description = resources.getStringArray(R.array.description)
        Director = resources.getStringArray(R.array.Director)

        MovieRecyclerView = binding.listMovie
        MovieList = arrayListOf<Movie>()
        getUserData()

        return view
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val movie = Movie(imageId[i], title[i], description[i], MovieGenre[i], Director[i])
            MovieList.add(movie)
        }

        val adapter = MovieAdapter(MovieList)
        MovieRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
