package com.xzq.nf;

import java.io.File;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FileFilterModel extends AbstractTableModel {
	private static final String[] columnNames = { Resource.getString("SELECTED_COLUMN_TITLE"),
			Resource.getString("DIR_COLUMN_TITLE"), Resource.getString("FILTER_COLUMN_TITLE"),
			Resource.getString("SUBDIR_COLUMN_TITLE") };

	private ArrayList<FileFilter> filterList;

	public FileFilterModel() {//���ɹ������嵥
		this.filterList = new ArrayList();//���������
	}

	public void addFileFilter(FileFilter filter) throws IllegalArgumentException {//��ӹ�������ɸѡ����
		filter.checkValid();//���ɸѡ�����Ƿ���Ч
		if (this.filterList.contains(filter)) {
			throw new IllegalArgumentException(Resource.getString("FILTER_EXISTS_EXCEPTION"));//�����Ѿ������˹����������׳��쳣
		}
		this.filterList.add(filter);//���
		fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);//������
	}

	public void removeFileFilter(int rowIndex) {//ɾ����������ɸѡ����
		this.filterList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);//ɾ����
	}

	public FileFilter[] getSelectedFileFilters() {//�õ���ѡ�е�һ������������
		ArrayList<FileFilter> selectedList = new ArrayList();
		for (int i = 0; i < this.filterList.size(); i++) {
			if (((FileFilter) this.filterList.get(i)).isSelected()) {
				selectedList.add(this.filterList.get(i));//��ӱ�ѡ�еĹ�������ѡ���嵥
			}
		}
		return (FileFilter[]) selectedList.toArray(new FileFilter[0]);
	}

	public int getRowCount() {//�õ�����������м���
		return this.filterList.size();
	}

	public int getColumnCount() {//�õ�����������м���
		return columnNames.length;
	}

	public String getColumnName(int column) {//�õ�����
		return columnNames[column];
	}

	public Class<?> getColumnClass(int columnIndex) {//�õ�������
		switch (columnIndex) {
		case 1:
		case 2:
			return String.class;//�����ַ�����
		}
		return Boolean.class;//���ز�����
	}

	public Object getValueAt(int rowIndex, int columnIndex) {//��ù������嵥����ָ����ĳ�к��е�ֵ
		FileFilter filter = (FileFilter) this.filterList.get(rowIndex);//�������±�õ�ĳ����������ĳ��ɸѡ����
		switch (columnIndex) {
		case 0:
			return Boolean.valueOf(filter.isSelected());//����0�У����ض�Ӧ���������Ƿ�ѡ��ֵ
		case 1:
			return filter.getDirectory().getAbsolutePath();//����1�У����ض�Ӧ������������Ŀ¼�ľ���·��
		case 2:
			return filter.getFilter();//����2�У����ض�Ӧ���������ļ���ɸѡ����
		}
		return Boolean.valueOf(filter.getSubdirectory());//�����Ƿ�ѡ�������Ŀ¼
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {//�жϵ�Ԫ���Ƿ�ɱ༭
		return columnIndex == 0;//�������嵥�ĵ�0�е�Ԫ��ɱ༭
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {//���������嵥���ĳ��Ԫ��ֵ
		FileFilter filter = (FileFilter) this.filterList.get(rowIndex);
		if (!(aValue instanceof Boolean)) {
			filter.setSelected(false);
		} else {
			filter.setSelected(((Boolean) aValue).booleanValue());
		}
	}

	public void selectAll() {//ѡ������
		for (int i = 0; i < getRowCount(); i++) {
			setValueAt(Boolean.valueOf(true), i, 0);
		}
		fireTableDataChanged();
	}

	public void selectNone() {//ȫ����ѡ
		for (int i = 0; i < getRowCount(); i++) {
			setValueAt(Boolean.valueOf(false), i, 0);
		}
		fireTableDataChanged();
	}
}
