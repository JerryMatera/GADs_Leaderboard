package io.github.jerrymatera.gadsleaderboard.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jerrymatera.gadsleaderboard.data.models.LearningLeader
import io.github.jerrymatera.gadsleaderboard.data.models.SkillIQLeader
import io.github.jerrymatera.gadsleaderboard.data.network.GadsApiService
import io.github.jerrymatera.gadsleaderboard.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var _leadersResults = MutableLiveData<Resource<List<LearningLeader>>>()
    val leadersResults: LiveData<Resource<List<LearningLeader>>>
        get() = _leadersResults

    private val _skillIQResults = MutableLiveData<Resource<List<SkillIQLeader>>>()
    val skllIQResults: LiveData<Resource<List<SkillIQLeader>>>
        get() = _skillIQResults


    init {
        getLeadersResults()
        getSkillIQResults()
    }

    private fun getLeadersResults() = viewModelScope.launch {
        _leadersResults.postValue(Resource.Loading())
        val response = GadsApiService.create().getLearningLeaders()
        _leadersResults.postValue(handleLeadersResponse(response))
    }

    private fun handleLeadersResponse(response: Response<List<LearningLeader>>): Resource<List<LearningLeader>> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    private fun getSkillIQResults() = viewModelScope.launch {
        _skillIQResults.postValue(Resource.Loading())
        val response = GadsApiService.create().getSkillIQLeaders()
        _skillIQResults.postValue(handleSkillIQResponse(response))
    }

    private fun handleSkillIQResponse(response: Response<List<SkillIQLeader>>): Resource<List<SkillIQLeader>> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
}