package cl.ravenhill.soulbound.mechanics

import cl.ravenhill.soulbound.cards.Decay
import cl.ravenhill.soulbound.cards.Spirit

/** Factory method to make Spirit Creatures. */
fun makeSpirit(name: String, level: Pair<Int, Int>) = Spirit(name, level)

/** Factory method to make Decay Creatures. */
fun makeDecay(name: String, level: Pair<Int, Int>) = Decay(name, level)