package com.xzq.nf;

public class NamingRule {
	private boolean selected = true;
	private String findText = "";//获取输入的匹配内容
	private boolean regex = false;
	private String replaceWith = "";//获取输入的替换内容
	private boolean proceedNext = true;
        
       //用select方法获取输入的替换文本
	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getFindText() {
		return this.findText;
	}

	public void setFindText(String findText) {
		this.findText = (findText == null ? "" : findText);
	}

        //定义正则表达式
	public boolean isRegex() {
		return this.regex;
	}

	public void setRegex(boolean regex) {
		this.regex = regex;
	}

	public String getFindRegex() {
		return this.regex ? this.findText : escapeFindText();
	}

	private String escapeFindText() {
		return this.findText.replaceAll("\\\\", "\\\\\\\\").replaceAll("\\+", "\\\\+").replaceAll("\\*", "\\\\*")
				.replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)").replaceAll("\\[", "\\\\[")
				.replaceAll("\\]", "\\\\]").replaceAll("\\^", "\\\\^").replaceAll("\\$", "\\\\\\$")
				.replaceAll("\\.", "\\\\.");
	}

        //获取要替换的文本
	public String getReplaceWith() {
		return this.replaceWith;
	}

	public void setReplaceWith(String replaceWith) {
		this.replaceWith = (replaceWith == null ? "" : replaceWith);
	}

	public String escapeReplaceWith() {
		return this.replaceWith.replaceAll("\\$", "\\\\\\$");
	}

	public boolean isProceedNext() {
		return this.proceedNext;
	}
     
        //重复执行替换，替换多个文件名
	public void setProceedNext(boolean proceedNext) {
		this.proceedNext = proceedNext;
	}

        //检验规则的有效性
	public void checkValid() throws IllegalArgumentException {
		if (this.findText.isEmpty()) {
			throw new IllegalArgumentException(Resource.getString("EMPTY_FIND_EXCEPTION"));
		}
	}

       //公共布尔函数等价对象
	public boolean equals(Object obj) {
		return (obj != null) && ((obj instanceof NamingRule)) && (this.findText.equals(((NamingRule) obj).findText))
				&& (this.regex == ((NamingRule) obj).regex)
				&& (this.replaceWith.equals(((NamingRule) obj).replaceWith));
	}
        //定义哈希代码
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + (this.findText != null ? this.findText.hashCode() : 0);
		hash = 53 * hash + (this.regex ? 1 : 0);
		hash = 53 * hash + (this.replaceWith != null ? this.replaceWith.hashCode() : 0);
		return hash;
	}
}
