package com.homeflow.invoices.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.homeflow.invoices.app.databinding.ActivityMainBinding
import com.homeflow.printer.HomeflowPrint
import com.homeflow.printer.HomeflowUsb
import com.homeflow.printer.core.Printable
import com.homeflow.printer.core.TextPrintable


class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setSupportActionBar(binding.toolbar)

    binding.fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()

      val printable = ArrayList<Printable>()
      printable.add(TextPrintable.Builder().setNewLine())
      printable.add(TextPrintable.Builder().setCenter("EL BUEN AMIGO").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("18383838383").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("San Jose - Acosta - Cangrejal ( Lo que sea )").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("jpedrez@gmail.com").setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())

      printable.add(TextPrintable.Builder().setLeft("Condición: Contado").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Clave: Contado").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Tiquete Electrónico: 00001040000000118").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Cliente: Contado").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("13/04/2022 15:20:38").setNewLine())
      printable.add(TextPrintable.Builder().setLine("----------------------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Cant.").setCenter("Producto").setRight("Total").setNewLine())
      printable.add(TextPrintable.Builder().setLine("----------------------------------------").setNewLine())

      printable.add(TextPrintable.Builder().setLeft("1").setCenter("Laptop").setRight("C$ 1,200.00").setNewLine())

      printable.add(TextPrintable.Builder().setLine("----------------------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Subtotal Gravado").setRight("C$ 1,061.95").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Subtotal No Gravado").setRight("C$ 0.00").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Total Gravado").setRight("C$ 1,061.95").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Total No Gravado").setRight("C$ 0.00").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("IVA (%13)").setRight("C$ 138.00").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Total").setRight("C$ 1200.00").setNewLine())
      printable.add(TextPrintable.Builder().setLine("----------------------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Pago Efectivo Colones").setRight("C$ 1200.00").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("Autorizada mediante la resolución de Facturación Electrónica N° DGT-R-033-2019 del 20 de junio del 2019 de la Dirección General de Tributación. Versión del documento 4.3").setNewLine())


      val usb = HomeflowUsb(this@MainActivity, printable)
      usb.printUsb()
    }

    printerPermission()
  }
  /**
   * Printer Permission
   *
   */
  private fun printerPermission() {
    if ((checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.BLUETOOTH) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_DENIED)
    ) {
      val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        arrayOf(
          Manifest.permission.CAMERA,
          Manifest.permission.BLUETOOTH,
          Manifest.permission.BLUETOOTH_SCAN,
          Manifest.permission.BLUETOOTH_ADMIN,
          Manifest.permission.BLUETOOTH_CONNECT,
          Manifest.permission.ACCESS_FINE_LOCATION,
          Manifest.permission.WRITE_EXTERNAL_STORAGE,
          )
      } else {
        arrayOf(
          Manifest.permission.CAMERA,
          Manifest.permission.BLUETOOTH,
          Manifest.permission.BLUETOOTH_ADMIN,
          Manifest.permission.ACCESS_FINE_LOCATION,
          Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
      }
      requestPermissions(permissions, 1)
    }
  }

}