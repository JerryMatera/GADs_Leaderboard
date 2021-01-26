package io.github.jerrymatera.gadsleaderboard.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.jerrymatera.gadsleaderboard.ui.view.LearningLeadersFragment
import io.github.jerrymatera.gadsleaderboard.ui.view.SkillIQLeadersFragment

const val LEARNING_LEADERS_INDEX = 0
const val SKILL_IQ_LEADERS_INDEX = 1

class LeaderBoardStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabsFragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        LEARNING_LEADERS_INDEX to { LearningLeadersFragment() },
        SKILL_IQ_LEADERS_INDEX to { SkillIQLeadersFragment() }
    )

    override fun getItemCount() = tabsFragmentsCreator.size

    override fun createFragment(position: Int): Fragment {
        return tabsFragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}