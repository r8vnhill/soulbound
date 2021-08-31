package cl.ravenhill.makarena.model

import cl.ravenhill.makarena.model.player.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll
import kotlin.random.Random

class PlayerTest : StringSpec({
  "Players with same parameters are equal" {
    forAll(nameGenerator()) { name ->
      val player1 = Player(name)
      val player2 = Player(name)
      player1 == player2
    }
  }
  "The deck can be set correctly" {
    forAll(nameGenerator()) { playerName ->
      val player = Player(playerName)
      val r = Random
      val cards = Array(r.nextInt(40, 60)) { Card("Card_$it", r.nextInt(10)) }
      player.deck = cards
      player.deck.contentEquals(cards)
    }
  }
})