package com.xzq.nf;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

//��������ģ�����չģ��
public class NamingRuleModel extends AbstractTableModel {
       
        //����Ԥ���Ľ�����Ŀ�����������ļ������ļ��б��⡢������ʽ���⡢�滻����ڶ����⣩
	private static final String[] columnNames = { Resource.getString("SELECTED_COLUMN_TITLE"),
			Resource.getString("FIND_TEXT_COLUMN_TITLE"), Resource.getString("REGEX_COLUMN_TITLE"),
			Resource.getString("REPLACE_WITH_COLUMN_TITLE"), Resource.getString("PROCEED_NEXT_COLUMN_TITLE") };

	private ArrayList<NamingRule> ruleList;
     
        //��������ģ�飨�����������޸ģ�
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
 
        //�����пɸ����������޸�
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
