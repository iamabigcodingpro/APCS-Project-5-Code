import java.util.Scanner;
public class Main {
    static final int BOARDX = 7;
    static final int BOARDY = 15;
    public static void main(String[] args) {
        System.out.println("Welcome to MEGA Connect 5!");
        System.out.println("You may choose to place one 3x3 MegaPiece");
        System.out.println();
        Board board = new Board(BOARDX, BOARDY);
        Scanner input = new Scanner(System.in); //creates scanner obj
        int player = 1;
        int[] remainingMegaPiece = new int[2];
        remainingMegaPiece[0] = 1;
        remainingMegaPiece[1] = 1;

        while (true) {
            board.displayAll();
            System.out.println("Player: " + player + ":");

            // Stuff should go here, probably
            String s = "N";
            if (remainingMegaPiece[player-1]>0){
                System.out.println("Use MegaPiece? (Y/N)?");
                s = input.nextLine();
            }

            if (s.equals("y") || s.equals("Y")){

                System.out.println("Enter the column you would like to place your MegaPiece at.");
                int c = input.nextInt();
                input.nextLine();
                if (c<=1 || c>=BOARDY){
                    System.out.println("Not a valid placement.");
                    continue;
                }
                MegaPiece p = new MegaPiece(c,player,board);
                if (p.getRow()<0){
                    System.out.println("Not a valid placement.");
                    continue;
                }
                board.placePiece(p);
                remainingMegaPiece[player-1]--;
            }else{

                System.out.println("Enter the column you would like to place your Piece at.");
                int c = input.nextInt();
                input.nextLine();
                if (c<1 || c>BOARDY){
                    System.out.println("Not a valid placement.");
                    continue;
                }
                Piece p = new Piece(c, player, board);
                if (p.getRow()<0){
                    System.out.println("Not a valid placement.");
                    continue;
                }
                board.placePiece(p);

            }

            if (board.checkForWin(player)) {
                System.out.println("player: " + player + " has won!");
                board.displayAll();
                break;
            }
            player = player % 2 + 1;
        }



    }
}
