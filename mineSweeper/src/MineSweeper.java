
import java.util.Random;
import java.util.Scanner;
public class MineSweeper {
    int rowNumber,colNumber,size,mineCount=0;
    String[][] mineMap;
    String[][] gamerMap;
    Random rand=new Random();//random object for mine input
    Scanner scan=new Scanner(System.in);// Scanner object for user input
    boolean game =true;
    MineSweeper(){// Constructor initializing the MineSweeper object

    }
    public  void start(){
        Scanner scan=new Scanner(System.in);

        System.out.println("Mayın tarlasına hoş geldiniz.\nLütfen oynamak istediğiniz boyutları giriniz.");
        do{
            System.out.println("Oyunun satır sayısını giriniz: ");
            this.rowNumber=scan.nextInt();
            System.out.println("Oyunun sütun sayısını giriniz: ");
            this.colNumber=scan.nextInt();
            if(this.colNumber<2||this.rowNumber<2){//check the entered row and column numbers
                System.out.println("Enaz 2x2 boyutlarında bir oyun başlatabilirsiniz.\nOyun boyutlarını tekrar giriniz.");
            }
        }while(this.colNumber<2||this.rowNumber<2);
        this.mineMap=new String[rowNumber][colNumber];// Creating a 2D array for the mine map
        this.gamerMap=new String[rowNumber][colNumber];// Creating a 2D array for the player's view
        this.size=rowNumber*colNumber;// Calculating the total size of the game board*/
        run();
    }
    public void run(){
        int row,col;// Variables for row and column input
        int succes=0;// Counter for successful moves
        System.out.println("Oyun başlıyor.");// Displaying game start message
        addMines();// Adding mines to the mine map
        printMap(mineMap);// Displaying the mine map!*********
        while(game){// Main game loop
            mineCount=0;// Resetting mine count for each move
            for (int i=0;i<=colNumber;i++){// Displaying separator between rows
                System.out.print("====");
            }
            System.out.println();
            printMap(gamerMap);// Displaying the player's view of the game board
            System.out.println("Satır numarasını giriniz: ");// Prompting user for row input
            row=scan.nextInt();// Reading user input for row
            System.out.println("Sütun numarasını giriniz: ");// Prompting user for column input
            col=scan.nextInt();// Reading user input for column

            // Validating user input
            if(row<0||row>=rowNumber){
                System.out.println("Geçersiz koordinat");
                continue;
            }
            if (col<0||col>=colNumber){
                System.out.println("Geçersiz koordinat");
                continue;
            }
            if (gamerMap[row][col] != "| - |") {
                System.out.println("Daha önce girdiniz");
                continue;
            }
            // Checking the selected cell
            if(mineMap[row][col]!="| * |"){
                check(row,col);// Checking surrounding cells for mines
                succes++;// Incrementing successful moves counter
                if(succes==size-(size/4)){
                    printMap(gamerMap);
                    System.out.println("tebrikler kazandınız.");// Displaying win message
                    break;// Exiting the game loop as the game is won
                }
            }else{
                game=false;// Ending the game as a mine is revealed
                System.out.println("game over!");
            }
        }

    }
    // Method to check surrounding cells for mines
    public void check(int r,int c){
        // Checking adjacent cells for mines and updating the count
        // The commented lines were probably intended for updating the game board
        if(gamerMap[r][c].equals("| - |")){
            if ((c<colNumber-1)&&(mineMap[r][c+1].equals("| * |"))){//right of the entered row and column
                mineCount++;
            }
            if ((c>0)&&(mineMap[r][c-1].equals("| * |"))){//left of the entered row and column
                mineCount++;
            }
            if ((r<rowNumber-1)&&(mineMap[r+1][c].equals("| * |"))){//down of the entered row and column
                mineCount++;
            }
            if ((r>0)&&(mineMap[r-1][c].equals("| * |"))){//upper of the entered row and column
                mineCount++;
            }
            if ((c<colNumber-1)&&(r<rowNumber-1)&&(mineMap[r+1][c+1].equals("| * |"))){//down right of the entered row and column
                mineCount++;
            }
            if ((r>0)&&(c>0)&&(mineMap[r-1][c-1].equals("| * |"))){//upper left of the entered row and column
                mineCount++;
            }
            if ((c>0)&&(r<rowNumber-1)&&(mineMap[r+1][c-1].equals("| * |"))){//down left of the entered row and column
                mineCount++;
            }
            if ((r>0)&&(c<colNumber-1)&&(mineMap[r-1][c+1].equals("| * |"))){//upper right of the entered row and column
                mineCount++;
            }
            int a=mineCount;////number of mines adjacent to the entered row and column
            gamerMap[r][c]= String.valueOf("| "+ a +" |");
        }

    }
    // Method to randomly add mines to the mine map
    public void addMines(){
        int randRow,randCol,count=0;
        // Generating random coordinates and placing mines until the mine count reaches 1/4th of the board size
        for(int i=0;i<mineMap.length;i++){
            for(int j=0;j<mineMap[0].length;j++){
                mineMap[i][j]="| - |";
                //System.out.print(mineMap[i][j]);
            }
            //System.out.println();
        }
        while(count!=(size/4)){
            randRow=rand.nextInt(rowNumber);
            randCol=rand.nextInt(colNumber);

            if (mineMap[randRow][randCol]!="| * |"){
                mineMap[randRow][randCol]="| * |";

                count++;
            }
        }

    }
    // Method to print the game board
    public void printMap(String[][] arr){
        for (int i=0;i< arr[0].length;i++){
            //System.out.print("    "+i);
            if(i>9){
                System.out.print("   "+i);
            }else{System.out.print("    "+i);}
        }
        System.out.println();

        // Displaying the game board
        for(int i=0;i< arr.length;i++){
            //System.out.print(i+" ");
            if(i>9){
                System.out.print(i);
            }else{System.out.print(i+" ");}
            for (int j=0;j<arr[0].length;j++){

                if(arr[i][j]==null){

                    arr[i][j]="| - |";
                    System.out.print("");
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

}


