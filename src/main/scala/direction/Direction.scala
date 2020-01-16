package direction

import enumeratum.values.{IntEnum, IntEnumEntry}

sealed abstract class Direction(val value: Int) extends IntEnumEntry

object Direction extends IntEnum[Direction] {
  case object North extends Direction(0)
  case object East extends Direction(1)
  case object South extends Direction(2)
  case object West extends Direction(3)

  val values = findValues

  def clockwise(current: Direction): Direction = {
    val nextIndex = (values.indexOf(current) + 1) % values.length
    values(nextIndex)
  }

  def anticlockwise(current: Direction): Direction = {
    val nextIndex = values.indexOf(current) - 1
    nextIndex match {
      case -1 => values(values.length - 1)
      case i => values(i)
    }
  }
}
