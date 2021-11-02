package ni.edu.uca.kaflaboristo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import ni.edu.uca.kaflaboristo.databinding.ActivityTablaTrabajadorBinding
import ni.edu.uca.kaflaboristo.modelos.AppViewModel
import ni.edu.uca.kaflaboristo.modelos.Empleado

class tablaTrabajador(private var lista: MutableList<Empleado>) : AppCompatActivity() {
    private lateinit var binding: ActivityTablaTrabajadorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTablaTrabajadorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnBuscarEmpleados.setOnClickListener(){
            binding.tvNombreTrabajador.text = buscarTrabajador(binding.txtNombreEmpleado.toString())
        }
    }

    public fun datos(list: MutableList<Empleado>){
        lista = list
    }

    fun buscarTrabajador(nombre: String): String{
        var tempName: String = ""
        for(i in 0..lista.size){
            if(lista.get(i).nombre == nombre){
                tempName = lista.get(i).nombre
            }
        }
        return tempName
    }
}