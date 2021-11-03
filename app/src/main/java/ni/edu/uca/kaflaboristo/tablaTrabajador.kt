package ni.edu.uca.kaflaboristo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.kaflaboristo.databinding.ActivityTablaTrabajadorBinding
import ni.edu.uca.kaflaboristo.modelos.DAOEmpleados
import ni.edu.uca.kaflaboristo.modelos.Empleado

class tablaTrabajador() : AppCompatActivity() {
    private lateinit var binding: ActivityTablaTrabajadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTablaTrabajadorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnBuscarEmpleados.setOnClickListener(){
            Toast.makeText(this, "" + DAOEmpleados.listaEmpleados.get(0).nombre, Toast.LENGTH_SHORT).show()
        }
    }
}