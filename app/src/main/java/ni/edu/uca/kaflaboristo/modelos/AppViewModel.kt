package ni.edu.uca.kaflaboristo.modelos
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ni.edu.uca.kaflaboristo.registroTrabajador

class AppViewModel : ViewModel() {
    private var _lista = MutableLiveData<MutableList<Empleado>>()
    val currentLista: LiveData<MutableList<Empleado>> get() = _lista


    //añadiendo datos al viewModel
    fun addNewEmployee(lista: MutableList<Empleado>){
        _lista.value = lista
    }

    //Obteniendo datos del viewModel
    fun getEmployee(nombre: String): String {
        var tempName: String = ""

        for (i:Empleado in currentLista.value!!){}

        return tempName
    }
}

