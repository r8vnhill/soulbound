import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec

class MyTests : FunSpec({
  test("length should return size of string") {
    "hello".length shouldBe 5
  }
  "startsWith should test for a prefix" {
    "world" should startWith("wor")
  }
})