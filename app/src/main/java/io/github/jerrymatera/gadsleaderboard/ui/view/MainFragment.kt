package io.github.jerrymatera.gadsleaderboard.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayoutMediator
import io.github.jerrymatera.gadsleaderboard.R
import io.github.jerrymatera.gadsleaderboard.databinding.FragmentMainBinding
import io.github.jerrymatera.gadsleaderboard.ui.adapter.LEARNING_LEADERS_INDEX
import io.github.jerrymatera.gadsleaderboard.ui.adapter.LeaderBoardStateAdapter
import io.github.jerrymatera.gadsleaderboard.ui.adapter.SKILL_IQ_LEADERS_INDEX

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        binding.submitBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_submitFragment))

        viewPager.adapter = LeaderBoardStateAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            LEARNING_LEADERS_INDEX -> getString(R.string.learning_leaders)
            SKILL_IQ_LEADERS_INDEX -> getString(R.string.skill_iq_leaders)
            else -> null
        }
    }


}