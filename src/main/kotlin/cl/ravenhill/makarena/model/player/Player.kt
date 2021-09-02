package cl.ravenhill.makarena.model.player

import cl.ravenhill.makarena.model.Card

open class Player(val name: String) {

  private var backingDeck = mutableListOf<Card>()
  var deck: MutableList<Card>
    get() = backingDeck.toMutableList()
    set(value) {
      backingDeck = value
    }

  fun draw(): Card {
    return backingDeck.removeFirst()
  }
  override fun equals(other: Any?): Boolean {
    return other is Player && other.name == this.name
  }

  val hand = mutableListOf<Card>()
  val graveyard = mutableListOf<Card>()
}