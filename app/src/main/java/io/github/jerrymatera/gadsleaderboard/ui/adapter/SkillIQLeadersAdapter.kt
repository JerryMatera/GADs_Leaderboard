package io.github.jerrymatera.gadsleaderboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.jerrymatera.gadsleaderboard.data.models.SkillIQLeader
import io.github.jerrymatera.gadsleaderboard.databinding.SkillIqLeadersItemBinding

class SkillIQLeadersAdapter : RecyclerView.Adapter<SkillIQLeadersAdapter.SkillIQViewHolder>() {
    val data = listOf<SkillIQLeader>()

    class SkillIQViewHolder private constructor(val binding: SkillIqLeadersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SkillIQLeader) {
            val skillIQScore = "${item.score} skill IQ Score, ${item.country}"

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
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size
}