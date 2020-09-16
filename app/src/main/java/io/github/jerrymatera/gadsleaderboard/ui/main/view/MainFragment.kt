package io.github.jerrymatera.gadsleaderboard.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import io.github.jerrymatera.gadsleaderboard.R
import io.github.jerrymatera.gadsleaderboard.ui.main.adapter.LeaderboardFragramentStateAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var leaderboardFragramentStateAdapter: LeaderboardFragramentStateAdapter
    private lateinit var viewPager: ViewPager2
    private var tabsTitle = arrayOf(R.string.learning_leaders, R.string.skilliq_leaders)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        leaderboardFragramentStateAdapter =
            LeaderboardFragramentStateAdapter(
                requireActivity()
            )
        viewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = leaderboardFragramentStateAdapter
        TabLayoutMediator(
            tabLayout,
            viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab: TabLayout.Tab, position: Int ->
                tab.text = tabsTitle[position].toString()
            }
        ).attach()
    }

}