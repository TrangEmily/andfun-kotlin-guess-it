package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    private var _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score
    val score_string = Transformations.map(score, { currentScore ->
        currentScore.toString()
    })

    private var _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain : LiveData<Boolean>
        get() = _eventPlayAgain

    init {
        _score.value = finalScore
        _eventPlayAgain.value = false
    }

    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun onPlayAgainCompleted() {
        _eventPlayAgain.value = false
    }
}