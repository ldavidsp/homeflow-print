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
    implementation 'com.github.ldavidsp:homeflow-print:v2.0.3'
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
printable.add(TextPrintable.Builder().setNewLine())
printable.add(TextPrintable.Builder().setCenter("EL TEST").setNewLine())
printable.add(TextPrintable.Builder().setCenter("18383838383").setNewLine())
printable.add(TextPrintable.Builder().setCenter("San Marcos").setNewLine())
printable.add(TextPrintable.Builder().setCenter("jpehgsre@gmail.com").setNewLine())
printable.add(TextPrintable.Builder().setNewLine())

printable.add(TextPrintable.Builder().setLeft("Condición: Contado").setNewLine())
printable.add(TextPrintable.Builder().setLeft("Clave: Contado").setNewLine())
printable.add(TextPrintable.Builder().setLeft("Tiquete: 000010400").setNewLine())
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
printable.add(TextPrintable.Builder().setLeft("Pago Efectivo").setRight("C$ 1200.00").setNewLine())

HomeflowPrinter(mActivity, printable).printBluetooth()

or

HomeflowPrinter(mActivity, printable).printUsb()

```
