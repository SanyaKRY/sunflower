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

package com.google.samples.apps.sunflower.di

import com.google.samples.apps.sunflower.data.db.dao.GardenPlantingDao
import com.google.samples.apps.sunflower.data.db.dao.PlantDao
import com.google.samples.apps.sunflower.data.repository.GardenPlantingRepository
import com.google.samples.apps.sunflower.data.repository.PlantRepository
import com.google.samples.apps.sunflower.features.garden.domain.GardenPlantingRepositoryInterface
import com.google.samples.apps.sunflower.features.plantlist.domain.PlantRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideGardenPlantingRepository(gardenPlantingDao: GardenPlantingDao): GardenPlantingRepositoryInterface {
        return GardenPlantingRepository(gardenPlantingDao)
    }

    @Singleton
    @Provides
    fun providePlantRepository(plantDao: PlantDao): PlantRepositoryInterface {
        return PlantRepository(plantDao)
    }
}