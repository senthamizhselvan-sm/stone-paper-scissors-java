import java.util.Random;
import java.util.Scanner;

public class StonePaperScissors {

    public static String name(int c) {
        Scanner sc = new Scanner(System.in);
        String player = "";
        if (c == 1) {
            System.out.print("\nType your name: ");
            player = sc.nextLine();
        } else {
            String[] players = new String[2];
            System.out.print("\nType name of player 1: ");
            players[0] = sc.nextLine();
            System.out.print("Type name of player 2: ");
            players[1] = sc.nextLine();
            player = players[0] + "," + players[1];
        }
        return player;
    }

    public static void play(int c, String player) {
        String[] lst = {"stone", "paper", "scissor"};
        int score1 = 0, score2 = 0;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        if (c == 1) {
            int a = 1;
            while (a == 1) {
                System.out.println("\n1. stone\n2. paper\n3. scissor");
                System.out.print("Enter your choice [1/2/3]: ");
                int playerChoice = sc.nextInt();

                // Computer's choice (randomly generated)
                int compChoice = rand.nextInt(3) + 1;
                System.out.println("Computer chose: " + lst[compChoice - 1]);
                System.out.println("You chose: " + lst[playerChoice - 1]);

                if (playerChoice == compChoice) {
                    System.out.println("It is a tie");
                } else if (playerChoice > compChoice) {
                    if (playerChoice == 3 && compChoice == 1) {
                        System.out.println("Computer won");
                        score2++;
                    } else {
                        System.out.println("You won");
                        score1++;
                    }
                } else {
                    if (playerChoice == 1 && compChoice == 3) {
                        System.out.println("You won");
                        score1++;
                    } else {
                        System.out.println("Computer won");
                        score2++;
                    }
                }

                System.out.print("Do you wish to continue? (yes-->1 , no-->2): ");
                a = sc.nextInt();
                if (a == 2) {
                    System.out.println("Your score = " + score1);
                    System.out.println("Computer score = " + score2);
                    if (score1 > score2) {
                        System.out.println("Congratulations " + player + ", you won");
                    } else if (score2 > score1) {
                        System.out.println("Better luck next time");
                    } else {
                        System.out.println("It is a tie");
                    }
                }
            }
        } else {
            int a = 1;
            String player1 = player.split(",")[0];
            String player2 = player.split(",")[1];

            while (a == 1) {
                System.out.println("\n1. stone\n2. paper\n3. scissor");
                System.out.print(player1 + " Enter your choice [1/2/3]: ");
                int player1Choice = sc.nextInt();
                System.out.print(player2 + " Enter your choice [1/2/3]: ");
                int player2Choice = sc.nextInt();

                System.out.println(player1 + " chose: " + lst[player1Choice - 1]);
                System.out.println(player2 + " chose: " + lst[player2Choice - 1]);

                if (player1Choice == player2Choice) {
                    System.out.println("It is a tie");
                } else if (player1Choice > player2Choice) {
                    if (player1Choice == 3 && player2Choice == 1) {
                        System.out.println(player2 + " won");
                        score2++;
                    } else {
                        System.out.println(player1 + " won");
                        score1++;
                    }
                } else {
                    if (player1Choice == 1 && player2Choice == 3) {
                        System.out.println(player1 + " won");
                        score1++;
                    } else {
                        System.out.println(player2 + " won");
                        score2++;
                    }
                }

                System.out.print("Do you wish to continue? (yes-->1 , no-->2): ");
                a = sc.nextInt();
                if (a == 2) {
                    System.out.println(player1 + " score = " + score1);
                    System.out.println(player2 + " score = " + score2);
                    if (score1 > score2) {
                        System.out.println("Congratulations " + player1 + ", you won");
                    } else if (score2 > score1) {
                        System.out.println("Congratulations " + player2 + ", you won");
                    } else {
                        System.out.println("It is a tie");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to stone paper scissor!");

        int ch;
        System.out.print("(1) 1 player\n(2) 2 player\nEnter your choice[1/2]: ");
        ch = sc.nextInt();

        if (ch != 1 && ch != 2) {
            System.out.print("Invalid choice\n");
            System.out.print("Enter your choice[1/2]: ");
            ch = sc.nextInt();
        }

        String player;
        if (ch == 1) {
            player = name(ch);
            play(ch, player);
        } else {
            player = name(ch);
            play(ch, player);
        }
    }
}
