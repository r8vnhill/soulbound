package cl.ravenhill.makarena.model

interface Card {
  val name: String
}

class Creature(override val name: String, val attack: Int) : Card

