/*
 * Copyright 2017 Kodehawa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kodehawa.lib.imageboards.entities.impl

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import net.kodehawa.lib.imageboards.entities.BoardImage
import net.kodehawa.lib.imageboards.entities.Rating

/**
 * @author Kodehawa
 */
data class FurryImage(
		//Image description
		@JsonProperty("description")
		val description: String? = null,
		@JsonProperty("url")
		override val url: String? = null,
		@JsonProperty("score")
		override val score: Int = 0,
		@JsonProperty("height")
		override val height: Int = 0,
		@JsonProperty("width")
		override val width: Int = 0,

		@JsonIgnore
		override val rating: Rating? = Rating.EXPLICIT,

		@JsonProperty("tags")
		override val tags: List<String>
) : BoardImage