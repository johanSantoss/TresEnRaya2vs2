package cat.copernic.johan.tresenraya2vs2.twoPlayers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import cat.copernic.johan.tresenraya2vs2.R
import cat.copernic.johan.tresenraya2vs2.databinding.TwoPlayersFragmentBinding


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

        if (viewModel.estadoPartida.value!! >= 1) {
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


    private fun resetGame() {
        // si es 0 - pasar a 1 y backg color yellow
        // si es 1 - pasar a 2 y backg color red
        // si es 2 - pasar a 0 y backg color btn reset / reset tablero
        if (viewModel.resetGame.value == 0) {
            viewModel.upResetGame()
            Toast.makeText(
                activity,
                "Pulsa una vez más para reiniciar partida!",
                Toast.LENGTH_SHORT
            ).show()
        } else if (viewModel.resetGame.value == 1) {
            iniciarPartida()
            Toast.makeText(activity, "Nueva partida iniciada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetTablero() {
        val tablero = arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        viewModel.setTablero(tablero)
    }

    private fun setBackgroundTableroDefauld() {
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

    private fun setBackgroundPosTablero(index: Int, player: Int) {
        when (index) {
            0 -> {
                if (player == 1) {
                    binding.btn00.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn00.setBackgroundResource(R.drawable.cercle)
                }
            }
            1 -> {
                if (player == 1) {
                    binding.btn11.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn11.setBackgroundResource(R.drawable.cercle)
                }
            }
            2 -> {
                if (player == 1) {
                    binding.btn22.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn22.setBackgroundResource(R.drawable.cercle)
                }
            }
            3 -> {
                if (player == 1) {
                    binding.btn33.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn33.setBackgroundResource(R.drawable.cercle)
                }
            }
            4 -> {
                if (player == 1) {
                    binding.btn44.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn44.setBackgroundResource(R.drawable.cercle)
                }
            }
            5 -> {
                if (player == 1) {
                    binding.btn55.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn55.setBackgroundResource(R.drawable.cercle)
                }
            }
            6 -> {
                if (player == 1) {
                    binding.btn66.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn66.setBackgroundResource(R.drawable.cercle)
                }
            }
            7 -> {
                if (player == 1) {
                    binding.btn77.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn77.setBackgroundResource(R.drawable.cercle)
                }
            }
            8 -> {
                if (player == 1) {
                    binding.btn88.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn88.setBackgroundResource(R.drawable.cercle)
                }
            }
        }
    }

    private fun setBackgroundPosGanadoraTablero(index: Int, player: Int) {
        when (index) {
            0 -> {
                if (player == 1) {
                    binding.btn00.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn00.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            1 -> {
                if (player == 1) {
                    binding.btn11.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn11.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            2 -> {
                if (player == 1) {
                    binding.btn22.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn22.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            3 -> {
                if (player == 1) {
                    binding.btn33.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn33.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            4 -> {
                if (player == 1) {
                    binding.btn44.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn44.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            5 -> {
                if (player == 1) {
                    binding.btn55.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn55.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            6 -> {
                if (player == 1) {
                    binding.btn66.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn66.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            7 -> {
                if (player == 1) {
                    binding.btn77.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn77.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            8 -> {
                if (player == 1) {
                    binding.btn88.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn88.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
        }
    }

    private fun setBackgroundPosDefauldTablero(index: Int) {
        when (index) {
            0 -> binding.btn00.setBackgroundResource(R.drawable.tablero)
            1 -> binding.btn11.setBackgroundResource(R.drawable.tablero)
            2 -> binding.btn22.setBackgroundResource(R.drawable.tablero)
            3 -> binding.btn33.setBackgroundResource(R.drawable.tablero)
            4 -> binding.btn44.setBackgroundResource(R.drawable.tablero)
            5 -> binding.btn55.setBackgroundResource(R.drawable.tablero)
            6 -> binding.btn66.setBackgroundResource(R.drawable.tablero)
            7 -> binding.btn77.setBackgroundResource(R.drawable.tablero)
            8 -> binding.btn88.setBackgroundResource(R.drawable.tablero)
        }
    }

    private fun restoreBackgroundTablero() {
        for (i in 0..8) {
            if (viewModel.jugadaGanadora.contains(i)) {
                if (viewModel.tablero.get(i) == 1) {
                    setBackgroundPosGanadoraTablero(i, 1)
                } else if (viewModel.tablero.get(i) == 2) {
                    setBackgroundPosGanadoraTablero(i, 2)
                }
            } else {
                if (viewModel.tablero.get(i) == 1) {
                    setBackgroundPosTablero(i, 1)
                } else if (viewModel.tablero.get(i) == 2) {
                    setBackgroundPosTablero(i, 2)
                } else {
                    setBackgroundPosDefauldTablero(i)
                }
            }

        }
    }

    private fun iniciarPartida() {
        // textView set
        binding.tvEstadoModo2.setText(R.string.titulo_select_player)
        // Generar lista de Botones
        val botones = arrayListOf<Int>(
            binding.btn00.id, binding.btn11.id, binding.btn22.id,
            binding.btn33.id, binding.btn44.id, binding.btn55.id,
            binding.btn66.id, binding.btn77.id, binding.btn88.id
        )
        viewModel.setBotones(botones)
        // Reset Tablero
        resetTablero()
        viewModel.iniciarPartida()
        setBackgroundTableroDefauld()
        aviableBtnPlayers()
    }

    private fun selectPlayer1() {
        disableBtnPlayers()
        viewModel.setPlayer(1)
        viewModel.setEstadoPartida(1)
        binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer1)
    }

    private fun selectPlayer2() {
        disableBtnPlayers()
        viewModel.setPlayer(2)
        viewModel.setEstadoPartida(1)
        binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer2)
    }

    private fun disableBtnPlayers() {
        binding.btnPlayer1.isEnabled = false
        binding.btnPlayer2.isEnabled = false
        binding.btnRestart2.isEnabled = true
    }

    private fun aviableBtnPlayers() {
        binding.btnPlayer1.isEnabled = true
        binding.btnPlayer2.isEnabled = true
        binding.btnRestart2.isEnabled = false
    }

    private fun ponerFicha(boton: View) {
        if (viewModel.estadoPartida.value == 0) {
            Toast.makeText(activity, "Select player to start!", Toast.LENGTH_SHORT).show()
        } else if (viewModel.estadoPartida.value == 1) {
            if (viewModel.player.value == 1) {
                fichaPlayer1(boton)
            } else if (viewModel.player.value == 2) {
                fichaPlayer2(boton)
            }
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

    private fun fichaPlayer1(boton: View) {
        val player = 1
        val index = viewModel.botones.indexOf(boton.id)

        setBackgroundPosTablero(index, player)
        viewModel.upTotalFichas()
        viewModel.setPosTablero(index, player)

        Toast.makeText(activity, "index-$index // tFichas-${viewModel.totalFichas.value} // datoTablero-${viewModel.tablero.get(index)}", Toast.LENGTH_SHORT).show()
        comprobarGanador(index, player)
        if (viewModel.estadoPartida.value != 2) {
            viewModel.setPlayer(2)
            binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer2)
        }
    }

    private fun fichaPlayer2(boton: View) {
        val player = 2
        val index = viewModel.botones.indexOf(boton.id)

        setBackgroundPosTablero(index, player)
        viewModel.upTotalFichas()
        viewModel.setPosTablero(index, player)

        Toast.makeText(activity, "index-$index // tFichas-${viewModel.totalFichas.value} // datoTablero-${viewModel.tablero.get(index)}", Toast.LENGTH_SHORT).show()
        comprobarGanador(index, player)
        if (viewModel.estadoPartida.value != 2) {
            viewModel.setPlayer(1)
            binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer1)
        }
    }

    private fun comprobarEstado() {
        if (viewModel.estadoPartida.value == 1) {
            disableBtnPlayers()
            if (viewModel.player.value == 1) {
                binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer1)
            } else if (viewModel.player.value == 2) {
                binding.tvEstadoModo2.setText(R.string.titulo_jugandoPlayer2)
            }
            restoreBackgroundTablero()
        } else if (viewModel.estadoPartida.value == 2) {
            disableBtnPlayers()
            if (viewModel.ganador.value == 1) {
                binding.tvEstadoModo2.setText(R.string.titulo_ganadorPlayer1)
            } else if (viewModel.ganador.value == 2) {
                binding.tvEstadoModo2.setText(R.string.titulo_ganadorPlayer2)
            }
            restoreBackgroundTablero()
        } else {
            iniciarPartida()
        }


    }

    private fun setJugadaGanadora(jugadaGanadora: List<Int>, player: Int) {
        setBackgroundPosGanadoraTablero(jugadaGanadora.get(0), player)
        setBackgroundPosGanadoraTablero(jugadaGanadora.get(1), player)
        setBackgroundPosGanadoraTablero(jugadaGanadora.get(2), player)
        viewModel.setJugadaGanadora(jugadaGanadora)
        viewModel.setEstadoPartida(2)
        viewModel.setGanador(player)
        if (player == 1){
            binding.tvEstadoModo2.setText(R.string.titulo_ganadorPlayer1)
        } else {
            binding.tvEstadoModo2.setText(R.string.titulo_ganadorPlayer2)
        }
    }

    private fun comprobarGanador(posJugada: Int, player: Int) {
        var final = false
        if (viewModel.totalFichas.value!! >= 5){
            if (posJugada == 0) {
                if (viewModel.tablero.get(0) == viewModel.tablero.get(1) && viewModel.tablero.get(0) == viewModel.tablero.get(2)) {
                    //H1
                    val jugadaGanadora = arrayListOf(0, 1, 2)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(0) == viewModel.tablero.get(3) && viewModel.tablero.get(0) == viewModel.tablero.get(6)) {
                    //V4
                    val jugadaGanadora = arrayListOf(0, 3, 6)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(0) == viewModel.tablero.get(4) && viewModel.tablero.get(0) == viewModel.tablero.get(8)) {
                    //D7
                    val jugadaGanadora = arrayListOf(0, 4, 8)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                }
            } else if (posJugada == 1) {
                if (viewModel.tablero.get(0) == viewModel.tablero.get(1) && viewModel.tablero.get(1) == viewModel.tablero.get(2)) {
                    //H1
                    val jugadaGanadora = arrayListOf(0, 1, 2)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(4) == viewModel.tablero.get(1) && viewModel.tablero.get(1) == viewModel.tablero.get(7)) {
                    //V5
                    val jugadaGanadora = arrayListOf(1, 4, 7)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                }
            } else if (posJugada == 2) {
                if (viewModel.tablero.get(0) == viewModel.tablero.get(2) && viewModel.tablero.get(1) == viewModel.tablero.get(2)) {
                    //H1
                    val jugadaGanadora = arrayListOf(2, 1, 0)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(2) == viewModel.tablero.get(5) && viewModel.tablero.get(2) == viewModel.tablero.get(8)) {
                    //V6
                    val jugadaGanadora = arrayListOf(2,5,8)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(2) == viewModel.tablero.get(4) && viewModel.tablero.get(2) == viewModel.tablero.get(6)) {
                    //D8
                    val jugadaGanadora = arrayListOf(2,4,6)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                }
            } else if (posJugada == 3) {
                if (viewModel.tablero.get(3) == viewModel.tablero.get(4) && viewModel.tablero.get(3) == viewModel.tablero.get(5)) {
                    //H2
                    val jugadaGanadora = arrayListOf(3,4,5)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(3) == viewModel.tablero.get(0) && viewModel.tablero.get(3) == viewModel.tablero.get(6)) {
                    //V4
                    val jugadaGanadora = arrayListOf(3,0,6)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                }
            } else if (posJugada == 5) {
                if (viewModel.tablero.get(5) == viewModel.tablero.get(4) && viewModel.tablero.get(5) == viewModel.tablero.get(3)) {
                    //H2
                    val jugadaGanadora = arrayListOf(5,4,3)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(5) == viewModel.tablero.get(2) && viewModel.tablero.get(5) == viewModel.tablero.get(8)) {
                    //V6
                    val jugadaGanadora = arrayListOf(5,2,8)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                }
            } else if (posJugada == 6) {
                if (viewModel.tablero.get(6) == viewModel.tablero.get(7) && viewModel.tablero.get(6) == viewModel.tablero.get(8)) {
                    //H3
                    val jugadaGanadora = arrayListOf(6,7,8)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(6) == viewModel.tablero.get(3) && viewModel.tablero.get(6) == viewModel.tablero.get(0)) {
                    //V4
                    val jugadaGanadora = arrayListOf(6,3,0)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(6) == viewModel.tablero.get(4) && viewModel.tablero.get(6) == viewModel.tablero.get(2)) {
                    //D8
                    val jugadaGanadora = arrayListOf(6,4,2)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                }
            } else if (posJugada == 7) {
                if (viewModel.tablero.get(7) == viewModel.tablero.get(6) && viewModel.tablero.get(7) == viewModel.tablero.get(8)) {
                    //H3
                    val jugadaGanadora = arrayListOf(7,6,8)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(7) == viewModel.tablero.get(4) && viewModel.tablero.get(7) == viewModel.tablero.get(1)) {
                    //V5
                    val jugadaGanadora = arrayListOf(7,4,1)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                }
            } else if (posJugada == 8) {
                if (viewModel.tablero.get(8) == viewModel.tablero.get(7) && viewModel.tablero.get(8) == viewModel.tablero.get(6)) {
                    //H3
                    val jugadaGanadora = arrayListOf(8,7,6)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(8) == viewModel.tablero.get(5) && viewModel.tablero.get(8) == viewModel.tablero.get(2)) {
                    //V6
                    val jugadaGanadora = arrayListOf(8,5,2)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                } else if (viewModel.tablero.get(8) == viewModel.tablero.get(4) && viewModel.tablero.get(8) == viewModel.tablero.get(0)) {
                    //D7
                    val jugadaGanadora = arrayListOf(8,4,0)
                    setJugadaGanadora(jugadaGanadora, player)
                    final = true
                }
            }
        }

        if (final == false && viewModel.totalFichas.value == 9) {
            viewModel.setEstadoPartida(2)
            binding.tvEstadoModo2.setText(R.string.titulo_empate)
        }
    }

}