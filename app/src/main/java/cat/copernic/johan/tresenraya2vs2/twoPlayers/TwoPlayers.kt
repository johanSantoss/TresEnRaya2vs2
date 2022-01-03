package cat.copernic.johan.tresenraya2vs2.twoPlayers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cat.copernic.johan.tresenraya2vs2.R

class TwoPlayers : Fragment() {

    companion object {
        fun newInstance() = TwoPlayers()
    }

    private lateinit var viewModel: TwoPlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.two_players_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TwoPlayersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}