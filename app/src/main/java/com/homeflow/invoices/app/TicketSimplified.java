package com.homeflow.invoices.app;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TicketSimplified {

  @SerializedName("footer2")
  private String footer2;

  @SerializedName("footer1")
  private String footer1;

  @SerializedName("tiquete_electronico")
  private String tiquete_electronico;

  @SerializedName("tiposPago")
  private List<TiposPagoItem> tiposPago;

  @SerializedName("comprobante")
  private String comprobante;

  @SerializedName("total_gravado")
  private String total_gravado;

  @SerializedName("total")
  private String total;

  @SerializedName("sub_total_gravado")
  private String sub_total_gravado;

  @SerializedName("iva")
  private String iva;

  @SerializedName("nombre_empresa")
  private String nombre_empresa;

  @SerializedName("correo")
  private String correo;

  @SerializedName("moneda")
  private String moneda;

  @SerializedName("total_no_gravado")
  private String total_no_gravado;

  @SerializedName("telefono")
  private String telefono;

  @SerializedName("lineas")
  private List<LineasItem> lineas;

  @SerializedName("vendedor")
  private String vendedor;

  @SerializedName("clave")
  private String clave;

  @SerializedName("gran_total")
  private String gran_total;

  @SerializedName("nombre_comercial")
  private String nombre_comercial;

  @SerializedName("direccion")
  private String direccion;

  @SerializedName("fecha_hora")
  private String fecha_hora;

  @SerializedName("identificacion")
  private String identificacion;

  @SerializedName("condicion")
  private String condicion;

  @SerializedName("sub_total_no_gravado")
  private String sub_total_no_gravado;

  @SerializedName("ivaArray")
  private List<Object> ivaArray;

  @SerializedName("cliente")
  private String cliente;

  @SerializedName("caja_nro")
  private String caja_nro;

  @SerializedName("tipo_cambio")
  private int tipo_cambio;

  @SerializedName("codigo_unico")
  private String codigo_unico;

  @SerializedName("porcentaje_iva")
  private String porcentaje_iva;

  public String getFooter2() {
    return footer2;
  }

  public String getFooter1() {
    return footer1;
  }

  public String getTiquete_electronico() {
    return tiquete_electronico;
  }

  public List<TiposPagoItem> getTiposPago() {
    return tiposPago;
  }

  public String getComprobante() {
    return comprobante;
  }

  public String getTotal_gravado() {
    return total_gravado;
  }

  public String getTotal() {
    return total;
  }

  public String getSub_total_gravado() {
    return sub_total_gravado;
  }

  public String getIva() {
    return iva;
  }

  public String getNombre_empresa() {
    return nombre_empresa;
  }

  public String getCorreo() {
    return correo;
  }

  public String getMoneda() {
    return moneda;
  }

  public String getTotal_no_gravado() {
    return total_no_gravado;
  }

  public String getTelefono() {
    return telefono;
  }

  public List<LineasItem> getLineas() {
    return lineas;
  }

  public String getVendedor() {
    return vendedor;
  }

  public String getClave() {
    return clave;
  }

  public String getGran_total() {
    return gran_total;
  }

  public String getNombre_comercial() {
    return nombre_comercial;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getFecha_hora() {
    return fecha_hora;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public String getCondicion() {
    return condicion;
  }

  public String getSub_total_no_gravado() {
    return sub_total_no_gravado;
  }

  public List<Object> getIvaArray() {
    return ivaArray;
  }

  public String getCliente() {
    return cliente;
  }

  public String getCaja_nro() {
    return caja_nro;
  }

  public int getTipo_cambio() {
    return tipo_cambio;
  }

  public String getCodigo_unico() {
    return codigo_unico;
  }

  public String getPorcentaje_iva() {
    return porcentaje_iva;
  }
}