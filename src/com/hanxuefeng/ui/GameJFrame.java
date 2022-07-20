package com.hanxuefeng.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {

    public GameJFrame(){
        initJFrame();

        initJMenuBar();

        this.setVisible(true);
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
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}
