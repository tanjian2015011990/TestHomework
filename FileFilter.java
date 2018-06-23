package com.xzq.nf;

import java.io.File;
/*     */ import java.util.ArrayList;

public class FileFilter implements java.io.FileFilter {//自定义过滤器实现FileFilter接口
	private boolean selected = true;
	private File directory = null;//文件
	private String filter = "*.*";//文件过滤器
	private boolean subdirectory;//是否包含子目录

	public boolean accept(File pathname) {//pathname为文件的java抽象路径名
		if (pathname.isFile()) {//检查此抽象路径名表示的是否是文件，是则该方法返回true，否则返回false
			return acceptFile(pathname);
		}
		return acceptDirectory(pathname);
	}

	private boolean acceptFile(File pathname) {//接收搜索路径下符合条件的文件，返回真假值
		return (pathname.getAbsolutePath().startsWith(this.directory.getAbsolutePath()))//如果文件的绝对路径的开头与当前过滤器对象的查找目录的绝对路径相匹配，
				&& (pathname.getName().matches(getFilterRegex()));//并且文件名与当前过滤器对象的正则表达式相匹配，则，返回真值，表示接收该文件
	}

	private String getFilterRegex() {//
		return this.filter.replaceAll("\\.", "\\\\.").replaceAll("\\*", ".*").replaceAll("\\?", ".?");
	}

	private boolean acceptDirectory(File pathname) {//当选中包含子目录选项时，接收搜索路径下的目录（文件夹），返回真假值
		String dir = this.directory.getAbsolutePath();//当前过滤器对象的查找目录的绝对路径存入dir
		return (this.subdirectory) && (pathname.getParent().startsWith(dir));//如果当前过滤器对象选中包含子目录选项，并且此目录的父级目录与dir相匹配(是当前搜索路径的子目录)，则返回真值，表示接受该目录
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public File getDirectory() {//获得当前过滤器对象的查找目录
		return this.directory;
	}

	public void setDirectory(String directory) {//设置当前过滤器对象的查找目录（传参）
		if ((directory == null) || (directory.isEmpty())) {
			setDirectory((File) null);//设置当前查找目录为null
		} else {
			setDirectory(new File(directory));//创建一个file对象，路径为directory
		}
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	public String getFilter() {
		return this.filter;
	}

	public void setFilter(String filter) {//设置过滤器：filter指向null或为空时，检索所有文件和目录；否则，就检索filter所指向的
		this.filter = ((filter == null) || (filter.isEmpty()) ? "*.*" : filter);
	}

	public boolean getSubdirectory() {
		return this.subdirectory;
	}

	public void setSubdirectory(boolean subdirectory) {//设置子目录
		this.subdirectory = subdirectory;
	}

	public void listMatchFiles(ArrayList<File> fileList) {
		listMatchFiles(fileList, this.directory);
	}

	private void listMatchFiles(ArrayList<File> fileList, File dir) {//建立匹配文件的清单（数组）的函数
		File[] files = dir.listFiles(this);//创建数组
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isFile()) {//file对象表示的是文件，则把它放入文件清单中
				fileList.add(file);
			}
		}
		for (File file : files) {
			if (file.isDirectory()) {//file对象表示的是文件，则调用自身
				listMatchFiles(fileList, file);
			}
		}
	}

	public void checkValid() throws IllegalArgumentException {//检查搜索目录directory是否有效
		String dirName;
		if (this.directory == null) {
			dirName = "";
		} else {
			if (!this.directory.isDirectory())
				dirName = this.directory.getAbsolutePath();
			else
				return;
		}
		throw new IllegalArgumentException(Resource.getString("NOT_DIRECTORY_EXCEPTION", new Object[] { dirName }));//抛出异常
	}

	public boolean equals(Object obj) {//当前过滤器与Filefilter对象的各属性值是否相等
		return (obj != null) && ((obj instanceof FileFilter)) && (this.directory.equals(((FileFilter) obj).directory))
				&& (this.filter.equals(((FileFilter) obj).filter))
				&& (this.subdirectory == ((FileFilter) obj).subdirectory);
	}

	public int hashCode() {//哈希编码
		int hash = 7;
		hash = 67 * hash + (this.directory != null ? this.directory.hashCode() : 0);
		hash = 67 * hash + (this.filter != null ? this.filter.hashCode() : 0);
		hash = 67 * hash + (this.subdirectory ? 1 : 0);
		return hash;
	}
}
