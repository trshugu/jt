package com.example;

import static spark.Spark.*;
import spark.*;

  /**
 * spark world
 *
 */
public class App 
{
  public static void main( String[] args )
  {
    get(new Route("/hell")
    {
      @Override
      public Object handle(Request request, Response response)
      {
        return "hell, spark";
      }
    });
  }
}
