package cl.ravenhill.soulbound.cards

sealed interface Creature {
  val isSummonable: Boolean
}

class Spirit(name: String, level: Pair<Int, Int>) : Creature {
  override val isSummonable: Boolean
    get() = TODO("Not yet implemented")
}

class Decay(name: String, level: Pair<Int, Int>) : Creature {
  override val isSummonable: Boolean
    get() = TODO("Not yet implemented")
}