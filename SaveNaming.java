package com.xzq.nf;

import java.io.File;

public class SaveNaming {
	private boolean selected = true;
	private File source;
	private File target;
	private boolean applied;
	private boolean saveOK;
	private String saveMemo;

	//�����ı�Ϊ�ջ�Ŀ���ļ�������ʱ�׳��쳣
	public SaveNaming(File source, File target) throws IllegalArgumentException {
		if ((source == null) || (!source.isFile())) {
			throw new IllegalArgumentException("%s is not a valid file.");
		}
		this.source = source;
		this.target = target;
	}

	//ѡ��
	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public File getSource() {
		return this.source;
	}

	public File getTarget() {
		return this.target;
	}

	//Ӧ��
	public boolean isApplied() {
		return this.applied;
	}

	//����ɹ�
	public boolean isSaveOK() {
		return this.saveOK;
	}

	public String getSaveMemo() {
		return this.saveMemo;
	}

	//���沢���ɱ�ע
	public void saveNaming() {
		if (this.applied) {
			return;
		}
		this.applied = true;
		this.selected = false;
		try {
			this.saveOK = this.source.renameTo(this.target);
		} catch (Exception ex) {
			this.saveMemo = ex.getLocalizedMessage();
		}
	}

	//��ǰ��������Filefilter����ĸ�����ֵ�Ƿ����
	public boolean equals(Object obj) {
		return (obj != null) && ((obj instanceof SaveNaming)) && (this.source.equals(((SaveNaming) obj).source))
				&& (this.target.equals(((SaveNaming) obj).target));
	}

	//��ϣ����
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + (this.source != null ? this.source.hashCode() : 0);
		hash = 71 * hash + (this.target != null ? this.target.hashCode() : 0);
		return hash;
	}
}
