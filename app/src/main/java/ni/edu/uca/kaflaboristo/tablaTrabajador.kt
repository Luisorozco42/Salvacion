package ni.edu.uca.kaflaboristo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import ni.edu.uca.kaflaboristo.databinding.ActivityTablaTrabajadorBinding
import ni.edu.uca.kaflaboristo.modelos.AppViewModel

class tablaTrabajador : AppCompatActivity() {
    private lateinit var binding: ActivityTablaTrabajadorBinding
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTablaTrabajadorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnBuscarEmpleados.setOnClickListener(){
            //Toast.makeText(this, viewModel.getEmployee(binding.txtNombreEmpleado.toString()), Toast.LENGTH_SHORT).show()
        }
    }
}