package io.github.jerrymatera.gadsleaderboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.jerrymatera.gadsleaderboard.data.models.LearningLeader
import io.github.jerrymatera.gadsleaderboard.databinding.LearningLeaderItemBinding

class LearningLeadersAdapter : RecyclerView.Adapter<LearningLeadersAdapter.LearnerViewHolder>() {

    val data = listOf<LearningLeader>()

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnerViewHolder {
        return LearnerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LearnerViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class LearnerViewHolder private constructor(val binding: LearningLeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LearningLeader) {

            val learnerScore = "${item.hours} Learning hours, ${item.country}"

            binding.leaderName.text = item.name
            binding.learnerData.text = learnerScore
        }


        companion object {
            fun from(parent: ViewGroup): LearnerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LearningLeaderItemBinding
                    .inflate(layoutInflater, parent, false)
                return LearnerViewHolder(binding)
            }
        }
    }
}