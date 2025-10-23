
# Explicación del programa


<h2>Introducción</h2>

<p>Este programa es una versión sencilla del Blackjack pensada para jugar directamente desde consola. El objetivo es alcanzar 21 sin pasarse, compitiendo contra el dealer. Intenté que fuera claro y funcional sin añadir reglas complicadas.</p>

<h2>Cómo se juega</h2>

<p>El jugador empieza con 100 de dinero y, antes de cada partida, elige cuánto apostar. Si intenta apostar más de lo que tiene, el programa lo corrige automáticamente. Después se reparten dos cartas al jugador y dos al dealer, aunque solo se muestra una del dealer. Los Ases pueden valer 1 u 11, según convenga para no pasarse.</p>

<p>El jugador puede decidir si pide más cartas o se planta, hasta un máximo de cuatro. Luego el dealer juega su turno automáticamente: si tiene menos de 17 pide carta, y si llega o supera 17 se planta. Así se mantiene una lógica sencilla pero parecida a la real.</p>

<h2>Final de la ronda</h2>

<p>Cuando ambos terminan, se comparan los resultados. Si el jugador consigue 21 con las dos primeras cartas, hace Blackjack y gana más dinero. Si se pasa, pierde. Si el dealer se pasa, gana el jugador. En caso de empate, se devuelve la apuesta. Después se muestran las estadísticas y se puede seguir jugando o salir.</p>

<h2>Detalles del juego</h2>

<p>Las cartas se generan de forma aleatoria, sin baraja física. No hay opciones como dividir, doblar o rendirse.</p>

