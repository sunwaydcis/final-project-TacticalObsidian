package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Knight (__color: Alliance) extends ChessPiece(__color) with Octet with ShortStepper:

  override val _symbol: String =
    __color match
      case White => "♘"
      case Black => "♞"
      case null => throw IllegalArgumentException(s"No such color $__color")

