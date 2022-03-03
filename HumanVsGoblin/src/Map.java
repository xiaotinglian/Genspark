import java.util.Arrays;

public class Map {

    Terrain[][] board;
    Terrain entity;

    public Map addEntity(Terrain humanoid){
        entity= humanoid;
        return this;
    }

    public Map(int x, int y){

        this.board = new Terrain[x][y];
        for( int i = 0; i< x; i ++){
            for(int j = 0; j< y ; j++){
                board[i][j] = new Land(x,y);
            }
        }
    }

    @Override
    public String toString() {
        for(var row: board){
            System.out.println(Arrays.toString(row).replace(",", "").replace("[", "").replace("]", "").trim());
        }
        return "";
    }



    public static void main(String[] args){
        var x =new Map(10,10);

        x.addEntity(new Terrain(1,1));
        System.out.println(x);

    }

}

