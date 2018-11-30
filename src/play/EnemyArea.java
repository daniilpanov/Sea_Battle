package play;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

import res.Ship;

public class EnemyArea extends JPanel
		implements Area
{
	private ArrayList<Ship> ships = Ship.enemyShips;
	
    public EnemyArea()
    {
    	setLayout(null);
    }
    
	public void paintComponent(Graphics g)
	{
    	super.paintComponent(g);
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
                addCell(button, x, y);
            }
        }
        
    	// Рисуем корабли
        Ship ship;
    	for (int i = 0; i < ships.size()-1 & (ship = ships.get(i)) != null; i++)
    	{
            ship.drawShip(g);
        }
	}
	
	// Добавление слушателей на кнопки
	private void addCell(JButton button, int x_coordinate, int y_coordinate)
    {
		int x = x_coordinate/64,
			y = y_coordinate/64;

		button.addActionListener(e ->
		{
		    Ship ship;
			for (int i = 0; i < ships.size()-1 & (ship = ships.get(i)) != null; i++)
			{
				System.out.println(ship.hit(x, y));
				System.out.println();
			}
			System.out.println();
		});

		add(button);
    }
    
    public void updateArea(Shoots shoot)
	{
	
	}
}
