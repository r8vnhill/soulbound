using System.Collections.Generic;
using Soulbound.main.godot.testing.core;

namespace Soulbound.main.godot.testing {
  public class TestConfiguration {
    internal List<TestListener> Listeners = new List<TestListener>();
    internal ISet<Tag> Tags = new HashSet<Tag>();
  }
}