namespace Soulbound.main.godot.testing.core.test {
  /// <summary>
  ///   A <see cref="TestCase" /> describes an actual block of code that will be tested.
  ///   It contains a reference back to the <see cref="Spec" /> instance in which it
  ///   is being executed.
  ///   It also captures a closure of the body of the test case.
  ///   This is a function which is invoked with a [TestContext].
  ///   The context is used so that the test function can, at runtime,
  ///   register nested tests with the test engine. This allows
  ///   nested tests to be executed lazily as required, rather
  ///   than when the [Spec] instance is created.
  ///   A test can be nested inside other tests if the [Spec] supports it.
  ///   For example, in the FunSpec we only allow top level tests.
  ///   test("this is a test") { }
  ///   And in WordSpec we allow two levels of tests.
  ///   "a string" should {
  ///   "return the length" {
  ///   }
  ///   }
  /// </summary>
  public class TestCase {
    public TestCase(AbstractDescription.Test description) { }
  }
}