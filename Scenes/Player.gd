extends Area2D

signal hit

var velocity: Vector2
var screen_size: Vector2
export var speed := 400

        
# Called when the node enters the scene tree for the first time.
func _ready():
    screen_size = get_viewport_rect().size
    hide()


# Processes the input on every frame
func _process(delta: float):
    velocity = Vector2()
    adjust_velocity()
    move_player_sprite(delta)


# region : PLAYER MOVEMENT

# Adjusts the sprite velocity according to the user input
func adjust_velocity():
    velocity.x += (1 if Input.is_action_pressed(UserInput.RIGHT) else 
                    -1 if Input.is_action_pressed(UserInput.LEFT) else 0)
    velocity.y += (1 if Input.is_action_pressed(UserInput.DOWN) else 
                    -1 if Input.is_action_pressed(UserInput.UP) else 0)


# Moves the player according to its velocity
func move_player_sprite(delta: float):
    var sprite = $AnimatedSprite
    if velocity.length() > 0:
        velocity = velocity.normalized() * speed
        sprite.play()
    else:
        sprite.stop()
    sprite.position += velocity * delta
    sprite.position.x = clamp(sprite.position.x, 0, screen_size.x)
    sprite.position.y = clamp(sprite.position.y, 0, screen_size.y)

    if velocity.x != 0:
        sprite.animation = SpriteAnimation.WALK
        sprite.flip_v = false
        sprite.flip_h = velocity.x < 0
    elif velocity.y != 0:
        sprite.animation = SpriteAnimation.UP
        sprite.flip_v = velocity.y > 0


func start(pos):
    position = pos
    show()
    $CollisionShape2D.disabled = false
# endregion
  
      
# region : MAPPINGS

# Mapping of the input keys
class UserInput:
    const RIGHT = "ui_right"
    const LEFT = "ui_left"
    const DOWN = "ui_down"
    const UP = "ui_up"


class SpriteAnimation:
    const WALK = "walk"
    const UP = "up"
    

class Switch:
    const ENABLED = "enabled"
    const DISABLED = "disabled"
# endregion


# region : SIGNAL HANDLERS
func _on_Player_body_entered(body: Node):
    hide()  # Player disappears after being hit.
    emit_signal($AnimatedSprite.hit.name)
    $CollisionShape2D.set_deferred(Switch.DISABLED, true)
# endregion
