package cat.copernic.johan.tresenraya2vs2.menu

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import cat.copernic.johan.tresenraya2vs2.MainActivity
import cat.copernic.johan.tresenraya2vs2.R
import cat.copernic.johan.tresenraya2vs2.databinding.MenuFragmentBinding

class Menu : Fragment() {

    companion object {
        fun newInstance() = Menu()
    }
    private lateinit var binding: MenuFragmentBinding
    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // generar binding
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.menu_fragment,
            container,
            false
        )
        // set level a 0 siempre que iniciemos el menú
        if (viewModel.level.value == 0){
            viewModel.setLevel((activity as MainActivity).setAndGetLevel(0))
        }
        // generar viewModel
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        // onClick buttons
        binding.btnEasy.setOnClickListener {
            buttonEasy()
        }
        binding.btnMedio.setOnClickListener {
            buttonMedio()
        }
        binding.btnModo1.setOnClickListener {
            buttonModo1()
        }
        binding.btnModo2.setOnClickListener {
            buttonModo2()
        }

        comprobarEstado()

        return binding.root
    }

    private fun buttonEasy(){
        // set and save level
        viewModel.setLevel((activity as MainActivity).setAndGetLevel(1))
        // comprobar estado del level para cambio de estado de los botones
        comprobarEstado()
        Toast.makeText(activity, "Nivel seleccionado: ${viewModel.level.value}", Toast.LENGTH_SHORT).show()
    }

    private fun buttonMedio(){
        // set and save level
        viewModel.setLevel((activity as MainActivity).setAndGetLevel(2))
        // comprobar estado del level para cambio de estado de los botones
        comprobarEstado()
        Toast.makeText(activity, "Nivel seleccionado: ${viewModel.level.value}", Toast.LENGTH_SHORT).show()
    }

    private fun buttonModo1(){
        if (viewModel.level.value != 0){
            val action = MenuDirections.actionMenuToOnePlayer()
            NavHostFragment.findNavController(this).navigate(action)
        }else{
            Toast.makeText(activity, "Select level!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun buttonModo2(){
        val action = MenuDirections.actionMenuToTwoPlayers()
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun comprobarEstado(){
        if (viewModel.level.value == 2) {
            binding.btnEasy.setTextColor(Color.WHITE)
            binding.btnMedio.setTextColor(Color.BLACK)
        } else if (viewModel.level.value == 1){
            binding.btnEasy.setTextColor(Color.BLACK)
            binding.btnMedio.setTextColor(Color.WHITE)
        } else {
            binding.btnEasy.setTextColor(Color.WHITE)
            binding.btnMedio.setTextColor(Color.WHITE)
        }
    }

}