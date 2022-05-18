[![Download](https://jitpack.io/v/ldavidsp/homeflow-print.svg)](https://jitpack.io/#ldavidsp/homeflow-print)
![GitHub repo size in bytes](https://img.shields.io/github/repo-size/ldavidsp/homeflow-print.svg)
![GitHub issues](https://img.shields.io/github/issues/ldavidsp/homeflow-print.svg)
![GitHub top language](https://img.shields.io/github/languages/top/ldavidsp/homeflow-print.svg)
![visitors](https://visitor-badge.laobi.icu/badge?page_id=homeflow-print.readme)

Homeflow Printer Android Kotlin
=====

Homeflow Printer, it is a library that uses https://github.com/DantSu/ESCPOS-ThermalPrinter-Android/tree/3.2.0 in a custom print format.

  - Bluetooth
  - USB
  - TCP
 
## Installation

**Step 1.** Add the [JitPack](https://jitpack.io/#ldavidsp/homeflow-print/1.1.0) repository to your build file. Add it in your root `/build.gradle` at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**If gradle is 7.2**:. Add the dependency in /settings.gradle:
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency in `/app/build.gradle` :

```gradle
dependencies {
    ...
    implementation 'com.github.ldavidsp:homeflow-print:v1.1.0'
}
```

## Bluetooth

### Bluetooth permission
Make sure to add the following permissions to your ```AndroidMenifest.xml```.
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
```
Also, you have to check the bluetooth permission in your app like this :
```kotlin
private fun printerPermission() {
    if ((checkSelfPermission(Manifest.permission.BLUETOOTH) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED) ||
      (checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_DENIED)
    ) {
      val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        arrayOf(
          Manifest.permission.BLUETOOTH,
          Manifest.permission.BLUETOOTH_SCAN,
          Manifest.permission.BLUETOOTH_ADMIN,
          Manifest.permission.BLUETOOTH_CONNECT,
          )
      } else {
        arrayOf(
          Manifest.permission.BLUETOOTH,
          Manifest.permission.BLUETOOTH_ADMIN,
        )
      }
      requestPermissions(permissions, 1)
    }
  }
```


Usage Homeflow Printer
-------------------
```kotlin
val printable = ArrayList<Printable>()
printable.add(TextPrintable.Builder().setCenter("ORDER N°045").setNewLine())
printable.add(TextPrintable.Builder().setLeft("BEAUTIFUL SHIRT").setRight("9.99e").setNewLine())

HomeflowPrint.bluetooth(printable)

or 

HomeflowPrint.usb(printable)

```


ESC/POS Thermal Printer - format
-------------------
```java
EscPosPrinter printer = new EscPosPrinter(BluetoothPrintersConnections.selectFirstPaired(), 203, 48f, 32);
printer
    .printFormattedText(
        "[C]<img>" + PrinterTextParserImg.bitmapToHexadecimalString(printer, this.getApplicationContext().getResources().getDrawableForDensity(R.drawable.logo, DisplayMetrics.DENSITY_MEDIUM))+"</img>\n" +
        "[L]\n" +
        "[C]<u><font size='big'>ORDER N°045</font></u>\n" +
        "[L]\n" +
        "[C]================================\n" +
        "[L]\n" +
        "[L]<b>BEAUTIFUL SHIRT</b>[R]9.99e\n" +
        "[L]  + Size : S\n" +
        "[L]\n" +
        "[L]<b>AWESOME HAT</b>[R]24.99e\n" +
        "[L]  + Size : 57/58\n" +
        "[L]\n" +
        "[C]--------------------------------\n" +
        "[R]TOTAL PRICE :[R]34.98e\n" +
        "[R]TAX :[R]4.23e\n" +
        "[L]\n" +
        "[C]================================\n" +
        "[L]\n" +
        "[L]<font size='tall'>Customer :</font>\n" +
        "[L]Raymond DUPONT\n" +
        "[L]5 rue des girafes\n" +
        "[L]31547 PERPETES\n" +
        "[L]Tel : +33801201456\n" +
        "[L]\n" +
        "[C]<barcode type='ean13' height='10'>831254784551</barcode>\n" +
        "[C]<qrcode size='20'>http://www.developpeur-web.dantsu.com/</qrcode>"
    );
```

