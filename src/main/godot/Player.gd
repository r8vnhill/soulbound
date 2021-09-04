extends Area2D

const HIT_SIG_ID = "hit"
signal hit

export var speed = 400  # How fast the player will move (pixels/sec).
var screen_size  # Size of the game window.
var _velocity: Vector2
var _animated_sprite: AnimatedSprite


func _ready():
    hide()
    screen_size = get_viewport_rect().size
    
func start(pos: Vector2):
    position = pos
    show()
    $CollisionShape2D.disabled = false

    
func _process(delta: float):
    _velocity = Vector2()
    _velocity.x += UserInput.get_horizontal()
    _velocity.y += UserInput.get_vertical()

    _animated_sprite = $AnimatedSprite
    _update_position(delta)
    _rotate_sprite()


func _update_position(delta: float):
    if (_velocity.length() > 0):
        _velocity = _velocity.normalized() * speed
        _animated_sprite.play()
    else:
        _animated_sprite.stop()

    position += _velocity * delta
    position = Vector2(
        clamp(position.x, 0, screen_size.x),
        clamp(position.y, 0, screen_size.y)
    )


func _rotate_sprite():
    if _velocity.x != 0 :
        _animated_sprite.animation = Animations.WALK
        _animated_sprite.flip_v = false
        _animated_sprite.flip_h = _velocity.x < 0
    elif _velocity.y != 0 :
        _animated_sprite.animation = Animations.UP
        _animated_sprite.flip_v = _velocity.y > 0      
    
    
func _on_Player_body_entered(body):
    hide()  # Player disappears after being hit.
    emit_signal(HIT_SIG_ID)
    $CollisionShape2D.set_deferred(Switch.DISABLED, true)
    
    
class UserInput:
    const _right = "ui_right"
    const _left = "ui_left"
    const _down = "ui_down"
    const _up = "ui_up"
    
    static func get_horizontal() -> int:
        return (1 if Input.is_action_pressed(_right) else 
                -1 if Input.is_action_pressed(_left) else 0)
                
    static func get_vertical() -> int:
        return (1 if Input.is_action_pressed(_down) else 
                -1 if Input.is_action_pressed(_up) else 0)
                
                
class Animations:
    const WALK = "walk"
    const UP = "up"


class Switch:
    const DISABLED = "disabled"
    const ENABLED = "enabled"
