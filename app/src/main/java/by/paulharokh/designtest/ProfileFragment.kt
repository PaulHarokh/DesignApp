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
import by.paulharokh.designtest.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(), View.OnTouchListener {


    private var t: Float = -1.0f
    private var m: Float = -1.0f
    private var _profileBinding: FragmentProfileBinding? = null
    private val profileBinding get() = _profileBinding!!
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _profileBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return profileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        view.setOnTouchListener(this)

        val tInflater = TransitionInflater.from(requireContext())
        enterTransition = tInflater.inflateTransition(R.transition.slide_top)
        exitTransition = tInflater.inflateTransition(R.transition.slide_bottom)

    }


    override fun onTouch(view: View?, event: MotionEvent?): Boolean {
        view?.performClick()

        if (event?.action == MotionEvent.ACTION_DOWN) {
            t = event.y
        }

        if (event?.action == MotionEvent.ACTION_MOVE) {
            m = event.y
        }

        if (t > 0.0f && m > 0.0f && t+200 < m) {
            navController.navigate(R.id.startFragment)
        }else{
            m = -1.0f
        }

        return true
    }
}
