package play;

import res.Ship;

import javax.swing.*;

public interface Player
{
    Ship[] ships = new Ship[10];
    
    JPanel getArea();
}
