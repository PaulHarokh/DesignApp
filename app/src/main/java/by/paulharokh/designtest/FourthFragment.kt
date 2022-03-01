package by.paulharokh.designtest

import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.paulharokh.designtest.databinding.FragmentFourthBinding


class FourthFragment : Fragment(), View.OnTouchListener {

    private var t: Float = -1.0f
    private var m: Float = -1.0f
    private var _fourthBinding: FragmentFourthBinding? = null
    private val fourthBinding get() = _fourthBinding!!
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fourthBinding = FragmentFourthBinding.inflate(inflater, container, false)
        return fourthBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        fourthBinding.cl.setOnTouchListener(this)

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

        if (t > 0.0f && m > 0.0f && t + 200 < m) {
            navController.navigate(R.id.thirdFragment)
            exitTransition = tInflater.inflateTransition(R.transition.slide_right)
        } else {
            m = -1.0f
        }

        return true
    }

}
