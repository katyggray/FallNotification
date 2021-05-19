package edu.ucdenver.falldetection

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


private const val TAG = "PatientListFragment"

class PatientListFragment : Fragment() {

    private lateinit var patientRecyclerView: RecyclerView
    private var adapter: PatientAdapter? = null

    private val patientListViewModel: PatientListViewModel by lazy {
        ViewModelProvider(this).get(PatientListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total patients: ${patientListViewModel.patients.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_patient_list, container, false)

        patientRecyclerView =
            view.findViewById(R.id.patient_recycler_view) as RecyclerView
        patientRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return view
    }

    private fun updateUI() {
        val patients = patientListViewModel.patients
        adapter = PatientAdapter(patients)
        patientRecyclerView.adapter = adapter
    }

    private inner class PatientHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var patient: Patient

        private val nameTextView: TextView = itemView.findViewById(R.id.full_name)
        private val ageTextView: TextView = itemView.findViewById(R.id.age)
        private val roomTextView: TextView = itemView.findViewById(R.id.room_number)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(patient: Patient) {
            this.patient = patient
            nameTextView.text = this.patient.fullName
            ageTextView.text = this.patient.age.toString()
            roomTextView.text = this.patient.roomNumber.toString()
        }

        override fun onClick(v: View) {
            Toast.makeText(context,"${patient.fullName} selected", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private inner class PatientAdapter(var patients: List<Patient>)
        : RecyclerView.Adapter<PatientHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientHolder {
            val view = layoutInflater.inflate(R.layout.list_item_patient, parent, false)
            return PatientHolder(view)
        }

        override fun onBindViewHolder(holder: PatientHolder, position: Int) {
            val patient = patients[position]
            holder.bind(patient)
        }

        override fun getItemCount() = patients.size
    }

    companion object {
        fun newInstance(): PatientListFragment {
            return PatientListFragment()
        }
    }
}