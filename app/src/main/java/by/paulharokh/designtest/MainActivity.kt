package by.paulharokh.designtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.paulharokh.designtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = "Алина"

        val formatString: String = applicationContext.getString(R.string.greetings)
        val substitutedString = String.format(
            formatString,
            username
        )

        binding.tvGreetings.text = substitutedString

        val services = listOf(
            Service(R.drawable.woman_grey, getText(R.string.laser) as String),
            Service(R.drawable.woman_blue,getText(R.string.laser) as String),
            Service(R.drawable.woman_grey, getText(R.string.laser) as String),
            Service(R.drawable.woman_blue,getText(R.string.laser) as String),

        )

        binding.rvServices.adapter = ServiceAdapter(services)


    }
}