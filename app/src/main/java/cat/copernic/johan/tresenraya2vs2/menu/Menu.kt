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

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.menu_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
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





        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun buttonEasy(){
        binding.btnEasy.setTextColor(Color.BLACK)
        binding.btnMedio.setTextColor(Color.WHITE)
        viewModel.setLevel(1)
    }

    private fun buttonMedio(){
        binding.btnEasy.setTextColor(Color.WHITE)
        binding.btnMedio.setTextColor(Color.BLACK)
        viewModel.setLevel(2)
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

    }

}