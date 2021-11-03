package ni.edu.uca.kaflaboristo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.kaflaboristo.databinding.ActivityMainBinding
import ni.edu.uca.kaflaboristo.modelos.DAOEmpleados
import ni.edu.uca.kaflaboristo.modelos.Empleado

class MainActivity() : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegistrarEmpleado.setOnClickListener {
            startActivity(Intent(this, registroTrabajador()::class.java))
        }

        binding.btnBuscarEmpleados.setOnClickListener {
            startActivity(Intent(this, tablaTrabajador()::class.java))
        }

    }


}