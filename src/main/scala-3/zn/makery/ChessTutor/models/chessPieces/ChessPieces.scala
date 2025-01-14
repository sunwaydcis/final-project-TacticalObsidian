package ChessTutor.models.chessPieces

import ChessTutor.models.chessPieces.Alliance._

class Pawn(_color: Alliance) extends BaseChessPiece(_color) with TPawn:
  override val symbol: String =
    _color match
      case White => "♙"
      case Black => "♟"
      case null => throw IllegalArgumentException(s"No such color $_color")


class Knight(_color: Alliance) extends BaseChessPiece(_color) with Octet with ShortTraversable:
  override val symbol: String =
    _color match
      case White => "♘"
      case Black => "♞"
      case null => throw IllegalArgumentException(s"No such color $_color")

class Bishop(_color: Alliance) extends BaseChessPiece(_color) with Diagonal:
  override val symbol =
    _color match
      case White => "♗"
      case Black => "♝"
      case null => throw IllegalArgumentException(s"No such color $_color")


class Rook(_color: Alliance) extends BaseChessPiece(_color) with Crosser:
  override val symbol =
    _color match
      case White => "♖"
      case Black => "♜"
      case null => throw IllegalArgumentException(s"No such color $_color")


class King (_color: Alliance) extends BaseChessPiece(_color) with AllDirections with ShortTraversable:
  override val symbol =
    _color match
      case White => "♔"
      case Black => "♚"
      case null => throw IllegalArgumentException(s"No such color $_color")

class Queen (_color: Alliance) extends BaseChessPiece(_color) with AllDirections:
  override val symbol =
    _color match
      case White => "♕"
      case Black => "♛"
      case null => throw IllegalArgumentException(s"No such color $_color")


