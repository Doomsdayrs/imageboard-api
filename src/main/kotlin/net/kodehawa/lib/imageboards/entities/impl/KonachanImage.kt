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

import com.fasterxml.jackson.annotation.JsonProperty
import net.kodehawa.lib.imageboards.entities.BoardImageStinged
import net.kodehawa.lib.imageboards.entities.Rating

/**
 * @author Kodehawa
 */
data class KonachanImage(
		@JsonProperty("height")
		override val height: Int = 0,
		@JsonProperty("width")
		override val width: Int = 0,
		@JsonProperty("score")
		override val score: Int = 0,

		@JsonProperty("url")
		override val url: String?,

		@JsonProperty("author")
		val author: String? = null,

		@JsonProperty("created_at")
		val createdAt: Int = 0,

		@JsonProperty("file_size")
		val fileSize: Long = 0,

		@JsonProperty("file_url")
		val fileUrl: String? = null,

		@JsonProperty("id")
		val id: Int = 0,

		@JsonProperty("jpeg_file_size")
		val jpegFileSize: Long = 0,

		@JsonProperty("jpeg_height")
		val jpegHeight: Int = 0,

		@JsonProperty("parsed_url")
		val parsedUrl: String? = null,

		@JsonProperty("jpeg_width")
		val jpegWidth: Int = 0,

		@JsonProperty("preview_height")
		val previewHeight: Int = 0,

		@JsonProperty("preview_url")
		val previewUrl: String? = null,

		@JsonProperty("preview_width")
		val previewWidth: Int = 0,

		@JsonProperty("sample_file_size")
		val sampleFileSize: Long = 0,

		@JsonProperty("sample_height")
		val sampleHeight: Int = 0,

		@JsonProperty("sample_url")
		val sampleUrl: String? = null,

		@JsonProperty("sample_width")
		val sampleWidth: Int = 0,

		@JsonProperty("source")
		val source: String? = null,

		@JsonProperty("status")
		val status: String? = null,

		@JsonProperty("tags")
		override val tagString: String? = null,

		@JsonProperty("rating")
		val ratingString: String? = null
) : BoardImageStinged() {
	override val rating: Rating? = Rating.lookupFromStringShort(ratingString)

}