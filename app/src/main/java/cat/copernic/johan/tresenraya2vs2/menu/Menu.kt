package cat.copernic.johan.tresenraya2vs2.menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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

    }

    private fun buttonMedio(){

    }

    private fun buttonModo1(){
//        val action = MenuDirections
    }

    private fun buttonModo2(){
//        val action = MenuDirections
    }

    private fun comprobarEstado(){

    }

}