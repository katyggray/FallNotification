package edu.ucdenver.falldetection

import androidx.lifecycle.ViewModel
import java.util.*

class PatientListViewModel : ViewModel() {
    val patients = mutableListOf<Patient>()

    private var firstNames = listOf("Anne", "Jane", "Susan", "John", "Dan")
    private var lastNames = listOf("Doe", "Smith", "Thompson", "Black", "Johnson")
    private var dateNow = Calendar.getInstance()

    init {
        for (i in 0 until 5) {
            val patient = Patient()
            patient.firstName = firstNames[i]
            patient.lastName = lastNames[i]
            patient.fullName = patient.firstName + " " + patient.lastName
            patient.age = 80 + i
            patient.roomNumber = i + 1
            patient.sessionHistory.add(dateNow)
            patients += patient
        }
    }
}