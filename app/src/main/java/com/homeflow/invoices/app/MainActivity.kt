package com.homeflow.invoices.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.homeflow.invoices.app.databinding.ActivityMainBinding
import com.homeflow.printer.HomeflowPrinter
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
      printable.add(TextPrintable.Builder().setCenter(getString(R.string.app_name)).setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())

      // Part 2
      printable.add(TextPrintable.Builder().setCenter("LEON / 2341-2017").setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())
      printable.add(TextPrintable.Builder().setCenter("Recibo: 1").setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())

      // Part 3
      printable.add(TextPrintable.Builder().setLeft("Fecha/Hora:").setRight("14/11/2022").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Transaccion:").setRight("8463562726").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Transaccion:").setCenter("ID").setRight("8463562726").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Cobro del Dia:").setCenter("2783483").setRight("84635").setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())

      // Part 4
      printable.add(TextPrintable.Builder().setLeft("Cliente: ").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Luis David Solorzano Paredes").setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())

      // Part 5
      printable.add(TextPrintable.Builder().setLeft("Cobro del Dia").setRight("C$ 1,200").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Monto atrasado:").setRight("C$ 200").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Dias mora:").setRight("1").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Monto int. moratorio:").setRight("C$ 13,200").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("--------------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Total a pagar:").setRight("C$ 16,200").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("--------------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Monto de cancelacion:").setRight("C$ 18,200").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("--------------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())

      // Part 6
      printable.add(TextPrintable.Builder().setLeft("Total cobrado:").setRight("C$ 1,000").setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())

      // Part 7
      printable.add(TextPrintable.Builder().setLeft("Concepto:").setRight("ABONO").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Saldo anterior:").setRight("C$ 18,200").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Nuevo saldo:").setRight("C$ 16,200").setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())
      printable.add(TextPrintable.Builder().setNewLine())

      // Part 8
      printable.add(TextPrintable.Builder().setCenter("-------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("Jose David Solorzano").setNewLine())


      HomeflowPrinter(this@MainActivity, printable).printAsyncBlueTooth()
    }

    printerPermission()

    //Log.e("TAG", "onCreate: ${String(byteArrayOf(0), Charsets.UTF_8)}")
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