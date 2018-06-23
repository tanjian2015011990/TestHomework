package com.xzq.nf;

import java.io.File;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class FileFilterModel extends AbstractTableModel {
	private static final String[] columnNames = { Resource.getString("SELECTED_COLUMN_TITLE"),
			Resource.getString("DIR_COLUMN_TITLE"), Resource.getString("FILTER_COLUMN_TITLE"),
			Resource.getString("SUBDIR_COLUMN_TITLE") };

	private ArrayList<FileFilter> filterList;

	public FileFilterModel() {//生成过滤器清单
		this.filterList = new ArrayList();//建立数组表单
	}

	public void addFileFilter(FileFilter filter) throws IllegalArgumentException {//添加过滤器（筛选规则）
		filter.checkValid();//检查筛选规则是否有效
		if (this.filterList.contains(filter)) {
			throw new IllegalArgumentException(Resource.getString("FILTER_EXISTS_EXCEPTION"));//表单中已经包含此过滤器，则抛出异常
		}
		this.filterList.add(filter);//添加
		fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);//插入行
	}

	public void removeFileFilter(int rowIndex) {//删除过滤器（筛选规则）
		this.filterList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);//删除行
	}

	public FileFilter[] getSelectedFileFilters() {//得到被选中的一个或多个过滤器
		ArrayList<FileFilter> selectedList = new ArrayList();
		for (int i = 0; i < this.filterList.size(); i++) {
			if (((FileFilter) this.filterList.get(i)).isSelected()) {
				selectedList.add(this.filterList.get(i));//添加被选中的过滤器到选中清单
			}
		}
		return (FileFilter[]) selectedList.toArray(new FileFilter[0]);
	}

	public int getRowCount() {//得到过滤器表的行计数
		return this.filterList.size();
	}

	public int getColumnCount() {//得到过滤器表的列计数
		return columnNames.length;
	}

	public String getColumnName(int column) {//得到列名
		return columnNames[column];
	}

	public Class<?> getColumnClass(int columnIndex) {//得到列种类
		switch (columnIndex) {
		case 1:
		case 2:
			return String.class;//返回字符串型
		}
		return Boolean.class;//返回布尔型
	}

	public Object getValueAt(int rowIndex, int columnIndex) {//获得过滤器清单表格的指定的某行和列的值
		FileFilter filter = (FileFilter) this.filterList.get(rowIndex);//根据行下标得到某个过滤器（某条筛选规则）
		switch (columnIndex) {
		case 0:
			return Boolean.valueOf(filter.isSelected());//表格第0列，返回对应过滤器的是否被选中值
		case 1:
			return filter.getDirectory().getAbsolutePath();//表格第1列，返回对应过滤器的搜索目录的绝对路径
		case 2:
			return filter.getFilter();//表格第2列，返回对应过滤器的文件名筛选条件
		}
		return Boolean.valueOf(filter.getSubdirectory());//返回是否选择包含子目录
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {//判断单元格是否可编辑
		return columnIndex == 0;//过滤器清单的第0列单元格可编辑
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {//给过滤器清单表的某单元格赋值
		FileFilter filter = (FileFilter) this.filterList.get(rowIndex);
		if (!(aValue instanceof Boolean)) {
			filter.setSelected(false);
		} else {
			filter.setSelected(((Boolean) aValue).booleanValue());
		}
	}

	public void selectAll() {//选中所有
		for (int i = 0; i < getRowCount(); i++) {
			setValueAt(Boolean.valueOf(true), i, 0);
		}
		fireTableDataChanged();
	}

	public void selectNone() {//全部不选
		for (int i = 0; i < getRowCount(); i++) {
			setValueAt(Boolean.valueOf(false), i, 0);
		}
		fireTableDataChanged();
	}
}
