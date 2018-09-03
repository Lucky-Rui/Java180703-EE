package com.situ.student.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SwingUtil {
	/*
	 * 设置位置到屏幕中间
	 */
	public static void setLocationCenter(JFrame frame) {
		int width = frame.getWidth();
		int height = frame.getHeight();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		frame.setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
	}
}
