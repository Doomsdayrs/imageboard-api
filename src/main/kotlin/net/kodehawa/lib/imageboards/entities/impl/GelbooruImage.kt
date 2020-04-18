package net.kodehawa.lib.imageboards.entities.impl

import com.fasterxml.jackson.annotation.JsonProperty
import net.kodehawa.lib.imageboards.entities.BoardImageStinged
import net.kodehawa.lib.imageboards.entities.Rating

data class GelbooruImage(
		@JsonProperty("source")
		val source: String? = null,

		@JsonProperty("hash")
		val hash: String? = null,

		@JsonProperty("height")
		override val height: Int = 0,

		@JsonProperty("width")
		override val width: Int = 0,

		@JsonProperty("score")
		override val score: Int = 0,

		@JsonProperty("url")
		override val url: String?,

		@JsonProperty("id")
		val id: Int = 0,

		@JsonProperty("image")
		val image: String? = null,

		@JsonProperty("owner")
		val owner: String? = null,

		@JsonProperty("tags")
		override val tagString: String? = null,

		//Thanks gelbooru for giving a full url I love you
		@JsonProperty("file_url")
		val fileUrl: String? = null,

		@JsonProperty("rating")
		val ratingString: String? = null
) : BoardImageStinged() {
	override val rating: Rating? = Rating.lookupFromStringShort(ratingString)
}