package io.github.jerrymatera.gadsleaderboard.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.jerrymatera.gadsleaderboard.databinding.FragmentSkilliqLeadersBinding
import io.github.jerrymatera.gadsleaderboard.ui.adapter.SkillIQLeadersAdapter

class SkillIQLeadersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSkilliqLeadersBinding.inflate(inflater, container, false)

        val adapter = SkillIQLeadersAdapter()
        binding.rvSkillIqLeaders.adapter = adapter

        return binding.root
    }


}