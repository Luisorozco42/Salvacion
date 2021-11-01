package ni.edu.uca.kaflaboristo.modelos
import androidx.lifecycle.ViewModel

class DAOEmpleados {
    private val listaEmpleados = arrayListOf<Empleado>()

    fun agregarEmpleado(e : Empleado) {
        listaEmpleados.add(e)
    }

    fun mostrarEmpleado() : ArrayList<Empleado> {
        return listaEmpleados
    }
}