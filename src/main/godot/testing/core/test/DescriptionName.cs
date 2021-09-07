using System.Diagnostics.Contracts;

namespace Soulbound.main.godot.testing.core.test {
  public partial class DescriptionName {
    public string Name;

    public TestName CreateTestName(string name) => CreateTestName(null, name, false);

    private TestName CreateTestName(string prefix, string name, bool defaultIncludeAffix) =>
      CreateTestName(prefix, name, configuration)

    public class SpecName : DescriptionName {
      public readonly string DisplayName;
      public readonly string QualifiedName;

      public SpecName(string qualifiedName, string name, string displayName) {
        QualifiedName = qualifiedName;
        DisplayName = displayName;
        Name = name;
      }
    }

    public class TestName : DescriptionName {
      private readonly bool _bang;
      private readonly string _displayName;
      private readonly bool _focus;

      public TestName(string name, string displayName, bool focus, bool bang) {
        _displayName = displayName;
        _focus = focus;
        _bang = bang;
        Name = name;
        Contract.Requires(string.IsNullOrWhiteSpace(Name) && string.IsNullOrEmpty(Name),
          "Cannot create test with blank or empty name");
        Contract.Requires(string.IsNullOrWhiteSpace(Name) && string.IsNullOrEmpty(Name),
          "Cannot create test with blank or empty displayName");
        Contract.Requires(!focus || !bang, "Bang and focus cannot both be true");
      }
    }
  }
}