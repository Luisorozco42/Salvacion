package ni.edu.uca.kaflaboristo.modelos

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import ni.edu.uca.kaflaboristo.R
import java.util.*

class DatePickerFragment (val listener: (day:Int, month:Int, year:Int) -> Unit) :
    DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker, day: Int, month: Int, year: Int) {
        listener(day, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val picker = DatePickerDialog(activity as Context, R.style.DatePickerTheme, this, year, month, day)
        picker.datePicker.maxDate = c.timeInMillis
        c.add(Calendar.YEAR, -20 )
        picker.datePicker.minDate = c.timeInMillis
        return picker
    }

}