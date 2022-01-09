package cat.copernic.johan.tresenraya2vs2.twoPlayers

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import cat.copernic.johan.tresenraya2vs2.R
import cat.copernic.johan.tresenraya2vs2.databinding.MenuFragmentBinding
import cat.copernic.johan.tresenraya2vs2.databinding.TwoPlayersFragmentBinding
import cat.copernic.johan.tresenraya2vs2.menu.MenuViewModel
import com.google.android.material.snackbar.Snackbar

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
        binding.btnPlayer1.setOnClickListener {
            selectPlayer1()
        }
        binding.btnPlayer2.setOnClickListener {
            selectPlayer2()
        }

        binding.btn00.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn11.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn22.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn33.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn44.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn55.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn66.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn77.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn88.setOnClickListener {
            ponerFicha(it)
        }

        if (viewModel.estadoPartida.value!! >= 1){
            comprobarEstado()
        } else if (viewModel.estadoPartida.value == 0) {
            iniciarPartida()
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TwoPlayersViewModel::class.java)
        // TODO: Use the ViewModel
    }

    // hay que revisar está mal----------------------------------------------------------------------------------------------------------------------------
    private fun resetGame(){
        // si es 0 - pasar a 1 y backg color yellow
        // si es 1 - pasar a 2 y backg color red
        // si es 2 - pasar a 0 y backg color btn reset / reset tablero
        if (viewModel.resetGame.value == 0) {
            viewModel.upResetGame()
            binding.btnRestart2.setBackgroundColor(Color.RED)
            Toast.makeText(activity, "Pulsa una vez más para reiniciar partida!", Toast.LENGTH_SHORT).show()
        } else if(viewModel.resetGame.value == 1){
            iniciarPartida()
            comprobarEstado()
            Toast.makeText(activity, "Nueva partida iniciada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetTablero(){
        val tablero = arrayListOf(0,0,0,0,0,0,0,0,0)
        viewModel.setTablero(tablero)
    }
    private fun setBackgroundTableroDefauld(){
        binding.btn00.setBackgroundResource(R.drawable.tablero)
        binding.btn11.setBackgroundResource(R.drawable.tablero)
        binding.btn22.setBackgroundResource(R.drawable.tablero)
        binding.btn33.setBackgroundResource(R.drawable.tablero)
        binding.btn44.setBackgroundResource(R.drawable.tablero)
        binding.btn55.setBackgroundResource(R.drawable.tablero)
        binding.btn66.setBackgroundResource(R.drawable.tablero)
        binding.btn77.setBackgroundResource(R.drawable.tablero)
        binding.btn88.setBackgroundResource(R.drawable.tablero)
    }
    private fun setBackgroundPosTablero(index : Int, player : Int){
        when (index) {
            0 -> {
                if (player == 1){
                    binding.btn00.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn00.setBackgroundResource(R.drawable.cercle)
                }
            }
            1 -> {
                if (player == 1){
                    binding.btn11.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn11.setBackgroundResource(R.drawable.cercle)
                }
            }
            2 -> {
                if (player == 1){
                    binding.btn22.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn22.setBackgroundResource(R.drawable.cercle)
                }
            }
            3 -> {
                if (player == 1){
                    binding.btn33.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn33.setBackgroundResource(R.drawable.cercle)
                }
            }
            4 -> {
                if (player == 1){
                    binding.btn44.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn44.setBackgroundResource(R.drawable.cercle)
                }
            }
            5 -> {
                if (player == 1){
                    binding.btn55.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn55.setBackgroundResource(R.drawable.cercle)
                }
            }
            6 -> {
                if (player == 1){
                    binding.btn66.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn66.setBackgroundResource(R.drawable.cercle)
                }
            }
            7 -> {
                if (player == 1){
                    binding.btn77.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn77.setBackgroundResource(R.drawable.cercle)
                }
            }
            8 -> {
                if (player == 1){
                    binding.btn88.setBackgroundResource(R.drawable.cross)
                }else {
                    binding.btn88.setBackgroundResource(R.drawable.cercle)
                }
            }
        }
    }

    private fun iniciarPartida(){
        // textView set
        binding.tvEstadoModo2.setText(R.string.titulo_select_player)
        // Generar lista de Botones
        val botones = arrayListOf<Int>( binding.btn00.id, binding.btn11.id, binding.btn22.id,
                                        binding.btn33.id, binding.btn44.id, binding.btn55.id,
                                        binding.btn66.id, binding.btn77.id, binding.btn88.id)
        viewModel.setBotones(botones)
        // Reset Tablero
        resetTablero()
        viewModel.iniciarPartida()
        setBackgroundTableroDefauld()
    }

    private fun selectPlayer1(){
        disableBtnPlayers()
        binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer1)
        viewModel.setPlayer(1)
        viewModel.setEstadoPartida(1)
    }

    private fun selectPlayer2(){
        disableBtnPlayers()
        binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer2)
        viewModel.setPlayer(2)
        viewModel.setEstadoPartida(1)
    }
    private fun disableBtnPlayers(){
        binding.btnPlayer1.isEnabled = false
        binding.btnPlayer2.isEnabled = false
    }

    private fun ponerFicha(boton : View){
        if (viewModel.estadoPartida.value == 0){
            Toast.makeText(activity, "Select player to start!", Toast.LENGTH_SHORT).show()
        } else if (viewModel.estadoPartida.value == 1){
            if (viewModel.player.value == 1){
                fichaPlayer1(boton)
            } else if (viewModel.player.value == 2){
                fichaPlayer2(boton)
            }
            Toast.makeText(activity, "Partida en marcha!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "Partida Finalizada, REINICIAR...", Toast.LENGTH_SHORT).show()
        }

    }
//    fun prueba1(boton : View){
//        Toast.makeText(activity, "${binding.btn11.id}", Toast.LENGTH_SHORT).show()
//    }
//    fun prueba2(boton : View){
//        Toast.makeText(activity, "${boton.id}", Toast.LENGTH_SHORT).show()
//    }
//    // no sirve
//    fun prueba3(boton : View){
//        Toast.makeText(activity, "${binding.btn11.bottom}", Toast.LENGTH_SHORT).show()
//    }

    private fun fichaPlayer1(boton : View){
        val player  = 1
        val index   = viewModel.botones.indexOf(boton.id)
        setBackgroundPosTablero(index, player)
        viewModel.upTotalFichas()
        viewModel.setPosTablero(index, player)
        comprobarGanador(index)
        if (viewModel.estadoPartida.value != 2){
            viewModel.setPlayer(2)
            binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer2)
        }
    }

    private fun fichaPlayer2(boton : View){
        val player  = 2
        val index   = viewModel.botones.indexOf(boton.id)
        setBackgroundPosTablero(index, player)
        viewModel.upTotalFichas()
        viewModel.setPosTablero(index, player)
        comprobarGanador(index)
        if (viewModel.estadoPartida.value != 2){
            viewModel.setPlayer(1)
            binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer1)
        }
    }

    private fun comprobarEstado(){


    }
    private fun disableButton(index : Int){

    }

    private fun comprobarGanador(posJugada : Int){
        if (!viewModel.tablero.contains(0)){
            viewModel.setEstadoPartida(2)
        }
    }

    private fun ponerFichaGanadora(pos1 : Int, pos2 : Int, pos3 : Int){

    }
}