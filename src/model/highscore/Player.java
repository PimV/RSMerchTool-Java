package model.highscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Legopiraat
 */
public class Player
  {

    private String username;

    public Player(String username)
      {
        this.username = username;

        try
          {
            getPlayerStats();
          }
        catch (IOException ex)
          {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

    public void getPlayerStats() throws MalformedURLException, IOException
      {
        URL itemInformation = new URL(getHighscoreUrl());
        URLConnection UrlCon = itemInformation.openConnection(); //proxy nodig ??

        InputStream inputStream = UrlCon.getInputStream();

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        
        String inputLine = "";
        while (!(inputLine = buffReader.readLine()).equals(""))
          {

            String parts[] = inputLine.split(",");

//            part[1] = rank;
//            part[2] = level;
//            part[3] = exp;
          }
      }

    public String getHighscoreUrl()
      {
        String highscoreUrl = "http://services.runescape.com/m=hiscore/index_lite.ws?player=" + username;
        return highscoreUrl;
      }

  }

/*
 All 27 skills in the following order: 
 overall, 
 attack, 
 defence, 
 strength, 
 constitution, 
 ranged, 
 prayer, 
 magic, 
 cooking, 
 woodcutting, 
 fletching, 
 fishing, 
 firemaking, 
 crafting, 
 smithing, 
 mining, 
 herblore, 
 agility, 
 thieving, 
 slayer, 
 farming, 
 runecrafting, 
 hunter, 
 construction, 
 summoning, 
 dungeoneering, 
 divination 
 */
