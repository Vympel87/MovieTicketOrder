package com.example.movieticketorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieticketorder.databinding.FragmentTopMovieBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TopMovieFragment : Fragment() {

    private lateinit var MovieRecyclerView: RecyclerView
    private lateinit var MovieList: ArrayList<Movie>
    lateinit var imageId: Array<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var Director: Array<String>
    lateinit var genres: List<String>
    lateinit var MovieGenre: Array<ArrayList<String>>
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentTopMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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
            arrayListOf(genres[3], genres[4], genres[7]),
            arrayListOf(genres[3], genres[5], genres[7]),
            arrayListOf(genres[0], genres[6], genres[7]),
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
