package by.paulharokh.designtest

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.paulharokh.designtest.databinding.FragmentStartBinding


class StartFragment : Fragment(), View.OnTouchListener {

    private var t: Float = -1.0f
    private var m: Float = -1.0f
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
            Service(R.drawable.woman_blue, getText(R.string.laser) as String),
            Service(R.drawable.woman_grey, getText(R.string.laser) as String),
            Service(R.drawable.woman_blue, getText(R.string.laser) as String),
            Service(R.drawable.woman_grey, getText(R.string.laser) as String),
            Service(R.drawable.woman_blue, getText(R.string.laser) as String),
        )

        startBinding.rvServices.adapter = ServiceAdapter(services)

        navController = view.findNavController()

        startBinding.cl.setOnTouchListener(this)

        startBinding.cvAva.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }

        startBinding.tvGreetings.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }



    }

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        view?.performClick()

        val tInflater = TransitionInflater.from(requireContext())

        if (event?.action == MotionEvent.ACTION_DOWN) {
            t = event.x
            Log.d("!!!t", t.toString())
        }

        if (event?.action == MotionEvent.ACTION_MOVE) {
            m = event.x
            Log.d("!!!m", m.toString())

        }

        if (t > 0.0f && m > 0.0f && t > m + 200) {
            navController.navigate(R.id.secondFragment)
            exitTransition = tInflater.inflateTransition(R.transition.slide_left)

        } else {
            m = -1.0f

        }

        return true
    }

}
