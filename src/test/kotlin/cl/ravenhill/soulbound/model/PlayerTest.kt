package cl.ravenhill.soulbound.model

import cl.ravenhill.soulbound.model.player.Player
import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.forAll
import kotlin.random.Random
import kotlin.random.Random.Default as rng

const val DUMMY_NAME = "TEST_PLAYER"

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
      val cards = Array(rng.nextInt(40, 60)) { Card("Card_$it", rng.nextInt(10)) }
      player.deck = cards.toMutableList()
      player.deck == cards.toList()
    }
  }
  "The player can draw a card" {
    forAll(nameGenerator()) { playerName ->
      val player = Player(playerName)
      val r = Random
      val cards = Array(r.nextInt(40, 60)) { Card("Card_$it", r.nextInt(10)) }.toList().shuffled()
      val expectedDeck = cards.toList()
      player.deck = cards.toMutableList()
      val card = player.draw()
      player.deck.size == (expectedDeck.size - 1) && expectedDeck[0] == card
    }
  }
  "The player can select a card from it's hand" {
    val numOfCards = rng.nextInt(1, 10)
    forAll(
      Arb.list(nameGenerator(), numOfCards .. numOfCards),
      Arb.int(0 until numOfCards),
    ) { names, selectIdx ->
      val cards = names.map { name -> Card(name, rng.nextInt(10)) }
      val player = Player(DUMMY_NAME)
      player.hand = cards
      player.selectFromHand(selectIdx) == cards[selectIdx]
    }
  }
})