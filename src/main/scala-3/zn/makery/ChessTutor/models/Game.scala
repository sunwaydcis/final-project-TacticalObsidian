package ChessTutor.models

class Game (var playerRole: String, var versusMode: String, var player1TimeCap: Double, var player2TimeCap: Double):
  val GameHistory = List[new Board]
