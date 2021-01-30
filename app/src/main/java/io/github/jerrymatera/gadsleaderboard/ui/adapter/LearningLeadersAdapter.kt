package io.github.jerrymatera.gadsleaderboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.jerrymatera.gadsleaderboard.R
import io.github.jerrymatera.gadsleaderboard.data.models.LearningLeader
import io.github.jerrymatera.gadsleaderboard.databinding.LearningLeaderItemBinding

class LearningLeadersAdapter :
    ListAdapter<LearningLeader, LearningLeadersAdapter.LearnerViewHolder>(
        LearningLearderDiffUtilCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnerViewHolder {
        return LearnerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LearnerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class LearnerViewHolder private constructor(val binding: LearningLeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LearningLeader) {

            val learnerScore = "${item.hours} Learning hours, ${item.country}"

            binding.learnerImage.setImageResource(
                R.drawable.top_learner
            )
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

class LearningLearderDiffUtilCallback : DiffUtil.ItemCallback<LearningLeader>() {
    override fun areItemsTheSame(oldItem: LearningLeader, newItem: LearningLeader): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: LearningLeader, newItem: LearningLeader): Boolean {
        return oldItem == newItem
    }

}