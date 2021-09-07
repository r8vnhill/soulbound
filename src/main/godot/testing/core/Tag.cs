namespace Soulbound.main.godot.testing.core {
  public abstract class Tag {
    protected string Name;

    protected Tag() => Name = GetType().Name;

    public override string ToString() => Name;
    public static NamedTag Invoke(string name) => new NamedTag(name);
  }

  public class NamedTag : Tag {
    public NamedTag(string name) => Name = name;
  }
}