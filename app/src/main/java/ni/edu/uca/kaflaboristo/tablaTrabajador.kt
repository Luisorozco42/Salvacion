package ni.edu.uca.kaflaboristo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.kaflaboristo.databinding.ActivityTablaTrabajadorBinding

class tablaTrabajador : AppCompatActivity() {
    private lateinit var binding: ActivityTablaTrabajadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTablaTrabajadorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}