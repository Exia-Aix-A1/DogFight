package jpu2016.dogfight.model;

import java.util.ArrayList;
import java.util.Observable;
/**
 * Modèle Dogfight
 * @author Mandel Vaubourg
 * @version 1.0
 *
 * */
public class DogfightModel extends Observable implements IDogfightModel{

    /**
     * Contient l'ensemble des éléments (nuages, avions, missiles, etc...)
     * */
    ArrayList<IMobile> mobiles;
    /**
     * Arène de combat
     * */
    IArea area;
    /**
     *Position dans la fenetre ?
     * */
    Position position;

    public DogfightModel(){
        //this.position = new Position();
        this.mobiles = new ArrayList<>();


    }
    @Override
    public IArea getArea(){
        return this.area;
    }

    @Override
    public void buildArea(Dimension dimension){
       this.area = new Sky(dimension);
    }

    @Override
    public void addMobile(IMobile mobile){
        this.mobiles.add(mobile);
    }

    @Override
    public void removeMobile(IMobile mobile){

        for(int i = 0; i < this.mobiles.size(); i++){
            if(this.mobiles.get(i) == mobile){
                this.mobiles.remove(i);
                break;
            }
        }
    }

    @Override
    public ArrayList<IMobile> getMobiles(){
        return this.mobiles;

    }

    @Override
    public IMobile getMobileByPlayer(final int player){
        if(this.mobiles.get(player).isPlayer(player)){
            return this.mobiles.get(player);
        }

        return this.mobiles.get(player);

    }


    /**
     * ??????????
     * */
    @Deprecated
    @Override
    public void setMobilesHavesMoved(){

    }
    @Override
    public Position getPosition() {
        return position;
    }
    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
    @Override
    public void setPosition(final double x, final double y){
        this.position.setX(x);
        this.position.setY(y);
    }
    @Override
    public void setPosition(final double x, final double y, final double maxX, final double maxY){
        this.position.setMaxX(maxX);
        this.position.setMaxY(maxY);
        this.position.setX(x);
        this.position.setY(y);

    }
}
