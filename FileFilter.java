package com.xzq.nf;

import java.io.File;
/*     */ import java.util.ArrayList;

public class FileFilter implements java.io.FileFilter {//�Զ��������ʵ��FileFilter�ӿ�
	private boolean selected = true;
	private File directory = null;//�ļ�
	private String filter = "*.*";//�ļ�������
	private boolean subdirectory;//�Ƿ������Ŀ¼

	public boolean accept(File pathname) {//pathnameΪ�ļ���java����·����
		if (pathname.isFile()) {//���˳���·������ʾ���Ƿ����ļ�������÷�������true�����򷵻�false
			return acceptFile(pathname);
		}
		return acceptDirectory(pathname);
	}

	private boolean acceptFile(File pathname) {//��������·���·����������ļ����������ֵ
		return (pathname.getAbsolutePath().startsWith(this.directory.getAbsolutePath()))//����ļ��ľ���·���Ŀ�ͷ�뵱ǰ����������Ĳ���Ŀ¼�ľ���·����ƥ�䣬
				&& (pathname.getName().matches(getFilterRegex()));//�����ļ����뵱ǰ�����������������ʽ��ƥ�䣬�򣬷�����ֵ����ʾ���ո��ļ�
	}

	private String getFilterRegex() {//
		return this.filter.replaceAll("\\.", "\\\\.").replaceAll("\\*", ".*").replaceAll("\\?", ".?");
	}

	private boolean acceptDirectory(File pathname) {//��ѡ�а�����Ŀ¼ѡ��ʱ����������·���µ�Ŀ¼���ļ��У����������ֵ
		String dir = this.directory.getAbsolutePath();//��ǰ����������Ĳ���Ŀ¼�ľ���·������dir
		return (this.subdirectory) && (pathname.getParent().startsWith(dir));//�����ǰ����������ѡ�а�����Ŀ¼ѡ����Ҵ�Ŀ¼�ĸ���Ŀ¼��dir��ƥ��(�ǵ�ǰ����·������Ŀ¼)���򷵻���ֵ����ʾ���ܸ�Ŀ¼
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public File getDirectory() {//��õ�ǰ����������Ĳ���Ŀ¼
		return this.directory;
	}

	public void setDirectory(String directory) {//���õ�ǰ����������Ĳ���Ŀ¼�����Σ�
		if ((directory == null) || (directory.isEmpty())) {
			setDirectory((File) null);//���õ�ǰ����Ŀ¼Ϊnull
		} else {
			setDirectory(new File(directory));//����һ��file����·��Ϊdirectory
		}
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	public String getFilter() {
		return this.filter;
	}

	public void setFilter(String filter) {//���ù�������filterָ��null��Ϊ��ʱ�����������ļ���Ŀ¼�����򣬾ͼ���filter��ָ���
		this.filter = ((filter == null) || (filter.isEmpty()) ? "*.*" : filter);
	}

	public boolean getSubdirectory() {
		return this.subdirectory;
	}

	public void setSubdirectory(boolean subdirectory) {//������Ŀ¼
		this.subdirectory = subdirectory;
	}

	public void listMatchFiles(ArrayList<File> fileList) {
		listMatchFiles(fileList, this.directory);
	}

	private void listMatchFiles(ArrayList<File> fileList, File dir) {//����ƥ���ļ����嵥�����飩�ĺ���
		File[] files = dir.listFiles(this);//��������
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isFile()) {//file�����ʾ�����ļ�������������ļ��嵥��
				fileList.add(file);
			}
		}
		for (File file : files) {
			if (file.isDirectory()) {//file�����ʾ�����ļ������������
				listMatchFiles(fileList, file);
			}
		}
	}

	public void checkValid() throws IllegalArgumentException {//�������Ŀ¼directory�Ƿ���Ч
		String dirName;
		if (this.directory == null) {
			dirName = "";
		} else {
			if (!this.directory.isDirectory())
				dirName = this.directory.getAbsolutePath();
			else
				return;
		}
		throw new IllegalArgumentException(Resource.getString("NOT_DIRECTORY_EXCEPTION", new Object[] { dirName }));//�׳��쳣
	}

	public boolean equals(Object obj) {//��ǰ��������Filefilter����ĸ�����ֵ�Ƿ����
		return (obj != null) && ((obj instanceof FileFilter)) && (this.directory.equals(((FileFilter) obj).directory))
				&& (this.filter.equals(((FileFilter) obj).filter))
				&& (this.subdirectory == ((FileFilter) obj).subdirectory);
	}

	public int hashCode() {//��ϣ����
		int hash = 7;
		hash = 67 * hash + (this.directory != null ? this.directory.hashCode() : 0);
		hash = 67 * hash + (this.filter != null ? this.filter.hashCode() : 0);
		hash = 67 * hash + (this.subdirectory ? 1 : 0);
		return hash;
	}
}
