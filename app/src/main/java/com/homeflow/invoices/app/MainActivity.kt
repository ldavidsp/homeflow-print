package com.homeflow.invoices.app

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
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

      val print = ArrayList<Printable>()

      print.add(TextPrintable.Builder().setLeft("TERMINAL:").setRight("342222").setNewLine())
      print.add(TextPrintable.Builder().setLeft("NUM. TARJETA:").setRight("535353").setNewLine())
      print.add(TextPrintable.Builder().setLine("----------------------------------------").setNewLine())
      print.add(TextPrintable.Builder().setLeft("VENTA FACTURA Nro:").setRight("7373").setNewLine())
      print.add(TextPrintable.Builder().setLeft("Fecha: 12/03/2000").setRight("Hora: $23:49").setNewLine())
      print.add(TextPrintable.Builder().setLeft("Ref: 93939393").setRight("Autorizacion: $8383").setNewLine())
      print.add(TextPrintable.Builder().setLeft("FORMA DE PAGO:").setRight("QPOS").setNewLine())
      print.add(TextPrintable.Builder().setLeft("TOTAL:").setRight("7373").setNewLine())

      print.add(TextPrintable.Builder().setLine("----------------------------------------").setNewLine())
      print.add(TextPrintable.Builder().setCenter("No  requiere firma").setNewLine())

      Log.e("DATA: ", HomeflowPrint.previewLog(print))
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