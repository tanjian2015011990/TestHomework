package com.xzq.nf;

import java.io.File;

public class SaveNaming {
	private boolean selected = true;
	private File source;
	private File target;
	private boolean applied;
	private boolean saveOK;
	private String saveMemo;

	//查找文本为空或目标文件不存在时抛出异常
	public SaveNaming(File source, File target) throws IllegalArgumentException {
		if ((source == null) || (!source.isFile())) {
			throw new IllegalArgumentException("%s is not a valid file.");
		}
		this.source = source;
		this.target = target;
	}

	//选择
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

	//应用
	public boolean isApplied() {
		return this.applied;
	}

	//保存成功
	public boolean isSaveOK() {
		return this.saveOK;
	}

	public String getSaveMemo() {
		return this.saveMemo;
	}

	//保存并生成备注
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

	//当前过滤器与Filefilter对象的各属性值是否相等
	public boolean equals(Object obj) {
		return (obj != null) && ((obj instanceof SaveNaming)) && (this.source.equals(((SaveNaming) obj).source))
				&& (this.target.equals(((SaveNaming) obj).target));
	}

	//哈希编码
	public int hashCode() {
		int hash = 7;
		hash = 71 * hash + (this.source != null ? this.source.hashCode() : 0);
		hash = 71 * hash + (this.target != null ? this.target.hashCode() : 0);
		return hash;
	}
}
