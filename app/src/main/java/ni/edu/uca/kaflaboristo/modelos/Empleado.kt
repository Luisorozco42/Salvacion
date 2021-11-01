package ni.edu.uca.kaflaboristo.modelos

class Empleado(
    val codigo : Int,
    val nombre: String,
    val apellido: String,
    val cargo: String,
    val fecha_nacimiento: String
) {
    public fun obtenerCodigo () : Int { return codigo }
    public fun obtenerNombre () : String { return nombre }
    public fun obtenerApellido () : String { return apellido }
    public fun obtenerCargo () : String { return cargo }
    public fun obtenerFechaNac () : String { return fecha_nacimiento }

}