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
import by.paulharokh.designtest.databinding.FragmentSecondBinding


class SecondFragment : Fragment(), View.OnTouchListener {

    private var t: Float = -1.0f
    private var m: Float = -1.0f
    private var _secondBinding: FragmentSecondBinding? = null
    private val secondBinding get() = _secondBinding!!
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _secondBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return secondBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        secondBinding.cl.setOnTouchListener(this)

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
            navController.navigate(R.id.thirdFragment)
            exitTransition = tInflater.inflateTransition(R.transition.slide_left)
        } else {
            if (t > 0.0f && m > 0.0f && t + 200 < m) {
                navController.navigate(R.id.startFragment)
                exitTransition = tInflater.inflateTransition(R.transition.slide_right)
            } else {
                m = -1.0f
            }
        }



        return true
    }

}