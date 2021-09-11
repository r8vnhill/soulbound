package cl.ravenhill.soulbound.cards

sealed interface Creature {
  val isSummonable: Boolean
    get() = level.first == 1
  val level: Pair<Int, Int>
  val name: String
}

data class Spirit(override val name: String, override val level: Pair<Int, Int>) : Creature

data class Decay(override val name: String, override val level: Pair<Int, Int>) : Creature