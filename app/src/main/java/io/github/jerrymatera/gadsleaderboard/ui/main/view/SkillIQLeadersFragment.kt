package io.github.jerrymatera.gadsleaderboard.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.jerrymatera.gadsleaderboard.R

class SkillIQLeadersFragment : Fragment() {

    companion object {
        fun newInstance() =
            SkillIQLeadersFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skilliq_leaders, container, false)
    }


}