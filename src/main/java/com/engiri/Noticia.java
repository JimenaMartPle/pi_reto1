package com.engiri;

public class Noticia {
  private int fecha;
  private int hora;
  private String texto;
  private int lecturas;

  public Noticia(int fecha, int hora, String texto) {
    this.fecha = fecha;
    this.hora = hora;
    this.texto = texto;
    lecturas = 0;
  }

  // Devolver la fecha en el formato aaaammdd
  public int getFecha() {
    return fecha;
  }

  // Devolver el número de lecturas
  public int getLecturas() {
    return lecturas;
  }

  // Incrementar en uno el número de lecturas
  public void incLecturas() {
    lecturas++;
  }

  // Comprobar si una fecha dada por d, m, a es igual a la fecha de la noticia actual public boolean igualFecha(int d, int m, int a)
  public boolean igualFecha(int d, int m, int a) {
    int day = fecha % 100;
    int month = (fecha / 100) % 100;
    int year = fecha / 10000;
    return day == d && month == m && year == a;
  }

  // Devuelve un String con la información de la noticia
  @Override
  public String toString() {
    String s = "";
    s+=fecha%100 + "/" + (fecha/100)%100+ "/" + (fecha/10000) + " - ";
    s+=(hora/100) + ":" + (hora%100) + "\n";
    s+=texto + "\n";
    s+="Leída " + lecturas + " veces\n"; return s;
  }
}
