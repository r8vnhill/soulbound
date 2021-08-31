package cl.ravenhill.makarena.model

import cl.ravenhill.makarena.model.player.Player
import io.kotest.core.datatest.forAll
import io.kotest.core.spec.style.StringSpec

class GameMatTest : StringSpec({
  "The mat owner is set correctly" {
    forAll(nameGenerator()) { a ->
      val player = Player(a.toString())
      val mat = GameMat(player)
      mat.owner == player
    }
  }
})