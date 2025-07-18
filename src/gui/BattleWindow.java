package gui;

import javax.swing.*;
import java.awt.*;

public class BattleWindow extends JFrame {

    public BattleWindow() {

        setTitle("WARRIORS by JuanDevART");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrar la ventana.

        //Añadimos nuestro panel.
        add(new BattlePanel());

        setVisible(true);

    }

    //Clase interna que extiende JPanel para dibujar.
    private class BattlePanel extends JPanel {

        private JButton attackButton;
        private String message = "";
        private int player1Health = 100;
        private int player2Health = 100;

        public BattlePanel() {

            //Usamos layout manual para psoicionar el botón
            setLayout(null);

            //Botón de atacar.
            attackButton = new JButton("Atacar");
            //Posición del botón.
            attackButton.setBounds(330, 500, 120, 40);
            //Añadir el botón.
            add(attackButton);

            //Acción al pulsar el botón.
            attackButton.addActionListener(e -> {

                //Simulación del daño y cambio de mensaje.
                int damage = (int)(Math.random() * 30);
                player2Health -= damage;
                if(player2Health < 0) player2Health = 0;

                message = "¡Atacaste e hiciste " + damage + " de daño!";
                repaint(); //Redibuja el panel para mostrar cambios.
            });

            //Color de fondo.
            setBackground(Color.DARK_GRAY);

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            //Dos rectángulos como ejemplo de los personajes.
            //Personaje 1.
            g.setColor(Color.GREEN);
            g.fillRect(100, 300, 100, 150);

            //Personaje 2.
            g.setColor(Color.CYAN);
            g.fillRect(600, 300, 100, 150);

            //Nombres.
            g.setColor(Color.WHITE);
            g.drawString("Player 1", 110, 290);
            g.drawString("Player2", 610, 290);
            g.setFont(new Font("Consolas", Font.BOLD, 16));

            //Vidas.
            g.drawString("Vida: " + player1Health, 110, 470);
            g.drawString("Vida: " + player2Health, 610, 470);

            //Mensaje.
            g.setFont(new Font("Consolas", Font.BOLD, 16));
            g.drawString(message, 280, 100);

        }
    }
}
