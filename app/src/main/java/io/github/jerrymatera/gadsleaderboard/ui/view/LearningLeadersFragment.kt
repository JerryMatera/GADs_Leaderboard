package io.github.jerrymatera.gadsleaderboard.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.github.jerrymatera.gadsleaderboard.databinding.FragmentLearningLeadersBinding
import io.github.jerrymatera.gadsleaderboard.ui.adapter.LearningLeadersAdapter
import io.github.jerrymatera.gadsleaderboard.utils.Resource

class LearningLeadersFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLearningLeadersBinding.inflate(inflater, container, false)

        val adapter = LearningLeadersAdapter()
        binding.rvLearningLeaders.adapter = adapter

        viewModel.leadersResults.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.LearnserProgressBar.isVisible
                }
                is Resource.Success -> {
                    binding.LearnserProgressBar.isInvisible
                    response.data?.let {
                        adapter.submitList(it)
                    }
                }
                is Resource.Error -> {
                    binding.LearnserProgressBar.isInvisible
                    Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show()
                }

            }
        })

        return binding.root
    }

}