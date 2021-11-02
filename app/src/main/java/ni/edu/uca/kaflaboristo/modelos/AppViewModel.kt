package ni.edu.uca.kaflaboristo.modelos
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ni.edu.uca.kaflaboristo.registroTrabajador

class AppViewModel : ViewModel() {
    var lista: MutableList<Empleado> = mutableListOf()
    private var _counter = MutableLiveData(0)
    private var _lista = MutableLiveData<MutableList<Empleado>>()
    val currentLista: LiveData<MutableList<Empleado>> get() = _lista
    val counterAUX: LiveData<Int> get() = _counter


    //añadiendo datos al viewModel
    fun addNewEmployee(lista: MutableList<Empleado>){
        _lista.value = lista
    }

    //Icrementando contador
    fun incremento(cont: Int){
        _counter.value = cont
    }

    //Obteniendo datos del viewModel
    fun getEmployee(nombre: String): Empleado {
        var name: String = ""
        var apellido: String = ""
        var puesto: String = ""
        var fechaNac: String = ""
        var codigo: Int = 0

        for (i in 0..counterAUX.value!!){
            if (nombre == currentLista.value?.get(i)?.nombre){
                codigo = currentLista.value?.get(i)?.codigo!!
                name = currentLista.value?.get(i)?.nombre!!
                apellido = currentLista.value?.get(i)?.apellido!!
                puesto = currentLista.value?.get(i)?.cargo!!
                fechaNac = currentLista.value?.get(i)?.fecha_nacimiento!!
            }
        }

        var tempName = Empleado(
            codigo,
            name,
            apellido,
            puesto,
            fechaNac
        )

        return tempName
    }
}

