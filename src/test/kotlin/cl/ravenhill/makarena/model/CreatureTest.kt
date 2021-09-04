@file:Suppress("UnusedEquals")

package cl.ravenhill.makarena.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll


class CreatureTest : StringSpec({
  "Creatures with the same name are equals" {
    checkAll(nameGenerator(), attackGenerator(), attackGenerator()) { name, atk1, atk2 ->
      Creature(name, atk1) shouldBe Creature(name, atk2)
    }
  }
//  "Cards with different parameters are not equal" {
//    val names = Pair(nameGenerator(), nameGenerator())
//    val attacks = Pair(attackGenerator(), attackGenerator())
//    forAll(names.first, names.second) { a, b ->
//      if (a != b) {
//        Card(a) != Card(b)
//      } else {
//        true
//      }
//    }
//    forAll(attacks.first, attacks.second) { a, b ->
//      if (a != b) {
//        Card("name") != Card("name")
//      } else {
//        true
//      }
//    }
})

fun attackGenerator() = Arb.int(0, 10)