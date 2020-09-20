package io.github.jerrymatera.gadsleaderboard.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayoutMediator
import io.github.jerrymatera.gadsleaderboard.R
import io.github.jerrymatera.gadsleaderboard.ui.adapter.LeaderBoardStateAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val submitBtn = view.findViewById<MaterialButton>(R.id.submit_btn)
        submitBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_submitFragment, null)
        }

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val adapter = LeaderBoardStateAdapter(this@MainFragment)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()
    }


}