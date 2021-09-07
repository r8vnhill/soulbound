using System.Text.RegularExpressions;

namespace Soulbound.main.godot.testing.core.test {
  public abstract class AbstractDescription {
    public static Regex IdRegex = new Regex("[^a-zA-Z0-9_.]");
    public abstract DescriptionName GetName();
  }

  public partial class DescriptionName { }
}