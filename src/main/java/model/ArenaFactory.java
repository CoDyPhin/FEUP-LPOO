package model;

public class ArenaFactory {

    public ArenaModel createArena(int width, int height, int nivel) {
        ArenaModel arena = new ArenaModel(width,height);
        if(nivel == 1){
            arena.createBonus(2);
        }
        else if(nivel == 2){
            arena.createWallsWithGaps();
            arena.createBonus(4);
        }
        else if(nivel == 3){
            arena.createWalls();
            arena.createBonus(6);
        }
        return arena;
    }
}
