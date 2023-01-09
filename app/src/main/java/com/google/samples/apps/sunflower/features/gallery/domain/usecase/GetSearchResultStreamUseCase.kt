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

package com.google.samples.apps.sunflower.features.gallery.domain.usecase

import androidx.paging.PagingData
import com.google.samples.apps.sunflower.data.datasource.api.model.UnsplashPhoto
import com.google.samples.apps.sunflower.features.gallery.domain.UnsplashRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchResultStreamUseCase @Inject constructor(private val repository: UnsplashRepository) {

    fun execute(query: String): Flow<PagingData<UnsplashPhoto>> {
        return repository.getSearchResultStream(query)
    }
}