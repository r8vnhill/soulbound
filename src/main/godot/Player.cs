using Godot;

namespace Soulbound.main.godot {
  /// <summary>
  ///   Controller for the game's player.
  /// </summary>
  public class Player : Area2D {
    [Signal]
    public delegate void Hit();

    private const string AnimatedSpritePath = "AnimatedSprite";
    private AnimatedSprite _animatedSprite;
    private Vector2 _screenSize; // Size of the game window.
    private Vector2 _velocity;
    [Export] public int Speed = 400; // How fast the player will move (pixels/sec).

    /// <summary>
    ///   Como yo
    /// </summary>
    public override void _Ready() {
      Hide();
      _screenSize = GetViewport().Size;
    }

    public override void _Process(float delta) {
      _velocity = new Vector2();
      _velocity.x += UserInput.Horizontal;
      _velocity.y += UserInput.Vertical;

      _animatedSprite = GetNode<AnimatedSprite>(AnimatedSpritePath);
      UpdatePosition(delta);
      RotateSprite();
    }

    private void UpdatePosition(float delta) {
      if (_velocity.Length() > 0) {
        _velocity = _velocity.Normalized() * Speed;
        _animatedSprite.Play();
      } else {
        _animatedSprite.Stop();
      }

      Position += _velocity * delta;
      Position = new Vector2(
        Mathf.Clamp(Position.x, 0, _screenSize.x),
        Mathf.Clamp(Position.y, 0, _screenSize.y)
      );
    }

    private void RotateSprite() {
      if (_velocity.x != 0) {
        _animatedSprite.Animation = Animations.Walk;
        _animatedSprite.FlipV = false;
        _animatedSprite.FlipH = _velocity.x < 0;
      } else if (_velocity.y != 0) {
        _animatedSprite.Animation = Animations.Up;
        _animatedSprite.FlipV = _velocity.y > 0;
      }
    }

    public void OnPlayerBodyEntered(PhysicsBody2D body) {
      Hide(); // Player disappears after being hit.
      EmitSignal("Hit");
      GetNode<CollisionShape2D>("CollisionShape2D").SetDeferred("disabled", true);
    }

    /// <summary>
    ///   Mapping of the user inputs
    /// </summary>
    private static class UserInput {
      private const string Right = "ui_right";
      private const string Left = "ui_left";
      private const string Down = "ui_down";
      private const string Up = "ui_up";

      public static float Horizontal => Input.IsActionPressed(Right) ? 1 : Input.IsActionPressed(Left) ? -1 : 0;
      public static float Vertical => Input.IsActionPressed(Down) ? 1 : Input.IsActionPressed(Up) ? -1 : 0;
    }

    private static class Animations {
      internal const string Up = "up";
      internal const string Walk = "walk";
    }
  }
}