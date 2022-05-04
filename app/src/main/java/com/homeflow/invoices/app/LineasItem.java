package com.homeflow.invoices.app;

import com.google.gson.annotations.SerializedName;

public class LineasItem{

	@SerializedName("Total")
	private String total;

	@SerializedName("cantidad")
	private int cantidad;

	@SerializedName("producto")
	private String producto;

	public String getTotal(){
		return total;
	}

	public int getCantidad(){
		return cantidad;
	}

	public String getProducto(){
		return producto;
	}
}