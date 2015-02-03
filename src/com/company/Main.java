package com.company;

/*
* Find the fastest runner. Print the name and his/her time (in minutes).
* Write a method that takes as input an array of integers and returns the index corresponding to the person with the lowest
* time. Run this method on the array of times. Print out the name and time corresponding to the returned index.
*
* Write a second method to find the second-best runner. The second method should use the first method to determine the
* best runner, and then loop through all values to find the second-best (second lowest) time.
**/


import java.util.Collections;

public class Main {

    public static void main(String[] args)
    {
        // Arrays are indexed with same length so you know who has the corresponding time
        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt" ,"Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron" ,"Kate" };
        int[] times = new int[]{ 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

        // Test to see if there is anything in the arrays and if not exit with error message.
        if(times.length == 0 && names.length == 0)
        {
          System.out.print ("There are not registered names or times in the arrays!\n Bailing out now!");
          System.exit (0);
        }

        for(int i = 0; i< names.length; i++) {
          System.out.println( names[i] + ":" + times[i]);
        }

        int index = FastestAndSlowestTimes (times, names);
        SecondFastest (times, names, index);

    }

    public static int FastestAndSlowestTimes (int times[], String names[])
    {
      int FastestTime = times[0];
      int SlowestTime = times[0];
      int index = 0;

      String SlowestRunnerName = "";
      String FastestRunnerName = "";

      for(int i = 0; i < times.length; i++) {
        if (times[i] > SlowestTime) {
          SlowestTime = times[i];
          SlowestRunnerName = names[i];
        } else if (times[i] < FastestTime) {
          FastestTime = times[i];
          FastestRunnerName = names[i];
          index = i;
        }
      }

      System.out.println ("\nThe fastest runner is " + FastestRunnerName + " with a time of " + FastestTime + " minutes.");
      System.out.println ("\nThe slowest runner is " + SlowestRunnerName + " with a time of " + SlowestTime + " minutes.");

      return index;
    }

    public static void SecondFastest ( int times[], String names[], int index)
    {
      int FastestTime = times[index];
      int SecondFastestTime = 0;
      String SecondRunnerName = "";

      for(int i = 0; i < times.length; i++) {
        if(times[i] > FastestTime) {
          SecondFastestTime = times[i];
          SecondRunnerName = names[i];
        }
      }
      System.out.println ("\nThe second fastest runner is " + SecondRunnerName + " with a time of " + SecondFastestTime + " minutes.");
    }
}