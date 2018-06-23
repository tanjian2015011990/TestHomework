package com.xzq.nf;

import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.ImageIcon;

//“≥√ÊÕº±Í¿‡
public class Resource{
	private static final String ICON_BASE = "/com/xzq/nf/images/";
	private static final ResourceBundle bundle = ResourceBundle.getBundle("com/xzq/nf/resource");
  
	public static String getString(String key) {
		return bundle.getString(key);
	}
	public static String getString(String key, Object... args) {
		return String.format(bundle.getString(key), args);
	}
	public static Icon getIcon(String iconName) {
		return new ImageIcon(Resource.class.getResource("/com/xzq/nf/images/" + iconName));
	}
}


