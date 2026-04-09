package entornos;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InterfazCalculadora extends JFrame {
    private JTextField txtEdad;
    private JLabel lblResultado;
    private JLabel lblIcono;
    private CalculadoraRiesgo calculadora;

    public InterfazCalculadora() {
        calculadora = new CalculadoraRiesgo();
        setupLookAndFeel();
        initUI();
    }

    private void setupLookAndFeel() {
        try {
            // Aplicar estilo FlatLaf (Moderno)
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 10);
            UIManager.put("Component.arc", 10);
            UIManager.put("TextComponent.arc", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initUI() {
        setTitle("Calculadora de Riesgo v2.0");
        setSize(450, 400);
        setMinimumSize(new Dimension(400, 350));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Contenedor principal con padding
        JPanel contentPane = new JPanel(new BorderLayout(20, 20));
        contentPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        contentPane.setBackground(Color.WHITE);

        // Header
        JPanel pnlHeader = new JPanel(new GridLayout(2, 1));
        pnlHeader.setBackground(Color.WHITE);
        
        JLabel lblTitulo = new JLabel("Sistema de Seguros");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(33, 37, 41));
        
        JLabel lblSubtitulo = new JLabel("Evaluación instantánea de perfil de riesgo");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(108, 117, 125));
        
        pnlHeader.add(lblTitulo);
        pnlHeader.add(lblSubtitulo);
        contentPane.add(pnlHeader, BorderLayout.NORTH);

        // Cuerpo / Formulario
        JPanel pnlBody = new JPanel(new GridBagLayout());
        pnlBody.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel lblEdad = new JLabel("Edad del cliente:");
        lblEdad.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 0;
        pnlBody.add(lblEdad, gbc);

        txtEdad = new JTextField();
        txtEdad.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtEdad.setPreferredSize(new Dimension(200, 40));
        gbc.gridy = 1;
        pnlBody.add(txtEdad, gbc);

        JButton btnCalcular = new JButton("Evaluar Riesgo");
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCalcular.setPreferredSize(new Dimension(200, 45));
        btnCalcular.setBackground(new Color(13, 110, 253));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 10, 0);
        pnlBody.add(btnCalcular, gbc);

        contentPane.add(pnlBody, BorderLayout.CENTER);

        // Footer / Resultado
        JPanel pnlFooter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlFooter.setBackground(new Color(248, 249, 250));
        pnlFooter.setPreferredSize(new Dimension(450, 80));
        pnlFooter.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(222, 226, 230)));

        lblResultado = new JLabel("Introduce una edad para comenzar");
        lblResultado.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblResultado.setForeground(new Color(73, 80, 87));
        
        pnlFooter.add(lblResultado);
        contentPane.add(pnlFooter, BorderLayout.SOUTH);

        // Lógica
        btnCalcular.addActionListener(e -> calcular());
        txtEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) calcular();
            }
        });

        add(contentPane);
    }

    private void calcular() {
        try {
            String input = txtEdad.getText();
            if (input.isEmpty()) return;
            
            int edad = Integer.parseInt(input);
            String resultado = calculadora.evaluarEdad(edad);
            
            lblResultado.setText("Categoría: " + resultado.toUpperCase());
            
            // Estilo visual según resultado
            switch (resultado) {
                case "Joven":
                    lblResultado.setForeground(new Color(25, 135, 84)); // Verde
                    break;
                case "Adulto":
                    lblResultado.setForeground(new Color(13, 110, 253)); // Azul
                    break;
                case "Senior":
                    lblResultado.setForeground(new Color(255, 193, 7)); // Amarillo/Dorado
                    break;
                case "Error":
                    lblResultado.setText("¡ERROR: EDAD NO VÁLIDA!");
                    lblResultado.setForeground(new Color(220, 53, 69)); // Rojo
                    break;
            }
            
            // Pequeña animación de feedback
            lblResultado.setFont(new Font("Segoe UI", Font.BOLD, 18));
            Timer timer = new Timer(200, e -> lblResultado.setFont(new Font("Segoe UI", Font.BOLD, 16)));
            timer.setRepeats(false);
            timer.start();

        } catch (NumberFormatException ex) {
            lblResultado.setText("POR FAVOR, INGRESA UN NÚMERO");
            lblResultado.setForeground(new Color(220, 53, 69));
        }
    }

    public static void main(String[] args) {
        // En un entorno real de VS Code, el usuario correría esto con F5
        SwingUtilities.invokeLater(() -> {
            new InterfazCalculadora().setVisible(true);
        });
    }
}
