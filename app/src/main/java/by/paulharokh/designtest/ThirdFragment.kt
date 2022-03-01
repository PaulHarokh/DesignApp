package by.paulharokh.designtest

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.paulharokh.designtest.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(), View.OnTouchListener {

    private var t: Float = -1.0f
    private var m: Float = -1.0f
    private var _thirdBinding: FragmentThirdBinding? = null
    private val thirdBinding get() = _thirdBinding!!
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _thirdBinding = FragmentThirdBinding.inflate(inflater, container, false)
        return thirdBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        thirdBinding.cl.setOnTouchListener(this)

    }

    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        view?.performClick()

        val tInflater = TransitionInflater.from(requireContext())

        if (event?.action == MotionEvent.ACTION_DOWN) {
            t = event.x
        }

        if (event?.action == MotionEvent.ACTION_MOVE) {
            m = event.x
        }

        if (t > 0.0f && m > 0.0f && t > m + 200) {
            navController.navigate(R.id.fourthFragment)
            exitTransition = tInflater.inflateTransition(R.transition.slide_left)
        } else {
            if (t > 0.0f && m > 0.0f && t + 200 < m) {
                navController.navigate(R.id.secondFragment)
                exitTransition = tInflater.inflateTransition(R.transition.slide_right)
            } else {
                m = -1.0f
            }
        }



        return true
    }


}