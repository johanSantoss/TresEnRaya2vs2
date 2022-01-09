package cat.copernic.johan.tresenraya2vs2.twoPlayers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoPlayersViewModel : ViewModel() {
    // jugador actual------------------------------------------------
    private val _player = MutableLiveData(0)
    val player: LiveData<Int> get() = _player
    fun setPlayer (player : Int){
        _player.value = player
    }
    // jugador ganador------------------------------------------------
    private val _ganador = MutableLiveData(0)
    val ganador: LiveData<Int> get() = _ganador
    fun setGanador (ganador : Int){
        _ganador.value = ganador
    }

    // resetGame-----------------------------------------------------
    //
    private val _resetGame = MutableLiveData(0)
    val resetGame: LiveData<Int> get() = _resetGame
    fun upResetGame(){
        _resetGame.value = 1
    }
    fun setResetGame(){
        _resetGame.value = 0
    }

    // estado de la partida-----------------------------------------
    // 2 finalizado // 1 en curso // 0 no iniciada
    private val _estadoPartida: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val estadoPartida: LiveData<Int> get() = _estadoPartida
    fun setEstadoPartida (estado : Int){
        _estadoPartida.value = estado
    }

    // total de Fichas jugadas--------------------------------------
    private val _totalFichas = MutableLiveData(0)
    val totalFichas: LiveData<Int> get() = _totalFichas
    // corregir incrementa en 1-------------------------------------------------------------------------------------
    fun upTotalFichas(){
        _totalFichas.value!!.plus(1)
    }
    fun setTotalFichas(){
        _totalFichas.value = 0
    }

    // tablero-------------------------------------------------------
    // 1- player1 // 2- player2
    private val _tablero: MutableList<Int> = mutableListOf( 0,0,0,
                                                            0,0,0,
                                                            0,0,0)
    val tablero : List<Int>  get() = _tablero
    fun setPosTablero(index : Int , player : Int){
        _tablero.set(index, player)
    }
    fun setTablero (tablero : List<Int>){
        _tablero.clear()
        _tablero.addAll(tablero)
    }

    // botones--------------------------------------------------------
    private val _botones: MutableList<Int> = mutableListOf()
    val botones : List<Int>  get() = _botones
    fun setBotones(listaBotones : List<Int>){
        _botones.addAll(listaBotones)
    }
    // jugada ganadora--------------------------------------------------
    private val _jugadaGanadora: MutableList<Int> = mutableListOf(-1, -1, -1)
    val jugadaGanadora : List<Int>  get() = _jugadaGanadora
    fun setJugadaGanadora(listaGanadora : List<Int>){
        _botones.addAll(listaGanadora)
    }

    // resetVariablesIniciarPartida------------------------------------
    fun iniciarPartida(){
        setPlayer(0)
        setResetGame()
        setEstadoPartida(0)
        setTotalFichas()
        setGanador(0)
        setJugadaGanadora(arrayListOf(-1, -1, -1))
    }








}