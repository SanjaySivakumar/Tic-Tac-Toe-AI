//Sai and Shivam
//period 2
import java.util.*;
public class AISS implements PlayerInt
{
    private char player;
    private char opp;
    private String name;

    public AISS(char letter)
    {
        name = "Sai's AI";
        player = letter;
    }

    @Override
    public char getLetter() {
        return player;
    }
    @Override
    public Location getMove(Board board)
    {
        int max =  -1;
        int oppMax = -1;
        Location best =  null;
        Location best1 =  null;


        for (int s = 0; s <4; s++)//tries to get advantage
        {
            for (int r = 0; r < 4; r++)
            {
                for (int c = 0; c < 4; c++)
                {
                    Location location = new Location(c, r, s);
                    if (board.isEmpty(location))
                    {
                        Countsss cts = new Countsss(board, location, player);
                        Countsss ctO =  new Countsss(board,location, opp);
                       // cts.addMe(cts.getCount());
                       // cts.addOpp(cts.getCount());
                       // int score = cts.getMy1s() + cts.getMy2s() * 10 + cts.getMy3s() * 100 + cts.getMy4s() * 1000;
                          int score = cts.getMy1s() + cts.getMy2s() * 10 + cts.getMy3s() * 100 + cts.getMy4s() * 1000;


                        //System.out.print("lacation "+location + " m1 "+cts.getMy1s() + " ,"+ " m2 "+ +cts.getMy2s()+ " ,"+ " m3 "+  +cts.getMy3s() + " ," + " m4 "+cts.getMy4s() +" ");

                        int scoreOpp = cts.getOpp1s() + cts.getOpp2s() * 10 + cts.getOpp3s() * 100 + cts.getOpp4s() * 1000;
                         scoreOpp+=score;
                         //cts.get

                        // System.out.println("lacation "+ " m1 "+location+cts.getOpp1s() + " ," +" m2 "+cts.getOpp2s()+ " ," +" m3 " +cts.getOpp3s() + " ,"+ " m4 "+cts.getOpp4s() +" ");


                        if (score > max)
                        {
                            max = score;
                            best = location;
                            //break;
                        }

                        if(score > max && score > 100)
                        {
                            max =  score;
                            best =  location;
                            break;
                        }

                        if(scoreOpp > max && scoreOpp > 100)
                        {
                            max =  scoreOpp;
                            best =  location;
                            break;
                        }
                    }
                }
            }
        }
        return best;
    }


    public String getName()
    {
        return name;
    }

    public PlayerInt freshCopy()
    {
        return new AISS(player);
    }
}























