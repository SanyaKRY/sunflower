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

package com.google.samples.apps.sunflower.features.plantlist.data

import com.google.samples.apps.sunflower.features.plantdetail.domain.PlantDetailsRepository
import com.google.samples.apps.sunflower.features.plantlist.data.datasource.db.dao.PlantDao
import com.google.samples.apps.sunflower.features.plantlist.domain.PlantRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository module for handling data operations.
 *
 * Collecting from the Flows in [PlantDao] is main-safe.  Room supports Coroutines and moves the
 * query execution off of the main thread.
 */
@Singleton
class PlantRepositoryImpl @Inject constructor(private val plantDao: PlantDao) :
    PlantRepository, PlantDetailsRepository {

    override fun getPlants() = plantDao.getPlants()

    override fun getPlant(plantId: String) = plantDao.getPlant(plantId)

    override fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: PlantRepositoryImpl? = null

        fun getInstance(plantDao: PlantDao) =
            instance ?: synchronized(this) {
                instance ?: PlantRepositoryImpl(plantDao).also { instance = it }
            }
    }
}