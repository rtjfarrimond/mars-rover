package rover.navigation

sealed trait Instruction
case object MoveForward extends Instruction
case object RotateClockwise extends Instruction
case object RotateAnticlockwise extends Instruction
