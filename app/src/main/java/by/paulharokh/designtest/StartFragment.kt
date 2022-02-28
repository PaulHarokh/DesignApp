package by.paulharokh.designtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.paulharokh.designtest.databinding.FragmentStartBinding


class StartFragment : Fragment() {


    private var _startBinding: FragmentStartBinding? = null
    private val startBinding get() = _startBinding!!
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _startBinding = FragmentStartBinding.inflate(inflater, container, false)
        return startBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = "Алина"

        val formatString: String = activity!!.applicationContext.getString(R.string.greetings)
        val substitutedString = String.format(
            formatString,
            username
        )

        startBinding.tvGreetings.text = substitutedString

        val services = listOf(
            Service(R.drawable.woman_grey, getText(R.string.laser) as String),
            Service(R.drawable.woman_blue,getText(R.string.laser) as String),
            Service(R.drawable.woman_grey, getText(R.string.laser) as String),
            Service(R.drawable.woman_blue,getText(R.string.laser) as String),
            Service(R.drawable.woman_grey, getText(R.string.laser) as String),
            Service(R.drawable.woman_blue,getText(R.string.laser) as String),
            )

        startBinding.rvServices.adapter = ServiceAdapter(services)

        navController = view.findNavController()

        startBinding.cvAva.setOnClickListener{
            navController.navigate(R.id.profileFragment)
        }

        startBinding.tvGreetings.setOnClickListener{
            navController.navigate(R.id.profileFragment)
        }

    }

}
