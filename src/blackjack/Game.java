/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author ELBANA
 */
public class Game {
     public Player[]players = new Player[4];
     public Card[]cards = new Card[52];
     public int highscore=0;
     
    public void generateCards(){
    
        int h =0;
    for(int i = 0 ; i<4 ; i++)
    {
      for(int j = 0 ; j<13 ; j++)
      {
         if(j>9) {
             cards[h]=new Card(i,j,10);
         }
         else
         {
           cards[h ]=new Card(i,j,(j+1));  
         }
         h++;
      }
    }
}
    
  public Card drawCard()
  {
      Random rand=new Random();
       Card returnobj;
       
      int drawcard=rand.nextInt(52);
      returnobj = cards[drawcard]; 
      
     while(cards[drawcard]==null)
     {
       drawcard=rand.nextInt(52);
       if(cards[drawcard]!=null)
       {
         returnobj = cards[drawcard];    
       }
     }  
    cards[drawcard]=null;
    return returnobj;
  }
  
  public void setPlayers()
  {
      Scanner setname=new Scanner (System.in);
      System.out.println("Enter players Name:");
      for(int i=0 ; i<4 ;i++)
      {
          
          String playername = setname.next();
              players[i]= new Player(playername);
              players[i].addCard (drawCard());
              players[i].addCard (drawCard());
              
      }
       
  }
  public void updateMaxscore()
  {
    for(int i=0 ; i<3; i++) 
    {
        if(players[i].getScore()<=21)
        {
            if(players[i].getScore()>highscore)
              {
                 highscore=players[i].getScore();
              }
        }
       
     
    }
  }
  
}
