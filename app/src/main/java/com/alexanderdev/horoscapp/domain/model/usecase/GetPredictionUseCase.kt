package com.alexanderdev.horoscapp.domain.model.usecase

import com.alexanderdev.horoscapp.domain.model.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}