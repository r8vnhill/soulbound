@file:Suppress("UnusedEquals")

package cl.ravenhill.soulbound.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.forAll


class CardTest : StringSpec({
  "Cards with the same parameters are equal" {
    forAll(nameGenerator(), attackGenerator()) { a, b ->
      Card(a, b) == Card(a, b)
    }
  }
  "Cards with different parameters are not equal" {
    val names = Pair(nameGenerator(), nameGenerator())
    val attacks = Pair(attackGenerator(), attackGenerator())
    forAll(names.first, names.second) { a, b ->
      if (a != b) {
        Card(a, 5) != Card(b, 5)
      } else {
        true
      }
    }
    forAll(attacks.first, attacks.second) { a, b ->
      if (a != b) {
        Card("name", a) != Card("name", b)
      } else {
        true
      }
    }
  }
})

fun attackGenerator() = Arb.int(0, 10)