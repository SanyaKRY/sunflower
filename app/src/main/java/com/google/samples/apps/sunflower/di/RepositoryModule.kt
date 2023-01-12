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

import com.google.samples.apps.sunflower.features.gallery.data.datasource.api.UnsplashService
import com.google.samples.apps.sunflower.features.garden.data.db.dao.GardenPlantingDao
import com.google.samples.apps.sunflower.features.plantlist.data.datasource.db.dao.PlantDao
import com.google.samples.apps.sunflower.features.garden.data.db.GardenPlantingRepositoryImpl
import com.google.samples.apps.sunflower.features.plantlist.data.PlantRepositoryImpl
import com.google.samples.apps.sunflower.features.gallery.data.repository.UnsplashRepositoryImpl
import com.google.samples.apps.sunflower.features.gallery.domain.UnsplashRepository
import com.google.samples.apps.sunflower.features.garden.domain.GardenPlantingRepository
import com.google.samples.apps.sunflower.features.plantdetail.domain.GardenPlantDetailsRepository
import com.google.samples.apps.sunflower.features.plantdetail.domain.PlantDetailsRepository
import com.google.samples.apps.sunflower.features.plantlist.domain.PlantRepository
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
    fun provideGardenPlantingRepository(gardenPlantingDao: GardenPlantingDao): GardenPlantingRepository {
        return GardenPlantingRepositoryImpl(gardenPlantingDao)
    }

    @Singleton
    @Provides
    fun providePlantRepository(plantDao: PlantDao): PlantRepository {
        return PlantRepositoryImpl(plantDao)
    }

    @Singleton
    @Provides
    fun provideGardenPlantDetailsRepository(gardenPlantingDao: GardenPlantingDao): GardenPlantDetailsRepository {
        return GardenPlantingRepositoryImpl(gardenPlantingDao)
    }

    @Singleton
    @Provides
    fun providePlantDetailsRepository(plantDao: PlantDao): PlantDetailsRepository {
        return PlantRepositoryImpl(plantDao)
    }

    @Singleton
    @Provides
    fun provideUnsplashRepository(service: UnsplashService): UnsplashRepository {
        return UnsplashRepositoryImpl(service)
    }
}