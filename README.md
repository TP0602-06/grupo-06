# grupo-06 - Games Creator

## NikoliGames

El objetivo de este proyecto es generar un programa en Java capaz de poder correr cualquier juego de la coleccion de Kikoli, codificado como un archivo de entrada en formato JSON. 

Actualmente se cuenta con implementaciones para jugar al [Sudoku](https://es.wikipedia.org/wiki/Sudoku) y al [kakuro](https://es.wikipedia.org/wiki/Kakuro). [Inshi No Haya], [Gokigen Naname], [Slitherlink], [Country Road]

## Prepare your workspace

* [Paso a paso para configurar el workspace](https://github.com/TP0602-06/grupo-06/wiki/Prepare-your-workspace)

## Let's start to fun

1. Verificar que el proyecto compile correctamente sin errores
  1. ./gradlew build
2. Jugar
  1. Sudoku: _./gradlew start -Dexec.args= "data/sudoku/tablero1.json"
  2. Kakuro: _./gradlew start -Dexec.args="data/kakuro/tablero1.json"
  
  Observación: si se quisiera correr cualquier otro juego sólo se debe pasar como parámetro del programa la ruta del archivo JSON válido que configura el tablero inicial, las reglas del juego y las especificaciones necesarias para la vista.
  
  3. Desde el IDE:
  
     ![alt tag](https://lh4.googleusercontent.com/hTt8BYObzkzO_ZQ028JkZmOAIZvhth7SgJ-aBkCDsS521FCCn0ia23aklJ4WCuwmpFh9BMKmQa9kJg=w1280-h635-rw)
     
3. Generar archivo de reporte jugada a jugada con un archivo de entrada plays.json:
  1. Inshi No Haya: _./grandlew start -Dexec.args= "data/inshi/tablero1.json data/sudoku/plays1.json data/inshi/output1.json"
  
  Observación: si se quisiera generar el reporte de cualquier juego implementado ( o cualquier que se pueda generar a partir de las reglas implementadas) es necesario pasar como primer parámetro la ruta del archivo que configura el juego, como segundo parámetro las jugadas paso a paso que se hacen sobre el tablero del juego, y como tercer parámetro la ruta del archivo donde queremos que se guarde la salida.
  
  La saldia es un archivo JSON que indica jugada a jugada cómo queda el status del board y finalmente si se ganó el juego o no.
  

## Repo usage

* [Ver Git Flow en la wiki] (https://github.com/TP0602-06/grupo-06/wiki/Git-Flow)
