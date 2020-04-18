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
import java.util.regex.Pattern

/**
 * @author Kodehawa
 */
data class DanbooruImage(
		@JsonProperty("score")
		override val score: Int = 0,
		@JsonProperty("rating")
		val ratingString: String? = null,
		@JsonProperty("width")
		override val width: Int = 0,
		@JsonProperty("height")
		override val height: Int = 0,
		@JsonProperty("uploader_id")
		val uploaderId: Int = 0,
		@JsonProperty("source")
		val source: String? = null,
		@JsonProperty("tag_string")
		override val tagString: String? = null,
		@JsonProperty("file_ext")
		val fileExt: String? = null,
		@JsonProperty("file_size")
		val fileSize: Int = 0,
		@JsonProperty("up_score")
		val upScore: Int = 0,
		@JsonProperty("down_score")
		val downScore: Int = 0,
		@JsonProperty("tag_count")
		val tagCount: Int = 0,
		@JsonProperty("uploader_name")
		val uploaderName: String? = null,
		@JsonProperty("tag_string_artist")
		val tagStringArtist: String? = null,
		@JsonProperty("tag_string_character")
		val tagStringCharacter: String? = null,
		@JsonProperty("file_url")
		val fileUrl: String? = null,
		@JsonProperty("large_file_url")
		val largeFileUrl: String? = null,
		@JsonProperty("preview_file_url")
		val previewFileUrl: String? = null
) : BoardImageStinged() {
	@JsonIgnore
	override val rating: Rating? = Rating.lookupFromStringShort(ratingString)

	@JsonIgnore
	private val urlPattern = Pattern.compile("https(:)?//[\\w\\d.]*donmai.us")

	/**
	 * Danbooru normally returns the URL as
	 *
	 *"file_url": "/data/__furude_rika_higurashi_no_naku_koro_ni_drawn_by_kamaboko_red__fc6fb27e9c6ea2a77c849e5483eafc40.png"
	 * Which isn't reachable. This methods gets around it.
	 * @return The *reachable* URL to get this image. PNG format, or the extension defined in file_ext.
	 */
	@JsonIgnore
	val parsedFileUrl: String? = getFixedURL(fileUrl)

	/**
	 * Danbooru normally returns the URL as
	 *
	 *"large_file_url": "/data/__furude_rika_higurashi_no_naku_koro_ni_drawn_by_kamaboko_red__fc6fb27e9c6ea2a77c849e5483eafc40.jpg"
	 * Which isn't reachable. This methods gets around it.
	 * @return The *reachable* URL to get this image. JPG format.
	 */
	@JsonIgnore
	val parsedLargeFileUrl: String? = getFixedURL(largeFileUrl)

	/**
	 * Danbooru normally returns the URL as
	 *
	 *"preview_file_url": "/data/preview/fc6fb27e9c6ea2a77c849e5483eafc40.jpg"
	 * Which isn't reachable. This methods gets around it.
	 * @return The *reachable* URL to get this image. JPG format.
	 */
	@JsonIgnore
	val parsedPreviewFileUrl: String? = getFixedURL(previewFileUrl)

	@JsonIgnore
	private fun getFixedURL(url: String?): String? {
		if (url == null) {
			return null
		}
		val matcher = urlPattern.matcher(url)
		return if (matcher.find()) {
			if (matcher.group(1).isEmpty()) {
				// Broken URL (https//)
				url.replace("https//", "https://")
			} else {
				url // Valid URL
			}
		} else {
			// URL without domain (/data/XXX)
			"https://danbooru.donmai.us$url"
		}
	}

	@JsonIgnore
	override val url: String? = parsedFileUrl
}