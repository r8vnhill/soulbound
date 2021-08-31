package cl.ravenhill.makarena.model.player

import cl.ravenhill.makarena.model.Card

open class Player(val name: String) {
  fun setDeck(cards: Array<Card>) {
    TODO("Not yet implemented")
  }

  val deck = mutableListOf<Card>()
  val hand = mutableListOf<Card>()
  val graveyard = mutableListOf<Card>()
}