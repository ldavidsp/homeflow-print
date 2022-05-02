package com.homeflow.printer.core

/**
 * Printer Text.
 *
 * @property text String
 * @constructor
 */
data class TextPrintable constructor(val text: String) : Printable {

  /**
   * Get Printables.
   *
   * @return List<String>
   */
  override fun getPrintables(): String {
    return text
  }

  /**
   * Builder.
   *
   * @property textLeft String
   * @property textCenter String
   * @property textRight String
   * @property textLine String
   */
  class Builder {
    private var textLeft = ""
    private var textCenter = ""
    private var textRight = ""
    private var textLine = ""

    /**
     * Set line plane.
     *
     * @param setLine String
     * @return Printable
     */
    fun setLine(setLine: String): Builder {
      this.textLine = setLine
      return this
    }

    /**
     * Set text left.
     *
     * @param textLeft String
     * @return Printable
     */
    fun setLeft(textLeft: String): Builder {
      this.textLeft = "[L]$textLeft"
      return this
    }

    /**
     * Set text center.
     *
     * @param setCenter String
     * @return Printable
     */
    fun setCenter(setCenter: String): Builder {
      this.textCenter = "[C]$setCenter"
      return this
    }

    /**
     * Set text right.
     *
     * @param setRight String
     * @return Printable
     */
    fun setRight(setRight: String): Builder {
      this.textRight = "[R]$setRight"
      return this
    }

    /**
     * Set new line.
     *
     * @return String
     */
    fun setNewLine(): Printable {
      return TextPrintable("$textLeft$textCenter$textRight$textLine\n")
    }
  }
}

