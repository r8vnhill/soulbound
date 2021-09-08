extends RigidBody2D

export var min_speed = 150  # Minimum speed range.
export var max_speed = 250  # Maximum speed range.


# Called when the node enters the scene tree for the first time.
func _ready():
    var animation_sprite = $AnimatedSprite
    var mob_types = animation_sprite.frames.get_animation_names()
    animation_sprite.animation = mob_types[randi() % mob_types.size()]


func _on_VisibilityNotifier2D_screen_exited() -> void:
    queue_free()
