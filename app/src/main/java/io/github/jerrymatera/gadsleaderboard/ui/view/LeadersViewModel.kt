package io.github.jerrymatera.gadsleaderboard.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.jerrymatera.gadsleaderboard.data.models.LearningLeader
import io.github.jerrymatera.gadsleaderboard.data.models.SkillIQLeader

class LeadersViewModel : ViewModel() {

    private var _leadersResults = MutableLiveData<List<LearningLeader>>()
    val leadersResults: LiveData<List<LearningLeader>>
        get() = _leadersResults

    private val _skillIQResults = MutableLiveData<List<SkillIQLeader>>()
    val skllIQResults: LiveData<List<SkillIQLeader>>
        get() = _skillIQResults


}