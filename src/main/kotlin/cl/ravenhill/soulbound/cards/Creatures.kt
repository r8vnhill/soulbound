package cl.ravenhill.soulbound.cards

/**
 * Base interface for all Creature cards.
 *
 * @property isSummonable
 *    flag to indicate if the Creature meets the soulbounding restrictions.
 * @property level
 *    the level of the card.
 * @property name
 *    the name of the card.
 */
sealed interface Creature {
  val isSummonable: Boolean
    get() = level.first == 1
  val level: Pair<Int, Int>
  val name: String
}

/** A Spirit Creature.  */
data class Spirit(override val name: String, override val level: Pair<Int, Int>) : Creature

/** A Decay Creature. */
data class Decay(override val name: String, override val level: Pair<Int, Int>) : Creature