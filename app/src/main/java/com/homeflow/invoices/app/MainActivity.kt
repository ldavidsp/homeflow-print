package com.homeflow.invoices.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import com.homeflow.invoices.app.databinding.ActivityMainBinding
import com.homeflow.printer.HomeflowPrint
import com.homeflow.printer.core.Printable
import com.homeflow.printer.core.TextPrintable


class MainActivity : AppCompatActivity() {
  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)

    val navController = findNavController(R.id.nav_host_fragment_content_main)
    appBarConfiguration = AppBarConfiguration(navController.graph)
    setupActionBarWithNavController(navController, appBarConfiguration)

    binding.fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()

      val printable = ArrayList<Printable>()

      printable.add(TextPrintable.Builder().setLeft("TERMINAL:").setRight("342222").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("NUM. TARJETA:").setRight("535353").setNewLine())
      printable.add(TextPrintable.Builder().setLine("----------------------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("VENTA FACTURA Nro:").setRight("7373").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Fecha: 12/03/2000").setRight("Hora: $23:49").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("Ref: 93939393").setRight("Autorizacion: $8383").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("FORMA DE PAGO:").setRight("QPOS").setNewLine())
      printable.add(TextPrintable.Builder().setLeft("TOTAL:").setRight("7373").setNewLine())

      printable.add(TextPrintable.Builder().setLine("----------------------------------------").setNewLine())
      printable.add(TextPrintable.Builder().setCenter("No  requiere firma").setNewLine())

      HomeflowPrint.previewLog(printable)
      HomeflowPrint.bluetooth(printable)
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

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    return when (item.itemId) {
      R.id.action_settings -> true
      else -> super.onOptionsItemSelected(item)
    }
  }

  override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_main)
    return navController.navigateUp(appBarConfiguration)
      || super.onSupportNavigateUp()
  }
}