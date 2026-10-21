package view;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/** Centraliza cores, fontes e componentes estilizados da interface. */
public final class Estilo {
    public static final Color AZUL = new Color(37, 99, 235);
    public static final Color AZUL_CLARO = new Color(59, 130, 246);
    public static final Color AZUL_ESCURO = new Color(29, 78, 216);
    public static final Color MENU = new Color(15, 23, 42);
    public static final Color MENU_HOVER = new Color(30, 41, 59);
    public static final Color FUNDO = new Color(241, 245, 249);
    public static final Color BORDA = new Color(226, 232, 240);
    public static final Color TEXTO = new Color(15, 23, 42);
    public static final Color TEXTO_SUAVE = new Color(100, 116, 139);
    public static final Color VERDE = new Color(22, 163, 74);
    public static final Color LARANJA = new Color(217, 119, 6);
    public static final Color VERMELHO = new Color(220, 38, 38);
    public static final Color CINZA = new Color(100, 116, 139);

    public static final Font FONTE = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font NEGRITO = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font TITULO = new Font("Segoe UI", Font.BOLD, 24);

    private Estilo() {}

    public static void aplicarTema() {
        UIManager.put("OptionPane.messageFont", FONTE);
        UIManager.put("OptionPane.buttonFont", NEGRITO);
        UIManager.put("OptionPane.messageForeground", TEXTO);
    }

    // ---------- Campos e rótulos ----------

    private static Border bordaCampo(Color cor) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(cor, 1),
                BorderFactory.createEmptyBorder(7, 10, 7, 10));
    }

    private static void estilizarCampo(JTextField c) {
        c.setFont(FONTE);
        c.setForeground(TEXTO);
        c.setCaretColor(AZUL);
        c.setBorder(bordaCampo(BORDA));
        c.addFocusListener(new FocusAdapter() {
            @Override public void focusGained(FocusEvent e) { c.setBorder(bordaCampo(AZUL)); }
            @Override public void focusLost(FocusEvent e) { c.setBorder(bordaCampo(BORDA)); }
        });
    }

    public static JTextField campo(int colunas) {
        JTextField c = new JTextField(colunas);
        estilizarCampo(c);
        return c;
    }

    public static JPasswordField senha(int colunas) {
        JPasswordField c = new JPasswordField(colunas);
        estilizarCampo(c);
        return c;
    }

    public static JLabel rotulo(String texto) {
        JLabel l = new JLabel(texto);
        l.setFont(new Font("Segoe UI", Font.BOLD, 12));
        l.setForeground(TEXTO_SUAVE);
        return l;
    }

    public static JPanel card(LayoutManager layout) {
        JPanel p = new JPanel(layout);
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDA),
                BorderFactory.createEmptyBorder(16, 16, 16, 16)));
        return p;
    }

    // ---------- Tabela ----------

    public static void estilizarTabela(JTable t) {
        t.setFont(FONTE);
        t.setRowHeight(32);
        t.setShowGrid(false);
        t.setIntercellSpacing(new Dimension(0, 0));
        t.setFillsViewportHeight(true);

        JTableHeader h = t.getTableHeader();
        h.setReorderingAllowed(false);
        h.setPreferredSize(new Dimension(0, 36));
        h.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tb, Object v, boolean sel,
                                                           boolean foco, int r, int c) {
                super.getTableCellRendererComponent(tb, v, sel, false, r, c);
                setBackground(AZUL);
                setForeground(Color.WHITE);
                setFont(NEGRITO);
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                return this;
            }
        });

        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tb, Object v, boolean sel,
                                                           boolean foco, int r, int c) {
                super.getTableCellRendererComponent(tb, v, sel, false, r, c);
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                setFont(FONTE);
                setForeground(TEXTO);
                if (sel) {
                    setBackground(new Color(219, 234, 254));
                } else {
                    setBackground(r % 2 == 0 ? Color.WHITE : new Color(248, 250, 252));
                }
                // Coluna 4 = Estoque: destaca em vermelho quando está baixo (5 ou menos)
                if (c == 4 && v instanceof Integer && ((Integer) v) <= 5) {
                    setForeground(VERMELHO);
                    setFont(NEGRITO);
                }
                return this;
            }
        });
    }

    // ---------- Botão arredondado ----------

    public static class Botao extends JButton {
        private final Color base;
        private final Color hover;
        private boolean sobre = false;

        public Botao(String texto, Color base) {
            super(texto);
            this.base = base;
            this.hover = base.darker();
            setFont(NEGRITO);
            setForeground(Color.WHITE);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setBorder(BorderFactory.createEmptyBorder(9, 20, 9, 20));
            addMouseListener(new MouseAdapter() {
                @Override public void mouseEntered(MouseEvent e) { sobre = true; repaint(); }
                @Override public void mouseExited(MouseEvent e) { sobre = false; repaint(); }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(sobre ? hover : base);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    // ---------- Item do menu lateral ----------

    public static class ItemMenu extends JButton {
        private static final Color TEXTO_MENU = new Color(203, 213, 225);
        private boolean ativo = false;
        private boolean sobre = false;

        public ItemMenu(String texto) {
            super(texto);
            setFont(FONTE);
            setForeground(TEXTO_MENU);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            setHorizontalAlignment(SwingConstants.LEFT);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));
            setAlignmentX(Component.LEFT_ALIGNMENT);
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 46));
            addMouseListener(new MouseAdapter() {
                @Override public void mouseEntered(MouseEvent e) { sobre = true; repaint(); }
                @Override public void mouseExited(MouseEvent e) { sobre = false; repaint(); }
            });
        }

        public void setAtivo(boolean ativo) {
            this.ativo = ativo;
            setForeground(ativo ? Color.WHITE : TEXTO_MENU);
            setFont(ativo ? NEGRITO : FONTE);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            if (ativo || sobre) {
                g2.setColor(MENU_HOVER);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
            if (ativo) {
                g2.setColor(AZUL_CLARO);
                g2.fillRect(0, 0, 4, getHeight());
            }
            g2.dispose();
            super.paintComponent(g);
        }
    }
}
