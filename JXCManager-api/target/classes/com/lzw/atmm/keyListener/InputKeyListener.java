package com.lzw.atmm.keyListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyListener extends KeyAdapter {

	@Override
	public void keyTyped(KeyEvent e) {
		String key="-0123456789"+(char)8;
		if(key.indexOf(e.getKeyChar())<0){
			e.consume();
		}
	}//键盘监听适配器
       
}
