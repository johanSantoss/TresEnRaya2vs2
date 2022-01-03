package cat.copernic.johan.tresenraya2vs2.onePlayer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cat.copernic.johan.tresenraya2vs2.R

class OnePlayer : Fragment() {

    companion object {
        fun newInstance() = OnePlayer()
    }

    private lateinit var viewModel: OnePlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.one_player_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OnePlayerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}