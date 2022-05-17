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
   * @property image String
   * @property textLeft String
   * @property textCenter String
   * @property textRight String
   * @property textLine String
   * @property barCode String
   * @property qrCode String
   */
  class Builder {
    private var image: String = ""
    private var textLeft: String = ""
    private var textCenter: String = ""
    private var textRight: String = ""
    private var textLine: String = ""
    private var barCode: String = ""
    private var qrCode: String = ""

    /**
     * Set image.
     *
     * @param setImage Drawable
     * @return Builder
     */
    /*fun setImage(setImage: Int, activity: Activity): Builder {
      //val printer = EscPosPrinterSize()
      //this.image = "[C]<img>${PrinterTextParserImg.bitmapToHexadecimalString(34f, activity.resources.getDrawableForDensity(setImage, DisplayMetrics.DENSITY_MEDIUM))}</img>"
      return this
    }*/

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

