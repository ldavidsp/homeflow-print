package com.homeflow.invoices.app;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("footer2")
	private String footer2;

	@SerializedName("footer1")
	private String footer1;

	@SerializedName("tiquete_electronico")
	private String tiqueteElectronico;

	@SerializedName("tiposPago")
	private List<TiposPagoItem> tiposPago;

	@SerializedName("comprobante")
	private String comprobante;

	@SerializedName("total_gravado")
	private String totalGravado;

	@SerializedName("total")
	private String total;

	@SerializedName("sub_total_gravado")
	private String subTotalGravado;

	@SerializedName("iva")
	private String iva;

	@SerializedName("nombre_empresa")
	private String nombreEmpresa;

	@SerializedName("correo")
	private String correo;

	@SerializedName("moneda")
	private String moneda;

	@SerializedName("total_no_gravado")
	private String totalNoGravado;

	@SerializedName("telefono")
	private String telefono;

	@SerializedName("lineas")
	private List<LineasItem> lineas;

	@SerializedName("vendedor")
	private String vendedor;

	@SerializedName("clave")
	private String clave;

	@SerializedName("gran_total")
	private String granTotal;

	@SerializedName("nombre_comercial")
	private String nombreComercial;

	@SerializedName("direccion")
	private String direccion;

	@SerializedName("fecha_hora")
	private String fechaHora;

	@SerializedName("identificacion")
	private String identificacion;

	@SerializedName("condicion")
	private String condicion;

	@SerializedName("sub_total_no_gravado")
	private String subTotalNoGravado;

	@SerializedName("ivaArray")
	private List<Object> ivaArray;

	@SerializedName("cliente")
	private String cliente;

	@SerializedName("caja_nro")
	private String cajaNro;

	@SerializedName("tipo_cambio")
	private int tipoCambio;

	@SerializedName("codigo_unico")
	private String codigoUnico;

	@SerializedName("porcentaje_iva")
	private String porcentajeIva;

	public String getFooter2(){
		return footer2;
	}

	public String getFooter1(){
		return footer1;
	}

	public String getTiqueteElectronico(){
		return tiqueteElectronico;
	}

	public List<TiposPagoItem> getTiposPago(){
		return tiposPago;
	}

	public String getComprobante(){
		return comprobante;
	}

	public String getTotalGravado(){
		return totalGravado;
	}

	public String getTotal(){
		return total;
	}

	public String getSubTotalGravado(){
		return subTotalGravado;
	}

	public String getIva(){
		return iva;
	}

	public String getNombreEmpresa(){
		return nombreEmpresa;
	}

	public String getCorreo(){
		return correo;
	}

	public String getMoneda(){
		return moneda;
	}

	public String getTotalNoGravado(){
		return totalNoGravado;
	}

	public String getTelefono(){
		return telefono;
	}

	public List<LineasItem> getLineas(){
		return lineas;
	}

	public String getVendedor(){
		return vendedor;
	}

	public String getClave(){
		return clave;
	}

	public String getGranTotal(){
		return granTotal;
	}

	public String getNombreComercial(){
		return nombreComercial;
	}

	public String getDireccion(){
		return direccion;
	}

	public String getFechaHora(){
		return fechaHora;
	}

	public String getIdentificacion(){
		return identificacion;
	}

	public String getCondicion(){
		return condicion;
	}

	public String getSubTotalNoGravado(){
		return subTotalNoGravado;
	}

	public List<Object> getIvaArray(){
		return ivaArray;
	}

	public String getCliente(){
		return cliente;
	}

	public String getCajaNro(){
		return cajaNro;
	}

	public int getTipoCambio(){
		return tipoCambio;
	}

	public String getCodigoUnico(){
		return codigoUnico;
	}

	public String getPorcentajeIva(){
		return porcentajeIva;
	}
}