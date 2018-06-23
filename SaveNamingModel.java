package com.xzq.nf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class SaveNamingModel extends AbstractTableModel {
	private static final String[] columnNames = { Resource.getString("SELECTED_COLUMN_TITLE"),
			Resource.getString("FILE_PATH_COLUMN_TITLE"), Resource.getString("FILE_NAME_COLUMN_TITLE"),
			Resource.getString("NEW_NAME_COLUMN_TITLE"), Resource.getString("SAVEOK_COLUMN_TITLE"),
			Resource.getString("SAVE_MEMO_COLUMN_TITLE") };
	private ArrayList<SaveNaming> saveList;

	public SaveNamingModel() {
		this.saveList = new ArrayList();
	}

	//建立保存文件名的清单
	public void addSaveNamingList(List<SaveNaming> saveNamingList) {
		if ((saveNamingList == null) || (saveNamingList.isEmpty())) {
			return;
		}
		int fromIndex = getRowCount();
		for (SaveNaming saveNaming : saveNamingList) {
			if (!this.saveList.contains(saveNaming)) {
				this.saveList.add(saveNaming);
			}
		}
		if (getRowCount() > fromIndex) {
			fireTableRowsInserted(fromIndex, getRowCount() - 1);
		}
	}

	//选择行
	public Integer[] getSelectedRows() {
		ArrayList<Integer> selectedList = new ArrayList();
		for (int row = 0; row < this.saveList.size(); row++) {
			if (((SaveNaming) this.saveList.get(row)).isSelected()) {
				selectedList.add(Integer.valueOf(row));
			}
		}
		return (Integer[]) selectedList.toArray(new Integer[0]);
	}

	public SaveNaming getSaveNamingAtRow(int rowIndex) {
		return (SaveNaming) this.saveList.get(rowIndex);
	}

	public void clear() {
		this.saveList.clear();
		fireTableDataChanged();
	}

	public int getRowCount() {
		return this.saveList.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Boolean.class;
		case 4:
			return Icon.class;
		}
		return String.class;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		SaveNaming saveNaming = (SaveNaming) this.saveList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return Boolean.valueOf(saveNaming.isSelected());
		case 1:
			return saveNaming.getSource().getParent();
		case 2:
			return saveNaming.getSource().getName();
		case 3:
			return saveNaming.getTarget().getName();
		case 4:
			return getSaveStateIcon(saveNaming);
		}
		return saveNaming.getSaveMemo();
	}

	//显示成功或失败
	private Icon getSaveStateIcon(SaveNaming saveNaming) {
		if (!saveNaming.isApplied())
			return null;
		if (saveNaming.isSaveOK()) {
			return Resource.getIcon("saveOK.png");
		}
		return Resource.getIcon("saveFail.png");
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (columnIndex == 0) && (!((SaveNaming) this.saveList.get(rowIndex)).isApplied());
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (!(aValue instanceof Boolean)) {
			((SaveNaming) this.saveList.get(rowIndex)).setSelected(false);
		} else {
			((SaveNaming) this.saveList.get(rowIndex)).setSelected(((Boolean) aValue).booleanValue());
		}
	}

	//选择全部
	public void selectAll() {
		for (int i = 0; i < this.saveList.size(); i++) {
			if (!((SaveNaming) this.saveList.get(i)).isApplied()) {
				((SaveNaming) this.saveList.get(i)).setSelected(true);
			}
		}
		fireTableDataChanged();
	}

	//没有选择
	public void selectNone() {
		for (int i = 0; i < this.saveList.size(); i++) {
			((SaveNaming) this.saveList.get(i)).setSelected(false);
		}
		fireTableDataChanged();
	}
}
