package com.hanxuefeng.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {

    private int[][] data = new int[4][4];
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
            data[i / 4][i % 4] = tmpArr[i];
        }
    }

    private void initImage() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon imageIcon = new ImageIcon("D:\\work\\code\\java\\project\\puzzle-game\\image\\animal\\animal3\\"+this.data[i][j]+".jpg");
                // 2. 创建一个jLabel
                JLabel jLabel = new JLabel(imageIcon);
                jLabel.setBounds(105 * j, 105 * i, 105, 105);
                this.add(jLabel);
            }
        }

        this.getContentPane().setLayout(null);
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


    }
}
