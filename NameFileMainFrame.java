package com.xzq.nf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class NameFileMainFrame extends javax.swing.JFrame {
	public static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("com.xzq.nf.NameFile");
	private JButton btnAddFilter;
	private JButton btnAddNamingRule;
	private JButton btnBrowse;

	//构造函数，主函数
	public NameFileMainFrame() {
		initComponents();
		this.btnNewProfile.setVisible(false);
		this.btnOpenProfile.setVisible(false);
		this.btnSaveProfile.setVisible(false);
		this.jSeparator1.setVisible(false);
	}

	private JButton btnExit;
	private JButton btnNewProfile;
	private JButton btnOpenProfile;
	private JButton btnPreview;
	private JButton btnRemoveFilter;
	private JButton btnRemoveNamingRule;
	
	//核心代码
	private void initComponents() {
		this.fileFilterModel = new FileFilterModel();//文件过滤模块
		this.namingRuleModel = new NamingRuleModel();//命名规则模块
		this.saveNamingModel = new SaveNamingModel();//保存文件名字模块
		this.fcDirectory = new javax.swing.JFileChooser();
		this.tbpNameFile = new javax.swing.JTabbedPane();
		this.jPanel3 = new javax.swing.JPanel();
		this.jSplitPane1 = new javax.swing.JSplitPane();
		this.jPanel1 = new javax.swing.JPanel();
		this.txfDirectory = new JTextField();
		this.txfFilter = new JTextField();
		this.ckbSubdirectory = new JCheckBox();
		this.jLabel1 = new JLabel();
		this.jScrollPane1 = new javax.swing.JScrollPane();
		this.tblFileFilter = new JTable();
		this.jToolBar1 = new JToolBar();
		this.btnSelAllFilter = new JButton();
		this.btnSelNoneFilter = new JButton();
		this.btnAddFilter = new JButton();
		this.btnRemoveFilter = new JButton();
		this.jLabel2 = new JLabel();
		this.btnBrowse = new JButton();
		this.jPanel2 = new javax.swing.JPanel();
		this.jScrollPane2 = new javax.swing.JScrollPane();
		this.tblNamingRule = new JTable();
		this.jLabel3 = new JLabel();
		this.txfFindText = new JTextField();
		this.jLabel4 = new JLabel();
		this.txfReplaceWith = new JTextField();
		this.ckbProceed = new JCheckBox();
		this.ckbRegex = new JCheckBox();
		this.jToolBar2 = new JToolBar();
		this.btnSelAllRule = new JButton();
		this.btnSelNoneRule = new JButton();
		this.btnAddNamingRule = new JButton();
		this.btnRemoveNamingRule = new JButton();
		this.jPanel4 = new javax.swing.JPanel();
		this.jToolBar4 = new JToolBar();
		this.btnSelAllNamingResult = new JButton();
		this.btnSelNoneNamingResult = new JButton();
		this.jScrollPane3 = new javax.swing.JScrollPane();
		this.tblSaveNaming = new JTable();
		this.jToolBar3 = new JToolBar();
		this.btnNewProfile = new JButton();
		this.btnOpenProfile = new JButton();
		this.btnSaveProfile = new JButton();
		this.jSeparator1 = new javax.swing.JToolBar.Separator();
		this.btnPreview = new JButton();
		this.btnSave = new JButton();
		this.jSeparator2 = new javax.swing.JToolBar.Separator();
		this.btnExit = new JButton();
		this.lbStatus = new JLabel();

		this.fcDirectory.setFileSelectionMode(1);

		setDefaultCloseOperation(3);
		setTitle(Resource.getString("APP_TITLE"));

		this.jSplitPane1.setBorder(null);
		this.jSplitPane1.setDividerLocation(210);
		this.jSplitPane1.setOrientation(0);
		this.jSplitPane1.setResizeWeight(0.5D);

		this.ckbSubdirectory.setSelected(true);
		this.ckbSubdirectory.setText(Resource.getString("INC_SUBDIR_TEXT"));

		this.jLabel1.setText(Resource.getString("DIRECTORY_LABEL"));

		this.tblFileFilter.setModel(this.fileFilterModel);
		this.tblFileFilter.setAutoResizeMode(0);
		this.tblFileFilter.setRowHeight(20);
		this.jScrollPane1.setViewportView(this.tblFileFilter);
		this.tblFileFilter.getColumnModel().getColumn(0).setPreferredWidth(60);
		this.tblFileFilter.getColumnModel().getColumn(0).setHeaderValue(Resource.getString("SELECTED_COLUMN_TITLE"));
		this.tblFileFilter.getColumnModel().getColumn(1).setPreferredWidth(300);
		this.tblFileFilter.getColumnModel().getColumn(1).setHeaderValue(Resource.getString("DIR_COLUMN_TITLE"));
		this.tblFileFilter.getColumnModel().getColumn(2).setPreferredWidth(150);
		this.tblFileFilter.getColumnModel().getColumn(2).setHeaderValue(Resource.getString("FILTER_COLUMN_TITLE"));
		this.tblFileFilter.getColumnModel().getColumn(3).setPreferredWidth(100);
		this.tblFileFilter.getColumnModel().getColumn(3).setHeaderValue(Resource.getString("SUBDIR_COLUMN_TITLE"));

		this.jToolBar1.setFloatable(false);
		this.jToolBar1.setRollover(true);

		this.btnSelAllFilter.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/SelectAll.png")));
		this.btnSelAllFilter.setToolTipText(Resource.getString("SELECT_ALL_TIP"));
		this.btnSelAllFilter.setFocusable(false);
		this.btnSelAllFilter.setHorizontalTextPosition(0);
		this.btnSelAllFilter.setVerticalTextPosition(3);
		this.btnSelAllFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnSelAllFilterActionPerformed(evt);
			}
		});
		this.jToolBar1.add(this.btnSelAllFilter);

		this.btnSelNoneFilter.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/SelectNone.png")));
		this.btnSelNoneFilter.setToolTipText(Resource.getString("SELECT_NONE_TIP"));
		this.btnSelNoneFilter.setFocusable(false);
		this.btnSelNoneFilter.setHorizontalTextPosition(0);
		this.btnSelNoneFilter.setVerticalTextPosition(3);
		this.btnSelNoneFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnSelNoneFilterActionPerformed(evt);
			}
		});
		this.jToolBar1.add(this.btnSelNoneFilter);

		this.btnAddFilter.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/add.png")));
		this.btnAddFilter.setToolTipText(Resource.getString("ADD_FILTER_TIP"));
		this.btnAddFilter.setFocusable(false);
		this.btnAddFilter.setHorizontalTextPosition(0);
		this.btnAddFilter.setVerticalTextPosition(3);
		this.btnAddFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnAddFilterActionPerformed(evt);
			}
		});
		this.jToolBar1.add(this.btnAddFilter);

		this.btnRemoveFilter.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/delete.png")));
		this.btnRemoveFilter.setToolTipText(Resource.getString("REMOVE_FILTER_TIP"));
		this.btnRemoveFilter.setFocusable(false);
		this.btnRemoveFilter.setHorizontalTextPosition(0);
		this.btnRemoveFilter.setVerticalTextPosition(3);
		this.btnRemoveFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnRemoveFilterActionPerformed(evt);
			}
		});
		this.jToolBar1.add(this.btnRemoveFilter);

		this.jLabel2.setText(Resource.getString("FILE_FILTER_LABLE"));

		this.btnBrowse.setText(Resource.getString("BROWSE_BUTTON_TEXT"));
		this.btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnBrowseActionPerformed(evt);
			}

		});
		GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(
						jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.jToolBar1, -1, -1,
												32767)
										.addGroup(
												jPanel1Layout.createSequentialGroup()
														.addGroup(jPanel1Layout
																.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(this.jLabel1).addComponent(this.jLabel2))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(jPanel1Layout
																.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addComponent(this.txfFilter, -2, 188, -2)
																		.addGap(18, 18, 18)
																		.addComponent(this.ckbSubdirectory))
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addComponent(this.txfDirectory, -2, 362, -2)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(this.btnBrowse)))
														.addGap(0, 121, 32767))
										.addComponent(this.jScrollPane1)).addContainerGap()));

		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel1).addComponent(this.txfDirectory, -2, -1, -2)
								.addComponent(this.btnBrowse))
						.addGap(6, 6, 6)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel2).addComponent(this.txfFilter, -2, -1, -2).addComponent(
										this.ckbSubdirectory))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(this.jToolBar1, -2, 25, -2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jScrollPane1, -1, 98, 32767).addContainerGap()));

		this.jSplitPane1.setTopComponent(this.jPanel1);

		this.tblNamingRule.setModel(this.namingRuleModel);
		this.tblNamingRule.setAutoResizeMode(0);
		this.tblNamingRule.setRowHeight(20);
		this.jScrollPane2.setViewportView(this.tblNamingRule);
		this.tblNamingRule.getColumnModel().getColumn(0).setPreferredWidth(60);
		this.tblNamingRule.getColumnModel().getColumn(0).setHeaderValue(Resource.getString("SELECTED_COLUMN_TITLE"));
		this.tblNamingRule.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.tblNamingRule.getColumnModel().getColumn(1).setHeaderValue(Resource.getString("FIND_TEXT_COLUMN_TITLE"));
		this.tblNamingRule.getColumnModel().getColumn(2).setPreferredWidth(80);
		this.tblNamingRule.getColumnModel().getColumn(2).setHeaderValue(Resource.getString("REGEX_COLUMN_TITLE"));
		this.tblNamingRule.getColumnModel().getColumn(3).setPreferredWidth(200);
		this.tblNamingRule.getColumnModel().getColumn(3)
				.setHeaderValue(Resource.getString("REPLACE_WITH_COLUMN_TITLE"));
		this.tblNamingRule.getColumnModel().getColumn(4).setPreferredWidth(60);
		this.tblNamingRule.getColumnModel().getColumn(4)
				.setHeaderValue(Resource.getString("PROCEED_NEXT_COLUMN_TITLE"));

		this.jLabel3.setText(Resource.getString("FIND_TEXT_LABEL"));

		this.jLabel4.setText(Resource.getString("REPLACE_WITH_LABEL"));

		this.ckbProceed.setSelected(true);
		this.ckbProceed.setText(Resource.getString("PROCEED_NEXT_TEXT"));

		this.ckbRegex.setText(Resource.getString("REGEX_CHECKBOX_TEXT"));

		this.jToolBar2.setFloatable(false);
		this.jToolBar2.setRollover(true);

		this.btnSelAllRule.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/SelectAll.png")));
		this.btnSelAllRule.setToolTipText(Resource.getString("SELECT_ALL_TIP"));
		this.btnSelAllRule.setFocusable(false);
		this.btnSelAllRule.setHorizontalTextPosition(0);
		this.btnSelAllRule.setVerticalTextPosition(3);
		this.btnSelAllRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnSelAllRuleActionPerformed(evt);
			}
		});
		this.jToolBar2.add(this.btnSelAllRule);

		this.btnSelNoneRule.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/SelectNone.png")));
		this.btnSelNoneRule.setToolTipText(Resource.getString("SELECT_NONE_TIP"));
		this.btnSelNoneRule.setFocusable(false);
		this.btnSelNoneRule.setHorizontalTextPosition(0);
		this.btnSelNoneRule.setVerticalTextPosition(3);
		this.btnSelNoneRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnSelNoneRuleActionPerformed(evt);
			}
		});
		this.jToolBar2.add(this.btnSelNoneRule);

		this.btnAddNamingRule.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/add.png")));
		this.btnAddNamingRule.setToolTipText(Resource.getString("ADD_NAMING_TIP"));
		this.btnAddNamingRule.setFocusable(false);
		this.btnAddNamingRule.setHorizontalTextPosition(0);
		this.btnAddNamingRule.setVerticalTextPosition(3);
		this.btnAddNamingRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnAddNamingRuleActionPerformed(evt);
			}
		});
		this.jToolBar2.add(this.btnAddNamingRule);

		this.btnRemoveNamingRule.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/delete.png")));
		this.btnRemoveNamingRule.setToolTipText(Resource.getString("REMOVE_NAMING_TIP"));
		this.btnRemoveNamingRule.setFocusable(false);
		this.btnRemoveNamingRule.setHorizontalTextPosition(0);
		this.btnRemoveNamingRule.setVerticalTextPosition(3);
		this.btnRemoveNamingRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnRemoveNamingRuleActionPerformed(evt);
			}
		});
		this.jToolBar2.add(this.btnRemoveNamingRule);

		GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
		this.jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jToolBar2, -1, -1,
								32767)
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout.createSequentialGroup()
												.addComponent(this.txfFindText, -2, 151, -2).addGap(18, 18, 18)
												.addComponent(this.jLabel4))
										.addComponent(this.ckbRegex))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.txfReplaceWith, -2, 161, -2).addComponent(this.ckbProceed))
								.addGap(0, 158, 32767))
						.addComponent(this.jScrollPane2)).addContainerGap()));

		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabel3).addComponent(this.txfFindText, -2, -1, -2)
								.addComponent(this.jLabel4).addComponent(this.txfReplaceWith, -2, -1, -2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.ckbProceed).addComponent(this.ckbRegex))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jToolBar2, -2, 25, -2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jScrollPane2, -1, 151, 32767).addContainerGap()));

		this.jSplitPane1.setRightComponent(this.jPanel2);

		GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
		this.jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSplitPane1));

		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSplitPane1));

		this.tbpNameFile.addTab(Resource.getString("SELECT_TAB_TITLE"), this.jPanel3);

		this.jToolBar4.setFloatable(false);
		this.jToolBar4.setRollover(true);

		this.btnSelAllNamingResult.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/SelectAll.png")));
		this.btnSelAllNamingResult.setToolTipText(Resource.getString("SELECT_ALL_TIP"));
		this.btnSelAllNamingResult.setFocusable(false);
		this.btnSelAllNamingResult.setHorizontalTextPosition(0);
		this.btnSelAllNamingResult.setVerticalTextPosition(3);
		this.btnSelAllNamingResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnSelAllNamingResultActionPerformed(evt);
			}
		});
		this.jToolBar4.add(this.btnSelAllNamingResult);

		this.btnSelNoneNamingResult.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/SelectNone.png")));
		this.btnSelNoneNamingResult.setToolTipText(Resource.getString("SELECT_NONE_TIP"));
		this.btnSelNoneNamingResult.setFocusable(false);
		this.btnSelNoneNamingResult.setHorizontalTextPosition(0);
		this.btnSelNoneNamingResult.setVerticalTextPosition(3);
		this.btnSelNoneNamingResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnSelNoneNamingResultActionPerformed(evt);
			}
		});
		this.jToolBar4.add(this.btnSelNoneNamingResult);

		this.tblSaveNaming.setModel(this.saveNamingModel);
		this.tblSaveNaming.setAutoResizeMode(0);
		this.tblSaveNaming.setRowHeight(20);
		this.jScrollPane3.setViewportView(this.tblSaveNaming);
		this.tblSaveNaming.getColumnModel().getColumn(0).setPreferredWidth(60);
		this.tblSaveNaming.getColumnModel().getColumn(0).setHeaderValue(Resource.getString("SELECTED_COLUMN_TITLE"));
		this.tblSaveNaming.getColumnModel().getColumn(1).setPreferredWidth(250);
		this.tblSaveNaming.getColumnModel().getColumn(1).setHeaderValue(Resource.getString("FILE_PATH_COLUMN_TITLE"));
		this.tblSaveNaming.getColumnModel().getColumn(2).setPreferredWidth(120);
		this.tblSaveNaming.getColumnModel().getColumn(2).setHeaderValue(Resource.getString("FILE_NAME_COLUMN_TITLE"));
		this.tblSaveNaming.getColumnModel().getColumn(3).setPreferredWidth(120);
		this.tblSaveNaming.getColumnModel().getColumn(3).setHeaderValue(Resource.getString("NEW_NAME_COLUMN_TITLE"));
		this.tblSaveNaming.getColumnModel().getColumn(4).setPreferredWidth(50);
		this.tblSaveNaming.getColumnModel().getColumn(4).setHeaderValue(Resource.getString("SAVEOK_COLUMN_TITLE"));
		this.tblSaveNaming.getColumnModel().getColumn(5).setPreferredWidth(200);
		this.tblSaveNaming.getColumnModel().getColumn(5).setHeaderValue(Resource.getString("SAVE_MEMO_COLUMN_TITLE"));

		GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
		this.jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(this.jToolBar4, -1, -1, 32767).addComponent(this.jScrollPane3, -1, 634,
										32767))
						.addContainerGap()));

		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jToolBar4, -2, 25, -2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(this.jScrollPane3, -1, 410, 32767).addContainerGap()));

		this.tbpNameFile.addTab(Resource.getString("PREVIEW_TAB_TITLE"), this.jPanel4);

		this.jToolBar3.setFloatable(false);
		this.jToolBar3.setRollover(true);

		this.btnNewProfile.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/new_profile.png")));
		this.btnNewProfile.setToolTipText(Resource.getString("NEW_PROFILE_TIP"));
		this.btnNewProfile.setFocusable(false);
		this.btnNewProfile.setHorizontalTextPosition(0);
		this.btnNewProfile.setVerticalTextPosition(3);
		this.btnNewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnNewProfileActionPerformed(evt);
			}
		});
		this.jToolBar3.add(this.btnNewProfile);

		this.btnOpenProfile.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/open_profile.png")));
		this.btnOpenProfile.setToolTipText(Resource.getString("OPEN_PROFILE_TIP"));
		this.btnOpenProfile.setFocusable(false);
		this.btnOpenProfile.setHorizontalTextPosition(0);
		this.btnOpenProfile.setVerticalTextPosition(3);
		this.btnOpenProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnOpenProfileActionPerformed(evt);
			}
		});
		this.jToolBar3.add(this.btnOpenProfile);

		this.btnSaveProfile.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/save_profile.png")));
		this.btnSaveProfile.setToolTipText(Resource.getString("SAVE_PROFILE_TIP"));
		this.btnSaveProfile.setFocusable(false);
		this.btnSaveProfile.setHorizontalTextPosition(0);
		this.btnSaveProfile.setVerticalTextPosition(3);
		this.btnSaveProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnSaveProfileActionPerformed(evt);
			}
		});
		this.jToolBar3.add(this.btnSaveProfile);
		this.jToolBar3.add(this.jSeparator1);

		this.btnPreview.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/apply_naming.png")));
		this.btnPreview.setToolTipText(Resource.getString("PREVIEW_NAMING_TIP"));
		this.btnPreview.setFocusable(false);
		this.btnPreview.setHorizontalTextPosition(0);
		this.btnPreview.setVerticalTextPosition(3);
		this.btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnPreviewActionPerformed(evt);
			}
		});
		this.jToolBar3.add(this.btnPreview);

		this.btnSave.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/save_result.png")));
		this.btnSave.setToolTipText(Resource.getString("SAVE_NAMING_TIP"));
		this.btnSave.setFocusable(false);
		this.btnSave.setHorizontalTextPosition(0);
		this.btnSave.setVerticalTextPosition(3);
		this.btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnSaveActionPerformed(evt);
			}
		});
		this.jToolBar3.add(this.btnSave);
		this.jToolBar3.add(this.jSeparator2);

		this.btnExit.setIcon(new ImageIcon(getClass().getResource("/com/xzq/nf/images/exit.png")));
		this.btnExit.setToolTipText(Resource.getString("EXIT_APP_TIP"));
		this.btnExit.setFocusable(false);
		this.btnExit.setHorizontalTextPosition(0);
		this.btnExit.setVerticalTextPosition(3);
		this.btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NameFileMainFrame.this.btnExitActionPerformed(evt);
			}
		});
		this.jToolBar3.add(this.btnExit);

		this.lbStatus.setText(" ");
		this.lbStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.tbpNameFile)
						.addComponent(this.jToolBar3, -1, -1, 32767).addComponent(this.lbStatus, -1, -1, 32767))
				.addContainerGap()));

		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap().addComponent(this.jToolBar3, -2, 25, -2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.tbpNameFile)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(this.lbStatus).addContainerGap()));

		pack();
	}

	private void btnSelAllFilterActionPerformed(ActionEvent evt) {
		this.fileFilterModel.selectAll();
	}

	private void btnSelNoneFilterActionPerformed(ActionEvent evt) {
		this.fileFilterModel.selectNone();
	}

	private void btnAddFilterActionPerformed(ActionEvent evt) {
		addFilterFromInput();
	}

	private void addFilterFromInput() throws IllegalArgumentException {
		if (this.txfDirectory.getText().isEmpty()) {
			return;
		}
		try {
			FileFilter filter = new FileFilter();
			filter.setDirectory(this.txfDirectory.getText());
			filter.setFilter(this.txfFilter.getText());
			filter.setSubdirectory(this.ckbSubdirectory.isSelected());
			this.txfDirectory.setText("");
			this.txfFilter.setText("");
			this.fileFilterModel.addFileFilter(filter);
		} catch (Exception ex) {
			this.lbStatus.setText(ex.getLocalizedMessage());
		}
	}

	private void btnRemoveFilterActionPerformed(ActionEvent evt) {
		int rowIndex = this.tblFileFilter.getSelectedRow();
		if (rowIndex != -1) {
			rowIndex = this.tblFileFilter.convertRowIndexToModel(rowIndex);
			this.fileFilterModel.removeFileFilter(rowIndex);
		}
	}

	private void btnBrowseActionPerformed(ActionEvent evt) {
		if (this.fcDirectory.showOpenDialog(this) == 0) {
			this.txfDirectory.setText(this.fcDirectory.getSelectedFile().getAbsolutePath());
		}
	}

	private void btnSelAllRuleActionPerformed(ActionEvent evt) {
		this.namingRuleModel.selectAll();
	}

	private void btnSelNoneRuleActionPerformed(ActionEvent evt) {
		this.namingRuleModel.selectNone();
	}

	private void btnAddNamingRuleActionPerformed(ActionEvent evt) {
		addNamingRuleFromInput();
	}
	
	//从输入框得到文件命名规则
	private void addNamingRuleFromInput() {
		if (this.txfFindText.getText().isEmpty()) {
			return;
		}
		try {
			NamingRule rule = new NamingRule();
			rule.setFindText(this.txfFindText.getText());
			rule.setRegex(this.ckbRegex.isSelected());
			rule.setReplaceWith(this.txfReplaceWith.getText());
			rule.setProceedNext(this.ckbProceed.isSelected());
			this.txfFindText.setText("");
			this.txfReplaceWith.setText("");
			this.namingRuleModel.addNamingRule(rule);
		} catch (Exception ex) {
			this.lbStatus.setText(ex.getLocalizedMessage());
		}
	}

	private void btnRemoveNamingRuleActionPerformed(ActionEvent evt) {
		int rowIndex = this.tblNamingRule.getSelectedRow();
		if (rowIndex != -1) {
			rowIndex = this.tblNamingRule.convertRowIndexToModel(rowIndex);
			this.namingRuleModel.removeNamingRule(rowIndex);
		}
	}

	private void btnSelAllNamingResultActionPerformed(ActionEvent evt) {
		this.saveNamingModel.selectAll();
	}

	private void btnSelNoneNamingResultActionPerformed(ActionEvent evt) {
		this.saveNamingModel.selectNone();
	}

	private void btnNewProfileActionPerformed(ActionEvent evt) {
	}

	private void btnOpenProfileActionPerformed(ActionEvent evt) {
	}

	private void btnSaveProfileActionPerformed(ActionEvent evt) {
	}

	private void btnPreviewActionPerformed(ActionEvent evt) {
		addFilterFromInput();
		addNamingRuleFromInput();
		try {
			new FileNamingPreviewer().execute();
		} catch (Exception ex) {
			this.lbStatus.setText(ex.getLocalizedMessage());
		}
	}

	private void btnSaveActionPerformed(ActionEvent evt) {
		if (javax.swing.JOptionPane.showConfirmDialog(this, Resource.getString("SAVE_WARNING_TEXT"),
				Resource.getString("SAVE_WARNING_TITLE"), 0, 2) == 1) {

			return;
		}
		try {
			new FileNamingSaver().execute();
		} catch (Exception ex) {
			this.lbStatus.setText(ex.getLocalizedMessage());
		}
	}

	private void btnExitActionPerformed(ActionEvent evt) {
		processWindowEvent(new java.awt.event.WindowEvent(this, 201));
	}

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			logger.log(java.util.logging.Level.SEVERE, null, ex);
		}
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NameFileMainFrame frame = new NameFileMainFrame();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.jSplitPane1.setDividerLocation(0.5D);
			}
		});
	}

	private JButton btnSave;

	private JButton btnSaveProfile;

	private JButton btnSelAllFilter;

	private JButton btnSelAllNamingResult;

	private JButton btnSelAllRule;

	private JButton btnSelNoneFilter;

	private JButton btnSelNoneNamingResult;

	private JButton btnSelNoneRule;

	private JCheckBox ckbProceed;

	private JCheckBox ckbRegex;
	private JCheckBox ckbSubdirectory;
	private javax.swing.JFileChooser fcDirectory;
	private FileFilterModel fileFilterModel;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JToolBar.Separator jSeparator1;
	private javax.swing.JToolBar.Separator jSeparator2;
	private javax.swing.JSplitPane jSplitPane1;
	private JToolBar jToolBar1;
	private JToolBar jToolBar2;
	private JToolBar jToolBar3;
	private JToolBar jToolBar4;
	private JLabel lbStatus;
	private NamingRuleModel namingRuleModel;
	private SaveNamingModel saveNamingModel;
	private JTable tblFileFilter;
	private JTable tblNamingRule;
	private JTable tblSaveNaming;
	private javax.swing.JTabbedPane tbpNameFile;
	private JTextField txfDirectory;
	private JTextField txfFilter;
	private JTextField txfFindText;
	private JTextField txfReplaceWith;
	private int fileNum =-1;//符合规则的文件的数目

	private void scrollToRowVisible(JTable table, int rowIndex) {
		table.scrollRectToVisible(table.getCellRect(rowIndex, 0, true));
	}

	private class FileNamingPreviewer extends javax.swing.SwingWorker<Object, SaveNaming> {
		FileFilter[] filters;
		NamingRule[] rules;

		public FileNamingPreviewer() {
			this.filters = NameFileMainFrame.this.fileFilterModel.getSelectedFileFilters();
			this.rules = NameFileMainFrame.this.namingRuleModel.getSelectedNamingRules();
			if (this.filters.length == 0) {
				throw new IllegalStateException(Resource.getString("NO_FILTER_SELECTED_EXCEPTION"));
			}
			if (this.rules.length == 0) {
				throw new IllegalStateException(Resource.getString("NO_NAMIN_RULE_SELECTED_EXCEPTION"));
			}
			NameFileMainFrame.this.saveNamingModel.clear();
			NameFileMainFrame.this.tbpNameFile.setSelectedIndex(1);
			NameFileMainFrame.this.lbStatus.setText(Resource.getString("SEARCH_RUNNING_TIP"));
		}

		protected Object doInBackground() throws Exception {
			java.util.ArrayList<java.io.File> fileList = new java.util.ArrayList();
			for (FileFilter filter : this.filters) {
				filter.listMatchFiles(fileList);
			}
			for (java.io.File file : fileList) {
				analyzeFileNaming(file);
			}
			return null;
		}

		private void analyzeFileNaming(java.io.File file) {
			fileNum++;
			String fileMainName = getFileMainName(file.getName());
			String fileExtension = getFileExtension(file.getName());
			String fileNewName = fileMainName;
			String tmpFileName = fileNewName;
			for (NamingRule rule : this.rules) {
				fileNewName = fileNewName.replaceAll(rule.getFindRegex(), String.valueOf(Integer.parseInt(rule.escapeReplaceWith())+fileNum));

				if ((!rule.isProceedNext()) && (!tmpFileName.equals(fileNewName))) {
					break;
				}
				tmpFileName = fileNewName;
			}
			if (!fileNewName.equals(fileMainName)) {
				fileNewName = fileNewName + fileExtension;
				SaveNaming saveNaming = new SaveNaming(file, new java.io.File(file.getParentFile(), fileNewName));

				publish(new SaveNaming[] { saveNaming });
			}
		}

		//得到文件名
		private String getFileMainName(String fileName) {
			int i = fileName.lastIndexOf('.');
			if (i == -1) {
				return fileName;
			}
			return fileName.substring(0, i);
		}
		
		//得到文件扩展名
		private String getFileExtension(String fileName) {
			int i = fileName.lastIndexOf('.');
			if (i == -1) {
				return "";
			}
			return fileName.substring(i);
		}

		protected void process(java.util.List<SaveNaming> chunks) {
			NameFileMainFrame.this.saveNamingModel.addSaveNamingList(chunks);
			NameFileMainFrame.this.scrollToRowVisible(NameFileMainFrame.this.tblSaveNaming,
					NameFileMainFrame.this.tblSaveNaming.getRowCount() - 1);
		}

		protected void done() {
			try {
				get();
				NameFileMainFrame.this.tbpNameFile.setSelectedIndex(1);
				NameFileMainFrame.this.lbStatus.setText(Resource.getString("SEARCH_FINISHED_TEXT"));
			} catch (Exception ex) {
				NameFileMainFrame.this.lbStatus
						.setText(Resource.getString("SEARCH_FAILED_TEXT", new Object[] { ex.getLocalizedMessage() }));
			}
		}
	}

	private class FileNamingSaver extends javax.swing.SwingWorker<Object, Integer> {
		Integer[] selectedRows;

		public FileNamingSaver() {
			this.selectedRows = NameFileMainFrame.this.saveNamingModel.getSelectedRows();
			if (this.selectedRows.length == 0) {
				throw new IllegalStateException(Resource.getString("NO_RESULT_SELECTED_EXCEPTION"));
			}
			NameFileMainFrame.this.tbpNameFile.setSelectedIndex(1);
			NameFileMainFrame.this.lbStatus.setText(Resource.getString("SAVING_RESULTS_TEXT"));
		}

		protected Object doInBackground() throws Exception {
			for (Integer row : this.selectedRows) {
				NameFileMainFrame.this.saveNamingModel.getSaveNamingAtRow(row.intValue()).saveNaming();
				publish(new Integer[] { row });
			}
			return null;
		}

		protected void process(java.util.List<Integer> chunks) {
			int fromRow = ((Integer) chunks.get(0)).intValue();
			int toRow = ((Integer) chunks.get(chunks.size() - 1)).intValue();
			NameFileMainFrame.this.scrollToRowVisible(NameFileMainFrame.this.tblSaveNaming, fromRow);
			NameFileMainFrame.this.saveNamingModel.fireTableRowsUpdated(fromRow, toRow);
		}

		protected void done() {
			try {
				get();
				NameFileMainFrame.this.lbStatus.setText(Resource.getString("NAMING_RESULTS_SAVED_TEXT"));
			} catch (Exception ex) {
				NameFileMainFrame.this.lbStatus.setText(
						Resource.getString("NAMING_SAVE_FAILED_TEXT", new Object[] { ex.getLocalizedMessage() }));
			}
		}
	}
}