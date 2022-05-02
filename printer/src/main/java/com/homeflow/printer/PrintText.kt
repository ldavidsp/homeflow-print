package com.homeflow.printer

/**
 * Printable
 *
 * @constructor Create empty Printable
 */
object PrintText : Printable {
	private var print = ""

	/**
	 * Set line plane.
	 *
	 * @param string String
	 * @return Printable
	 */
	fun setLine(string: String): PrintText {
		this.print = string
		return this
	}

	/**
	 * Set text left.
	 *
	 * @param string String
	 * @return Printable
	 */
	fun setLeft(string: String): PrintText {
		this.print = "[L]$string"
		return this
	}

	/**
	 * Set text center.
	 *
	 * @param string String
	 * @return Printable
	 */
	fun setCenter(string: String): PrintText {
		this.print = "[C]$string"
		return this
	}

	/**
	 * Set text right.
	 *
	 * @param string String
	 * @return Printable
	 */
	fun setRight(string: String): PrintText {
		this.print = "[R]$string"
		return this
	}

	/**
	 * Set new line.
	 *
	 * @return String
	 */
	/*fun setNewLine(): Printable {
		return this.print.plus("\n").toString()
	}*/

	override fun getPrintables(): List<String> {
		TODO("Not yet implemented")
	}
}



