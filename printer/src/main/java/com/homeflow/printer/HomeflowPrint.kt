package com.homeflow.printer

import android.annotation.SuppressLint
import android.app.Activity
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.os.Parcelable
import android.util.Log
import androidx.core.content.ContextCompat
import com.dantsu.escposprinter.EscPosCharsetEncoding
import com.dantsu.escposprinter.EscPosPrinter
import com.dantsu.escposprinter.connection.bluetooth.BluetoothPrintersConnections
import com.dantsu.escposprinter.connection.usb.UsbConnection
import com.dantsu.escposprinter.connection.usb.UsbPrintersConnections
import com.homeflow.printer.core.Printable


/**
 * Homeflow print
 *
 * @constructor Create empty Homeflow print
 */
object HomeflowPrint {

  /**
   * Print Bluetooth.
   *
   * @param printables MutableList<Printable>
   */
  fun bluetooth(printables: MutableList<Printable>) {
    val printer = EscPosPrinter(BluetoothPrintersConnections.selectFirstPaired(), 203, 48f, 32, EscPosCharsetEncoding("windows-1252", 16))
    printer.printFormattedText(rows(printables))
    printer.disconnectPrinter()
  }

  /**
   * Print USB.
   *
   * @param printables MutableList<Printable>
   */
  fun usb(printables: MutableList<Printable>, usbManager: UsbManager, usbDevice: UsbDevice) {
    val printer = EscPosPrinter(UsbConnection(usbManager, usbDevice), 203, 48f, 32)
    printer.printFormattedText(rows(printables))
    printer.disconnectPrinter()
  }

  /**
   * Rows printable.
   *
   * @param printables MutableList<Printable>
   * @return String
   */
  private fun rows(printables: MutableList<Printable>): String {
    var printable = ""
    printables.map { printable += it.getPrintables() }
    return printable
  }

  /**
   * Rows printable.
   *
   * @param printables MutableList<Printable>
   * @return String
   */
  fun previewLog(printables: MutableList<Printable>) {
    printables.map { Log.e("PRINTABLE: ", it.getPrintables()) }
  }

}
