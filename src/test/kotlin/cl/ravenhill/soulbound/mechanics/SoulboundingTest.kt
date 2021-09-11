package cl.ravenhill.soulbound.mechanics

import cl.ravenhill.soulbound.cards.Creature
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.*
import io.kotest.property.checkAll

/**
 * Simple class to generate test Creature cards.
 *
 * @property name
 *    the name of the card
 * @property level
 *    the card's level
 * @property factory
 *    a reference to the concrete card's constructor.
 */
private data class ArbCard(
  val name: String,
  val level: Pair<Int, Int>,
  val factory: (String, Pair<Int, Int>) -> Creature
)

/** Custom arbitrary binding for generating creature cards */
private val arbCard = Arb.bind(
  Arb.string(1..30),
  Arb.int(2..4),
  Arb.choose(1 to arbitrary { ::makeSpirit }, 1 to arbitrary { ::makeDecay })
) { name, maxLvl, factory ->
  ArbCard(name, Pair(1, maxLvl), factory)
}

/** Test suite for the Summoning mechanic. */
class SoulboundingTest : StringSpec({
  "An S1 creature always meets the summoning restriction." {
    checkAll(arbCard) { card ->
      card.factory(card.name, card.level).isSummonable shouldBe true
    }
  }
})
