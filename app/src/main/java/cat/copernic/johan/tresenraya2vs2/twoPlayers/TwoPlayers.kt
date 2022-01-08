package cat.copernic.johan.tresenraya2vs2.twoPlayers

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import cat.copernic.johan.tresenraya2vs2.R
import cat.copernic.johan.tresenraya2vs2.databinding.MenuFragmentBinding
import cat.copernic.johan.tresenraya2vs2.databinding.TwoPlayersFragmentBinding
import cat.copernic.johan.tresenraya2vs2.menu.MenuViewModel

class TwoPlayers : Fragment() {

    companion object {
        fun newInstance() = TwoPlayers()
    }
    private lateinit var binding: TwoPlayersFragmentBinding
    private lateinit var viewModel: TwoPlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.two_players_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(TwoPlayersViewModel::class.java)

        binding.btnRestart2.setOnClickListener {
            resetGame()
        }



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TwoPlayersViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun resetGame(){
        // si es 0 - pasar a 1 y backg color yellow
        // si es 1 - pasar a 2 y backg color red
        // si es 2 - pasar a 0 y backg color btn reset / reset tablero

    }
    private fun resetTablero(){

    }

    private fun comprobarEstado(){
        // comprobar estado boton reset

    }


}