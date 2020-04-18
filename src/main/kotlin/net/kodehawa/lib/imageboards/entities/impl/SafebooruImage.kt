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
import net.kodehawa.lib.imageboards.entities.BoardImageStinged
import net.kodehawa.lib.imageboards.entities.Rating

/**
 * @author Kodehawa
 */
data class SafebooruImage(
		@JsonProperty("score")
		override val score: Int = 0,

		@JsonProperty("rating")
		override val rating: Rating? = null,

		@JsonProperty("height")
		override val height: Int = 0,

		@JsonProperty("width")
		override val width: Int = 0,

		@JsonProperty("tags")
		override val tagString: String? = null,

		@JsonProperty("directory")
		val directory: String? = null,

		@JsonProperty("image")
		val image: String? = null

) : BoardImageStinged() {
	@JsonProperty("file_url")
	val fileUrl: String = "https://safebooru.org/images/$directory/$image"

	@JsonIgnore
	override val url: String? = fileUrl
}