package cat.copernic.johan.tresenraya2vs2.twoPlayers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoPlayersViewModel : ViewModel() {
    // jugador actual
    private val _player = MutableLiveData(1)
    val player: LiveData<Int> get() = _player

    fun setPlayer (player : Int){
        _player.value = player
    }

    // resetGame
    private val _resetGame = MutableLiveData(0)
    val resetGame: LiveData<Int> get() = _resetGame

    fun upResetGame(){
        _resetGame.value =+ 1
    }
    fun resetGame(){
        _resetGame.value = 0
    }

//    // Partida en juego o no
//    private val _game = MutableLiveData(0)
//    val game: LiveData<Int> get() = _game
//
//    fun setGame(game : Int){
//        _game.value = game
//    }


    // estado de la partida
    // 1 finalizado // 0 en curso
    private val _estadoPartida = MutableLiveData(0)
    val estadoPartida: LiveData<Int> get() = _estadoPartida

    fun setEstadoPartida (estado : Int){
        _estadoPartida.value = estado
    }

    // total de Fichas jugadas
    private val _totalFichas = MutableLiveData(0)
    val totalFichas: LiveData<Int> get() = _totalFichas

    fun upTotalFichas(){
        _totalFichas.value =+ 1
    }

    // tablero
    // 1- player1 // 2- player2
    private val _tablero: MutableList<Int> = mutableListOf(   0,0,0,
                                            0,0,0,
                                            0,0,0)

    val tablero : List<Int>  get() = _tablero
    fun setTablero(index : Int , jugada : Int){
        _tablero[index] = jugada
    }

    // botones
    private val _botones: MutableList<Int> = mutableListOf( 0,0,0,
                                                            0,0,0,
                                                            0,0,0)

    val botones : List<Int>  get() = _botones
    fun setBotones(listaBotones : List<Int>){
        _botones.clear()
        _botones.addAll(listaBotones)
    }








}