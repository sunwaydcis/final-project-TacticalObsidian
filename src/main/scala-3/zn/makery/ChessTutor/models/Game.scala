package ChessTutor.models

class Game ( //Constructor parameters
             val playerRole: String, 
             val playerELO: Int, 
             val aiELO: Int, 
             val player1TimeCap: Double, 
             val player2TimeCap: Double):
  //Defined during / after game creation
  var moveHistory: List[Board]
  

