/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;

/**
 *
 * @author ELBANA
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
     static Game gameobject = new Game();
    
    public static void main(String[] args) {
        // TODO code application logic here
         GUI gui=new GUI();
        gameobject.generateCards();
        gameobject.setPlayers();
        gui.runGUI(gameobject.cards,gameobject.players[0].cardobj ,gameobject.players[1].cardobj 
                ,gameobject. players[2].cardobj, gameobject.players[3].cardobj);
        
        Scanner x=new Scanner (System.in);
        for(int i= 0 ;i <3 ; i++)
        {
           String hitplayer=x.next();
           while(hitplayer.equals("h"))
           {
               Card y =gameobject.drawCard();
               gameobject.players[i].addCard(y);
               gui.updatePlayerHand(y, i);
               hitplayer=x.next();
               if(gameobject.players[i].getScore()>21)
               {
                 System.out.println(gameobject.players[i].getPlayername()+" is Busted.");
                 break;
               }
           }
          
        }
        gameobject .updateMaxscore();
        
         if(gameobject.players[3].getScore()>gameobject.highscore&&gameobject.highscore!=0)
         {
            System.out.println("The Winner is the Dealer.");
            gameobject.highscore=gameobject.players[3].getScore();
         }
        
         else
            {
              while(gameobject.players[3].getScore()<21)
                {
             
                Card z =gameobject.drawCard();
                 gameobject.players[3].addCard(z);
                 gui.updateDealerHand(z,gameobject.cards);
                 if(gameobject.players[3].getScore()==21 )
                 {
                      System.out.println("The Winner is the Dealer.");
                      gameobject.highscore=gameobject.players[3].getScore();
                      break;
                 }
                
                } 
             }
         boolean getblack=false;
         boolean checkblack=false;
         for(int i=0 ; i<3 ; i++)
         {
              for(int j=0 ; j<3 ; j++)
              {
                 if((i!=j)&&((gameobject.players[i].getScore()==gameobject.highscore)&&(gameobject.players[j].getScore()==gameobject.highscore))) 
                 {
                   getblack=true;
                 }
                 else if(gameobject.players[i].getScore()==gameobject.highscore )
                 {
                    checkblack=true;
                 }
         
              } 
              if(getblack==true)
                 {
                    System.out.println("Game Push"); 
                    break;
                 }
              else if(checkblack==true)
                      {
                        System.out.println("The winner is "+ gameobject.players[i].getPlayername()+ ".") ; 
                        break;
                      }
             
         }
         if(gameobject.highscore==0)
         {
             System.out.println("Game Push"); 
         }
          for(int i=0 ; i<4 ; i++)
          {
              System.out.println("Score of Player "+ (i+1)+" : " + gameobject.players[i].getScore());
          }
            System.out.println("The HighScore is "+gameobject.highscore);
        }
           
    
    
    }
