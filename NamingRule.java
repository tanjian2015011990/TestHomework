package com.xzq.nf;

public class NamingRule {
	private boolean selected = true;
	private String findText = "";//��ȡ�����ƥ������
	private boolean regex = false;
	private String replaceWith = "";//��ȡ������滻����
	private boolean proceedNext = true;
        
       //��select������ȡ������滻�ı�
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

        //����������ʽ
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

        //��ȡҪ�滻���ı�
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
     
        //�ظ�ִ���滻���滻����ļ���
	public void setProceedNext(boolean proceedNext) {
		this.proceedNext = proceedNext;
	}

        //����������Ч��
	public void checkValid() throws IllegalArgumentException {
		if (this.findText.isEmpty()) {
			throw new IllegalArgumentException(Resource.getString("EMPTY_FIND_EXCEPTION"));
		}
	}

       //�������������ȼ۶���
	public boolean equals(Object obj) {
		return (obj != null) && ((obj instanceof NamingRule)) && (this.findText.equals(((NamingRule) obj).findText))
				&& (this.regex == ((NamingRule) obj).regex)
				&& (this.replaceWith.equals(((NamingRule) obj).replaceWith));
	}
        //�����ϣ����
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + (this.findText != null ? this.findText.hashCode() : 0);
		hash = 53 * hash + (this.regex ? 1 : 0);
		hash = 53 * hash + (this.replaceWith != null ? this.replaceWith.hashCode() : 0);
		return hash;
	}
}
