using System;
using Soulbound.main.godot.testing.core.test;

namespace Soulbound.main.godot.testing.core.listeners {
  public abstract class AbstractBeforeTestListener : IListener {
    public string Name() => throw new NotImplementedException();

    private async void BeforeTest(TestCase testCase) {
      throw new NotImplementedException();
    }
  }
}