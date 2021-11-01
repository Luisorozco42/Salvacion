package ni.edu.uca.kaflaboristo

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ni.edu.uca.kaflaboristo.databinding.ActivityRegistroTrabajadorBinding
import ni.edu.uca.kaflaboristo.modelos.DAOEmpleados
import ni.edu.uca.kaflaboristo.modelos.DatePickerFragment
import ni.edu.uca.kaflaboristo.modelos.Empleado

class registroTrabajador : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroTrabajadorBinding
    val REQUEST_CAMERA = 1
    var foto : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityRegistroTrabajadorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSeleccionarFoto.setOnClickListener { requestPermissions() }
        binding.btnTomarFoto.setOnClickListener{ pedirPermiso() }
        binding.etNacimiento.setOnClickListener { showDatePickerDialog() }

        binding.btnRegistrar.setOnClickListener {
            val emp : Empleado = crearEmpleado(
                binding.etCodigoTexto.text.toString().toInt(),
                binding.etNombreTexto.text.toString(),
                binding.etApellidoTexto.text.toString(),
                binding.etCargoTexto.text.toString(),
                binding.etNacimiento.text.toString()
            )


            Toast.makeText(applicationContext, "Se ha creado a ${emp.nombre} ${emp.apellido}.", Toast.LENGTH_LONG).show()
            //mostrarDialogoEmpleado(emp)
        }
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        binding.etNacimiento.setText( twoDigits(day) + "/" + twoDigits(month+1) + "/" + year)
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month + 1, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }
    private fun twoDigits(n: Int): String? {
        return if (n <= 9) "0$n" else n.toString()
    }

    private fun crearEmpleado(id:Int, nombre:String, apellido:String, cargo:String, nacimiento:String) : Empleado {
        val emp = Empleado(id, nombre, apellido, cargo, nacimiento)
        return emp
    }

    private fun mostrarDialogoEmpleado(emp : Empleado) {
        MaterialAlertDialogBuilder(applicationContext)
            .setTitle("Nuevo empleado")
            .setMessage("Se ha registrado a ${emp.obtenerNombre()}.")
            .setCancelable(false)
            .show()
    }

    private fun requestPermissions() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            when{
                ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED -> {
                    pickPhotoFromGallery()
                }
                else -> permiso.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }

        }else{
            pickPhotoFromGallery()
        }
    }

    private val permiso = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted->
        if(isGranted) {
            pickPhotoFromGallery()
        }else{
            Toast.makeText(this, "Necesitas habilitar los permisos",Toast.LENGTH_LONG).show()
        }
    }

    private val starForActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data
            binding.ivFoto.setImageURI(data)
        }
    }
    private val starForActivityCamara = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result->
        if (result.resultCode == Activity.RESULT_OK){
            binding.ivFoto.setImageURI(foto)
        }
    }

    private fun pickPhotoFromGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        starForActivityGallery.launch(intent)
    }

    private fun dispatchTakePictureIntent() {
        val value = ContentValues()
        value.put(MediaStore.Images.Media.TITLE,"Nueva Imagen")
        foto = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,value)
        val camaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT,foto)
        starForActivityCamara.launch(camaraIntent)
    }
    private fun pedirPermiso() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when{
                ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                    dispatchTakePictureIntent()
                }
                else -> damePermi.launch(Manifest.permission.CAMERA)
            }
        }else{
            dispatchTakePictureIntent()
        }
    }
    private val damePermi = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted->
        if(isGranted) {
            dispatchTakePictureIntent()
        }else{
            Toast.makeText(this, "Necesitas habilitar los permisos",Toast.LENGTH_LONG).show()
        }
    }
}
