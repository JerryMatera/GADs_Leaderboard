package io.github.jerrymatera.gadsleaderboard.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.jerrymatera.gadsleaderboard.databinding.FragmentLearningLeadersBinding
import io.github.jerrymatera.gadsleaderboard.ui.adapter.LearningLeadersAdapter

class LearningLeadersFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLearningLeadersBinding.inflate(inflater, container, false)

        val adapter = LearningLeadersAdapter()
        binding.rvLearningLeaders.adapter = adapter

        return binding.root
    }
}