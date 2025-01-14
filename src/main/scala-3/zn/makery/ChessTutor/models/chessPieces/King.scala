package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class King (__color: Alliance) extends ChessPiece(__color) with AllDirections with ShortStepper:
  
  override val _symbol =
    __color match
      case White => "♔"
      case Black => "♚"
      case _ => throw IllegalArgumentException(s"No such color $__color")

    

