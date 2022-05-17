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
class HomeflowUsb(private var mActivity: Activity, private var printables: MutableList<Printable>) {

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
            if (usbDevice != null) {
              HomeflowPrint.usb(printables, usbManager, usbDevice)
            }
          }
        }
      }
    }
  }

  /**
   * Print USB
   */
  @SuppressLint("UnspecifiedImmutableFlag")
  fun printUsb() {
    val usbConnection = UsbPrintersConnections.selectFirstConnected(mActivity)
    Log.e("USB", "USB CONNECTION: $usbConnection")
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
}