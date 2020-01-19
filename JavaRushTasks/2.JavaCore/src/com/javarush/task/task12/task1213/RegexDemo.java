package com.javarush.task.task12.task1213;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexDemo
{
   public static void main(String[] args)
   {


   //	args = new String[]{"(Java( language)\2)", "I think that Java language is very cool."};

      if (args.length != 2)
      {
         System.err.println("usage: java RegexDemo regex input");
         return;
      }

      // Convert new-line (\n) character sequences to new-line characters.

      args[1] = args[1].replaceAll("\\\\n", "\n");

      try
      {
         System.out.println("regex = " + args[0]);
         System.out.println("input = " + args[1]);
         Pattern p = Pattern.compile(args[0]);
         Matcher m = p.matcher(args[1]);
         while (m.find())
            System.out.println("Found [" + m.group() + "] starting at "
                               + m.start() + " and ending at " + (m.end() - 1));
      }
      catch (PatternSyntaxException pse)
      {
         System.err.println("Bad regex: " + pse.getMessage());
         System.err.println("Description: " + pse.getDescription());
         System.err.println("Index: " + pse.getIndex());
         System.err.println("Incorrect pattern: " + pse.getPattern());
      }
   }
}