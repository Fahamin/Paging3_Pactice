package kodi.tv.iptv.m3u.paging3_pactice.View_Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kodi.tv.iptv.m3u.paging3_pactice.Repository.QuteRepository
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repo: QuteRepository) : ViewModel() {

    val data = repo.getQuets().cachedIn(viewModelScope)

}