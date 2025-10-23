# Explicación del programa


<h2>Introducción</h2>

<p>Este programa es una versión sencilla del Blackjack pensada para jugar directamente desde consola. El objetivo es alcanzar 21 sin pasarse, compitiendo contra el dealer. Intenté que fuera claro y funcional sin añadir reglas complicadas.</p>

<h2>Cómo se juega</h2>

<p>El jugador empieza con <strong>100 de dinero</strong> y antes de cada partida elige cuánto apostar.   
Una vez hecha la apuesta, se reparten dos cartas al jugador y dos al dealer, aunque solo se muestra una del dealer. Los <strong>Ases</strong> pueden valer <strong>1 u 11</strong> según convenga para no pasarse de 21.</p>

<p>El jugador puede decidir si pide una carta más o se planta, hasta un máximo de cuatro cartas. Después el dealer juega su turno automáticamente: pide si tiene menos de 17 y se planta si tiene 17 o más.</p>

<h2>Final de la ronda</h2>

<p>Cuando ambos terminan, se comparan los totales:</p>
<ul>
  <li>Si el jugador consigue 21 con las dos primeras cartas, gana un <strong>Blackjack</strong>.</li>
  <li>Si se pasa de 21, pierde.</li>
  <li>Si el dealer se pasa, gana el jugador.</li>
  <li>Si empatan, se devuelve la apuesta.</li>
</ul>

<p>Al final se muestran las estadísticas, el dinero disponible y se pregunta si el jugador quiere seguir jugando o salir.</p>

<h2>Detalles del juego</h2>

<p>Las cartas se generan de forma aleatoria, sin baraja física. No hay opciones como dividir, doblar o rendirse.</p>

