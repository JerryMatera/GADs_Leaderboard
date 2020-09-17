package io.github.jerrymatera.gadsleaderboard.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import io.github.jerrymatera.gadsleaderboard.R

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val submitBtn = view.findViewById<MaterialButton>(R.id.submit_btn)
        submitBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_submitFragment, null)
        }
    }


}