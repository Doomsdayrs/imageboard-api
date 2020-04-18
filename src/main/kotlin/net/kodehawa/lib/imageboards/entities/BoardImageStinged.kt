package net.kodehawa.lib.imageboards.entities


/*
 * imageboard-api
 * 18 / 04 / 2020
 *
 * @author github.com/doomsdayrs
 */
abstract class BoardImageStinged : BoardImage {
	abstract override val width: Int
	abstract override val height: Int
	abstract override val score: Int
	abstract override val rating: Rating?
	abstract override val url: String?
	abstract val tagString: String?
	override val tags: List<String>
		get() = tagString?.split(" ") ?: arrayListOf()
}