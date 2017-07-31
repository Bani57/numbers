package com.endava.numbers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Stack;

@Service
public class NumberCollection {
    private ArrayList<NumberInput> numberList=new ArrayList<>();
    private Integer sum=0;

    public void addNumber(NumberInput numberInput)
    {
        numberList.add(numberInput);
        for(int i=0;i<numberInput.getLength();i++)
            sum+=numberInput.getData()[i];
    }

    public void deleteNumber(NumberInput numberInput)
    {
        for(NumberInput ni:numberList)
        {
            if(ni.equals(numberInput))
                numberList.remove(ni);
        }
    }

    public ArrayList<NumberInput> getNumberList() {
        return numberList;
    }

    public void clearList()
    {
        numberList.clear();
        sum=0;
    }
    public Double getAverage()
    {
        return 1.0*sum/numberList.size();
    }

    public String balancedPartition()
    {
        int n=0;
        for(NumberInput numberInput:numberList)
            n+=numberInput.getLength();
        int niza[]=new int[n];
        int k=0;
        for(NumberInput numberInput:numberList)
        {
            for (Integer number:numberInput.getData())
                niza[k++] = number;
        }
        int suma=0;
        for(int i=0;i<n;i++)
            suma+=niza[i];
        int[][] partition=new int[n+1][suma+1];
        for(int i=0;i<=n;i++)
            partition[i][0]=1;
        for(int j=1;j<=suma;j++)
            partition[0][j]=0;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=suma;j++)
            {
                if(partition[i-1][j]==1 || (j-niza[i-1]>=0 && partition[i-1][j-niza[i-1]]==1))
                    partition[i][j]=1;
                else
                    partition[i][j]=0;
            }
        }
        int bestj=suma/2;
        while(bestj>=0)
        {
            if(partition[n][bestj]==1)
                break;
            bestj--;
        }
        int best=Math.abs(bestj-(suma-bestj));
        Stack<Integer> part1=new Stack<>();
        Stack<Integer> part2=new Stack<>();
        int i=n,j=bestj;
        while(i>0 && bestj>=0)
        {
            if(partition[i-1][j]==1)
                part2.push(niza[i-1]);
            else if (j-niza[i-1]>=0 && partition[i-1][j-niza[i-1]]==1) {
                part1.push(niza[i-1]);
                j-=niza[i-1];
            }
            else
                part1.push(niza[i-1]);
            i--;
        }
        String output="Best difference: "+best+"\nPartition 1: ";
        while(!part1.empty())
            output+=part1.pop()+" ";
        output+="\nPartition 2: ";
        while(!part2.empty())
            output+=part2.pop()+" ";
        return output;
    }
}
