package ni.edu.uca.kaflaboristo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.kaflaboristo.databinding.ActivityTablaTrabajadorBinding
import ni.edu.uca.kaflaboristo.modelos.DAOEmpleados
import ni.edu.uca.kaflaboristo.registroTrabajador

class tablaTrabajador : AppCompatActivity() {
    private lateinit var binding: ActivityTablaTrabajadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTablaTrabajadorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i: Int = 0
        binding.btnBuscarEmpleados.setOnClickListener(){
            val model: DAOEmpleados
        }
    }
}