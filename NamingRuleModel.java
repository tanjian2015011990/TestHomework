package com.xzq.nf;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

//命名规则模块的扩展模块
public class NamingRuleModel extends AbstractTableModel {
       
        //设置预览的界面栏目（标题栏、文件所在文件夹标题、正则表达式标题、替换标题第二标题）
	private static final String[] columnNames = { Resource.getString("SELECTED_COLUMN_TITLE"),
			Resource.getString("FIND_TEXT_COLUMN_TITLE"), Resource.getString("REGEX_COLUMN_TITLE"),
			Resource.getString("REPLACE_WITH_COLUMN_TITLE"), Resource.getString("PROCEED_NEXT_COLUMN_TITLE") };

	private ArrayList<NamingRule> ruleList;
     
        //命名规则模块（用链表批量修改）
	public NamingRuleModel() {
		this.ruleList = new ArrayList();
	}

	public void addNamingRule(NamingRule namingRule) throws IllegalArgumentException {
		namingRule.checkValid();
		if (this.ruleList.contains(namingRule)) {
			throw new IllegalArgumentException(Resource.getString("RULE_EXISTS_EXCEPTION"));
		}
		this.ruleList.add(namingRule);
		fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
	}

	public void removeNamingRule(int rowIndex) {
		this.ruleList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public NamingRule[] getSelectedNamingRules() {
		ArrayList<NamingRule> selectedList = new ArrayList();
		for (int i = 0; i < this.ruleList.size(); i++) {
			if (((NamingRule) this.ruleList.get(i)).isSelected()) {
				selectedList.add(this.ruleList.get(i));
			}
		}
		return (NamingRule[]) selectedList.toArray(new NamingRule[0]);
	}

	public int getRowCount() {
		return this.ruleList.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 1:
		case 3:
			return String.class;
		}
		return Boolean.class;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		NamingRule rule = (NamingRule) this.ruleList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return Boolean.valueOf(rule.isSelected());
		case 1:
			return rule.getFindText();
		case 2:
			return Boolean.valueOf(rule.isRegex());
		case 3:
			return rule.getReplaceWith();
		}
		return Boolean.valueOf(rule.isProceedNext());
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 0;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		NamingRule rule = (NamingRule) this.ruleList.get(rowIndex);
		if (!(aValue instanceof Boolean)) {
			rule.setSelected(false);
		} else {
			rule.setSelected(((Boolean) aValue).booleanValue());
		}
	}
 
        //对所有可更改数据作修改
	public void selectAll() {
		for (int i = 0; i < getRowCount(); i++) {
			setValueAt(Boolean.valueOf(true), i, 0);
		}
		fireTableDataChanged();
	}

	public void selectNone() {
		for (int i = 0; i < getRowCount(); i++) {
			setValueAt(Boolean.valueOf(false), i, 0);
		}
		fireTableDataChanged();
	}
}
