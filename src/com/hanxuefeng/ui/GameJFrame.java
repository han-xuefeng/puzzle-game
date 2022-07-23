package com.hanxuefeng.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    private int[][] data = new int[4][4];

    private int[] girl = new int[12];
    private int[] animal = new int[7];
    private int[] sport = new int[9];


    private int x = 0;
    private int y = 0;

    // 定义变量 用来统计步数
    private int step = 0;

    private String pathType = "animal\\animal3\\";
    private static final String path = "image\\";

    // 子菜单
    private JMenu changeImageJMenuItem = new JMenu("更换图片");
    private JMenuItem girlJMenuItem = new JMenuItem("美女");
    private JMenuItem animalJMenuItem = new JMenuItem("动物");
    private JMenuItem sportJMenuItem = new JMenuItem("运动");
    private JMenuItem rePlayJMenuItem = new JMenuItem("重新游戏");
    private JMenuItem reLoginJMenuItem = new JMenuItem("重新登录");
    private JMenuItem closeGameJMenuItem = new JMenuItem("关闭游戏");
    private JMenuItem accountJMenuItem = new JMenuItem("公众号");

    public GameJFrame(){
        initImageData();
        initJFrame();

        initJMenuBar();

        initData();

        initImage();

        this.setVisible(true);
    }

    private void initData() {
        int[] tmpArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Random random = new Random();
        // 打乱数组
        for (int i = 0; i < tmpArr.length; i++) {
            int index = random.nextInt(tmpArr.length);

            int tmp = tmpArr[i];
            tmpArr[i] = tmpArr[index];
            tmpArr[index] = tmp;
        }
        for (int i = 0; i < tmpArr.length; i++) {
            if (tmpArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tmpArr[i];
        }
    }

    private void initImage() {
        // 情况原本已经出现的图片
        this.getContentPane().removeAll();
        if (victory()) {
            JLabel vJLabel = new JLabel(new ImageIcon("image\\win.png"));
            vJLabel.setBounds(203,240, 197,73);
            this.getContentPane().add(vJLabel);
        }

        JLabel stepCountJLabel = new JLabel("步数：" + step);
        stepCountJLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCountJLabel);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon imageIcon = new ImageIcon(path  + pathType + this.data[i][j]+".jpg");
                // 2. 创建一个jLabel
                JLabel jLabel = new JLabel(imageIcon);
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }

        initBackground();

        this.getContentPane().setLayout(null);
        this.getContentPane().repaint();
    }

    private void initBackground() {
        ImageIcon bg = new ImageIcon("image\\background.png");
        JLabel bgJLabel = new JLabel(bg);
        bgJLabel.setBounds(40,40, 508, 560);
        this.getContentPane().add(bgJLabel);
    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        // 菜单
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        // 添加事件
        rePlayJMenuItem.addActionListener(this);
        reLoginJMenuItem.addActionListener(this);
        closeGameJMenuItem.addActionListener(this);
        accountJMenuItem.addActionListener(this);

        girlJMenuItem.addActionListener(this);
        animalJMenuItem.addActionListener(this);
        sportJMenuItem.addActionListener(this);

        changeImageJMenuItem.add(girlJMenuItem);
        changeImageJMenuItem.add(animalJMenuItem);
        changeImageJMenuItem.add(sportJMenuItem);

        functionJMenu.add(changeImageJMenuItem);
        functionJMenu.add(rePlayJMenuItem);
        functionJMenu.add(reLoginJMenuItem);
        functionJMenu.add(closeGameJMenuItem);

        aboutJMenu.add(accountJMenuItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // 给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        // 设置标题
        this.setTitle("拼图游戏单机版 v1.0");
        // 设置置顶
//        this.setAlwaysOnTop(true);
        // 设置关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 设置居中显示
        this.setLocationRelativeTo(null);
        // 取消默认的居中方式
        this.setLayout(null);

        //添加键盘事件
        this.addKeyListener(this);


    }

    private void initImageData() {
        for (int i = 0; i < 12; i++) {
            girl[i] = i+1;
        }
        for (int i = 0; i < 9; i++) {
            sport[i] = i+1;
        }
        for (int i = 0; i < 7; i++) {
            animal[i] = i+1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon(path + pathType + "all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);
            initBackground();
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        switch (code) {
            case 37: // 左
                if (y + 1 == 4) {
                    return;
                }
                data[x][y] = data[x][y+1];
                data[x][y+1] = 0;
                y++;
                step++;
                break;
            case 38: // 上
                if (x + 1 == 4) {
                    return;
                }
                data[x][y] = data[x+1][y];
                data[x+1][y] = 0;
                x++;
                step++;
                break;
            case 39: // 右
                if (y - 1 == -1) {
                    return;
                }
                data[x][y] = data[x][y-1];
                data[x][y-1] = 0;
                y--;
                step++;
                break;
            case 40: // 下
                if (x - 1 == -1) {
                    return;
                }
                data[x][y] = data[x-1][y];
                data[x-1][y] = 0;
                x--;
                step++;
                break;
            case 87:
                data = new int[][]{
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,0}
                };
                break;
        }
        initImage();
    }

    public boolean victory() {
        int[][] tmpData = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,0}
        };
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != tmpData[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == rePlayJMenuItem) {
            step = 0;
            initData();
            initImage();
        } else if (obj == reLoginJMenuItem) {
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj == closeGameJMenuItem) {
            System.exit(0);
        } else if (obj == accountJMenuItem) {
            JDialog jDialog = new JDialog();

            JLabel jLabel = new JLabel(new ImageIcon("image/about.png"));
            jLabel.setBounds(0, 0, 258, 258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344, 344);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (obj == girlJMenuItem) {
            changeImage(1);
        } else if (obj == animalJMenuItem) {
            changeImage(2);
        } else if (obj == sportJMenuItem) {
            changeImage(3);
        }
    }

    private void changeImage(int type) {

        Random random = new Random();
        if (type == 1) {
            int i = random.nextInt(girl.length);
            pathType =  "girl\\" + "girl" +girl[i] + "\\";
        } else if (type ==2) {
            int i = random.nextInt(animal.length);
            pathType =  "animal\\" + "animal" +animal[i] + "\\";
        } else {
            int i = random.nextInt(sport.length);
            pathType =  "sport\\" + "sport" +sport[i] + "\\";
        }
        step = 0;
        initData();
        initImage();
    }
}
