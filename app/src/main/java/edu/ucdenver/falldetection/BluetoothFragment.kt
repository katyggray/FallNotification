package edu.ucdenver.falldetection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.ucdenver.falldetection.databinding.FragmentBluetoothScanBinding


class BluetoothFragment : Fragment() {

    private lateinit var bluetoothViewModel: BluetoothViewModel
    private var _binding: FragmentBluetoothScanBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // TODO: attach bluetooth scanning, connection functionality
    // TODO: implement filter on scanning results
    // TODO: create, implement check battery button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bluetoothViewModel =
            ViewModelProvider(this).get(BluetoothViewModel::class.java)

        _binding = FragmentBluetoothScanBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBluetooth
        bluetoothViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}