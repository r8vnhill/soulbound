package cl.ravenhill.makarena.model.player

import cl.ravenhill.makarena.model.Card

open class Player(val name: String) {

  private var backingDeck = mutableListOf<Card>()
  var deck: MutableList<Card>
    get() = backingDeck.toMutableList()
    set(value) {
      backingDeck = value
    }

  private var backingHand = mutableListOf<Card>()
  var hand: List<Card>
    get() = backingHand.toList()
    set(value) {
      backingHand = value.toMutableList()
    }

  fun draw(): Card {
    return backingDeck.removeFirst()
  }

  override fun equals(other: Any?) = other is Player && other.name == this.name

  override fun hashCode() = name.hashCode()
  fun selectFromHand(selectIdx: Int): Card {
    TODO("Not yet implemented")
  }

  val graveyard = mutableListOf<Card>()
}