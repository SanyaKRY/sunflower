/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.features.garden.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.google.samples.apps.sunflower.data.datasource.db.model.PlantAndGardenPlantings
import com.google.samples.apps.sunflower.features.garden.domain.usecase.GetPlantedGardensUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GardenPlantingListViewModel @Inject internal constructor(
    private val getPlantedGardensUseCase: GetPlantedGardensUseCase
) : ViewModel() {
    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
        getPlantedGardensUseCase.execute().asLiveData()
}
