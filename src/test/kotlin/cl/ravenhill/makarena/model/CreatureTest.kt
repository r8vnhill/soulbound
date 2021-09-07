package cl.ravenhill.makarena.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll


class CreatureTest : StringSpec({
  "Creatures with the same name are equals" {
    checkAll(nameGenerator(), attackGenerator(), attackGenerator()) { name, atk1, atk2 ->
      Creature(name, atk1) shouldBe Creature(name, atk2)
    }
  }
  "Cards with different parameters are not equal" {
    val names = Pair(nameGenerator(), nameGenerator())
    val attacks = Pair(attackGenerator(), attackGenerator())
    checkAll(names.first, names.second, attacks.first) { name1, name2, atk ->
      if (name1 != name2) {
        Creature(name1, atk) shouldNotBe Creature(name2, atk)
      }
    }
  }
})

fun attackGenerator() = Arb.int(0, 10)