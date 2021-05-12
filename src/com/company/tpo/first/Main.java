package com.company.tpo.first;

class Main {

    public static void main(String[] args) {
        System.out.println(myCos(Math.PI/6));
    }

    public static double myCos(double x){
        double nSum, oSum, sum;
        int i = 0;
        sum = nSum = 1;
        do
        {
            oSum = nSum;
            i++;
            sum = sum * x * x / i;
            i++;
            sum = sum / i;
            sum = -sum;
            nSum = oSum + sum;
        }
        while( nSum != oSum);
        return nSum;
    }
}
