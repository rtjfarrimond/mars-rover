package rover.navigation

case class Coordinate(x: Int, y: Int) {

  def delta(other: Coordinate): (Int, Int) = (math.abs(x - other.x), math.abs(y - other.y))
}
