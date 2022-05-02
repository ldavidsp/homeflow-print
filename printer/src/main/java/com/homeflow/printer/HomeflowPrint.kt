package com.homeflow.printer

import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import com.dantsu.escposprinter.EscPosPrinter
import com.dantsu.escposprinter.connection.bluetooth.BluetoothPrintersConnections
import com.dantsu.escposprinter.connection.usb.UsbConnection

/**
 * Homeflow print
 *
 * @constructor Create empty Homeflow print
 */
object HomeflowPrint {

  /**
   * Print Bluetooth.
   *
   * @param invoice String
   */
  fun bluetooth(invoice: String) {
    val printer = EscPosPrinter(BluetoothPrintersConnections.selectFirstPaired(), 203, 48f, 32)
    printer.printFormattedText(invoice)
    printer.disconnectPrinter()
  }

  /**
   * Print USB.
   *
   * @param invoice String
   */
  fun usb(invoice: String, usbManager: UsbManager, usbDevice: UsbDevice) {
    val printer = EscPosPrinter(UsbConnection(usbManager, usbDevice), 203, 48f, 32)
    printer.printFormattedText(invoice)
    printer.disconnectPrinter()
  }
}
