package ni.edu.uca.kaflaboristo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.kaflaboristo.databinding.ActivityTablaTrabajadorBinding
import ni.edu.uca.kaflaboristo.modelos.Empleado

class tablaTrabajador(val Dempleado: DAOEmpleado) : AppCompatActivity() {
    private lateinit var binding: ActivityTablaTrabajadorBinding
    //private var lista : MutableList<Empleado> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTablaTrabajadorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        lista = registroTrabajador().lista
        val nombre: String = binding.txtNombreEmpleado.toString()

        binding.btnBuscarEmpleados.setOnClickListener(){

           // binding.tvNombreTrabajador.setText = buscarTrabajador(nombre)
           binding.tvNombreTrabajador.setText(lista[0].nombre)

        }
    }

    public fun datos(list: MutableList<Empleado>){
        lista = list
    }

    /*fun buscarTrabajador(nombre: String): String{
        var tempName: String = ""
        for(i in 0..lista.size){
            if(lista[i].nombre == nombre){
                tempName = lista[i].nombre.toString
            }
        }
        return lista[0].nombre
    }*/
}