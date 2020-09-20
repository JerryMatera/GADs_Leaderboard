package io.github.jerrymatera.gadsleaderboard.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.jerrymatera.gadsleaderboard.R
import io.github.jerrymatera.gadsleaderboard.ui.view.LearningLeadersFragment
import io.github.jerrymatera.gadsleaderboard.ui.view.MainFragment
import io.github.jerrymatera.gadsleaderboard.ui.view.SkillIQLeadersFragment

class LeaderBoardStateAdapter(private val fm: MainFragment) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment = when (position) {
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