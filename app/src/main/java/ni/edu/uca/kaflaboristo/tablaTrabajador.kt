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
            buscarEmp()
        }
    }
    fun buscarEmp(){
        var cont: Int = 0
        var nombre : String = binding.txtNombreEmpleado.text.toString()
        for(i:Empleado in DAOEmpleados.listaEmpleados) {
            if (nombre == DAOEmpleados.listaEmpleados[cont].nombre || nombre == DAOEmpleados.listaEmpleados[cont].apellido) {
                binding.tvIDTrabajador.setText(DAOEmpleados.listaEmpleados[cont].codigo.toString())
                binding.tvNombreTrabajador.setText(DAOEmpleados.listaEmpleados[cont].nombre)
                binding.tvApellidoTrabajador.setText(DAOEmpleados.listaEmpleados[cont].apellido)
                binding.tvCargoTrabajador.setText(DAOEmpleados.listaEmpleados[cont].apellido)
                binding.tvFechaNacTrabajador.setText(DAOEmpleados.listaEmpleados[cont].fecha_nacimiento)
                binding.imgTrabadorPerfil.setImageBitmap(DAOEmpleados.listaEmpleados[cont].imagen)
            }
            cont += 1
        }
    }
}