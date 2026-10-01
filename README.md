# Reto 1

> Desarrolla una aplicación Java que gestione las noticias de un periódico.

**Autor/a:** _M. Jimena Martínez Plenasio_
**Curso:** _2026-2027_
**Módulo:** _Proyecto Intermodular 2_

---

## Índice

1. [Herramienta de IA utilizada](#1-herramienta-de-ia-utilizada)
2. [Prompts principales](#2-prompts-principales)
3. [Comparación entre las dos soluciones](#3-comparación-entre-las-dos-soluciones)
4. [Errores o problemas detectados](#4-errores-o-problemas-detectados)
5. [Reflexión personal sobre el uso de la IA](#5-reflexión-personal-sobre-el-uso-de-la-ia)
6. [Reflexión personal final](#6-reflexión-personal-final)

---

## 1. Herramientas de IA utilizada

Para generar el código:
- **Herramienta:** _Claude_
- **Modelo / versión:** _Sonnet 5.5 (medio)_

Para hacer la comparación de ambos códigos:
- **Herramienta:** _Claude_
- **Modelo / versión:** _Free_


- **Fecha de uso:** _septiembre 2026_

---

## 2. Prompts principales

### Prompt 1: _Generar app del reto_

```text
Teniendo en cuenta el PDF del reto 1, crea una app en Java utilizando Maven. Debes implementar todas las clases y métodos solicitados y crear una clase App que permita comprobar el funcionamiento. Antes de comenzar a crear hazme preguntas si tienes dudas sobre cómo proceder en algún punto
```

**Respuesta obtenida:** _Tengo claro casi todo el enunciado, pero hay tres puntos donde prefiero que decidas tú antes de crear el proyecto._ 

_P: ¿Qué paquete y groupId uso? (la captura del PDF muestra com.engiri)
R: com.engiri_

_P: ¿Qué versión de Java uso en el pom.xml?
R: Java 25_

_P: ¿Cómo trato el toString() de Noticia?
R: Mejorado con ceros (10:05, 03/09/2021)_

### Prompt 1: _Comparar códigos_

```text
Compara pi_reto1-AI y pi_reto1 en estas dimensiones: Estructura del código, Facilidad de comprensión, Complejidad del código, Tratamiento de errores, Mantenibilidad, Pruebas realizadas, Cumplimiento del enunciado. Para cada dimensión, explica qué opción funciona mejor y por qué. Luego, recomienda qué opción se adapta mejor a un desarrollador de aplicaciones.
```
---

## 3. Comparación entre las dos soluciones

- **Solución A:** _Solución propia_
- **Solución B:** _Solución generada con IA_

### Resumen comparativo

| Criterio                  | Solución A (propia)                      | Solución B (IA)                                                   |
|---------------------------|------------------------------------------|-------------------------------------------------------------------|
| Estructura del código     | Correcta y sencilla                      | Mejor estructurada                                                |
| Facilidad de comprensión  | Sencilla, aunque con menos documentación | Más clara y documentada                                           |
| Complejidad del código    | Ligeramente menor                        | Algo mayor, pero sigue siendo sencilla                            |
| Tratamiento de errores    | Básico                                   | Más completo                                                      |
| Mantenibilidad            | Correcta                                 | Mejor                                                             |
| Pruebas realizadas        | Varias pruebas básicas                   | Más pruebas y más casos límite                                    |
| Cumplimiento del enunciado| Cumple los requisitos principales        | Cumple los requisitos principales y añade algunas comprobaciones |

### 3.1. Estructura del código

_Las dos soluciones utilizan la misma estructura básica, con las clases App, Noticia y Periodico, por lo que ambas separan correctamente las responsabilidades principales._

_La solución B (IA) está algo mejor estructurada. Por ejemplo, utiliza una constante CAPACIDAD para representar el máximo de 1000 noticias, en lugar de escribir directamente 1000 en el código. También declara explícitamente como public el constructor de Periodico y contiene más comentarios y documentación sobre el funcionamiento de los métodos._

_La solución A es más sencilla y no tiene una estructura incorrecta, pero utiliza algunos valores directamente en el código y tiene menos documentación._

_Mejor opción: Solución B (IA), porque mantiene la misma estructura sencilla, pero facilita la lectura y la modificación posterior del código._

### 3.2. Facilidad de comprensión

_La solución A resulta fácil de entender porque utiliza una implementación bastante directa y contiene poca lógica adicional. Esto puede ser positivo para un ejercicio inicial de programación._

_Sin embargo, la solución B tiene comentarios más completos y nombres como CAPACIDAD, limite o max, que ayudan a comprender qué representa cada elemento. Además, la clase Noticia incluye documentación sobre sus atributos y métodos._

_Mejor opción: Solución B (IA), principalmente por la documentación y la claridad general._

### 3.3. Complejidad del código

_Las dos soluciones tienen una complejidad baja y utilizan estructuras apropiadas para el nivel del ejercicio: ArrayList, bucles y condiciones sencillas._

_La solución A es ligeramente más simple en algunos puntos. Por ejemplo, igualFecha() descompone la fecha en día, mes y año y los compara directamente. Además, borrarAnteriores() utiliza un recorrido desde el final de la lista, que permite eliminar elementos sin necesidad de utilizar un Iterator._

_La solución B utiliza un Iterator para eliminar las noticias anteriores y realiza algunas comprobaciones adicionales. Esto añade un poco de código, aunque no supone una complejidad importante._

_Mejor opción: Solución A (propia) si el criterio es exclusivamente reducir la complejidad. Es ligeramente más directa. Aun así, la diferencia es pequeña y ambas soluciones tienen una complejidad adecuada._

### 3.4. Tratamiento de errores

_Aquí existe una diferencia importante._

_En la solución A, insertar() comprueba que no se haya alcanzado el límite de 1000 noticias, pero no comprueba que la noticia recibida sea distinta de null. Por tanto, sería posible insertar un null y posteriormente provocar problemas al utilizar métodos como primeraNoticia() o masPopulares()._

_La solución B incorpora la comprobación:_

_if (n != null && numNoticias < CAPACIDAD)_

_De esta forma, una noticia null simplemente se ignora. También controla explícitamente el caso de un periódico vacío en mostrar() y masPopulares()._

_En las pruebas de la solución B se comprueba expresamente la inserción de null, algo que no se contemplaba en la solución A._

_Mejor opción: Solución B (IA), porque contempla más casos límite y evita errores derivados de referencias null._

### 3.5. Mantenibilidad

_La solución B es más fácil de mantener a largo plazo._

_Un ejemplo claro es la utilización de:_

_private static final int CAPACIDAD = 1000;_

_Si en el futuro se quisiera cambiar la capacidad máxima del periódico, bastaría con modificar ese valor. En la solución A, el valor 1000 está escrito directamente en el código._

_También ayuda la mayor cantidad de documentación de la solución B y la configuración algo más completa del pom.xml, donde se especifican versiones de plugins de Maven._

_La solución A sigue siendo suficientemente mantenible para un proyecto pequeño, pero necesitaría algo más de organización si el proyecto creciera._

_Mejor opción: Solución B (IA), porque facilita realizar modificaciones y ampliar el proyecto posteriormente._

### 3.6. Pruebas realizadas

| Prueba / caso                        | Entrada                                                | Resultado esperado                                       | Solución A                         | Solución B    |
|------------------------|--------------------------------------------------------|----------------------------------------------------------|------------------------------------|------------------------------------|
| Crear noticias                       | 4 objetos Noticia con distintas fechas, horas y textos | Las noticias se crean correctamente y muestran sus datos | ✔️ Se prueba                       | ✔️ Se prueba  |
| Comprobar fecha correcta             | n1.igualFecha(30, 9, 2021)                             | Debe devolver true si la fecha coincide                  | ❌ No se prueba directamente        | ✔️ Se prueba  |
| Comprobar fecha incorrecta           | n1.igualFecha(1, 10, 2021)                             | Debe devolver false                                      | ❌ No se prueba directamente        | ✔️ Se prueba  |
| Obtener fecha                        | n3.getFecha()                                          | Debe devolver la fecha almacenada                        | ❌ No se prueba directamente        | ✔️ Se prueba  |
| Insertar noticias                    | Insertar n1, n2, n3 y n4                               | Las noticias deben almacenarse correctamente             | ✔️ Se prueba                       | ✔️ Se prueba  |
| Insertar null                        | insertar(null)                                         | No debe producir error ni insertar una noticia nula      | ❌ No se prueba                     | ✔️ Se prueba  |
| Mostrar periódico vacío              | new Periodico().mostrar()                              | Debe indicar que no hay noticias                         | ❌ No se prueba                     | ✔️ Se prueba  |
| Mostrar noticias                     | mostrar() después de insertar 4 noticias               | Deben mostrarse todas las noticias almacenadas           | ✔️ Se prueba                       | ✔️ Se prueba  |
| Buscar noticia existente             | primeraNoticia(30, 9, 2021)                            | Debe devolver la primera noticia de esa fecha            | ❌ No exactamente: busca 30/10/2021 | ✔️ Se prueba  |
| Buscar noticia inexistente           | primeraNoticia(1, 1, 2000)                             | Debe devolver null                                       | ✔️ Se prueba                       | ✔️ Se prueba  |
| Más populares sin lecturas           | Todas las noticias con 0 lecturas                      | Deben mostrarse todas, porque están empatadas            | ❌ No se prueba                     | ✔️ Se prueba  |
| Una noticia más popular              | n2 con 2 lecturas y n3 con 1                           | Debe mostrarse únicamente n2                             | ❌ No se prueba específicamente     | ✔️ Se prueba  |
| Empate entre noticias                | n2 y n3 con 2 lecturas                                 | Deben mostrarse ambas                                    | ❌ No se prueba                     | ✔️ Se prueba  |
| Más populares con periódico vacío    | new Periodico().masPopulares()                         | Debe indicar que no hay noticias                         | ❌ No se prueba                     | ✔️ Se prueba  |
| Eliminar noticias anteriores         | borrarAnteriores(1, 10, 2021)                          | Deben eliminarse las anteriores al 01/10/2021            | ✔️ Se prueba                       | ✔️ Se prueba  |
| Eliminar todas las noticias          | borrarAnteriores(1, 1, 2030)                           | Deben eliminarse todas                                   | ❌ No se prueba                     | ✔️ Se prueba  |
| Mostrar periódico después de borrar  | mostrar() tras las eliminaciones                       | Debe mostrar únicamente las noticias que permanecen      | ✔️ Se prueba tras una eliminación  | ✔️ Se prueba  |

_CONCLUSIÓN:_

_Las dos soluciones realizan pruebas manuales desde la clase App, comprobando las principales funcionalidades del programa. Sin embargo, la "Solución B" realiza una batería de pruebas más amplia y contempla más casos límite._

### 3.7. Cumplimiento del enunciado

_La solución A cumple los requisitos principales mediante una implementación sencilla._

_La solución B también los cumple y añade algunas comprobaciones que hacen que el comportamiento sea más robusto, como ignorar una noticia null o mostrar un mensaje cuando el periódico está vacío._

_Por tanto, ambas soluciones cumplen el núcleo del ejercicio, aunque la solución B ofrece un comportamiento algo más completo ante situaciones límite._

_Mejor opción: Solución B (IA), aunque la diferencia no está en las funcionalidades principales, sino en la robustez de la implementación._

---

## 4. Errores o problemas detectados

| Nº | Solución   | Descripción del error                                                                                                                                                                         | Cómo se detectó                                                                                                                                          | Cómo se soluciona                                                                                                             |
|----|------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| 1  | A | El método insertar() permite insertar null. Esto puede provocar un error posteriormente cuando otros métodos intenten acceder a esa noticia mediante getFecha() o getLecturas().              | Al revisar el método insertar() se comprobó que únicamente verifica que no se haya alcanzado el límite de 1000 noticias, pero no comprueba si n es null. | Añadiendo la condición n != null antes de insertar la noticia.                                                                |
| 2  | A | El método mostrar() no informa cuando el periódico está vacío. Simplemente no muestra nada, por lo que el usuario no puede distinguir entre un periódico vacío y un problema en la ejecución. | Se creó un Periodico vacío y se llamó a mostrar(). El método no produce ningún mensaje.                                                                  | Añadiendo una comprobación de numNoticias == 0 para mostrar un mensaje indican                                                |
| 3  | A | Las pruebas de App no cubren suficientes casos límite, como insertar null, trabajar con un periódico vacío o comprobar empates entre las noticias más populares.                              | Al revisar los casos incluidos en App y compararlos con posibles situaciones límite.                                                                     | Ampliando las pruebas de App para comprobar estos casos.                                                                      |
| 4  | B | No se detectaron errores funcionales importantes en las operaciones principales. Sin embargo, las pruebas siguen siendo manuales y no existen pruebas unitarias automatizadas con JUnit.      | Al revisar la estructura del proyecto y comprobar que las verificaciones se realizan desde App.                                                          | Se podrían añadir pruebas unitarias en src/test utilizando JUnit para automatizar las comprobaciones y detectar regresiones.  |

---

## 5. Reflexión personal sobre el uso de la IA

### ¿Qué ventajas has encontrado al utilizar IA?

_Creo que la mayor ventaja de utilizar la IA es que permite generar una estructura en pocos segundos y ampliar las pruebas del código, especialmente teniendo en cuenta casos límite que quizá no se nos ocurrirían inicialmente. También puede ahorrar bastante tiempo en tareas sencillas o repetitivas. En cambio, la complejidad del código desarrollado por una persona dependerá de factores como su experiencia, sus conocimientos y el tiempo disponible._

### ¿Qué inconvenientes has encontrado?

_En este caso concreto no he encontrado inconvenientes importantes, pero cabe destacar que no siempre tiene por qué ser así. La IA es un apoyo importante y puede ahorrar mucho tiempo en determinadas tareas, pero a medida que un proyecto escala, utilizar código generado sin que una persona con las bases claras lo revise y comprenda puede convertir el proyecto en un caos._

### ¿Qué solución entiendes mejor y por qué?

_Ambas soluciones son entendibles, pero es cierto que, gracias a los comentarios agregados en la solución B, puede resultar más rápido comprender ese código si se vuelve a revisar pasado un tiempo. Además, algunas comprobaciones adicionales hacen que sea más sencillo entender cómo debe comportarse el programa en determinados casos límite._

### ¿Has encontrado algún error en el código generado por la IA?

_No, en este caso no he detectado errores funcionales en el código generado por la IA. Las pruebas realizadas han funcionado correctamente._

### ¿Cambiarías algo de tu solución original después de realizar este reto?

_Sí. Ampliaría las pruebas para tener en cuenta más casos límite, especialmente situaciones como un periódico vacío o la inserción de valores null. También declararía explícitamente la visibilidad de las clases y métodos para evitar posibles problemas si el proyecto creciera o se organizara en diferentes paquetes._

---

## 6. Reflexión personal final

_Este reto me ha permitido comprobar que la IA puede ser una herramienta muy útil para programar, especialmente para ahorrar tiempo, mejorar la documentación y detectar casos límite que quizá no había tenido en cuenta inicialmente._

_Al comparar mi solución con la generada por IA, he comprobado que ambas cumplían el enunciado, aunque la solución con IA incluía más comprobaciones y pruebas. Al mismo tiempo, mi solución era más sencilla y me resultaba más natural de comprender._

_Lo más importante que me llevo es que utilizar IA no significa aceptar directamente todo el código que genera. Es necesario comprenderlo, probarlo y saber detectar qué partes pueden mejorarse. Después de realizar este reto, ampliaría las pruebas de mi solución y aplicaría algunas de las mejoras de organización y validación que he visto en la solución con IA._

_En conclusión, considero que la IA es un buen apoyo para un desarrollador, pero el conocimiento y el criterio del propio desarrollador siguen siendo necesarios para conseguir un código correcto, comprensible y mantenible._