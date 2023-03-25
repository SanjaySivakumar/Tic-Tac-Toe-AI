class Countsss
{
    private int my4s, my3s = 0, my2s =0, my1s = 0;
    private int Opp4s, Opp3s = 0, Opp2s = 0, Opp1s = 0;
    private Board board;
    private Location location;
    private char me,opp;
    private int winSheet = 0;
    private int winCol = 0;
    private int winRow = 0;
    //New lines of code
    private int count = 0;
    private int winPosCounterMe = 0;
    private int winPosCounterMeOpp = 0;
    //End code mod

    public Countsss( Board board, Location location, char me)
    {
        // this.my4s = my4s;
        this.board = board;
        this.location = location;
        this.me = me;
        opp =  (me == 'X')?'O':'X';
        calculate();
        calculateOpp();
    }

    public int getWinSheet()
    {
        return winSheet;
    }

    public int getWinCol()
    {
        return winCol;
    }

    public int getWinRow()
    {
        return winRow;
    }

    public int getMy1s()
    {
        return my1s;
    }

    public int getMy2s() {
        return my2s;
    }

    public int getMy3s() {
        return my3s;
    }

    public int getMy4s() {
        return my4s;
    }

    public int getOpp1s()
    {
        return Opp1s;
    }

    public int getOpp2s()
    {
        return Opp2s;
    }

    public int getOpp3s()
    {
        return Opp3s;
    }

    public int getOpp4s()
    {
        return Opp4s;
    }

    //new line code
    public int getCount()
    {
        return count;
    }
    //end code mod

    public void addMe(int count)
    {

        if(count ==1)
        {
            my1s++;
        }
        else if(count == 2)
        {
            my2s++;
        }
        else if(count == 3)
        {
            my3s++;
        }
        else if(count == 4)
        {
            my4s++;
            winPosCounterMe++;
        }
    }

    public void addOpp(int count)
    {
        if(count == 1)
        {
            Opp1s++;
        }
        else if(count == 2)
        {
            Opp2s++;
        }
        else if(count == 3)
        {
            Opp3s++;
        }
        else if(count == 4)
        {
            Opp4s++;
            winPosCounterMeOpp++;
        }
    }

    public void calculate()
    {
        int  c = location.getCol();
        int  r = location.getRow();
        int  s =  location.getSheet();


        char[][][] b  =  board.getData();
        int count = 0;

        //horizontals
        for(int cc = 0; cc <4; cc++)
        {
            if(b[s][r][cc]==me)
            {
                count++;
            }

            else if(b[s][r][cc]==opp)
            {
                count = 0;
                break;
            }
        }
        addMe(count);
/*
        if(getOpp4s() > 0 && winPosCounterMe > 0)
        {
            winCol = cc;
            winSheet = s;
            winRow = r;
        }


 */
        //verticals
        count  =1;
        for (int rr =0; rr<4;rr++)
        {
            if(b[s][rr][c]==me)
            {
                count++;
            }

            else if(b[s][rr][c]==opp)
            {
                count = 0;
                break;
            }
        }
        addMe(count);
/*
        if(getOpp4s() > 0 && winPosCounterMe > 0)
        {
            winCol = c;
            winSheet = s;
            winRow = rr;
        }

 */

        //backwards
        count =1;
        for (int ss = 0; ss < 4; ss++)
        {
            if(b[ss][r][c]==me)
            {
                count++;
            }
            else if(b[ss][r][c]==opp)
            {
                count  = 0;
                break;
            }
        }
        addMe(count);
/*
        if(getOpp4s() > 0 && winPosCounterMe > 0)
        {
            winCol = c;
            winSheet = ss;
            winRow = r;
        }

 */

        //z diagonal 1
        if(c+r==3)
        {
            count=1;
            for (int aa = 0; aa < 4; aa++)
            {
                if(b[s][aa][aa]==me)
                {
                    count++;
                }
                else if(b[s][aa][aa]==opp)
                {
                    count=0;
                    break;
                }
            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = aa;
                winSheet = s;
                winRow = aa;
            }


 */
        }

        //z diagonal 2
        if(c+r==3)
        {
            count=1;
            for (int aa = 0; aa < 4; aa++)
            {
                if(b[s][aa][3-aa]==me)
                {
                    count++;
                }
                else if(b[s][aa][3-aa]==opp)
                {
                    count=0;
                    break;
                }
            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = 3-aa;
                winSheet = s;
                winRow = aa;
            }

 */

        }
        //y plane D1
        if(c ==s)
        {
            count =1;
            for(int aa=0; aa<4;aa++)
            {
                if(b[aa][r][aa]==me)
                {
                    count++;
                }
                else if(b[aa][r][aa]==opp)
                {
                    count = 0;
                    break;
                }

            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = aa;
                winSheet = aa;
                winRow = r;
            }

 */
        }
        //y plane D2
        if(c+s==3)
        {
            count =1;
            for (int aa = 0; aa<4;aa++)
            {
                if(b[aa][r][3-aa]==me)
                {
                    count++;
                }
                else if(b[aa][r][3-aa]==opp)
                {
                    count  = 0;
                    break;
                }

            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = 3-aa;
                winSheet = aa;
                winRow = r;
            }

 */
        }

        //x plane D1
        if(c+s==3)
        {
            count =1;
            for (int aa = 0; aa<4;aa++)
            {
                if(b[aa][aa][c]==me)
                {
                    count++;
                }
                else if(b[aa][aa][c]==opp)
                {
                    count  = 0;
                    break;

                }
            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = c;
                winSheet = aa;
                winRow = aa;
            }

 */
        }

        //x plane D2
        if(r+s==3)
        {
            count =1;
            for (int aa = 0; aa<4;aa++)
            {
                if(b[aa][3-aa][c]==me)
                {
                    count++;
                }
                else if(b[aa][3-aa][c]==opp)
                {
                    count  = 0;
                    break;

                }
            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = c;
                winSheet = aa;
                winRow = 3-aa;
            }

 */
        }
        //special 1
        if((count ==0 && r==0 && s==0) || (count ==1 && r==1 && s==1) ||(count ==2 && r==2 && s==2)||(count ==3 && r==3 && s==3))
        {
            count =1;
            for (int aa=0; aa<4; aa++)
            {
                if(b[aa][aa][aa]==me)
                {
                    count++;
                }
                else if (b[aa][aa][aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = aa;
                winSheet = aa;
                winRow = aa;
            }

 */
        }

        //special diagonal 2
        if((count ==3 && r==0 && s==0) ||(count ==2 && r==1 && s==1) ||(count ==1 && r==2 && s==2)||(count ==0 && r==3 && s==3))
        {
            count =1;
            for (int aa=0; aa<4; aa++)
            {
                if(b[aa][aa][aa]==me)
                {
                    count++;

                }
                else if (b[aa][aa][3-aa]==opp)
                {
                    count = 0;

                    break;
                }
            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = 3-aa;
                winSheet = aa;
                winRow = aa;
            }

 */
        }

        //special diagonal 3
        if((count ==0 && r==0 && s==3) ||(count ==1 && r==1 && s==2) ||(count ==2 && r==2 && s==1)||(count ==3 && r==3 && s==0))
        {
            count =1;
            for (int aa=0; aa<4; aa++)
            {
                if(b[aa][aa][aa]==me)
                {
                    count++;

                    //   count = 0;
                }
                else if (b[3-aa][aa][aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = aa;
                winSheet = 3-aa;
                winRow = aa;
            }

 */

        }

        //special diagonal 4
        if((count ==3 && r==0 && s==3) ||(count ==2 && r==1 && s==2) ||(count ==1 && r==2 && s==1)||(count ==0 && r==3 && s==0))
        {
            count =1;
            for (int aa=0; aa<4; aa++)
            {
                if(b[aa][aa][aa]==me)
                {
                    count++;

                }
                else if (b[3-aa][aa][3-aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);
/*
            if(getOpp4s() > 0 && winPosCounterMe > 0)
            {
                winCol = 3-aa;
                winSheet = 3-aa;
                winRow = aa;
            }

 */
        }
    }

    public void calculateOpp()
    {
        int  c = location.getCol();
        int  r = location.getRow();
        int  s =  location.getSheet();

        char[][][] b  =  board.getData();
        int count = 0;
        //horizontals
        for(int cc = 0; cc <4; cc++)
        {
            if(b[s][r][cc]==opp)
            {
                count++;
                // break;
            }
            else if(b[s][r][cc]==me)
            {
                count = 0;
                break;
            }
            addOpp(count);
/*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = cc;
                winSheet = s;
                winRow = r;
            }

 */
        }
        //verticals
        count  =1;
        for(int  rr = 0; rr <4; rr++)
        {
            if(b[s][rr][c]==opp)
            {
                count++;
                // break;
            }
            else if(b[s][rr][c]==me)
            {
                count = 0;
                break;
            }
        }

        addOpp(count);
        /*
        if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
        {
            winCol = c;
            winSheet = s;
            winRow = rr;
        }

         */

        //backwards
        count =1;
        for (int ss = 0; ss < 4; ss++)
        {
            if(b[ss][r][c]==opp)
            {
                count++;
            }
            else if(b[ss][r][c]==me)
            {
                count  = 0;
                break;
            }
        }
        addOpp(count);
/*
        if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
        {
            winCol = c;
            winSheet = ss;
            winRow = r;
        }

 */
        //z diagonal 1
        if(c+r==3)
        {
            count=1;
            for (int aa = 0; aa < 4; aa++)
            {
                if(b[s][aa][aa]==opp)
                {
                    count++;
                }
                else if(b[s][aa][aa]==me)
                {
                    count=0;
                    break;
                }
            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = aa;
                winSheet = s;
                winRow = aa;
            }

             */
        }

        //z diagonal 2
        if(c+r==3)
        {
            count=1;
            for (int aa = 0; aa < 4; aa++)
            {
                if(b[s][aa][3-aa]==opp)
                {
                    count++;
                }
                else if(b[s][aa][3-aa]==me)
                {
                    count=0;
                    break;
                }
            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = 3-aa;
                winSheet = s;
                winRow = aa;
            }

             */
        }
        //y plane D1
        if(c ==s)
        {
            count =1;
            for(int aa=0; aa<4;aa++)
            {
                if(b[aa][r][aa]==opp)
                {
                    count++;
                }
                else if(b[aa][r][aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = aa;
                winSheet = aa;
                winRow = r;
            }

             */
        }
        //y plane D2
        if(c+s==3)
        {
            count =1;
            for (int aa = 0; aa<4;aa++)
            {
                if(b[aa][r][3-aa]==opp)
                {
                    count++;
                }
                else if(b[aa][r][3-aa]==me)
                {
                    count  = 0;
                    break;
                }
            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = 3-aa;
                winSheet = aa;
                winRow = r;
            }

             */
        }

        //x plane D1
        if(c+s==3)
        {
            count =1;
            for (int aa = 0; aa<4;aa++)
            {
                if(b[aa][aa][c]==opp)
                {
                    count++;
                }
                else if(b[aa][aa][c]==me)
                {
                    count  = 0;
                    break;
                }
            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = c;
                winSheet = aa;
                winRow = aa;
            }

             */
        }

        //x plane D2
        if(r+s==3)
        {
            count =1;
            for (int aa = 0; aa<4;aa++)
            {
                if(b[aa][3-aa][c]==opp)
                {
                    count++;
                }
                else if(b[aa][3-aa][c]==me)
                {
                    count  = 0;
                    break;

                }
            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = c;
                winSheet = aa;
                winRow = 3-aa;
            }

             */

        }
        //special 1
        if((count ==0 && r==0 && s==0) ||(count ==1 && r==1 && s==1) ||(count ==2 && r==2 && s==2)||(count ==3 && r==3 && s==3))
        {
            count =1;
            for (int aa=0; aa<4; aa++)
            {
                if(b[aa][aa][aa]==opp)
                {
                    count++;
                }
                else if (b[aa][aa][aa]==me)
                {

                    count  = 0;
                    break;
                }

            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = aa;
                winSheet = aa;
                winRow = aa;
            }

             */

        }

        //special diagonal 2
        if((count ==3 && r==0 && s==0) ||(count ==2 && r==1 && s==1) ||(count ==1 && r==2 && s==2)||(count ==0 && r==3 && s==3))
        {
            count =1;
            for (int aa=0; aa<4; aa++)
            {
                if(b[aa][aa][3-aa]==opp)
                {
                    count++;
                }
                else if (b[aa][aa][3-aa]==me)
                {
                    count = 0;
                    break;
                }

            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = 3-aa;
                winSheet = aa;
                winRow = aa;
            }

             */

        }

        //special diagonal 3
        if((count ==0 && r==0 && s==3) ||(count ==1 && r==1 && s==2) ||(count ==2 && r==2 && s==1)||(count ==3 && r==3 && s==0))
        {
            count =1;
            for (int aa=0; aa<4; aa++)
            {
                if(b[3-aa][aa][aa]==opp)
                {
                    count++;

                }
                else if (b[3-aa][aa][aa]==me)
                {
                    count = 0;
                    break;
                }


            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = aa;
                winSheet = 3-aa;
                winRow = aa;
            }

             */
        }

        //special diagonal 4
        if((count ==3 && r==0 && s==3) ||(count ==2 && r==1 && s==2) ||(count ==1 && r==2 && s==1)||(count ==0 && r==3 && s==0))
        {
            count =1;
            for (int aa=0; aa<4; aa++)
            {
                if(b[3-aa][aa][3-aa]==opp)
                {
                    count++;
                }
                else if (b[3-aa][aa][3-aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
            /*
            if(getOpp4s() > 0 && winPosCounterMeOpp > 0)
            {
                winCol = 3-aa;
                winSheet = 3-aa;
                winRow = aa;
            }

             */
        }
    }
}

