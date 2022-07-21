package com.hanxuefeng.test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603,680);
        jFrame.setTitle("事件");
        // 设置置顶
//        jFrame.setAlwaysOnTop(true);
        // 设置关闭方式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 设置居中显示
        jFrame.setLocationRelativeTo(null);
        // 取消默认的居中方式
        jFrame.setLayout(null);


        // 创建一个按钮
        JButton jButton = new JButton("点位啊");
        jButton.setBounds(0, 0, 100, 50);



        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("不要点我啊");
            }
        });

        jFrame.add(jButton);

        jFrame.setVisible(true);
    }
}
