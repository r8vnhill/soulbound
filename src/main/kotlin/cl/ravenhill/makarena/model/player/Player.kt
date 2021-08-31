package cl.ravenhill.makarena.model.player

import cl.ravenhill.makarena.model.Card

open class Player(val name: String) {

  private var backingDeck = emptyArray<Card>()
  var deck: Array<Card>
    get() = backingDeck.copyOf()
    set(value) {
      backingDeck = value
    }

  override fun equals(other: Any?): Boolean {
    return other is Player && other.name == this.name
  }

  val hand = mutableListOf<Card>()
  val graveyard = mutableListOf<Card>()
}