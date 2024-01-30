/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author ELBANA
 */
public class Player {
    private final String  playername;
    private int score=0;
    public Card[]cardobj= new Card[11];
    // boolean getblack=false;
    //boolean check=false;
    int index=0;

    public Player(String name)
    {
        this.playername=name;
    }

    public String getPlayername() {
        return playername;
    }
    
     public void addCard(Card cardadded)
    {
        cardobj[index]=cardadded;
        score+=cardobj[index].getValue();
        index++;
    }

    public int getScore() {
        return score;
    }
     
}
