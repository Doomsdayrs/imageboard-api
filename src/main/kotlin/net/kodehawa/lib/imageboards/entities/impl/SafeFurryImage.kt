package net.kodehawa.lib.imageboards.entities.impl

import net.kodehawa.lib.imageboards.entities.BoardImage
import net.kodehawa.lib.imageboards.entities.Rating

data class SafeFurryImage(
        override val score: Int = 0,
        override val rating: Rating? = null,
        override val width: Int = 0,
        override val height: Int = 0,
        override val tags: List<String> = arrayListOf(),
        val id: Int = 0,
        val description: String? = null,
        val creatorId: Int = 0,
        val author: String? = null,
        val change: Int = 0,
        val source: String? = null,
        val favCount: Int = 0,
        val md5: String? = null,
        val fileSize: Int = 0,
        val fileUrl: String? = null,
        val fileExt: String? = null,
        val previewUrl: String? = null,
        val status: String? = null

) : BoardImage {
	val artist: Array<String> = arrayOf()
	override val url: String? = fileUrl
}