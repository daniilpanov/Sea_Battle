package play;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.*;

import res.Ship;

public class EnemyArea extends JPanel
		implements Area
{
	private ArrayList<Ship> ships = Ship.enemyShips;
	private Graphics graphics;
	private JButton[][] cells;
	
    public EnemyArea()
    {
    	setLayout(null);
    }
    
	public void paintComponent(Graphics g)
	{
    	super.paintComponent(g);
    	// Получаем объект для рисования
    	this.graphics = g;
    	// Цвет линий
    	g.setColor(Color.BLUE);
    	// Рисуем фон
        // линии по X
    	for (int x = 0; x <= 640; x+=64)
    	{
    		g.drawLine(x, 0, x, 640);
    	}
    	// линии по Y
    	for (int y = 0; y <= 640; y+=64)
		{
			g.drawLine(0, y, 640, y);
		}
        // Добавляем кнопки
        JButton button; // объект будет меняться после каждой итерации цикла
    	Color color = new Color(0, 0, 0, 0); // цвет кнопок (прозрачный)
        for (int x = 0; x < 640; x+=64)
        {
            for (int y = 0; y < 640; y+=64)
            {
                button = new JButton();
                button.setBounds(x, y, 64, 64);
                button.setBackground(color);
                addEmptyCell(button, x, y);
            }
        }
        
    	// Рисуем корабли
        Ship ship;
    	for (int i = 0; i < ships.size()-1 & (ship = ships.get(i)) != null; i++)
    	{
            ship.drawShip(g);
        }
	}
	
	// Добавляем пустую клетку
	private void addEmptyCell(JButton button, int x_coordinate, int y_coordinate)
    {
		int x = x_coordinate/64,
			y = y_coordinate/64;
		
		button.addActionListener(e ->
                updateArea(new Shoots(Shoots.PLAYER, x, y, false)));

		add(button);
    }
    // Добавляем клетку с кораблём
    private void addShipCell(JButton button, int id, int x_coordinate, int y_coordinate)
    {
        int x = x_coordinate/64,
            y = y_coordinate/64;
        
        cells[x][y] = button;
        
        button.addActionListener(e ->
        {
            AtomicReference<Ship> ship = new AtomicReference<>();
            
            for (int i = 0; i < ships.size()-1 && ships.get(i) != null; i++)
            {
                if (ships.get(i).ID == id)
                {
                    ship.set(ships.get(i));
                    break;
                }
            }
            
            ship.get().hit(x, y);
            
            updateArea(new Shoots(Shoots.PLAYER, x, y, true));
        });
    }
    
    public void updateArea(Shoots shoot)
	{
	    System.out.println("Shooting!..");
	    int x = shoot.x,
            y = shoot.y;
	    
        if (shoot.hit)
        {
            System.out.println("HIT!!!");
            graphics.drawLine(x, y, x+64, y+64);
            graphics.drawLine(x, y+64, x+64, y);
        }
        else
        {
            System.out.println("Oh, no!");
            graphics.fillOval(x+28, y+28, 8, 8);
        }
        //cells[x][y].setVisible(false);
	}
}
