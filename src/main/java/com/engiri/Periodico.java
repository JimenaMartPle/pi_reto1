package com.engiri;

import java.util.ArrayList;

public class Periodico {
  private ArrayList<Noticia> noticias;
  private int numNoticias;

  Periodico(){
    noticias= new ArrayList<>(1000);
    numNoticias = 0;
  }

  // Inserta una noticia
  public void insertar(Noticia n){
    if (numNoticias < 1000) {
      noticias.add(n);
      numNoticias++;
    }
  }

  // Devuelva la primera noticia
  public Noticia primeraNoticia(int d, int m, int a){
    for (int i = 0; i < numNoticias; i++) {
      if (noticias.get(i).igualFecha(d, m, a)) {
        return noticias.get(i);
      }
    }
    return null;
  }

  // Imprimir las noticias más populares
  public void masPopulares(){
    if (numNoticias == 0) {
      System.out.println("No hay noticias.");
      return;
    }

    int maxLecturas = 0;
    for (int i = 0; i < numNoticias; i++) {
      if (noticias.get(i).getLecturas() > maxLecturas) {
        maxLecturas = noticias.get(i).getLecturas();
      }
    }

    for (int i = 0; i < numNoticias; i++) {
      if (noticias.get(i).getLecturas() == maxLecturas) {
        System.out.println(noticias.get(i));
      }
    }
  }

  // Borrar noticias anteriores a una fecha
  public void borrarAnteriores(int d, int m, int a){
    int fechaLimite = a * 10000 + m * 100 + d;

    for (int i = numNoticias - 1; i >= 0; i--) {
      if (noticias.get(i).getFecha() < fechaLimite) {
        noticias.remove(i);
        numNoticias--;
      }
    }
  }

  // Mostrar todas las noticias
  public void mostrar(){
    for (int i = 0; i < numNoticias; i++) {
      System.out.println(noticias.get(i));
    }
  }
}
