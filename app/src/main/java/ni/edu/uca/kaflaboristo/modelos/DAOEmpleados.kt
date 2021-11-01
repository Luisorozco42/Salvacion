package ni.edu.uca.kaflaboristo.modelos
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DAOEmpleados : ViewModel() {
    private val lista: MutableLiveData<List<Empleado>> by lazy {
        MutableLiveData<List<Empleado>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<Empleado>> {
        return lista
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}