package cl.ravenhill.makarena.model

import cl.ravenhill.makarena.model.player.Player
import io.kotest.core.spec.style.StringSpec
import kotlin.random.Random
import io.kotest.property.forAll


class GameMatTest : StringSpec({
  "The mat owner is set correctly" {
    forAll(nameGenerator()) { a ->
      val player = Player(a)
      val mat = GameMat(player)
      mat.owner == player
    }
  }
  "The deck can be set correctly" {
    forAll(nameGenerator()) { playerName ->
      val player = Player(playerName)
      val mat = GameMat(player)
      val r = Random.Default
      val cards = Array(r.nextInt(40, 60)) { Card("Card_$it", r.nextInt(10)) }
      player.setDeck(cards)
      mat.deck == cards
    }
  }
})