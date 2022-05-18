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
import com.dantsu.escposprinter.EscPosCharsetEncoding
import com.dantsu.escposprinter.EscPosPrinter
import com.dantsu.escposprinter.connection.bluetooth.BluetoothPrintersConnections
import com.dantsu.escposprinter.connection.tcp.TcpConnection
import com.dantsu.escposprinter.connection.usb.UsbConnection
import com.dantsu.escposprinter.connection.usb.UsbPrintersConnections
import com.homeflow.printer.core.Printable

/**
 * Homeflow USB
 *
 * @property mActivity Activity
 * @property printables MutableList<Printable>
 * @property usbReceiver BroadcastReceiver
 * @constructor
 */
class HomeflowPrinter(private var mActivity: Activity, private var printables: MutableList<Printable>) {

  /**
   * Print Bluetooth.
   */
  fun printBluetooth() {
    val printer = EscPosPrinter(BluetoothPrintersConnections.selectFirstPaired(), 203, 48f, 32, EscPosCharsetEncoding("windows-1252", 16))
    printer.printFormattedText(rows(printables))
    printer.disconnectPrinter()
  }

  /**
   * Print USB
   */
  @SuppressLint("UnspecifiedImmutableFlag")
  fun printUsb() {
    val usbConnection = UsbPrintersConnections.selectFirstConnected(mActivity)
    val usbManager = mActivity.getSystemService(Context.USB_SERVICE) as UsbManager?
    if (usbConnection != null && usbManager != null) {
      val permissionIntent: PendingIntent = PendingIntent.getBroadcast(
        mActivity,
        0,
        Intent("com.android.example.USB_PERMISSION"),
        0
      )
      val filter = IntentFilter("com.android.example.USB_PERMISSION")
      mActivity.registerReceiver(this.usbReceiver, filter)
      usbManager.requestPermission(usbConnection.device, permissionIntent)
    }
  }

  /**
   * Print TCP
   */
  fun printTCP(ip: String, port: Int) {
    Thread {
      try {
        val printer = EscPosPrinter(TcpConnection(ip, port, 15), 203, 48f, 32)
        printer.printFormattedText(rows(printables))
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }.start()
  }

  /**
   * Print Preview Log
   */
  fun printPreviewLog() {
    printables.map { Log.e("PREVIEW: ", it.getPrintables()) }
  }

  /**
   * USB Broadcast Receiver
   */
  private fun printUsb(printables: MutableList<Printable>, usbManager: UsbManager, usbDevice: UsbDevice) {
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
   * Usb receiver
   */
  private val usbReceiver: BroadcastReceiver = object : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
      val action = intent.action
      if ("com.android.example.USB_PERMISSION" == action) {
        synchronized(this) {
          val usbManager = mActivity.getSystemService(Context.USB_SERVICE) as UsbManager
          val usbDevice = intent.getParcelableExtra<Parcelable>(UsbManager.EXTRA_DEVICE) as UsbDevice?
          if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
            if (usbManager != null && usbDevice != null) {
              printUsb(printables, usbManager, usbDevice)
              unregisterReceiver()
            }
          }
        }
      }
    }
  }

  /**
   * Unregister receiver
   */
  private fun unregisterReceiver() {
    mActivity.unregisterReceiver(usbReceiver)
  }
}

