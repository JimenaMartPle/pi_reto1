package com.engiri;

public class App {
  //Modifier 'public' is redundant for 'main' method on Java 25
  static void main(String[] args) {
    System.out.println("=== PRUEBA 1: CREAR NOTICIAS ===");
    Noticia n1 = new Noticia(20211030, 1005, "El Ayuntamiento aprueba el nuevo presupuesto");
    Noticia n2 = new Noticia(20211030, 1830, "Final del torneo local de ajedrez");
    Noticia n3 = new Noticia(20211101, 900, "Se inaugura la nueva biblioteca municipal");
    Noticia n4 = new Noticia(20211015, 2000, "Concierto benéfico reúne a cientos de personas");

    n1.incLecturas();
    n1.incLecturas();
    n1.incLecturas();
    n2.incLecturas();
    n2.incLecturas();
    n2.incLecturas();
    n3.incLecturas();

    System.out.println(n1);
    System.out.println(n2);
    System.out.println(n3);
    System.out.println(n4);

    System.out.println("=== PRUEBA 2: INSERTAR ===");
    Periodico periodico = new Periodico();
    periodico.insertar(n1);
    periodico.insertar(n2);
    periodico.insertar(n3);
    periodico.insertar(n4);
    periodico.mostrar();

    System.out.println("=== PRUEBA 3: PRIMERA NOTICIA ===");
    Noticia encontrada = periodico.primeraNoticia(30, 10, 2021);
    if (encontrada != null) {
      System.out.println("Encontrada:");
      System.out.println(encontrada);
    } else {
      System.out.println("No se encontró ninguna noticia con esa fecha.");
    }

    Noticia noEncontrada = periodico.primeraNoticia(1, 1, 2020);
    if (noEncontrada == null) {
      System.out.println("Correcto: no hay noticias el 1/1/2020.");
    }

    System.out.println("=== PRUEBA 4: MÁS POPULARES ===");
    periodico.masPopulares();

    System.out.println("=== PRUEBA 5: BORRAR ANTERIORES ===");
    periodico.borrarAnteriores(20, 10, 2021);
    System.out.println("Noticias después de borrar anteriores al 20/10/2021:");
    periodico.mostrar();
  }
}