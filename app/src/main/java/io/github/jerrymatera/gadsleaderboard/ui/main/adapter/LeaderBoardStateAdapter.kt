package io.github.jerrymatera.gadsleaderboard.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.jerrymatera.gadsleaderboard.R
import io.github.jerrymatera.gadsleaderboard.ui.main.view.LearningLeadersFragment
import io.github.jerrymatera.gadsleaderboard.ui.main.view.MainFragment
import io.github.jerrymatera.gadsleaderboard.ui.main.view.SkillIQLeadersFragment

class LeaderBoardStateAdapter(val fm: MainFragment) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment = when(position){
        0 -> LearningLeadersFragment.newInstance()
        else -> SkillIQLeadersFragment.newInstance()

    }

    fun getTitle(position: Int):String{
        return when(position){
            0 -> fm.requireContext().resources.getString(R.string.learning_leaders)
            else -> fm.requireContext().resources.getString(R.string.skilliq_leaders)
        }
    }
}