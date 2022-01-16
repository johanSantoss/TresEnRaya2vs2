package cat.copernic.johan.tresenraya2vs2.settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.PreferenceFragmentCompat
import cat.copernic.johan.tresenraya2vs2.R
import cat.copernic.johan.tresenraya2vs2.databinding.OnePlayerFragmentBinding
import cat.copernic.johan.tresenraya2vs2.databinding.SettingsFragmentBinding
import cat.copernic.johan.tresenraya2vs2.menu.MenuDirections
import cat.copernic.johan.tresenraya2vs2.menu.MenuViewModel
import cat.copernic.johan.tresenraya2vs2.onePlayer.OnePlayerDirections
import cat.copernic.johan.tresenraya2vs2.onePlayer.OnePlayerViewModel

class settings : Fragment() {

//    companion object {
//        fun newInstance() = settings()
//    }

//    private lateinit var viewModelPlayer: OnePlayerViewModel
//    private lateinit var viewModelMenu: MenuViewModel
    private lateinit var viewModel: SettingsViewModel
    private lateinit var binding : SettingsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.settings_fragment,
            container,
            false
        )
//        viewModelPlayer = ViewModelProvider(this).get(OnePlayerViewModel::class.java)
//        MenuViewModel().setLevel(1)
//        Toast.makeText(activity, "Nivel seleccionado: ${cat.copernic.johan.tresenraya2vs2.menu.MenuViewModel().level.value}", Toast.LENGTH_SHORT).show()




        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(cat.copernic.johan.tresenraya2vs2.onePlayer.OnePlayer.newInstance()).get(OnePlayerViewModel::class.java)
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}