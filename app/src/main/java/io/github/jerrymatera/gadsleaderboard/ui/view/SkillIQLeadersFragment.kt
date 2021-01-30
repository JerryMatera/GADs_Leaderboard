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
import io.github.jerrymatera.gadsleaderboard.databinding.FragmentSkilliqLeadersBinding
import io.github.jerrymatera.gadsleaderboard.ui.adapter.SkillIQLeadersAdapter
import io.github.jerrymatera.gadsleaderboard.utils.Resource

class SkillIQLeadersFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSkilliqLeadersBinding.inflate(inflater, container, false)

        val adapter = SkillIQLeadersAdapter()
        binding.rvSkillIqLeaders.adapter = adapter

        viewModel.skllIQResults.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.SkillIQProgressBar.isVisible
                }
                is Resource.Success -> {
                    binding.SkillIQProgressBar.isInvisible
                    response.data?.let {
                        adapter.submitList(it)
                    }
                }
                is Resource.Error -> {
                    binding.SkillIQProgressBar.isInvisible
                    Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show()
                }

            }
        })

        return binding.root
    }


}