package io.github.jerrymatera.gadsleaderboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.jerrymatera.gadsleaderboard.R
import io.github.jerrymatera.gadsleaderboard.data.models.SkillIQLeader
import io.github.jerrymatera.gadsleaderboard.databinding.SkillIqLeadersItemBinding

class SkillIQLeadersAdapter : ListAdapter<SkillIQLeader, SkillIQLeadersAdapter.SkillIQViewHolder>(
    SkillIQLeaderDiffUtilCallback()
) {

    class SkillIQViewHolder private constructor(val binding: SkillIqLeadersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SkillIQLeader) {
            val skillIQScore = "${item.score} skill IQ Score, ${item.country}"

            binding.skillIqImage.setImageResource(R.drawable.skill_iq_trimmed)
            binding.leaderName.text = item.name
            binding.skillIqData.text = skillIQScore
        }

        companion object {
            fun from(parent: ViewGroup): SkillIQViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SkillIqLeadersItemBinding
                    .inflate(layoutInflater, parent, false)
                return SkillIQViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillIQViewHolder {
        return SkillIQViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SkillIQViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class SkillIQLeaderDiffUtilCallback : DiffUtil.ItemCallback<SkillIQLeader>() {
    override fun areItemsTheSame(oldItem: SkillIQLeader, newItem: SkillIQLeader): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: SkillIQLeader, newItem: SkillIQLeader): Boolean {
        return oldItem == newItem
    }

}
