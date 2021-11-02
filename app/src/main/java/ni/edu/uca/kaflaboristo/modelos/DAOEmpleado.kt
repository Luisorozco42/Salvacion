package ni.edu.uca.kaflaboristo.modelos

class DAOEmpleados {
    private val listaEmpleados = arrayListOf<Empleado>()

    fun agregarEmpleado(e : Empleado) {
        listaEmpleados.add(e)
    }

}