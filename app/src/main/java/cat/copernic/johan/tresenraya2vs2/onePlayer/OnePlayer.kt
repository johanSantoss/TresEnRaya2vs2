package cat.copernic.johan.tresenraya2vs2.onePlayer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import cat.copernic.johan.tresenraya2vs2.R
import cat.copernic.johan.tresenraya2vs2.databinding.OnePlayerFragmentBinding
import cat.copernic.johan.tresenraya2vs2.menu.MenuViewModel
import cat.copernic.johan.tresenraya2vs2.twoPlayers.TwoPlayersViewModel

class OnePlayer : Fragment() {

    companion object {
        fun newInstance() = OnePlayer()
    }

    private lateinit var binding : OnePlayerFragmentBinding
    private lateinit var viewModel: OnePlayerViewModel
    // revisar----------------------------------------------------------------------------------------------
//    private val viewModelMenu : MenuViewModel = MenuViewModel()
//    private val level = MenuViewModel().level.value

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.one_player_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(OnePlayerViewModel::class.java)
        binding.btnRestart1.setOnClickListener {
            resetGame()
        }

        binding.btn0.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn1.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn2.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn3.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn4.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn5.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn6.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn7.setOnClickListener {
            ponerFicha(it)
        }
        binding.btn8.setOnClickListener {
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
        viewModel = ViewModelProvider(this).get(OnePlayerViewModel::class.java)
        // TODO: Use the ViewModel
    }


    private fun resetGame() {
        // si es 0 - pasar a 1
        // si es 1 - pasar btn reset / reset tablero
        if (viewModel.resetGame.value == 0) {
            viewModel.upResetGame()
            Toast.makeText(
                activity,
                "Pulsa una vez más para reiniciar partida!",
//                "nivelElegido--${viewModel.nivell.value}",
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
        binding.btn0.setBackgroundResource(R.drawable.tablero)
        binding.btn1.setBackgroundResource(R.drawable.tablero)
        binding.btn2.setBackgroundResource(R.drawable.tablero)
        binding.btn3.setBackgroundResource(R.drawable.tablero)
        binding.btn4.setBackgroundResource(R.drawable.tablero)
        binding.btn5.setBackgroundResource(R.drawable.tablero)
        binding.btn6.setBackgroundResource(R.drawable.tablero)
        binding.btn7.setBackgroundResource(R.drawable.tablero)
        binding.btn8.setBackgroundResource(R.drawable.tablero)
    }

    private fun setBackgroundPosTablero(index: Int, player: Int) {
        when (index) {
            0 -> {
                if (player == 1) {
                    binding.btn0.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn0.setBackgroundResource(R.drawable.cercle)
                }
            }
            1 -> {
                if (player == 1) {
                    binding.btn1.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn1.setBackgroundResource(R.drawable.cercle)
                }
            }
            2 -> {
                if (player == 1) {
                    binding.btn2.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn2.setBackgroundResource(R.drawable.cercle)
                }
            }
            3 -> {
                if (player == 1) {
                    binding.btn3.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn3.setBackgroundResource(R.drawable.cercle)
                }
            }
            4 -> {
                if (player == 1) {
                    binding.btn4.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn4.setBackgroundResource(R.drawable.cercle)
                }
            }
            5 -> {
                if (player == 1) {
                    binding.btn5.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn5.setBackgroundResource(R.drawable.cercle)
                }
            }
            6 -> {
                if (player == 1) {
                    binding.btn6.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn6.setBackgroundResource(R.drawable.cercle)
                }
            }
            7 -> {
                if (player == 1) {
                    binding.btn7.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn7.setBackgroundResource(R.drawable.cercle)
                }
            }
            8 -> {
                if (player == 1) {
                    binding.btn8.setBackgroundResource(R.drawable.cross)
                } else {
                    binding.btn8.setBackgroundResource(R.drawable.cercle)
                }
            }
        }
    }

    private fun setBackgroundPosGanadoraTablero(index: Int, player: Int) {
        when (index) {
            0 -> {
                if (player == 1) {
                    binding.btn0.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn0.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            1 -> {
                if (player == 1) {
                    binding.btn1.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn1.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            2 -> {
                if (player == 1) {
                    binding.btn2.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn2.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            3 -> {
                if (player == 1) {
                    binding.btn3.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn3.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            4 -> {
                if (player == 1) {
                    binding.btn4.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn4.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            5 -> {
                if (player == 1) {
                    binding.btn5.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn5.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            6 -> {
                if (player == 1) {
                    binding.btn6.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn6.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            7 -> {
                if (player == 1) {
                    binding.btn7.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn7.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
            8 -> {
                if (player == 1) {
                    binding.btn8.setBackgroundResource(R.drawable.cross_winner)
                } else {
                    binding.btn8.setBackgroundResource(R.drawable.cercle_winner)
                }
            }
        }
    }

    private fun setBackgroundPosDefauldTablero(index: Int) {
        when (index) {
            0 -> binding.btn0.setBackgroundResource(R.drawable.tablero)
            1 -> binding.btn1.setBackgroundResource(R.drawable.tablero)
            2 -> binding.btn2.setBackgroundResource(R.drawable.tablero)
            3 -> binding.btn3.setBackgroundResource(R.drawable.tablero)
            4 -> binding.btn4.setBackgroundResource(R.drawable.tablero)
            5 -> binding.btn5.setBackgroundResource(R.drawable.tablero)
            6 -> binding.btn6.setBackgroundResource(R.drawable.tablero)
            7 -> binding.btn7.setBackgroundResource(R.drawable.tablero)
            8 -> binding.btn8.setBackgroundResource(R.drawable.tablero)
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
        binding.tvEstadoModo1.setText(R.string.titulo_select_player)
        // Generar lista de Botones
        val botones = arrayListOf<Int>(
            binding.btn0.id, binding.btn1.id, binding.btn2.id,
            binding.btn3.id, binding.btn4.id, binding.btn5.id,
            binding.btn6.id, binding.btn7.id, binding.btn8.id
        )
        viewModel.setBotones(botones)
        // Reset Tablero
        resetTablero()
        viewModel.iniciarPartida()
        setBackgroundTableroDefauld()
        viewModel.setPlayer(1)
        viewModel.setEstadoPartida(1)
        binding.tvEstadoModo1.setText(R.string.titulo_jugandoPlayer)

        // revisar -----------------------------------------------------------------------------------
        viewModel.setNivell(MenuViewModel().level.value!!)
//        viewModel.setNivell(1)
//        Toast.makeText(activity, "${MenuViewModel().level.value}", Toast.LENGTH_SHORT).show()

    }


    private fun ponerFicha(boton: View) {
        if (viewModel.estadoPartida.value == 0) {
            Toast.makeText(activity, "Select player to start!", Toast.LENGTH_SHORT).show()
        } else if (viewModel.estadoPartida.value == 1) {
            if (viewModel.player.value == 1) {
                fichaPlayer1(boton)
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
            binding.tvEstadoModo1.setText(R.string.titulo_jugandoPlayer)
            fichaMachine()
        }
    }

    private fun fichaMachine(){

        if (viewModel.estadoPartida.value == 1 && viewModel.totalFichas.value!! < 9) {
            // -------------- jugada logica
            val player = 2
            var indexButon: Int

            if (viewModel.nivell.value == 1){
                indexButon = comprobarJugadaMaquina1()
            } else {
                indexButon = comprobarJugadaMaquina2()
            }
            viewModel.setPosTablero(indexButon, player)
            viewModel.upTotalFichas()
            setBackgroundPosTablero(indexButon, player)
            Toast.makeText(activity, "index-$indexButon // tFichas-${viewModel.totalFichas.value} // datoTablero-${viewModel.tablero.get(indexButon)}", Toast.LENGTH_SHORT).show()
            comprobarGanador(indexButon, player)
            if (viewModel.estadoPartida.value != 2) {
                viewModel.setPlayer(1)
                binding.tvEstadoModo1.setText(R.string.titulo_jugandoPlayer1)
            }
        }

    }

    private fun comprobarJugadaMaquina1() : Int {
        val indexButon : Int
        val listaJugadas = arrayListOf<Int>()
        for (i in 0..8){
            if (viewModel.tablero.get(i) == 0) listaJugadas.add(i)
        }
        indexButon = listaJugadas.random()

        return indexButon
    }

    private fun comprobarJugadaMaquina2() : Int {
        // comprobar la siguiente jugada de la maquina
        var proxJugada: Int = 0

        if (viewModel.totalFichas.value!! < 2 && viewModel.tablero.get(4) == 0) {
            proxJugada = 4
        } else if (viewModel.totalFichas.value!! < 2 && viewModel.tablero.get(4) == 1) {
            proxJugada = listOf(0, 2, 6, 8).random()
        } else if (viewModel.totalFichas.value == 3) {
            // ---------------------------------------------------------------------exterior-esquina
            // esquina sup izq--done
            if (viewModel.tablero.get(4) == 2 && viewModel.tablero.get(0) == 1) {
                if (viewModel.tablero.get(1) == 1) {
                    proxJugada = 2
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = 1
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = 6
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = 2
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = 3
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = 3
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = 3
                }

                // esquina sup der -------Done
            } else if (viewModel.tablero.get(4) == 2 && viewModel.tablero.get(2) == 1) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = 1
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = 0
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = listOf(0, 1, 7).random()
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = 8
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = listOf(1, 3, 5, 7).random()
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = listOf(0, 3, 5).random()
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = 5
                }
                // esquina inf der
            } else if (viewModel.tablero.get(4) == 2 && viewModel.tablero.get(8) == 1) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = listOf(1, 3, 5, 7).random()
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = listOf(2, 3, 5).random()
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = 5
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = listOf(1, 2, 7).random()
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = 2
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = 7
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = 6
                }
                // esquina inf izq
            } else if (viewModel.tablero.get(4) == 2 && viewModel.tablero.get(6) == 1) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = 3
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = listOf(3, 5, 8).random()
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = listOf(1, 3, 5, 7).random()
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = 0
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = listOf(1, 7, 8).random()
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = 8
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = 7
                }
                // -------------------------------------------------------------------exterior-medio
                // medio--top
            } else if (viewModel.tablero.get(4) == 2 && viewModel.tablero.get(1) == 1) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = 2
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = 0
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = listOf(0, 6).random()
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = listOf(2, 8).random()
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = listOf(0, 3, 5).random()
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = listOf(0, 2, 6, 8).random()
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = listOf(2, 3, 5).random()
                }
                // medio--left
            } else if (viewModel.tablero.get(4) == 2 && viewModel.tablero.get(3) == 1) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = 6
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = listOf(0, 2).random()
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = listOf(0, 1, 7).random()
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = listOf(0, 2, 6, 8).random()
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = 0
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = listOf(6, 8).random()
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = listOf(1, 6, 7).random()
                }
                // medio--right
            } else if (viewModel.tablero.get(4) == 2 && viewModel.tablero.get(5) == 1) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = listOf(1, 2, 7).random()
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = listOf(0, 2).random()
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = 8
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = listOf(0, 2, 6, 8).random()
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = listOf(1, 7, 8).random()
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = listOf(6, 8).random()
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = 2
                }
                // medio--but
            } else if (viewModel.tablero.get(4) == 2 && viewModel.tablero.get(7) == 1) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = listOf(3, 5, 6).random()
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = listOf(0, 2, 6, 8).random()
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = listOf(3, 5, 8).random()
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = listOf(0, 6).random()
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = listOf(2, 8).random()
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = 8
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = 6
                }
                // ----------------------------------------------------------------------------medio
                // left - top
            } else if (viewModel.tablero.get(4) == 1 && viewModel.tablero.get(0) == 2) {
                if (viewModel.tablero.get(1) == 1) {
                    proxJugada = 7
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = 6
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = 5
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = 3
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = 2
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = 1
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = 2
                }
                // right - top
            } else if (viewModel.tablero.get(4) == 1 && viewModel.tablero.get(2) == 2) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = 8
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = 7
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = 5
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = 3
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = 8
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = 1
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = 0
                }
                // left - but
            } else if (viewModel.tablero.get(4) == 1 && viewModel.tablero.get(6) == 2) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = 8
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = 7
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = 0
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = 5
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = 3
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = 1
                } else if (viewModel.tablero.get(8) == 1) {
                    proxJugada = 0
                }
                //right - but
            } else if (viewModel.tablero.get(4) == 1 && viewModel.tablero.get(8) == 2) {
                if (viewModel.tablero.get(0) == 1) {
                    proxJugada = 6
                } else if (viewModel.tablero.get(1) == 1) {
                    proxJugada = 7
                } else if (viewModel.tablero.get(2) == 1) {
                    proxJugada = 6
                } else if (viewModel.tablero.get(3) == 1) {
                    proxJugada = 5
                } else if (viewModel.tablero.get(5) == 1) {
                    proxJugada = 3
                } else if (viewModel.tablero.get(6) == 1) {
                    proxJugada = 2
                } else if (viewModel.tablero.get(7) == 1) {
                    proxJugada = 1
                }
            }
        } else if (viewModel.totalFichas.value!! >= 5) {
//             ----------------jugada random
            val jugadasDisponibles: MutableList<Int> = ArrayList()

            for (i in 0..8) {
                if (viewModel.tablero.get(i) == 0) {
                    jugadasDisponibles.add(i)
                }
            }
            proxJugada = jugadasDisponibles.random()
        }
        return proxJugada
    }

    private fun comprobarEstado() {
        if (viewModel.estadoPartida.value == 1) {
            if (viewModel.player.value == 1) {
                binding.tvEstadoModo1.setText(R.string.titulo_jugando)
            } else if (viewModel.player.value == 2) {
                binding.tvEstadoModo1.setText(R.string.titulo_jugando)
            }
            restoreBackgroundTablero()
        } else if (viewModel.estadoPartida.value == 2) {
            if (viewModel.ganador.value == 1) {
                binding.tvEstadoModo1.setText(R.string.titulo_ganadorPlayer)
            } else if (viewModel.ganador.value == 2) {
                binding.tvEstadoModo1.setText(R.string.titulo_ganadorMachine)
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
            binding.tvEstadoModo1.setText(R.string.titulo_ganadorPlayer)
        } else {
            binding.tvEstadoModo1.setText(R.string.titulo_ganadorMachine)
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
            binding.tvEstadoModo1.setText(R.string.titulo_empate)
        }
    }


}