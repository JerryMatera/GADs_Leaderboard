package io.github.jerrymatera.gadsleaderboard.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.jerrymatera.gadsleaderboard.ui.main.view.LearningLeadersFragment
import io.github.jerrymatera.gadsleaderboard.ui.main.view.SkillIQLeadersFragment

class LeaderboardFragramentStateAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> LearningLeadersFragment.newInstance()
            else -> SkillIQLeadersFragment.newInstance()

        }
    }

}