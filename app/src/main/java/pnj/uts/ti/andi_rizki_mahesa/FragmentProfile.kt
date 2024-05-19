package pnj.uts.ti.andi_rizki_mahesa

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Access SharedPreferences to retrieve profile data
        val sharedPref = activity?.getSharedPreferences("andi", Context.MODE_PRIVATE)
        val name = sharedPref?.getString("Nama", "andi")
        val nim = sharedPref?.getString("Nim", "123456789")
        val kelas = sharedPref?.getString("Kelas", "TI-1A")
        val email = sharedPref?.getString("Email", "andi@gmail.com")

        // Set the retrieved data to TextViews
        view.findViewById<TextView>(R.id.profileName).text = "Name: $name"
        view.findViewById<TextView>(R.id.profileNim).text = "NIM: $nim"
        view.findViewById<TextView>(R.id.profileClass).text = "Class: $kelas"
        view.findViewById<TextView>(R.id.profileEmail).text = "Email: $email"

        return view
    }
}