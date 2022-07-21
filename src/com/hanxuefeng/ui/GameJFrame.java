package com.hanxuefeng.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {

    private int[][] data = new int[4][4];

    private int x = 0;
    private int y = 0;
    public GameJFrame(){
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

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon imageIcon = new ImageIcon("image\\animal\\animal3\\"+this.data[i][j]+".jpg");
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

        // 子菜单
        JMenuItem rePlayJMenuItem = new JMenuItem("重新游戏");
        JMenuItem reLoginJMenuItem = new JMenuItem("重新登录");
        JMenuItem closeGameJMenuItem = new JMenuItem("关闭游戏");
        JMenuItem accountJMenuItem = new JMenuItem("公众号");

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon("image/animal/animal3/all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);
            initBackground();
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case 37: // 左
                if (y + 1 == 4) {
                    return;
                }
                data[x][y] = data[x][y+1];
                data[x][y+1] = 0;
                y++;
                break;
            case 38: // 上
                if (x + 1 == 4) {
                    return;
                }
                data[x][y] = data[x+1][y];
                data[x+1][y] = 0;
                x++;
                break;
            case 39: // 右
                if (y - 1 == -1) {
                    return;
                }
                data[x][y] = data[x][y-1];
                data[x][y-1] = 0;
                y--;
                break;
            case 40: // 下
                if (x - 1 == -1) {
                    return;
                }
                data[x][y] = data[x-1][y];
                data[x-1][y] = 0;
                x--;
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
}
