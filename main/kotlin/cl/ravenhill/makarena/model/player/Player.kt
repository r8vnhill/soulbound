package cl.ravenhill.makarena.model.player

import cl.ravenhill.makarena.model.Card

open class Player {
  val deck = mutableListOf<Card>()
  val hand = mutableListOf<Card>()
  val graveyard = mutableListOf<Card>()
}