package com.homeflow.invoices.app;

import com.google.gson.annotations.SerializedName;

public class TiposPagoItem{

	@SerializedName("tipo")
	private String tipo;

	@SerializedName("monto")
	private String monto;

	public String getTipo(){
		return tipo;
	}

	public String getMonto(){
		return monto;
	}
}