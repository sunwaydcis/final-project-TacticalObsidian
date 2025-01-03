//package zn.makery.ChessTutor.util
//
//import ChessTutor.models.Board
//import ChessTutor.models.chessPieces.Alliance._
//import ChessTutor.models.chessPieces.{Pawn, Promotable}
//
//object BoardFactory:
//  def init(_board: Board) =
//    for col <- 0 until 8 do
//      _board.place(new Pawn(White) with Promotable, 1, col)
//      _board.placePiece(new Pawn(Black) with Promotable, 6, col)
